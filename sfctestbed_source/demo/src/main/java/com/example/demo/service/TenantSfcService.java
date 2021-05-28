package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TenantSfcDao;
import com.example.demo.modular.TenantSfc;

@Service
public class TenantSfcService {

	@Autowired
	TenantSfcDao tenantSfcDao;
	
	public List<TenantSfc> getAll(){
		return tenantSfcDao.findAll();
	}
	
	public TenantSfc getByTenantSfcId(int tenantSfcId){
		return tenantSfcDao.findBytenantSfcId(tenantSfcId);
	}
	
	public void delByTenantSfcId(int tenantSfcId){
		tenantSfcDao.deleteBytenantSfcId(tenantSfcId);
	}
	
}
