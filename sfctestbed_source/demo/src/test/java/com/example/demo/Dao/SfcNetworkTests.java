package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.SfcNetworkDao;
import com.example.demo.service.SfcNetworkService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SfcNetworkTests {

	@Autowired
	SfcNetworkDao sfcNetworkDao;
	
	@Autowired
	SfcNetworkService sfcNetworkService;
	
	@Test
	public void getNetworkOsidBySfcId(){
		System.out.println(sfcNetworkService.getNetworkOsidBySfcId("sfc1~2016-12-23 09:58:49~1"));
	}
}
