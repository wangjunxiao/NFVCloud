package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SfcInstanceDao;
import com.example.demo.modular.SfcInstance;

@Service
public class SfcInstanceService {

	@Autowired
	SfcInstanceDao sfcInstanceDao;
	
	public List<SfcInstance> getAll(){
		return sfcInstanceDao.findAll();
	}
	
	public SfcInstance getBySfcInstanceId(int sfcInstanceId){
		return sfcInstanceDao.findBysfcInstanceId(sfcInstanceId);
	}
	
	public void delBySfcInstanceId(int sfcInstanceId){
		sfcInstanceDao.deleteBysfcInstanceId(sfcInstanceId);
	}
	
	public SfcInstance insertSfcInstance(SfcInstance sfcInstance){
		return sfcInstanceDao.saveAndFlush(sfcInstance);
	}
	
	public String getSfcIdByInstanceId(String instanceId){
		return sfcInstanceDao.findByInstanceId(instanceId).getSfcId();
	}
}
