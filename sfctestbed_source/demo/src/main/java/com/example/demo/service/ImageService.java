package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ImageDao;
import com.example.demo.modular.Image;

@Service
public class ImageService {

	@Autowired
	ImageDao imageDao;
	
	public List<Image> getAll(){
		return imageDao.findAll();
	}
	
	public Image getByImageId(int imageId){
		return imageDao.findByimageId(imageId);
	}
	
	public Image getByImageOsid(String imageOsid){
		return imageDao.findByimageOsid(imageOsid);
	}
	
	public Image getByImageName(String imageName){
		return imageDao.findByimageName(imageName);
	}
	
	public Image insertImage(Image image){
		return imageDao.saveAndFlush(image);
	}
	
	public void delByImageId(int imageId){
		imageDao.deleteByimageId(imageId);
	}
	
	public String getImageOsidByImageId(int imageId){
		return imageDao.findImageOsidByImageId(imageId);
	}
}
