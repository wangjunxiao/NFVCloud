package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VnfFlavorDao;
import com.example.demo.modular.VnfFlavor;

@Service
public class VnfFlavorService {

	@Autowired
	VnfFlavorDao vnfFlavorDao;
	
	public List<VnfFlavor> getAll(){
		return vnfFlavorDao.findAll();
	}
	
	public void delByVnfFlavorId(int vnfFlavorId){
		vnfFlavorDao.deleteByvnfFlavorId(vnfFlavorId);
	}
	
	public VnfFlavor getByVnfFlavorId(int vnfFlavorId){
		return vnfFlavorDao.findByvnfFlavorId(vnfFlavorId);
	}
	
	public VnfFlavor insertByVnfFlavor(VnfFlavor vnfFlavor){
		return vnfFlavorDao.saveAndFlush(vnfFlavor);
	}
}
