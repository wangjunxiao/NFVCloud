package com.example.demo.openstack;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modular.Stack;
import com.example.demo.service.StackService;
import com.example.demo.util.AppProperties;
import com.example.demo.util.HttpRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @class OpenStackHeatApi
 * @brief OpenStack's heat API
 * @author 60912
 *
 */
@Service
public class OpenStackHeatApi {

	@Autowired
	private OpenStackIdentityApi openStackIdentityApi;
	
	@Autowired
	private StackService stackService;
	/**
	 * build heat template,call heatapi send template post to OpenStack for creating vm
	 * @param temp_ins_id
	 * @param flavor_osid
	 * @param image_osid
	 * @param network_osid
	 * @param subnet_osid
	 * @param floatingip_osid
	 * @param compute_zone_name
	 * @return
	 */
	public int createInstance(String temp_ins_id,String flavor_osid,String image_osid,
			String network_osid,String subnet_osid,String floatingip_osid,String compute_zone_name)
	{
//		String POST_URL="http://192.168.0.87:8004/v1/2379e521097a4f7986f8f7dde862d922/stacks";
		String POST_URL="http://"+AppProperties.getcontrolAddr()+":8004/v1/"
						+AppProperties.gettenantDemo()+"/stacks";
		String content="";
		
		Date dt=new Date();
		//DateFormat df=new SimpleDateFormat("HHmmss");
		
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String nowTime="";
		nowTime=df.format(dt);
		

		JSONObject json1=new JSONObject();
		JSONObject json2=new JSONObject();
		JSONObject json3=new JSONObject();
		JSONObject json4=new JSONObject();
		JSONObject json5=new JSONObject();
		JSONArray jsonarray1=new JSONArray();
		JSONObject json6=new JSONObject();
		JSONObject json7=new JSONObject();
		JSONObject json8=new JSONObject();
		JSONObject json9=new JSONObject();
		JSONObject json10=new JSONObject();
		JSONArray jsonarray2=new JSONArray();
		JSONObject json11=new JSONObject();
		JSONObject json12=new JSONObject();
		JSONObject json13=new JSONObject();
		JSONObject json14=new JSONObject();
		JSONObject json15=new JSONObject();
		JSONObject json16=new JSONObject();
		JSONObject json17=new JSONObject();
		JSONObject json18=new JSONObject();
		JSONObject json19=new JSONObject();
		JSONObject json20=new JSONObject();
		
		JSONObject json21=new JSONObject();
		JSONObject json22=new JSONObject();
		JSONObject json23=new JSONObject();
		JSONObject json60=new JSONObject();
		JSONObject json61=new JSONObject();
		
		List<String> array3=new ArrayList<String>();
		List<String> array4=new ArrayList<String>();
		List<String> array5=new ArrayList<String>();
		List<String> array6=new ArrayList<String>();
		
		//JSONArray jsonarray3=new JSONArray();
		
		//private_ip
		array5.add("vm1");
		array5.add("first_address");
		json16.put("get_attr", array5);
		json15.put("value", json16);
		
		json18.put("get_resource", "vm1");
		json17.put("value", json18);
		
		json20.put("get_resource", "port1");
		json19.put("value", json20);
		
		json14.put("instance_osport_osid", json19);
		json14.put("instance_osid", json17);
		json14.put("instance_addr", json15);
		
		
		
		json13.put("get_resource", "port1");
		if(!floatingip_osid.equals(""))
		{
			//set vnf's floatingip and second NIC
			json21.put("get_resource", "port2");
			json22.put("value",json21);
			array6.add("vm1");
			array6.add("networks");
			array6.add("sfc-iface-net");
			json60.put("get_attr", array6);
			json61.put("value", json60);
			json14.put("instance_osport_osid2", json22);
			json14.put("instance_ip2", json61);
			
			json12.put("floatingip_id", floatingip_osid);
			
			JSONObject json50=new JSONObject();
			json50.put("get_resource", "port2");
			
			json12.put("port_id", json50);
			
			json11.put("type","OS::Neutron::FloatingIPAssociation");
			json11.put("properties", json12);
			
			array3.add("vm1");
			json11.put("depends_on", array3);
			json3.put("floating_ip_ass", json11);
		}
		
		json2.put("outputs", json14);
		
		//single port by default, name as port1
		json7.put("get_resource", "port1") ;  
		json6.put("port",json7);
		
		if(!floatingip_osid.equals(""))
		{
			// resources add second nic 
			
			String temp_network_osid=AppProperties.getnetworkOsid();
			String temp_subnet_osid=AppProperties.getsubnetOsid();
			
			JSONObject json30=new JSONObject();
			json30.put("network_id", temp_network_osid);
			JSONObject json31=new JSONObject();
			json31.put("subnet_id", temp_subnet_osid);
			JSONArray array32=new JSONArray();
			array32.add(json31);
			json30.put("fixed_ips", array32);
			
			JSONObject json34=new JSONObject(); 
			json34.put("properties", json30);
			json34.put("type", "OS::Neutron::Port");
			
			json3.put("port2",json34);
			
			JSONObject json35=new JSONObject();
			json35.put("get_resource", "port2");
			
			JSONObject json36=new JSONObject();
			json36.put("port", json35);
			
			jsonarray1.add(json36);
			
			array4.add("port2");
			
		}
		jsonarray1.add(json6);
		
		
		json5.put("networks",jsonarray1);
		json5.put("image",image_osid);
		json5.put("flavor", flavor_osid);
		json5.put("availability_zone", compute_zone_name);
		array4.add("port1");
		
		json4.put("properties", json5);
		json4.put("depends_on", array4);
		json4.put("type", "OS::Nova::Server");
		json3.put("vm1", json4);
		
		
		
		// port info
		// security group info has not been added
		json10.put("subnet_id",subnet_osid);
		jsonarray2.add(json10);
		json9.put("fixed_ips",jsonarray2);
		json9.put("network_id", network_osid);
		
		json8.put("type","OS::Neutron::Port");
		json8.put("properties", json9);	
		
		json3.put("port1", json8);
		
		//outer
		
		json2.put("resources", json3);
		json2.put("heat_template_version", "2013-05-23");
		
		
		
		//outer stack_name as the identification of stac, must be unique
		//stack insert
		Stack temp_stack=new Stack(0,"","","","",compute_zone_name,"",nowTime);
		//insert initial stack into db
		int temp_stack_id=stackService.insertStack(temp_stack).getStackId();
		
		//use stack and incremental id as stack_name, send to openstack
		String stack_name="stack" + temp_stack_id;
		json1.put("stack_name",stack_name);
		json1.put("template", json2);
		
		content=json1.toString();
		
		//return content;

		String result="";
		
		openStackIdentityApi.validateToken(OpenStackIdentityApi.getHEADER_VALUE()); 
		
		System.out.println("####### http request for instance ###################");
		System.out.println(content);
		
		 try {
			 	result = HttpRequest.readContentFromPost(POST_URL, content, OpenStackIdentityApi.getHEADER_NAME(), OpenStackIdentityApi.getHEADER_VALUE());
	     } catch (IOException e) {
		    	// TODO Auto-generated catch block
	    	 	e.printStackTrace();
		 }
	    
	     //return stack_id
	     return temp_stack_id;
	}
	/**
	 * call OpenStack heat api get all stack list
	 * @return
	 */
	public String ListStack() {
		// TODO Auto-generated method stub
		
		// send GET to control node, get all stack info
		String GET_URL="http://"+AppProperties.getcontrolAddr()+":8004/v1/"
		+AppProperties.gettenantDemo()+"/stacks";
		String result = "";
		openStackIdentityApi.validateToken(OpenStackIdentityApi.getHEADER_VALUE());
		
		try {
			result = HttpRequest.readContentFromGet(GET_URL, OpenStackIdentityApi.getHEADER_NAME(), OpenStackIdentityApi.getHEADER_VALUE());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(result.length()==0){
				result = e.toString();
			}
		}
		return result;
	}
	/**
	 * use stack_name and stack_id as post, get all stacks
	 * @param stack_name
	 * @param stack_id
	 * @return
	 */
	public String ShowStack(String stack_name, String stack_id) {
		// TODO Auto-generated method stub
		
		String GET_URL="http://"+AppProperties.getcontrolAddr()+":8004/v1/"
		+AppProperties.gettenantDemo()+"/stacks/" + stack_name +  "/" + stack_id;
		String result = "";
		openStackIdentityApi.validateToken(OpenStackIdentityApi.getHEADER_VALUE());
		
		try {
			result = HttpRequest.readContentFromGet(GET_URL, OpenStackIdentityApi.getHEADER_NAME(), OpenStackIdentityApi.getHEADER_VALUE());
//			 	result = Vnet_HttpRequest.readContentFromGet(GET_URL, Vnet_OpsIdentityServiceImpl.getHEADER_NAME(), Vnet_OpsIdentityServiceImpl.getHEADER_VALUE());
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
}
