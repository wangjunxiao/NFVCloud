package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.InstanceDao;
import com.example.demo.service.InstanceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstanceTests {
	
	@Autowired
	InstanceDao instanceDao;
	
	@Autowired
	InstanceService instanceService;
	
//	@Test
//	public void getAll(){
//		System.out.println(instanceService.getAll());
//	}
	
//	@Test
//	public void getById(){
//		System.out.println(instanceService.getByInstanceId("vm1~2017-06-01 18:16:33~1"));
//	}
	
//	@Test
//	public void getByStackId(){
//		System.out.println(instanceService.getByStackId(340));
//	}
	
//	@Test
//	public void getIddByOsid(){
//		System.out.println(instanceService.getInstanceIdByInstanceOsid("7b9bba2a-9004-4b29-89cc-12576b95aeae"));
//	}
	
//	@Test
//	public void getBySfcId(){
//		System.out.println(instanceService.getBySfcId("sfc1~2017-06-01 18:16:33~1"));
//	}
	
	@Test
	public void gethead(){
		System.out.println(instanceService.getTailInstanceBySfcId("sfc1~2017-06-01 18:16:33~1"));
	}
}
