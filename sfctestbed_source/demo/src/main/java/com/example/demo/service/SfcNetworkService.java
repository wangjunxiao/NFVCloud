package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SfcNetworkDao;
import com.example.demo.modular.SfcNetwork;

@Service
public class SfcNetworkService {

	@Autowired
	SfcNetworkDao sfcNetworkDao;
	
	public List<SfcNetwork> getAll(){
		return sfcNetworkDao.findAll();
	}
	
	public SfcNetwork getBySfcNetworkId(int sfcNetworkId){
		return sfcNetworkDao.findBysfcNetworkId(sfcNetworkId);
	}
	
	public String getNetworkOsidBySfcId(String sfcId){
		return sfcNetworkDao.findNetworkOsidBySfcId(sfcId).getNetworkOsid();
	}
	
	public void delBySfcNetworkId(int sfcNetworkId){
		sfcNetworkDao.deleteBysfcNetworkId(sfcNetworkId);
	}
	
	public SfcNetwork insertSfcNetwork(SfcNetwork sfcNetwork){
		return sfcNetworkDao.saveAndFlush(sfcNetwork);
	}
}
