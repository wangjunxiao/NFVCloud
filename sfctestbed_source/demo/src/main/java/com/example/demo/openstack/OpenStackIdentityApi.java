package com.example.demo.openstack;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.util.AppProperties;
import com.example.demo.util.HttpRequest;

import net.sf.json.JSONObject;
/**
 * OpenStack's keystone api, used for verifying identification from OpenStack
 * @author ychuang
 *
 */
@Service
@SuppressWarnings("all")
public class OpenStackIdentityApi {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static String HEADER_NAME = "X-Auth-Token";
	public static String HEADER_VALUE = "";
	
	public static String getHEADER_NAME() {
		return HEADER_NAME;
	}


	public static void setHEADER_NAME(String hEADER_NAME) {
		HEADER_NAME = hEADER_NAME;
	}

	public static String getHEADER_VALUE() {
		return HEADER_VALUE;
	}


	public static void setHEADER_VALUE(String hEADER_VALUE) {
		HEADER_VALUE = hEADER_VALUE;
	}
	/**
	 * build OpenStack access Token
	 */
	public void createToken(){
		logger.info("create a new token");
		String postUrl = "http://" + AppProperties.getcontrolAddr() + ":35357/v2.0/tokens";
		String content = "{\"auth\":{\"tenantName\":\"demo\","
		 		+ "\"passwordCredentials\":{\"username\":\"demo\",\"password\":\"0000\"}}}"; 
		 String result = "";
		 try{
			 result = HttpRequest.readContentFromPost(postUrl, content, "", "");
		 }catch(IOException e){
			 e.printStackTrace();
		 }
		 JSONObject json1 = JSONObject.fromObject(result);
	     JSONObject json2 = json1.getJSONObject("access");
	     JSONObject json3 = json2.getJSONObject("token");
		 OpenStackIdentityApi.setHEADER_VALUE(json3.getString("id"));
		 logger.info("token: " + OpenStackIdentityApi.getHEADER_VALUE());
	}
	/**
	 * verify Token
	 * @param head
	 */
	public void validateToken(String head) {
		String GET_URL = "http://"+AppProperties.getcontrolAddr()+":35357/v2.0/tokens/" + head;
		String result = "";
		
		try {
			result = HttpRequest.readContentFromGet(GET_URL, "X-Auth-Token", head);
			System.out.println(result);
		} catch (IOException e) {
			if((e.toString().indexOf("response code: 401"))!= -1){
				this.createToken();
			}
		}
		
	}
}
