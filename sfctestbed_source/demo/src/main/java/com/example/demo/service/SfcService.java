package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SfcDao;
import com.example.demo.modular.Sfc;

@Service
public class SfcService {

	@Autowired
	SfcDao sfcDao;
	
	public List<Sfc> getAll(){
		return sfcDao.findAll();
	}
	
	public Sfc insertSfc(Sfc sfc){
		return sfcDao.saveAndFlush(sfc);
	}
	
	public Sfc getBySfcId(String sfcId){
		return sfcDao.findBysfcId(sfcId);
	}
	
	public Sfc getByInstanceId(String instanceId){
		return sfcDao.findByInstanceId(instanceId);
	}
	
	public Sfc getByStackId(int stackId){
		return sfcDao.findBystackId(stackId);
	}
	
	public void delBySfcId(String sfcId){
		sfcDao.deleteBysfcId(sfcId);
	}
	
	public List<Sfc> getByLinkId(String linkId){
		return sfcDao.findBylinkId(linkId);
	}
	
	public int updateSfc(Sfc sfc){
		return sfcDao.updateSfc(sfc.getSfcId(), sfc.getSfcStatus());
	}
}
