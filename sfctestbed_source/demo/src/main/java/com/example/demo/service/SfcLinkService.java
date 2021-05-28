package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SfcLinkDao;
import com.example.demo.modular.SfcLink;

@Service
public class SfcLinkService {
	
	@Autowired
	SfcLinkDao sfcLinkDao;
	
	public List<SfcLink> getAll(){
		return sfcLinkDao.findAll();
	}
	
	public SfcLink getBySfcLinkId(int sfcLinkId){
		return sfcLinkDao.findBysfcLinkId(sfcLinkId);
	}
	
	public SfcLink insertSfcLink(SfcLink sfcLink){
		return sfcLinkDao.saveAndFlush(sfcLink);
	}
	
	public void delBySfcLinkId(int sfcLinkId){
		sfcLinkDao.deleteBysfcLinkId(sfcLinkId);
	}
}
