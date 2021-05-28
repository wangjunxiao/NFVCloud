package com.example.demo.Dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.FlavorDao;
import com.example.demo.modular.Flavor;
import com.example.demo.service.FlavorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlavorTests {
	
	@Autowired
	private FlavorDao flavorDao;
	
	@Autowired
	private FlavorService flavorService;
	
//	@Test
//	public void getAll(){
//		List<Flavor> flavors = flavorDao.findAll();
//		System.out.println(flavors);
//	}
	
//	@Test
//	public void insertFlavor(){
//		Flavor flavor = new Flavor(10,"10","m2.small",10,10,10,null,null);
//		flavorService.insertFlavor(flavor);
//	}
	
//	@Test
//	public void delByFlavorId(){
//		flavorDao.deleteByFlavorId(10);
//	}
	
//	@Test
//	public void getByFlavorId(){
//		Flavor flavor = flavorService.getByFlavorId(9);
//		System.out.println(flavor.toString());
//	}
	
}
