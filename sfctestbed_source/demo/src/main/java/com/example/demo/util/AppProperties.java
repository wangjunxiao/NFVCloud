package com.example.demo.util;

import java.util.ArrayList;
/**
 * @class AppProperties
 * @brief constants.properties
 * @author ychuang
 *
 */
public class AppProperties {
	
	private static PropertiesFileLoader propertiesFileLoader = new PropertiesFileLoader("constants.properties");

	public static String getcompute1Addr()
	{
		return propertiesFileLoader.get("compute1Addr").toString();
	}

	public static String getvrouterOsid()
	{
		return propertiesFileLoader.get("vrouterOsid").toString();
	}
	
	public static String getcompute2Addr()
	{
		return propertiesFileLoader.get("compute2Addr").toString();
	}
	
	public static String getconfigIp()
	{
		return propertiesFileLoader.get("configIp").toString();
	}
	
	public static String getcontrolAddr()
	{
		return propertiesFileLoader.get("controlAddr").toString();
	}
	
	public static String gettenantDemo()
	{
		return propertiesFileLoader.get("tenantDemo").toString();
	}
	
	public static String getimageName()
	{
		return propertiesFileLoader.get("imageName").toString();
	}
	
	public static String getimageOsid()
	{
		return propertiesFileLoader.get("imageOsid").toString();
	}
	
	public static String getnetworkName()
	{
		return propertiesFileLoader.get("networkName").toString();
	}
	public static String getnetworkOsid()
	{
		return propertiesFileLoader.get("networkOsid").toString();
	}

	public static String getsubnetOsid()
	{
		return propertiesFileLoader.get("subnetOsid").toString();
	}
	
	
	public static String getcomputeNum()
	{
		return propertiesFileLoader.get("computeNum").toString();
	}
	
	public static String getcompute1Name()
	{
		return propertiesFileLoader.get("compute1Name").toString();
	}
	
	public static String getcompute2Name()
	{
		return propertiesFileLoader.get("compute2Name").toString();
	}

	
	public static ArrayList<String> getcomputesNames(int numOfComputes)
	{
		ArrayList<String> result=new ArrayList<String>();
		for(int i=1;i<=numOfComputes;i++)
		{
			String computeName=propertiesFileLoader.get("compute" + i + "Name").toString();
			result.add(computeName);		
		}
		return result;
	}
	
	public static String floodlightOpenflowPort()
	{
		return propertiesFileLoader.get("floodlightOpenflowPort").toString();
	}
	
	public static String userName(){
		return propertiesFileLoader.get("userName").toString();
	}
	public static String Vnet_userpassword(){
		return propertiesFileLoader.get("Vnet_userpassword").toString();
	}
	public static String Vnet_adminname(){
		return propertiesFileLoader.get("Vnet_adminname").toString();
	}
	public static String Vnet_adminpassword(){
		return propertiesFileLoader.get("Vnet_adminpassword").toString();
	}
	
	public static ArrayList<String> getDetails(int computeNum)
	{
		ArrayList<String> result=new ArrayList<String>();
		for(int i=1;i<=computeNum;i++)
		{
			String computeName=propertiesFileLoader.get("compute" + i + "Name").toString();
			String computeAddr=propertiesFileLoader.get("compute" + i + "Addr").toString();
			String computeRam=propertiesFileLoader.get("compute" + i + "Ram").toString();
			String computeCpu=propertiesFileLoader.get("compute" + i + "Cpu").toString();
			result.add(computeName);
			result.add(computeAddr);
			result.add(computeRam);
			result.add(computeCpu);			
		}
		return result;
	}
	
	public static String compute1VnetBr(){
		return propertiesFileLoader.get("compute1VnetBr").toString();
	}
	
	public static String compute2VnetBr(){
		return propertiesFileLoader.get("compute2VnetBr").toString();
	}

}
