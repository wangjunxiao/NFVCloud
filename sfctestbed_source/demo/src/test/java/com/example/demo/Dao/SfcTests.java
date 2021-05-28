package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.SfcDao;
import com.example.demo.service.SfcService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SfcTests {

	@Autowired
	SfcDao sfcDao;
	
	@Autowired
	SfcService sfcService;
	
//	@Test
//	public void getByLinkId(){
//		System.out.println(sfcService.getByLinkId("vnf1~vnf2~2017-06-01 18:16:33~1"));
//	}
	
//	@Test
//	public void getByInstanceID(){
//		System.out.println(sfcService.getByInstanceId("vm1~2017-06-01 18:16:33~1"));
//	}
	
//	@Test
//	public void getBysfcId(){
//		System.out.println(sfcService.getBySfcId("sfc1~2017-06-01 18:16:33~1"));
//	}
	
	@Test
	public void getByStackId(){
		System.out.println(sfcService.getByStackId(337));
	}
}
