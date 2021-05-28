package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VnfDao;
import com.example.demo.modular.Vnf;

@Service
public class VnfService {

	@Autowired
	VnfDao vnfDao;
	
	public List<Vnf> getAll(){
		return vnfDao.findAll();
	}
	
	public Vnf getByVnfId(String vnfId){
		return vnfDao.findByvnfId(vnfId);
	}
	
	public Vnf getByVnfName(String vnfName){
		return vnfDao.findByvnfName(vnfName);
	}
	
	public void delByVnfId(String vnfId){
		vnfDao.deleteByvnfId(vnfId);
	}
	
	public Vnf getByStackId(int stackId){
		return vnfDao.findBystackId(stackId);
	}
	
	public List<Vnf> getBySfcId(String sfcId){
		return vnfDao.findBysfcId(sfcId);
	}
	
	public Vnf insertVnf(Vnf vnf){
		return vnfDao.saveAndFlush(vnf);
	}
	
	public int updateVnf(Vnf vnf){
		return vnfDao.updateVnf(vnf.getVnfId(), vnf.getVnfStatus());
	}
}
