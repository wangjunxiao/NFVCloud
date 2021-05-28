package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FlavorInstanceDao;
import com.example.demo.modular.FlavorInstance;
/**
 * @class FlavorInstanceService
 * @brief FlavorInstanceDao access
 * @author ychuang
 * @note
 * 
 *
 */
@Service
public class FlavorInstanceService {

	@Autowired
	private FlavorInstanceDao flavorInstanceDao;
	
	public List<FlavorInstance> getAll(){
		return flavorInstanceDao.findAll();
	}
	
//	public List<FlavorInstance> getAllActive(int exeId){
//		return flavorInstanceDao.getAllActive(exeId);
//	}
	
	public FlavorInstance getById(int flavorInstanceId){
		return flavorInstanceDao.findByflavorInstanceId(flavorInstanceId);
	}
	
	public FlavorInstance insertFlavorInstance(FlavorInstance flavorInstance){
		return flavorInstanceDao.saveAndFlush(flavorInstance);
	}
	
	public void delById(int flavorInstanceId){
		flavorInstanceDao.deleteByflavorInstanceId(flavorInstanceId);
	}
}
