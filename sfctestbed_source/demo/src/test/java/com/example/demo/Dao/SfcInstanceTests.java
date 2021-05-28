package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.SfcInstanceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SfcInstanceTests {

	@Autowired
	SfcInstanceService sfcInstanceService;
	
	@Test
	public void getSfcIdByInstanceId(){
		System.out.println(sfcInstanceService.getSfcIdByInstanceId("dlut"));
	}
}
