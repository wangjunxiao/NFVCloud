package com.example.demo.job;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.util.AppProperties;
import com.example.demo.util.HttpRequest;
/**
 * @class IptablesJob
 * @brief Timer task in compute nodes
 * @author 60912
 * @note
 * disenable Iptables, avioding VNFs lossing packet
 *
 */
@Component
public class IptablesJob {
	
	@Scheduled(fixedRate = 60 * 1000)
	public void executeIptables(){
		String POST_URL = "http://"+AppProperties.getcompute1Addr()+":12345";
		String content = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"cmd\",\"params\":{" +
				"\"cmd\":\"iptables -F\"}}";
	    String result = "";
	    try {
	    	result = HttpRequest.rpcFromPost(POST_URL, content);
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
	    String POST_URL2 = "http://"+AppProperties.getcompute2Addr()+":12345";
		String content2 = "{\"id\":\"1\",\"jsonrpc\":\"2.0\",\"method\":\"cmd\",\"params\":{" +
				"\"cmd\":\"iptables -F\"}}";
	    String result2 = "";
	    try {
	    	result2 = HttpRequest.rpcFromPost(POST_URL2, content2);
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    System.out.println("execute \"iptables -F\" on Compute Node");
	}
}
