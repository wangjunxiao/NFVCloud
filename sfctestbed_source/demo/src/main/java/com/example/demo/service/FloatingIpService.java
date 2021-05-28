package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FloatingIpDao;
import com.example.demo.modular.FloatingIp;

@Service
public class FloatingIpService {

	@Autowired
	FloatingIpDao floatingIpDao;
	
	public List<FloatingIp> getAll(){
		return floatingIpDao.findAll();
	}
	
	public void updateFloatingIpStatusByFloatingIpId(int floatingIpId, String status){
		FloatingIp floatingIp = floatingIpDao.findByfloatingIpId(floatingIpId);
		floatingIp.setFloatingIpStatus(status);
		floatingIpDao.saveAndFlush(floatingIp);
	}
	
	public void updateFloatingIpStatusByFloatingIpOsid(String floatingIpOsid, String status){
		FloatingIp floatingIp = floatingIpDao.findByfloatingIpOsid(floatingIpOsid);
		floatingIp.setFloatingIpStatus(status);
		floatingIpDao.saveAndFlush(floatingIp);
	}
	
	public FloatingIp getByFloatingIpId(int floatingIpId){
		return floatingIpDao.findByfloatingIpId(floatingIpId);
	}
	
	public FloatingIp getRandomFloatingIp(String floatingIpStatus){
		return floatingIpDao.findRandomFloatingIp(floatingIpStatus);
	}
	
	public FloatingIp insertFloatingIp(FloatingIp floatingIp){
		return floatingIpDao.saveAndFlush(floatingIp);
	}
	
	
}
