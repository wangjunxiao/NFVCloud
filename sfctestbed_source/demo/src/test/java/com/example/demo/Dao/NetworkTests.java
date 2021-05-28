package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.NetworkDao;
import com.example.demo.service.NetworkService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NetworkTests {

	@Autowired
	NetworkDao networkDao;
	
	@Autowired
	NetworkService networkService;
	
//	@Test
//	public void getAll(){
//		System.out.println(networkService.getAll());
//	}
	
	@Test
	public void getByNetworkId(){
		System.out.println(networkService.getByNetworkStatus("unused"));
	}
}
