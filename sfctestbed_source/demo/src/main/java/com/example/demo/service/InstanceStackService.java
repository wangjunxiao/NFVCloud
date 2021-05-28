package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InstanceStackDao;
import com.example.demo.modular.InstanceStack;

@Service
public class InstanceStackService {

	@Autowired
	InstanceStackDao instanceStackDao;
	
	public List<InstanceStack> getAll(){
		return instanceStackDao.findAll();
	}
	
	public InstanceStack getByInstanceStackId(int instanceStackId){
		return instanceStackDao.findByinstanceStackId(instanceStackId);
	}
	
	public InstanceStack getByStackId(int stackId){
		return instanceStackDao.findBystackId(stackId);
	}
	
	public void delByInstanceStackId(int instanceStackId){
		instanceStackDao.deleteByinstanceStackId(instanceStackId);
	}
	
	public InstanceStack insertInstanceStack(InstanceStack instanceStack){
		return instanceStackDao.saveAndFlush(instanceStack);
	}
	
}
