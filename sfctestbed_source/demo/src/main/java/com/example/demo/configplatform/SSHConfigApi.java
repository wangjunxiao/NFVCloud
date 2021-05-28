package com.example.demo.configplatform;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modular.Instance;
import com.example.demo.modular.Subnet;
import com.example.demo.openstack.OpenStackNeutronApi;
import com.example.demo.service.InstanceService;
import com.example.demo.service.SubnetService;
import com.example.demo.util.AppProperties;
import com.example.demo.util.HttpRequest;
/**
 * @class SSHConfigApi
 * @brief confi VNF node and internal overlay link
 * @author ychuang
 * @note
 * init: add virtual nic for each VNF with specified MAC and IP address
 * link: create GRE tunnel with OVS, directing request between VNFs
 * vnf config: use .click file to load vnf service
 * vnf update: reload .click file
 *
 */
@Service
public class SSHConfigApi {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InstanceService instanceService;
	
	@Autowired
	private SubnetService subnetService;
	
	@Autowired
	private OpenStackNeutronApi openStackNeutronApi;
	
	/**
	 * create virtual nic for VNF, and config with specified MAC and IP, add flow rule to determine the steering
	 * @param type	vnf location in SFC, includes chain head, middle, tail
	 * @param localIp	VNF vm's IP address
	 * @param backIp	next hop VNF vm's IP address
	 * @param forwardIp	last hop VNF vm's IP address
	 * @param vnfType	VNF type, such as Firewalls, NAT.
	 * @param instanceIp2	required if SFC is cross domain, the IP is OpenStack floating IP
	 * @param internServer	required for NAT, internal device's IP address
	 * @param configIp	config node's IP address, used for RPC
	 * @return	return RPC results
	 */
	public String addLink(String type, String localIp, String backIp, String forwardIp, String vnfType, String instanceIp2, String internServer, String configIp){
		logger.info("## SSHConfigApi addLink param list: " + "type=" + type + " localIp=" + localIp + " backIp=" + backIp
				+ " forwardIp=" + forwardIp + " vnfType=" + vnfType + " instanceIp2=" + instanceIp2 + " internServer=" + internServer + " ##");
		logger.info("## addLink ##");
		String POST_URL = "http://"+configIp+":56789";
		String content = "";
		String intern = subnetService.getBySubnetType("intern").getSubnetCidr();
		String internCidr = getDefaultGwByCIDR("intern");
		String externCidr = "";
		if(!instanceIp2.equals("")){
			externCidr = instanceIp2 + "/20";	//	must be modified
		}else{
			externCidr = getDefaultGwByCIDR("extern");
		}
		logger.info("## internCidr = " + internCidr + " ##");
		logger.info("## externCidr = " + externCidr + " ##");
		if(vnfType.equals("NAT")){
			content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"ssh\",\"params\":{" +
					"\"cmd\":\"" + "ovs-vsctl add-br vfunc-br~" +
					"ovs-vsctl add-port vfunc-br vfunc-forward -- set interface vfunc-forward type=gre " +
					"options:df_default=true options:in_key=flow options:local_ip=" + localIp +
					" options:out_key=flow options:remote_ip=" + forwardIp + "~" + 
					"ovs-vsctl add-port vfunc-br vfunc-backward -- set interface vfunc-backward type=gre " +
					"options:df_default=true options:in_key=flow options:local_ip=" + localIp +
					" options:out_key=flow options:remote_ip=" + backIp + "~" +
					"ovs-vsctl add-port vfunc-br p1 -- set interface p1 ofport_request=1" + "~" +
					"ovs-vsctl add-port vfunc-br p2 -- set interface p2 ofport_request=2" + "~" +
					"ovs-vsctl set interface p1 type=internal" + "~" +
					"ovs-vsctl set interface p2 type=internal" + "~" +
					"ifconfig p1 hw ether fa:39:c6:60:a5:05" + "~" +		
					"ifconfig p2 hw ether 6a:c4:5c:e7:8f:61" + "~" +		
					"ifconfig p1 " + internCidr + " up" + "~" +		// modify by getSubnet_cidr()
					"ifconfig p2 " + externCidr + " ; ifconfig p2 down" +  "~" +		//Ditto
					"ifconfig p1 promisc" + "~" +
					"ifconfig p2 promisc" + "~" +
					"ifconfig p1 mtu 1400" + "~" +
					"ifconfig p2 mtu 1400" + "~" +
					"ovs-vsctl set interface vfunc-forward ofport_request=3" + "~" +
					"ovs-vsctl set interface vfunc-backward ofport_request=4" +  "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=1,actions=output:4" + "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=4,actions=output:1" + "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=2,actions=output:3" + "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=3,actions=output:2" + "~" +
					"route add -net " + intern + " gw " + internCidr.split("/")[0] + 
					"\",\"ip\":\"" + localIp + "\"}}";
		}else if(!instanceIp2.equals("") && vnfType.equals("Firewall") && type.equals("egress")){
			content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"ssh\",\"params\":{" +
					"\"cmd\":\"" + "ovs-vsctl add-br vfunc-br~" +
					"ovs-vsctl add-port vfunc-br vfunc-backward -- set interface vfunc-backward type=gre " +
					"options:df_default=true options:in_key=flow options:local_ip=" + localIp +
					" options:out_key=flow options:remote_ip=" + backIp + "~" +
					"ovs-vsctl add-port vfunc-br p1 -- set interface p1 ofport_request=1" + "~" +
					"ovs-vsctl set interface p1 type=internal" + "~" +
					"ifconfig p1 0 up" + "~" +		
					"ifconfig p1 promisc" + "~" +
					"ifconfig p1 mtu 1400" + "~" +
					"ovs-vsctl set interface vfunc-backward ofport_request=2" +  "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=1,actions=output:2" + "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=2,actions=output:1" + "~" +
					"ifconfig eth1 promisc" + "~" +
					"dhclient eth1" + 
					"\",\"ip\":\"" + instanceIp2 + "\"}}";
		}else{
			content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"ssh\",\"params\":{" +
					"\"cmd\":\"" + "ovs-vsctl add-br vfunc-br~" +
					"ovs-vsctl add-port vfunc-br vfunc-forward -- set interface vfunc-forward type=gre " +
					"options:df_default=true options:in_key=flow options:local_ip=" + localIp +
					" options:out_key=flow options:remote_ip=" + forwardIp + "~" + 
					"ovs-vsctl add-port vfunc-br vfunc-backward -- set interface vfunc-backward type=gre " +
					"options:df_default=true options:in_key=flow options:local_ip=" + localIp +
					" options:out_key=flow options:remote_ip=" + backIp + "~" +
					"ovs-vsctl add-port vfunc-br p1 -- set interface p1 ofport_request=1" + "~" +
					"ovs-vsctl add-port vfunc-br p2 -- set interface p2 ofport_request=2" + "~" +
					"ovs-vsctl set interface p1 type=internal" + "~" +
					"ovs-vsctl set interface p2 type=internal" + "~" +
					"ifconfig p1 0 up" + "~" +		
					"ifconfig p2 0 up" + "~" +		
					"ifconfig p1 promisc" + "~" +
					"ifconfig p2 promisc" + "~" +
					"ifconfig p1 mtu 1400" + "~" +
					"ifconfig p2 mtu 1400" + "~" +
					"ovs-vsctl set interface vfunc-forward ofport_request=3" + "~" +
					"ovs-vsctl set interface vfunc-backward ofport_request=4" +  "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=1,actions=output:4" + "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=4,actions=output:1" + "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=2,actions=output:3" + "~" +
					"ovs-ofctl add-flow vfunc-br priority=10,in_port=3,actions=output:2" +
					"\",\"ip\":\"" + localIp + "\"}}";
		}
		String result = "";
		try {
	    	result = HttpRequest.rpcFromPost(POST_URL, content);
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	
	/**
	 * create SFC virtual nic on endhost, used for connecting SFC head or tail
	 * @param type	head or tail
	 * @param instanceIp  host ip address
	 * @param instanceId  host instance ID, used for setting virtual nic with specified ip address
	 * @param otherIp  SFC head or tail VNF's IP address, used for building GRE tunnel
	 * @param configIp	config node ip address
	 * @return	return RPC results
	 */
	public String createBridge(String type, String instanceIp, String instanceId, String otherIp, String configIp) {
		logger.info("## SSHCpnfigApi createBridge param list: " + " type=" + type + " instanceIp=" + instanceIp + " instanceId=" + instanceId + " otherIp=" + otherIp + " ##");
		String POST_URL = "http://"+configIp+":56789";
		Instance instance = instanceService.getByInstanceId(instanceId);
		Subnet subnet = subnetService.getByInstanceId(instanceId);
		String content = "";
		String partOfCidr = "/" + subnet.getSubnetCidr().split("/")[1];
		logger.info("## " + partOfCidr + " ##");
		String ip = instance.getInstanceIp() + partOfCidr;
		if(type.equals("ingress")){
			content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"ssh\",\"params\":{" +
			"\"cmd\":\"" +
			"ovs-vsctl add-br vfunc-br~" +
			"ovs-vsctl add-port vfunc-br vfunc-forward -- set interface vfunc-forward type=gre " +
			"options:df_default=true options:in_key=flow options:local_ip=" + instanceIp +
			" options:out_key=flow options:remote_ip=" + otherIp + "~ovs-vsctl add-port vfunc-br ptest " +
			"-- set Interface ptest ofport_request=1 -- set Interface ptest type=internal~" +
			"ovs-vsctl set interface vfunc-forward ofport_request=2" + "~" +
			"ip netns add ns1" + "~" +
			"ip link set ptest netns ns1" + "~" +
			"ip netns exec ns1 ip addr add " + ip + " dev ptest~ip netns exec ns1 ifconfig ptest promisc up" + "~" +
			"ip netns exec ns1 ifconfig ptest mtu 1400" + "~" +
			"ovs-ofctl add-flow vfunc-br priority=10,in_port=1,actions=output:2" + "~" +
			"ovs-ofctl add-flow vfunc-br priority=10,in_port=2,actions=output:1" +
			"\"," +
			"\"ip\":\"" + instanceIp + "\"}}";
		}
		else{
			content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"ssh\",\"params\":{" +
			"\"cmd\":\"" +
			"ovs-vsctl add-br vfunc-br~" +
			"ovs-vsctl add-port vfunc-br vfunc-backward -- set interface vfunc-backward type=gre " +
			"options:df_default=true options:in_key=flow options:local_ip=" + instanceIp +
			" options:out_key=flow options:remote_ip=" + otherIp + "~ovs-vsctl add-port vfunc-br ptest " +
			"-- set Interface ptest ofport_request=1 -- set Interface ptest type=internal~" +
			"ovs-vsctl set interface vfunc-backward ofport_request=2" + "~" +
			"ip netns add ns1" + "~" +
			"ip link set ptest netns ns1" + "~" +
			"ip netns exec ns1 ip addr add " + ip + " dev ptest~ip netns exec ns1 ifconfig ptest promisc up" + "~" +
			"ip netns exec ns1 ifconfig ptest mtu 1400" + "~" +
			"ovs-ofctl add-flow vfunc-br priority=10,in_port=1,actions=output:2" + "~" +
			"ovs-ofctl add-flow vfunc-br priority=10,in_port=2,actions=output:1" +
			"\"," +
			"\"ip\":\"" + instanceIp + "\"}}";
		}
	    String result = "";
	    try {
	    	result = HttpRequest.rpcFromPost(POST_URL, content);
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    while(result.equals("")){
	    	logger.info("## rpsresponse is empty ##");
	    	
	    }
	    return result;
	}
	
	/**
	 * load .click into VNF's vm
	 * @param type	the location of VNF in SFC, head, tail or middle
	 * @param vnfType	the type of VNF, Firewalls or nat
	 * @param vnfConfig	 .click config file
	 * @param instanceIp  NAT external ip address, used for building .click's AddressInfo component
	 * @param internServer	in NAT, used for building .click's AddressIndo component
	 * @param localIp	VNF vm's ip address which config node can touch
	 * @param configIp	config node's ip address
	 * @return	return RPC results
	 */
	public String addConfig(String type, String vnfType, String vnfConfig, String instanceIp, String internServer, String localIp, String configIp){
		logger.info("## SSHConfigApi addConfig param list: " + " type=" + type + " vnfType=" + vnfType
				+ " vnfConfig=" + vnfConfig + " instanceIp=" + instanceIp + " internServer=" + internServer + " localIp=" + localIp + " ##");
		String POST_URL = "http://"+configIp+":56789";
		String content = "";
		String macAddress = openStackNeutronApi.getGatewayMacAddress();
		Subnet internSubnet = subnetService.getBySubnetType("intern");
		String intern = internSubnet.getSubnetCidr();
		Subnet externSubnet = subnetService.getBySubnetType("intern");
		String extern = externSubnet.getSubnetCidr();
		String internCidr = getDefaultGwByCIDR("intern");
		String externCidr = "";
		if(!instanceIp.equals("")){
			externCidr = instanceIp + "/20";	//	must be modified
		}else{
			externCidr = getDefaultGwByCIDR("extern");
		}
		String addressInfo = "";
		String ipAddress = "";
		if(vnfType.equals("NAT") && instanceIp.equals("")){
			addressInfo = "AddressInfo(" + " " + " intern " + internCidr.split("/")[0] + " " + intern + " fa:39:c6:60:a5:05, " 
				  + " extern " + externCidr.split("/")[0] + " " + extern + " 6a:c4:5c:e7:8f:61, " 
				  + " intern_server " + internServer + ", " 
				  + ");";
			ipAddress = localIp;
		}else if(vnfType.equals("NAT") && !instanceIp.equals("")){
			addressInfo = "AddressInfo(" + " " + " intern " + internCidr.split("/")[0] + " " + intern + " fa:39:c6:60:a5:05, " 
				  + " extern " + externCidr.split("/")[0] + " " + externCidr + " 6a:c4:5c:e7:8f:61, " 
				  + " extern_next_hop " + macAddress + ", " 
				  + " intern_server " + internServer + ", " 
				  + ");";
			ipAddress = localIp;
		}else if(vnfType.equals("Firewall") && type.equals("egress") && !instanceIp.equals("")){
			ipAddress = instanceIp;
		}else if(vnfType.equals("Firewall") && (type.equals("egress") || type.equals("")) && instanceIp.equals("")){
			ipAddress = localIp;
		}else if(vnfType.equals("Firewall")  && type.equals("ingress")){
			ipAddress = localIp;
		}
		content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"config\",\"params\":{" +
				"\"ip\":\"" + ipAddress + "\",\"config\":\"" + addressInfo + vnfConfig + "\"}}";
		String result = "";
		System.out.println(content);
		try {
	    	result = HttpRequest.rpcFromPost(POST_URL, content);
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	
	/**
	 * update VNF instance's .click file
	 * @param desIp	 the ip address of the VNF that need to be updated .click file
	 * @param configIp	ip address used for config
	 * @param vnfConfig	.click content used for updating
	 * @return	return RPC results
	 */
	public String updateConfig(String desIp, String configIp, String vnfConfig){
		String POST_URL = "http://"+configIp+":56789";
		String content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"update\",\"params\":{" +
				"\"ip\":\"" + desIp + "\",\"config\":\"" + vnfConfig + "\"}}";
		String result = "";
		System.out.println(content);
		try {
	    	result = HttpRequest.rpcFromPost(POST_URL, content);
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	
	/**
	 * user defined external and internal subnet CIDR
	 * @param type	external or internal
	 * @return	return subnet gateway's CIDR
	 */
	//create nat's intern network ipaddress and nat's extern network ipaddress.
	public String getDefaultGwByCIDR(String type){
		Subnet subnet = subnetService.getBySubnetType(type);
		String internCidr = subnet.getSubnetCidr();
		String[] partOfCidr = internCidr.split("/");
		String[] partOfIp = partOfCidr[0].split("\\.");
		int defaultGWIP = Integer.parseInt(partOfIp[3]) + 1;
		String defaultGWCidr = partOfIp[0] + "." + partOfIp[1] + "." + partOfIp[2] + "." + defaultGWIP + "/" + partOfIp[1];
		return defaultGWCidr;
	}
}
