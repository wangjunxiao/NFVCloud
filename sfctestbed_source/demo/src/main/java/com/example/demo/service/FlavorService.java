package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FlavorDao;
import com.example.demo.modular.Flavor;

@Service
public class FlavorService {
	
	@Autowired
	private FlavorDao flavorDao;
	
	public List<Flavor> getAll(){
		return flavorDao.findAll();
	}
	
	public Flavor getByFlavorId(int flavorId){
		return flavorDao.findByFlavorId(flavorId);
	}
	
	public void delByFlavorId(int flavorId){
		flavorDao.deleteByFlavorId(flavorId);
	}
	
	public Flavor insertFlavor(Flavor flavor){
		return flavorDao.saveAndFlush(flavor);
	}
	
}
