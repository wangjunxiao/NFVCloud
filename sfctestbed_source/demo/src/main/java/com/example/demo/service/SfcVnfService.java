package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SfcVnfDao;
import com.example.demo.modular.SfcVnf;

@Service
public class SfcVnfService {

	@Autowired
	SfcVnfDao sfcVnfDao;
	
	public List<SfcVnf> getAll(){
		return sfcVnfDao.findAll();
	}
	
	public void delBySfcVnfId(int sfcVnfId){
		sfcVnfDao.deleteBysfcVnfId(sfcVnfId);
	}
	
	public SfcVnf getBySfcVnfId(int sfcVnfId){
		return sfcVnfDao.findBysfcVnfId(sfcVnfId);
	}
	
	public SfcVnf insertSfcVnf(SfcVnf sfcVnf){
		return sfcVnfDao.saveAndFlush(sfcVnf);
	}
}
