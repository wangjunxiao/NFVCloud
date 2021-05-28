package com.example.demo.modular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemList {
//	public   List<Vnet_ofport> ofportlist=new ArrayList<Vnet_ofport>();
//	public   List<Vnet_controller> controllerlist=new ArrayList<Vnet_controller>();
//	public   List<Vnet_switch> switchlist=new ArrayList<Vnet_switch>();
//	public   List<Vnet_host> hostlist=new ArrayList<Vnet_host>();
//	public   List<Vnet_oflink> oflinklist=new ArrayList<Vnet_oflink>();
//	public   List<Vnet_link> linklist=new ArrayList<Vnet_link>();
//	public   List<Vnet_switch_ofport> switch_ofportlist=new ArrayList<Vnet_switch_ofport>();
//	public   Vnet_vnet myvnet = new Vnet_vnet();
//	public   Vnet_executor_vnet executor_vnet = new Vnet_executor_vnet();
//	public   List<Vnet_vnet_resource> vnet_resourcelist=new ArrayList<Vnet_vnet_resource>();
//	
//	public   List<Vnet_request> requestlist=new ArrayList<Vnet_request>();
//	public   List<Vnet_instance> instancelist=new ArrayList<Vnet_instance>();
//	
//	public   List<Vnet_flavor_instance> flavor_instancelist=new ArrayList<Vnet_flavor_instance>();
//	public   List<Vnet_image_instance> image_instancelist=new ArrayList<Vnet_image_instance>();
//	public   List<Vnet_instance_controller> instance_controllerlist=new ArrayList<Vnet_instance_controller>();
//	public   List<Vnet_osport> osportlist=new ArrayList<Vnet_osport>();
//	public   List<Vnet_instance_osport> instance_osportlist=new ArrayList<Vnet_instance_osport>();
//	public   List<Vnet_instance_host> instance_hostlist=new ArrayList<Vnet_instance_host>();
	
	public List<Vnf> vnfList=new ArrayList<Vnf>();
	public List<VnfFlavor> vnfFlavorList=new ArrayList<VnfFlavor>();
	public List<Link> linkList=new ArrayList<Link>();
	public List<Sfc> sfcList=new ArrayList<Sfc>();
	public List<SfcLink> sfcLinkList=new ArrayList<SfcLink>();
	public List<SfcVnf> sfcVnfList=new ArrayList<SfcVnf>();
	
	
	public List<FlavorInstance> flavorInstanceList=new ArrayList<FlavorInstance>();
	public List<ImageInstance> imageInstanceList=new ArrayList<ImageInstance>();
	public List<Subnet> subnetList=new ArrayList<Subnet>();
	public List<InstanceSubnet> instanceSubnetList=new ArrayList<InstanceSubnet>();
	public List<Instance> instanceList=new ArrayList<Instance>();
	
	public List<SfcInstance> sfcInstanceList=new ArrayList<SfcInstance>();
	
	
	//stack hash is owned by each user, clear it when requesthandle happens
	public Map<Integer,Integer> stackIdMap=new HashMap<Integer,Integer>();
}
