package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.FloatingIpDao;
import com.example.demo.modular.FloatingIp;
import com.example.demo.service.FloatingIpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FloatingipTests {

	@Autowired
	FloatingIpDao floatingIpDao;
	
	@Autowired
	FloatingIpService floatingIpService;
	
//	@Test
//	public void getAll(){
//		System.out.println(floatingIpService.getAll());
//	}
	
//	@Test
//	public void updateFloatingIpStatus(){
//		floatingIpService.updateFloatingIpStatusByFloatingIpId(1);
//	}
	
//	@Test
//	public void getRandowm(){
//		System.out.println(floatingIpService.getRandomFloatingIp("ACTIVE").toString());
//	}
	
	
	
}
