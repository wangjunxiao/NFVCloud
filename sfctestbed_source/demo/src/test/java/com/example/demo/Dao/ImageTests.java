package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.ImageDao;
import com.example.demo.modular.Image;
import com.example.demo.service.ImageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageTests {

	@Autowired
	ImageDao imageDao;
	
	@Autowired
	ImageService imageService;
	
//	@Test
//	public void getAll(){
//		System.out.println(imageService.getAll());
//	}
	
//	@Test
//	public void getById(){
//		System.out.println(imageService.getByImageId(12));
//	}
	
//	@Test
//	public void getByOsid(){
//		System.out.println(imageService.getByImageOsid("a99eab30-2ce5-4223-abe7-925dd13d624c"));
//	}
	
//	@Test
//	public void getByName(){
//		System.out.println(imageService.getByImageName("clickOS"));
//	}
	
//	@Test
//	public void insertImage(){
//		Image image = new Image("temp","temp","temp","temp");
//		System.out.println(imageService.insertImage(image));
//	}
	
	@Test
	public void selByImageId(){
		imageService.delByImageId(22);
	}
}
