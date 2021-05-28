package com.example.demo.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.demo.configplatform.ConfigNodeApi;
import com.example.demo.configplatform.SSHConfigApi;
import com.example.demo.modular.FlavorInstance;
import com.example.demo.modular.FloatingIp;
import com.example.demo.modular.ImageInstance;
import com.example.demo.modular.Instance;
import com.example.demo.modular.InstanceStack;
import com.example.demo.modular.InstanceSubnet;
import com.example.demo.modular.Link;
import com.example.demo.modular.MemList;
import com.example.demo.modular.Sfc;
import com.example.demo.modular.SfcInstance;
import com.example.demo.modular.SfcLink;
import com.example.demo.modular.SfcNetwork;
import com.example.demo.modular.SfcVnf;
import com.example.demo.modular.Stack;
import com.example.demo.modular.Subnet;
import com.example.demo.modular.Vnf;
import com.example.demo.modular.VnfFlavor;
import com.example.demo.modular.VnfStack;
import com.example.demo.openstack.OpenStackHeatApi;
import com.example.demo.openstack.OpenStackNeutronApi;
import com.example.demo.service.FlavorInstanceService;
import com.example.demo.service.FlavorService;
import com.example.demo.service.FloatingIpService;
import com.example.demo.service.ImageInstanceService;
import com.example.demo.service.ImageService;
import com.example.demo.service.InstanceService;
import com.example.demo.service.InstanceStackService;
import com.example.demo.service.InstanceSubnetService;
import com.example.demo.service.LinkService;
import com.example.demo.service.SfcInstanceService;
import com.example.demo.service.SfcLinkService;
import com.example.demo.service.SfcNetworkService;
import com.example.demo.service.SfcService;
import com.example.demo.service.SfcVnfService;
import com.example.demo.service.StackService;
import com.example.demo.service.SubnetService;
import com.example.demo.service.VnfFlavorService;
import com.example.demo.service.VnfService;
import com.example.demo.service.VnfStackService;
import com.example.demo.service.VtenantService;

/*
 * JSON templates' lexer.
 */

import com.example.demo.template.TemplateLexer;
import com.example.demo.util.AppProperties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @class JsonTemplateLexer
 * @brief resolve Json
 * @author ychuang
 * @note
 * receive json
 * verify tenant and get operation type
 * if type is create 
 * store the resource info into db
 * call OpenStack api to request OpenStack resource
 * call ssh api to request vnf config and overlay link config
 */
@Controller
public class JsonTemplateLexer implements TemplateLexer {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private VnfService vnfService;
	
	@Autowired
	private VnfFlavorService vnfFlavorService;

	@Autowired
	private FlavorService flavorService;
	
	@Autowired
	private FloatingIpService floatingIpService;
	
	@Autowired
	private StackService stackService;
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private SfcService sfcService;
	
	@Autowired
	private SfcInstanceService sfcInstanceService;
	
	@Autowired
	private SfcLinkService sfcLinkService;
	
	@Autowired
	private SfcVnfService sfcVnfService;
	
	@Autowired
	private SfcNetworkService sfcNetworkService;
	
	@Autowired
	private VnfStackService vnfStackService;
	
	@Autowired
	private FlavorInstanceService flavorInstanceService;
	
	@Autowired
	private ImageInstanceService imageInstanceService;
	
	@Autowired
	private SubnetService subnetService;
	
	@Autowired
	private InstanceSubnetService instanceSubnetService;
	
	@Autowired
	private InstanceService instanceService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private InstanceStackService instanceStackService;
	
	@Autowired
	private OpenStackNeutronApi openStackNeutronApi;
	
	@Autowired
	private OpenStackHeatApi openStackHeatApi;
	
	@Autowired 
	private SSHConfigApi sshConfigApi;
	
	@Autowired
	private ConfigNodeApi configNodeApi;
	
	@Autowired
	private VtenantService vtenantService;

	JSONObject jsonObject = new JSONObject();
	
	public Map<Integer, MemList> mapMemList = new HashMap<Integer, MemList>();
	
	Map<Sfc, String> configNodeList = new HashMap<>();
	
	/**
	 * string to json, resolve operation type: create, delete and update
	 */
	@Override
	public void lexer(String template) throws InterruptedException{
		jsonObject = JSONObject.fromObject(template);
		System.out.println(vtenantService.getAll());
		String method = jsonObject.getString("type");
		int tenantId = jsonObject.getInt("tenantId");
		if(!mapMemList.containsKey(tenantId)){
			MemList memList = new MemList();
			mapMemList.put(tenantId, memList);
		}
		switch(method){
		case "create":
			templateResourceCreate(tenantId);
			break;
		case "delete":
			templateResourceDelete();
			break;
		case "update":
			templateResourceUpdate(tenantId);
			break;
		default:
			break;
		}
	}
	
	/**
	 * write into db
	 * @param tenantId
	 */
	public void templateResourceToDB(int tenantId){
		
		//Vnf information writed into Database.
		JSONArray vnfArray = jsonObject.getJSONArray("vnf");
		mapMemList.get(tenantId).vnfList.clear();
		for(int i=0; i<vnfArray.size(); i++){
			Object object = vnfArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			Vnf vnf = (Vnf) JSONObject.toBean(tempJsonObject, Vnf.class);
			vnfService.insertVnf(vnf);
			mapMemList.get(tenantId).vnfList.add(vnf);
		}
		
		//Link information writed into Database.
		JSONArray linkArray = jsonObject.getJSONArray("link");
		for(int i=0; i<linkArray.size(); i++){
			Object object = linkArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			Link link = (Link) JSONObject.toBean(tempJsonObject, Link.class);
			mapMemList.get(tenantId).linkList.add(linkService.insertLink(link));
		}
		
		//Sfc information writed into Database.
		JSONArray sfcArray = jsonObject.getJSONArray("sfc");
		for(int i=0; i<sfcArray.size(); i++){
			Object object = sfcArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			Sfc sfc = (Sfc) JSONObject.toBean(tempJsonObject, Sfc.class);
			mapMemList.get(tenantId).sfcList.add(sfcService.insertSfc(sfc));
		}
		
		//Sfc_Link information writed into Database.
		JSONArray sfcLinkArray = jsonObject.getJSONArray("sfc_link");
		for(int i=0; i<sfcLinkArray.size(); i++){
			Object object = sfcLinkArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			SfcLink sfcLink = (SfcLink) JSONObject.toBean(tempJsonObject, SfcLink.class);
			mapMemList.get(tenantId).sfcLinkList.add(sfcLinkService.insertSfcLink(sfcLink));
		}
		
		//Sfc_Vnf information writed into Database.
		JSONArray sfcVnfArray = jsonObject.getJSONArray("sfc_vnf");
		for(int i=0; i<sfcVnfArray.size(); i++){
			Object object = sfcVnfArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			SfcVnf sfcVnf = (SfcVnf) JSONObject.toBean(tempJsonObject, SfcVnf.class);
			mapMemList.get(tenantId).sfcVnfList.add(sfcVnfService.insertSfcVnf(sfcVnf));
		}
		
		//Vnf_flavor information writed into Database.
		JSONArray vnfFlavorArray = jsonObject.getJSONArray("vnf_flavor");
		for(int i=0; i<vnfFlavorArray.size(); i++){
			Object object = vnfFlavorArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			VnfFlavor vnfFlavor = (VnfFlavor) JSONObject.toBean(tempJsonObject, VnfFlavor.class);
			mapMemList.get(tenantId).vnfFlavorList.add(vnfFlavorService.insertByVnfFlavor(vnfFlavor));
		}
		
		//Flavor_Instance information writed into Database.
		JSONArray flavorInstanceArray = jsonObject.getJSONArray("flavor_instance");
		for(int i=0; i<flavorInstanceArray.size(); i++){
			Object object = flavorInstanceArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			FlavorInstance flavorInstance = (FlavorInstance) JSONObject.toBean(tempJsonObject, FlavorInstance.class);
			mapMemList.get(tenantId).flavorInstanceList.add(flavorInstanceService.insertFlavorInstance(flavorInstance));
		}
		
		//Image_Instance information writed into Database.
		JSONArray imageInstanceArray = jsonObject.getJSONArray("image_instance");
		for(int i=0; i<imageInstanceArray.size(); i++){
			Object object = imageInstanceArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			ImageInstance imageInstance = (ImageInstance) JSONObject.toBean(tempJsonObject, ImageInstance.class);
			mapMemList.get(tenantId).imageInstanceList.add(imageInstanceService.insertImageInstance(imageInstance));
		}
		
		//Subnet information writed into Database.
		JSONArray subnetArray = jsonObject.getJSONArray("subnet");
		for(int i=0; i<subnetArray.size(); i++){
			Object object = subnetArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			Subnet subnet = (Subnet) JSONObject.toBean(tempJsonObject, Subnet.class);
			mapMemList.get(tenantId).subnetList.add(subnetService.insertSubnet(subnet));
		}
		
		//Instance_Subnet information writed into Database.
		JSONArray instanceSubnetArray = jsonObject.getJSONArray("instance_subnet");
		for(int i=0; i<instanceSubnetArray.size(); i++){
			Object object = instanceSubnetArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			InstanceSubnet instanceSubnet = (InstanceSubnet) JSONObject.toBean(tempJsonObject, InstanceSubnet.class);
			mapMemList.get(tenantId).instanceSubnetList.add(instanceSubnetService.insertInstanceSubnet(instanceSubnet));
		}
		
		//Instance information writed into Database.
		JSONArray instanceArray = jsonObject.getJSONArray("instance");
		for(int i=0; i<instanceArray.size(); i++){
			Object object = instanceArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			Instance instance = (Instance) JSONObject.toBean(tempJsonObject, Instance.class);
			mapMemList.get(tenantId).instanceList.add(instanceService.insertInstance(instance));
		}
		
		//Sfc_Instance information writed into Database.
		JSONArray sfcInstanceArray = jsonObject.getJSONArray("sfc_instance");
		for(int i=0; i<sfcInstanceArray.size(); i++){
			Object object = sfcInstanceArray.get(i);
			JSONObject tempJsonObject = JSONObject.fromObject(object);
			SfcInstance sfcInstance = (SfcInstance) JSONObject.toBean(tempJsonObject, SfcInstance.class);
			mapMemList.get(tenantId).sfcInstanceList.add(sfcInstanceService.insertSfcInstance(sfcInstance));
		}
	}
	
	/**
	 * create resource
	 */
	@Override
	public int templateResourceCreate(int tenantId) throws InterruptedException{
		templateResourceToDB(tenantId);
		
		List<Map<String, String>> instanceList = new ArrayList<>();
		mapMemList.get(tenantId).stackIdMap.clear();
		
		//first step is send the requests of creating instance and vnf
		for(int i=0; i<mapMemList.get(tenantId).sfcList.size(); i++){
			
			//each sfc has one subnet
			List<String> networkResult = openStackNeutronApi.createNetwork(tenantId, mapMemList.get(tenantId).sfcList.get(i).getSfcName());
			String sfcId = mapMemList.get(tenantId).sfcList.get(i).getSfcId();
			SfcNetwork sfcNetwork = new SfcNetwork(sfcId,networkResult.get(0));
			sfcNetworkService.insertSfcNetwork(sfcNetwork);
			
			//create configure node
			String tempConfigNodeFloatingIpOsid = "";
			int tempConfigNodeFloatingIpId = 0;
			FloatingIp tempConfigNodeFloatingIp = floatingIpService.getRandomFloatingIp("DOWN");
			tempConfigNodeFloatingIp.setFloatingIpStatus("ACTIVE");
			floatingIpService.updateFloatingIpStatusByFloatingIpOsid(tempConfigNodeFloatingIp.getFloatingIpOsid(), "ACTIVE");
			tempConfigNodeFloatingIpOsid=tempConfigNodeFloatingIp.getFloatingIpOsid();
			tempConfigNodeFloatingIpId=tempConfigNodeFloatingIp.getFloatingIpId();
			configNodeApi.ConfigNodeCreate(networkResult.get(0), networkResult.get(1), tempConfigNodeFloatingIpOsid);
			configNodeList.put(mapMemList.get(tenantId).sfcList.get(i), tempConfigNodeFloatingIp.getFloatingIpAddr());
			
			//create vnf
			List<Vnf> vnfList = new ArrayList<>();
			vnfList = vnfService.getBySfcId(mapMemList.get(tenantId).sfcList.get(i).getSfcId());
			String tempFloatingIpOsid = "";
			int tempFloatingIpId = 0;
			System.out.println("## vnfList.size() = " + vnfList.size() + " ##");
			for(int j=0; j<vnfList.size(); j++){
				//if this sfc type is vm to outside , the last vnf need to add the second NIC and get a floatingip.
				//if(map_memlist.get(tenant_id).sfc_list.get(i).getSfc_type().equals("type2") && vnf_list.get(j).getVnf_id().equals(map_memlist.get(tenant_id).sfc_list.get(i).getSfc_egress())){
				if(j == vnfList.size()-1 && mapMemList.get(tenantId).sfcList.get(i).getSfcType().equals("type2")){
					FloatingIp tempFloatingIp = floatingIpService.getRandomFloatingIp("DOWN");
					tempFloatingIp.setFloatingIpStatus("ACTIVE");
					floatingIpService.updateFloatingIpStatusByFloatingIpOsid(tempFloatingIp.getFloatingIpOsid(), "ACTIVE");
					tempFloatingIpOsid=tempFloatingIp.getFloatingIpOsid();
					tempFloatingIpId=tempFloatingIp.getFloatingIpId();
					createInstance("vnf",vnfList.get(j).getVnfId(),tenantId,networkResult.get(0),networkResult.get(1),tempFloatingIpOsid);
				}else{
					createInstance("vnf",vnfList.get(j).getVnfId(),tenantId,networkResult.get(0),networkResult.get(1),"");
				}
			}
			
			List<Instance> tempInstanceList = new ArrayList<Instance>();
			tempInstanceList = instanceService.getBySfcId(mapMemList.get(tenantId).sfcList.get(i).getSfcId());
			
			System.out.println("## tempInstanceList.size() = " + tempInstanceList.size() + " ##");
			for(int j=0; j<tempInstanceList.size(); j++){
				createInstance("", tempInstanceList.get(j).getInstanceId(), tenantId, networkResult.get(0), networkResult.get(1), "");
			}
		}
		
		//second step is to insure all instance has been created successful
		
		//save the second NIC's IP address
		String tempInstanceIP2 = "";
		
		while(true){
			Thread.sleep(10000);
			boolean flag = true;
			String stackLists = openStackHeatApi.ListStack();
			JSONObject jo1 = JSONObject.fromObject(stackLists);
			JSONArray jo2 = jo1.getJSONArray("stacks");
			for(int ik=0; ik<jo2.size(); ik++){
				JSONObject jo3 = JSONObject.fromObject(jo2.get(ik));
				Integer dd = Integer.parseInt(jo3.getString("stack_name").substring(5));
				if(!mapMemList.get(tenantId).stackIdMap.containsKey(dd)){
					continue;
				}
				String stackStatus = jo3.getString("stack_status");
				if(!stackStatus.equals("CREATE_COMPLETE")){
					//if some stacks havn't been created yet,set flag false,into next loop
					flag = false;
					break;
				}
			}
			
			if(flag == true){
				//all stacks have been created successful,we need to let the information writed into database
				String ingressIP = "";
				String egressIP = "";
				for(int ik=0; ik<jo2.size(); ik++){
					JSONObject jo3 = JSONObject.fromObject(jo2.get(ik));
					Integer dd = Integer.parseInt(jo3.getString("stack_name").substring(5));
					if(!mapMemList.get(tenantId).stackIdMap.containsKey(dd)){
						continue;
					}
					String stackName = jo3.getString("stack_name");
					String stackId = jo3.getString("id");
					String showStackResult = openStackHeatApi.ShowStack(stackName, stackId);
					String tempStackOsid = "";
					String tempInstanceOsid = "";
					String tempInstanceIP = "";
					int tempInstanceIPId = 0;
					String tempOsportOsid = "";
					String tempOsportOsid2 = "";
					JSONObject hj1 = JSONObject.fromObject(showStackResult);
					JSONObject hj2 = hj1.getJSONObject("stack");
					tempStackOsid = hj2.getString("id");
					JSONArray hj3 = hj2.getJSONArray("outputs");
					for(int index=0; index<hj3.size(); index++){
				    	 JSONObject hj4 = JSONObject.fromObject(hj3.get(index));
				    	 String outputKey = hj4.getString("output_key");
				    	 if(outputKey.equals("instance_addr")){
				    		 tempInstanceIP = hj4.getString("output_value");
				    	 }else if(outputKey.equals("instance_osid")){
				    		 tempInstanceOsid=hj4.getString("output_value");
				    	 }else if(outputKey.equals("instance_osport_osid")){
				    		 tempOsportOsid = hj4.getString("output_value");
				    	 }else if(outputKey.equals("instance_osport_osid2")){
				    		 tempOsportOsid2 = hj4.getString("output_value");
				    	 }else if(outputKey.equals("instance_ip2")){
				    		 tempInstanceIP2 = hj4.getString("output_value").substring(2,hj4.getString("output_value").length()-2);
				    	 }
				    }
				    int tempStackId = Integer.parseInt(stackName.substring(5));
				    Stack tempStack = stackService.getByStackId(tempStackId);
				    tempStack.setStackIp(tempInstanceIP);
				    tempStack.setStackStatus("ACTIVE");
				    tempStack.setStackName(stackName);
				    tempStack.setStackOsid(tempStackOsid);
				    stackService.insertStack(tempStack);
				    if(vnfService.getByStackId(tempStackId) == null){
				    	 Instance instance = instanceService.getByStackId(tempStackId);
				    	 Map<String, String> map = new HashMap<String, String>();
				    	 map.put("type", instance.getInstanceType());
				    	 map.put("ip", tempInstanceIP);
				    	 map.put("id", instance.getInstanceId());
				    	 instanceList.add(map);
				    	 instance.setInstanceOsid(tempInstanceOsid);
				    	 instance.setInstanceStatus("ACTIVE");
				    	 instanceService.insertInstance(instance);
				    }else{
					     Vnf tempVnf=vnfService.getByStackId(tempStackId);
					     tempVnf.setVnfStatus("ACTIVE");
					     vnfService.insertVnf(tempVnf);
				    	 Sfc sfc = sfcService.getByStackId(tempStackId);
				    	 if(sfc.getSfcIngress().equals(vnfService.getByStackId(tempStackId).getVnfName())){
				    		 ingressIP = tempInstanceIP;
				    	 }else if(sfc.getSfcEgress().equals(vnfService.getByStackId(tempStackId).getVnfName())){
				    		 egressIP = tempInstanceIP;
				    	 }
				    }
				}
				
				for (int i = 0; i < instanceList.size(); i++) {
					//create instance's bridge
					//create instance and sfc_egress, sfc_ingress's link
					if(instanceList.get(i).get("type").equals("ingress")){
						String configIp = configNodeList.get(instanceList.get(i).get("id"));
						sshConfigApi.createBridge("ingress", instanceList.get(i).get("ip"), 
								instanceList.get(i).get("id"), ingressIP, configIp);
					}
					else{
						String configIp = configNodeList.get(instanceList.get(i).get("id"));
						sshConfigApi.createBridge("egress", instanceList.get(i).get("ip"), 
								instanceList.get(i).get("id"), egressIP, configIp);
					}
				}
				break;
			}
		}
		
		for(int i=0; i<mapMemList.get(tenantId).sfcList.size();i++){
			Sfc tempSfc = mapMemList.get(tenantId).sfcList.get(i);
			String headVnfId = tempSfc.getSfcIngress();
			String tailVnfId = tempSfc.getSfcEgress();
			List<String> headInstanceIp = new ArrayList<>();
			List<String> tailInstanceIp = new ArrayList<>();
			String[] internServerIp = new String[instanceList.size()];
			for(int j=0; j<instanceList.size(); j++){
				if(instanceList.get(j).get("type").equals("ingress")){
					headInstanceIp.add(instanceList.get(j).get("ip"));
					Instance instance = instanceService.getByInstanceId(instanceList.get(j).get("id"));
					internServerIp[j] = instance.getInstanceIp();
				}else{
					tailInstanceIp.add(instanceList.get(j).get("ip"));
				}
			}
			
			ArrayList<Link> linkList = (ArrayList<Link>) linkService.getBySfcId(tempSfc.getSfcId());
			String tempSrc = "";
			String tempDst = "";
			String tempPresent = headVnfId;
			
			while(true){
				if(tempPresent.equals(tailVnfId)){
					String localIp = stackService.getByVnfName(tempPresent, tempSfc.getSfcId()).getStackIp();
					String vnfType = vnfService.getByVnfName(tempPresent).getVnfType();
					String vnfConfig = vnfService.getByVnfName(tempPresent).getVnfConfig();
					String backIp = stackService.getByVnfName(tempSrc, tempSfc.getSfcId()).getStackIp();
					String configIp = configNodeList.get(tempSfc.getSfcId());
					sshConfigApi.addLink("egress", localIp, backIp, "", vnfType, tempInstanceIP2, internServerIp[0], configIp);
					sshConfigApi.addConfig("egress", vnfType, vnfConfig, tempInstanceIP2, internServerIp[0], localIp, configIp);
					break;
				}else{
					for(int j=0; j<linkList.size(); j++){
						if(linkList.get(j).getLinkSrc().equals(tempPresent)){
							tempDst = linkList.get(j).getLinkDst();
							break;
						}
					}
					if(tempPresent.equals(headVnfId)){
						String localIp = stackService.getByVnfName(tempPresent, tempSfc.getSfcId()).getStackIp();
						String vnfType = vnfService.getByVnfName(tempPresent).getVnfType();
						String forwardIp = stackService.getByVnfName(tempDst, tempSfc.getSfcId()).getStackIp();
						String vnfConfig = vnfService.getByVnfName(tempPresent).getVnfConfig();
						String configIp = configNodeList.get(tempSfc.getSfcId());
						sshConfigApi.addLink("ingress", localIp, headInstanceIp.get(0), forwardIp, vnfType, tempInstanceIP2, internServerIp[0], configIp);
						sshConfigApi.addConfig("ingress", vnfType, vnfConfig, tempInstanceIP2, internServerIp[0], localIp, configIp);
					}else{
						String localIp = stackService.getByVnfName(tempPresent, tempSfc.getSfcId()).getStackIp();
						String vnfType = vnfService.getByVnfName(tempPresent).getVnfType();
						String vnfConfig = vnfService.getByVnfName(tempPresent).getVnfConfig();
						String backIp = stackService.getByVnfName(tempSrc, tempSfc.getSfcId()).getStackIp();
						String forwardIp = stackService.getByVnfName(tempDst, tempSfc.getSfcId()).getStackIp();
						String configIp = configNodeList.get(tempSfc.getSfcId());
						sshConfigApi.addLink("", localIp, backIp, forwardIp, vnfType, tempInstanceIP2, internServerIp[0], configIp);
						sshConfigApi.addConfig("", vnfType, vnfConfig, tempInstanceIP2, internServerIp[0], localIp, configIp);
					}
					tempSrc = tempPresent;
					tempPresent = tempDst;
				}
			}
			tempSfc.setSfcStatus("ACTIVE");
			sfcService.insertSfc(tempSfc);
		}
		logger.info("## ALL Operation Done ##");
		return 0;
	}
	/**
	 * call OpenStack heat API to create vm
	 * @param type
	 * @param instanceId
	 * @param tenantId
	 * @param netId
	 * @param subnetId
	 * @param tempFloatingIpOsid
	 * @return
	 */
	private int createInstance(String type, String instanceId, int tenantId, String netId, String subnetId,
			String tempFloatingIpOsid) {
		Integer flavorId=0;
		Integer imageId=0;
		String flavorOsid="";
		String instanceType = "vnf";
		String imageOsid=AppProperties.getimageOsid();
		String networkOsid=netId;
		String subnetOsid=subnetId;
		
		if(type.equals(instanceType)){
			for(int i=0;i<mapMemList.get(tenantId).vnfFlavorList.size();i++)
			{
				if(instanceId.equals(mapMemList.get(tenantId).vnfFlavorList.get(i).getVnfId()))
				{
					flavorId=mapMemList.get(tenantId).vnfFlavorList.get(i).getFlavorId();
					flavorOsid=flavorService.getByFlavorId(flavorId).getFlavorOsid();
					break;
				}
			}
		}else{
			for(int i=0;i<mapMemList.get(tenantId).flavorInstanceList.size();i++)
			{
				if(instanceId.equals(mapMemList.get(tenantId).flavorInstanceList.get(i).getInstanceId()))
				{
					flavorId=mapMemList.get(tenantId).flavorInstanceList.get(i).getFlavorId();
					flavorOsid=flavorService.getByFlavorId(flavorId).getFlavorOsid();
					break;
				}
			}
			for(int i=0;i<mapMemList.get(tenantId).imageInstanceList.size();i++)
			{
				if(instanceId.equals(mapMemList.get(tenantId).imageInstanceList.get(i).getInstanceId()))
				{
					imageId=mapMemList.get(tenantId).imageInstanceList.get(i).getImageId();
					imageOsid=imageService.getByImageId(imageId).getImageOsid();
					break;
				}
			}
		}
		
		
		// assign vm into specified vm by a dedicated algorithm
		
		int numOfComputes=Integer.parseInt(AppProperties.getcomputeNum());
		List<String> computeNames=AppProperties.getcomputesNames(numOfComputes);
		Random random=new Random();
		int randomIndexCompute=random.nextInt(numOfComputes);
		String computeZoneName=computeNames.get(randomIndexCompute);
		
		int stackId=openStackHeatApi.createInstance(instanceId, flavorOsid, imageOsid, networkOsid, subnetOsid, tempFloatingIpOsid, computeZoneName);
		
		// add stack_id into hash table, used for detecting stack state
		mapMemList.get(tenantId).stackIdMap.put(stackId, 1);
		
		if(type.equals(instanceType)){
			//create vnf_stack entry, write stack and vnf info
			VnfStack tempVnfStack=new VnfStack();
			tempVnfStack.setStackId(stackId);
			tempVnfStack.setVnfId(instanceId);
			vnfStackService.insertVnfStack(tempVnfStack);
		}else{
		//  create instance_stack entry, write stack and instance info
			InstanceStack tempInsStack=new InstanceStack();
			tempInsStack.setStackId(stackId);
			tempInsStack.setInstanceId(instanceId);
			instanceStackService.insertInstanceStack(tempInsStack);
		}
		
		return stackId;
	}

	/**
	 * resource delete
	 */
	@Override
	public void templateResourceDelete(){
		
	}
	/**
	 * resource update
	 */
	@Override
	public void templateResourceUpdate(int tenantId){
		JSONArray vnfArray = jsonObject.getJSONArray("vnf");
		String configIp = configNodeList.get(jsonObject.get("sfcId"));
		for(int i=0; i<vnfArray.size(); i++){
			JSONObject jsonObject = vnfArray.getJSONObject(i);
			Vnf vnf = vnfService.getByVnfId(jsonObject.getString("vnfId"));
			vnf.setVnfConfig(jsonObject.getString("vnfConfig"));
			String desIp = stackService.getByStackId(vnfStackService.getByVnfId(vnf.getVnfId())).getStackIp();
			
			String result = sshConfigApi.updateConfig(desIp, configIp, vnf.getVnfConfig());
			if(result.equals("")){
				vnfService.updateVnf(vnf);
			}
		}
		
	}
	
}
