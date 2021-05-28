package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuotaDao;
import com.example.demo.modular.Quota;

@Service
public class QuotaService {
	
	@Autowired
	QuotaDao quotaDao;
	
	public List<Quota> getAll(){
		return quotaDao.findAll();
	}
	
	public void delByQuotaId(int quotaId){
		quotaDao.deleteByquotaId(quotaId);
	}
	
	public Quota getByQuotaId(int quotaId){
		return quotaDao.findByquotaId(quotaId);
	}
}
