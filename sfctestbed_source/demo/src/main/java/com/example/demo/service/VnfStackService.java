package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VnfStackDao;
import com.example.demo.modular.VnfStack;

@Service
public class VnfStackService {

	@Autowired
	VnfStackDao vnfStackDao;
	
	public List<VnfStack> getAll(){
		return vnfStackDao.findAll();
	}
	
	public VnfStack getByVnfStackId(int vnfStackId){
		return vnfStackDao.findByvnfStackId(vnfStackId);
	}
	
	public VnfStack getByStackId(int stackId){
		return vnfStackDao.findBystackId(stackId);
	}
	
	public int getByVnfId(String vnfId){
		return vnfStackDao.findByvnfId(vnfId).getStackId();
	}
	
	public VnfStack insertVnfStack(VnfStack vnfStack){
		return vnfStackDao.saveAndFlush(vnfStack);
	}
	
	public void delByVnfStackId(int vnfStackId){
		vnfStackDao.deleteByvnfStackId(vnfStackId);
	}
}
