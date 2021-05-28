package com.example.demo.Dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.VtenantDao;
import com.example.demo.modular.Vtenant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VtenantTests {
	
	@Autowired
	private VtenantDao vtenantDao;
	
//	@Test
//	public void getAll(){
//		List<Vtenant> vtenants = vtenantDao.findAll();
//		System.out.println(vtenants);
//	}
	
	@Test
	public void getByNameAndPasswd(){
		System.out.println(vtenantDao.findByTenantNameAndTenantPassword("admin", "0000"));
	}
	
	
	
}
