package com.example.demo.configplatform;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.openstack.OpenStackHeatApi;
import com.example.demo.util.AppProperties;
/**
 * @class ConfigNodeApi
 * @brief create config node
 * @author ychuang
 * @note
 * call OpenStackHeatApi to create one config node for each service function chaining instance
 *
 */
@Service
public class ConfigNodeApi {

	@Autowired
	OpenStackHeatApi openStackHeatApi;
	/**
	 * call OpenStackHeatApi to create config node
	 * @param networkOsid ：OpenStack network Osid
	 * @param subnetOsid ：OpenStack subnet Osid
	 * @param floatingIpOsid ：config node floating Ip Osid
	 * @return floating IP address
	 */
	public String ConfigNodeCreate(String networkOsid, String subnetOsid, String floatingIpOsid){
		String flavorOsid="2";
		String imageOsid="";
		
		int numOfComputes=Integer.parseInt(AppProperties.getcomputeNum());
		List<String> computeNames=AppProperties.getcomputesNames(numOfComputes);
		Random random=new Random();
		int randomIndexCompute=random.nextInt(numOfComputes);
		String computeZoneName=computeNames.get(randomIndexCompute);
		
		openStackHeatApi.createInstance("confignode~2017-06-01 18:16:33~1", flavorOsid, imageOsid, networkOsid, subnetOsid, floatingIpOsid, computeZoneName);
		return null;
		
	}
}
