package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.LinkDao;
import com.example.demo.service.LinkService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkTests {

	@Autowired
	LinkDao linkDao;
	
	@Autowired
	LinkService linkService;
	
//	@Test
//	public void getAll(){
//		System.out.println(linkService.getAll());
//	}
	
//	@Test
//	public void getById(){
//		System.out.println(linkService.getByLinkId("vnf1~vnf2~2017-06-01 18:16:33~1"));
//	}
	
	@Test
	public void getBySfcId(){
		System.out.println(linkService.getBySfcId("sfc1~2017-06-01 18:16:33~1"));
	}
}
