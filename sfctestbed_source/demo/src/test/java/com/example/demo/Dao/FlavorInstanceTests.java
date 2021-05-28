package com.example.demo.Dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.FlavorInstanceDao;
import com.example.demo.modular.FlavorInstance;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlavorInstanceTests {
	
	@Autowired
	private FlavorInstanceDao flavorInstanceDao;
	
//	@Test
//	public void getAll(){
//		List<FlavorInstance> flavorInstances = flavorInstanceDao.findAll();
//		System.out.println(flavorInstances);
//	}
	
//	@Test
//	public void getByFlavorInstanceId(){
//		FlavorInstance flavorInstance = flavorInstanceDao.findByflavorInstanceId(159);
//		System.out.println(flavorInstance.toString());
//	}
	
//	@Test
//	public void getByInstanceId(){
//		FlavorInstance flavorInstance = flavorInstanceDao.findByinstanceId("vm1~2017-06-01 18:16:33~1");
//		System.out.println(flavorInstance.toString());
//	}
	
//	@Test
//	public void delByFlavorInstanceId(){
//		flavorInstanceDao.deleteByflavorInstanceId(159);
//	}
	
	@Test
	public void insertFlavorInstance(){
		
	}
}
