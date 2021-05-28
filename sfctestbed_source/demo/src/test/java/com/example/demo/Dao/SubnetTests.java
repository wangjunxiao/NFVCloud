package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.SubnetDao;
import com.example.demo.service.SubnetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubnetTests {

	@Autowired
	SubnetDao subnetDao;
	
	@Autowired
	SubnetService subnetService;
	
//	@Test
//	public void getAll(){
//		System.out.println(subnetService.getAll());
//	}
	
//	@Test
//	public void getBySubnetId(){
//		System.out.println(subnetService.getBySubnetId("subnet1~2017-06-01 18:16:33~1"));
//	}
	
//	@Test
//	public void getBySubnetType(){
//		System.out.println(subnetService.getBySubnetType("intern"));
//	}
	
	@Test
	public void getByInstanceId(){
		System.out.println(subnetService.getByInstanceId("vm1~2017-06-01 18:16:33~1"));
	}
}
