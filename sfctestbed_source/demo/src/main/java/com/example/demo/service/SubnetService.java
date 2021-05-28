package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubnetDao;
import com.example.demo.modular.Subnet;

@Service
public class SubnetService {

	@Autowired
	SubnetDao subnetDao;
	
	public List<Subnet> getAll(){
		return subnetDao.findAll();
	}
	
	public Subnet getBySubnetId(String subnetId){
		return subnetDao.findBysubnetId(subnetId);
	}
	
	public Subnet getBySubnetType(String subnetType){
		return subnetDao.findBysubnetType(subnetType);
	}
	
	public Subnet getByInstanceId(String instanceId){
		return subnetDao.findByinstanceId(instanceId);
	}
	
	public void delBySubnetId(String subnetId){
		subnetDao.deleteBysubnetId(subnetId);
	}
	
	public Subnet insertSubnet(Subnet subnet){
		return subnetDao.saveAndFlush(subnet);
	}
	
}
