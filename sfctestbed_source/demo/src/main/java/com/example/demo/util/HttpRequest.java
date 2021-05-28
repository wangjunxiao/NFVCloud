package com.example.demo.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @class HttpRequest
 * @brief http request tool
 * @author ychuang
 *
 */
public class HttpRequest {

	public static String readContentFromGet(String GET_URL, String HEADER_NAME, String HEADER_VALUE) throws IOException {
		String getURL = GET_URL;
		System.out.println("getURL======"+getURL);
		URL getUrl = new URL(getURL);
		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();
		connection.setRequestProperty("Content-Type",
				"application/json");
		connection.setRequestProperty(HEADER_NAME, HEADER_VALUE);
		connection.setConnectTimeout(10000);

		connection.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
		String line = "";
		String result = "";   
		while ((line = reader.readLine()) != null){
			result = result + line;
        }
		reader.close();
		connection.disconnect();	
		System.out.println("Get Success");
		return result;
	}
	
	
	/**
	 * HttpRequest.readContentFromPut()
	 * @param PUT_URL PUT URL
	 */
	public static String readContentFromPut(String PUT_URL, String content, String HEADER_NAME, String HEADER_VALUE)
			throws IOException {
		URL putUrl = new URL(PUT_URL);
//		System.out.println("putURL======"+putUrl);
		HttpURLConnection connection = (HttpURLConnection) putUrl
				.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty(HEADER_NAME, HEADER_VALUE);
		connection.setConnectTimeout(10000);
		
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.writeBytes(content);
		out.flush();
		out.close();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));
		String line = "";
		String result = "";   
		while ((line = reader.readLine()) != null){
			result = result + line;
        }
		reader.close();
		connection.disconnect();
		return result;
	}
	
		
	/**
	 * HttpRequest.readContentFromPost()
	 * @param POST_URL POST URL
	 * @param content POST data
	 */
	public static String readContentFromPost(String POST_URL, String content, String HEADER_NAME, String HEADER_VALUE)
			throws IOException {
		URL postUrl = new URL(POST_URL);
		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestProperty("Content-Type",
				"application/json");
		connection.setRequestProperty(HEADER_NAME, HEADER_VALUE);
		connection.setConnectTimeout(10000);

		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		out.writeBytes(content);
		out.flush();
		out.close();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));
		String line = "";
		String result = "";   //Post
		while ((line = reader.readLine()) != null){
			result = result + line;
        }
		reader.close();
		connection.disconnect();
		return result;
	}
	
	
	public static String rpcFromPost(String POST_URL, String content)
	throws IOException {
		URL postUrl = new URL(POST_URL);
		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestProperty("Content-Type","application/json");
		connection.setConnectTimeout(10000);
		connection.connect();
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.writeBytes(content);
		out.flush();
		out.close();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));
		String line = "";
		String result = "";   //Post
		while ((line = reader.readLine()) != null){
			result = result + line;
        }
		reader.close();
		connection.disconnect();
		return result;
	}
	
	
	public static Boolean readContentFromDelete(String DELETE_URL, String HEADER_NAME, String HEADER_VALUE)
			throws IOException {

		Boolean result = false;
		URL deleteUrl = new URL(DELETE_URL);
		
		HttpURLConnection connection = (HttpURLConnection) deleteUrl.openConnection();
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty(HEADER_NAME, HEADER_VALUE);
		connection.setRequestMethod("DELETE");
		if (connection.getResponseCode() == 204) {
			result = true;
		} 
		
		connection.disconnect();
		return result;
	}
	
}
