package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ImageInstanceDao;
import com.example.demo.modular.ImageInstance;

@Service
public class ImageInstanceService {

	@Autowired
	ImageInstanceDao imageInstanceDao;
	
	public List<ImageInstance> getAll(){
		return imageInstanceDao.findAll();
	}
	
	public ImageInstance getByImageInstanceId(int imageInstanceId){
		return imageInstanceDao.findByimageInstanceId(imageInstanceId);
	}
	
	public void delByImageInstanceId(int imageInstanceId){
		imageInstanceDao.deleteByimageInstanceId(imageInstanceId);
	}
	
	public ImageInstance insertImageInstance(ImageInstance imageInstance){
		return imageInstanceDao.saveAndFlush(imageInstance);
	}
}
