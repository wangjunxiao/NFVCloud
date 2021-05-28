package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TenantQuotaDao;
import com.example.demo.modular.TenantQuota;

@Service
public class TenantQuotaService {

	@Autowired
	TenantQuotaDao tenantQuotaDao;
	
	public List<TenantQuota> getAll(){
		return tenantQuotaDao.findAll();
	}
	
	public TenantQuota getByTenantQuotaId(int tenantQuotaId){
		return tenantQuotaDao.findBytenantQuotaId(tenantQuotaId);
	}
	
	public void delByTenantQuotaId(int tenantQuotaId){
		tenantQuotaDao.deleteBytenantQuotaId(tenantQuotaId);
	}
	
}
