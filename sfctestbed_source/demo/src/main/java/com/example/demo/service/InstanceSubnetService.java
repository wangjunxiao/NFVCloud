package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InstanceSubnetDao;
import com.example.demo.modular.InstanceSubnet;

@Service
public class InstanceSubnetService {
	
	@Autowired
	InstanceSubnetDao instanceSubnetDao;
	
	public List<InstanceSubnet> getAll(){
		return instanceSubnetDao.findAll();
	}
	
	public InstanceSubnet getByInstanceSubnetId(int instanceSubnetId){
		return instanceSubnetDao.findByinstanceSubnetId(instanceSubnetId);
	}
	
	public void delByInstanceSubnetId(int instanceSubnetId){
		instanceSubnetDao.deleteByinstanceSubnetId(instanceSubnetId);
	}
	
	public InstanceSubnet insertInstanceSubnet(InstanceSubnet instanceSubnet){
		return instanceSubnetDao.saveAndFlush(instanceSubnet);
	}
}
