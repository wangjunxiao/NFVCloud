package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.InstanceSubnetDao;
import com.example.demo.service.InstanceSubnetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstanceSubnetTests {

	@Autowired
	InstanceSubnetDao instanceSubnetDao;
	
	@Autowired
	InstanceSubnetService instanceSubnetService;
	
	@Test
	public void getAll(){
		System.out.println(instanceSubnetService.getAll());
	}
}
