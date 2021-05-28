package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VtenantDao;
import com.example.demo.modular.Vtenant;


@Service
public class VtenantService {
	
	@Autowired
	private VtenantDao vtenantDao;
	
	public List<Vtenant> getAll(){
		return vtenantDao.findAll();
	}
	
	public Vtenant getByTenantId(int tenantId){
		return vtenantDao.findBytenantId(tenantId);
	}
	
	public Vtenant getByTenantNameAndTenantPassword(String tenantName, String tenantPassword){
		return vtenantDao.findByTenantNameAndTenantPassword(tenantName, tenantPassword);
	}
	
	public void delByTenantId(int tenantId){
		vtenantDao.deleteBytenantId(tenantId);
	}
	
}