package com.example.demo.openstack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modular.Network;
import com.example.demo.service.NetworkService;
import com.example.demo.util.AppProperties;
import com.example.demo.util.HttpRequest;

import net.sf.json.JSONObject;
/**
 * @class OpenStackNeutronApi
 * @brief OpenStack's Neutron API, used for creating OpenStack subnet
 * @author ychuang
 *
 */
@Service
public class OpenStackNeutronApi {
	
	@Autowired
	private OpenStackIdentityApi openStackIdentityApi;
	
	@Autowired
	private NetworkService networkService;
	/**
	 * create SFC's OpenStack network
	 * @param tenantId
	 * @param sfcName
	 * @return network info
	 */
	public List<String> createNetwork(Integer tenantId, String sfcName) {
		List<String> networkResult = new ArrayList<String>();
		
		String netID = tenantId+"_"+sfcName;
		String controlAddr=AppProperties.getcontrolAddr();
		String POST_URL = "http://"+ controlAddr + ":9696/v2.0/networks";
		String result = "";
		String content = "{\"network\": {\"name\": \""+netID+"\",\"admin_state_up\": true}}";
		openStackIdentityApi.validateToken(OpenStackIdentityApi.getHEADER_VALUE());
		try {
			result = HttpRequest.readContentFromPost(POST_URL, content,OpenStackIdentityApi.getHEADER_NAME(), OpenStackIdentityApi.getHEADER_VALUE());
		} catch (IOException e) {
			e.printStackTrace();
			if(result.length()==0){
				result = e.toString();
			}
		}
		JSONObject jsonResult = JSONObject.fromObject(result).getJSONObject("network");
		networkResult.add(jsonResult.getString("id"));
		
		String POST_URL2 = "http://"+ controlAddr + ":9696/v2.0/subnets";
		String result2 = "";
		Network network = networkService.getByNetworkStatus("unused"); //unique in parallel
		network.setNetworkStatus("ACTIVE");
		networkService.insertNetwork(network);
		String content2 = "{\"subnet\":{\"network_id\":\"" + jsonResult.getString("id") + "\"," +
				"\"ip_version\":4,\"cidr\":\"" + network.getSubnetCidr() + "\"}}";
		try {
			result2 = HttpRequest.readContentFromPost(POST_URL2, content2,OpenStackIdentityApi.getHEADER_NAME(), OpenStackIdentityApi.getHEADER_VALUE());
		} catch (IOException e) {
			e.printStackTrace();
			if(result2.length()==0){
				result2 = e.toString();
			}
		}
		JSONObject jsonResult2 = JSONObject.fromObject(result2).getJSONObject("subnet");
		networkResult.add(jsonResult2.getString("id"));
		
		network.setNetworkOsid(jsonResult.getString("id"));
		network.setSubnetOsid(jsonResult2.getString("id"));
		networkService.insertNetwork(network);
		
		// Add Interface
		String PUT_URL = "http://"+ controlAddr + ":9696/v2.0/routers/" + AppProperties.getvrouterOsid()
							+ "/add_router_interface";
		String result3 = "";
		String content3 = "{\"subnet_id\": \"" + network.getSubnetOsid() + "\"}";
		try {
			result3 = HttpRequest.readContentFromPut(PUT_URL,content3,OpenStackIdentityApi.getHEADER_NAME(), OpenStackIdentityApi.getHEADER_VALUE());
		} catch (IOException e) {
			e.printStackTrace();
			if(result3.length()==0){
				result3 = e.toString();
			}
		}
		
		return networkResult;
	}
	/**
	 * get created subnet's default gateway mac
	 * @return mac address
	 */
	public String getGatewayMacAddress(){
		String controlAddr=AppProperties.getcontrolAddr();
		String networkOsid = AppProperties.getnetworkOsid();
		String GET_URL = "http://" + controlAddr + ":9696/v2.0/ports?network_id=" + networkOsid + "&device_owner=network:router_interface";
		String result = "";
		openStackIdentityApi.validateToken(OpenStackIdentityApi.getHEADER_VALUE());
		try {
			result = HttpRequest.readContentFromGet(GET_URL, OpenStackIdentityApi.getHEADER_NAME(), OpenStackIdentityApi.getHEADER_VALUE());
		} catch (IOException e) {
			e.printStackTrace();
		}	
		String macAddress = JSONObject.fromObject(result).getJSONArray("ports").getJSONObject(0).getString("mac_address");
		return macAddress;
	}
}
