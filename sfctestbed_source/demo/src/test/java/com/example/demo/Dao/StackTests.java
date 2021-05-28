package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.StackDao;
import com.example.demo.modular.Stack;
import com.example.demo.service.StackService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StackTests {

	@Autowired
	StackDao stackDao;
	
	@Autowired
	StackService stackService;
	
//	@Test
//	public void getAll(){
//		System.out.println(stackService.getAll());
//	}
	
//	@Test
//	public void getByStackId(){
//		System.out.println(stackService.getByStackId(337));
//	}
	
//	@Test
//	public void getBySfcId(){
//		System.out.println(stackService.getBySfcId("sfc1~2017-06-01 18:16:33~1"));
//	}
	
//	@Test
//	public void getByVnfName(){
//		System.out.println(stackService.getByVnfName("vnf1", "sfc1~2017-06-01 18:16:33~1"));
//	}
	
//	@Test
//	public void getByVnfId(){
//		System.out.println(stackService.getByVnfId("vnf1~2017-06-01 18:16:33~1"));
//	}
	
	@Test
	public void updateStack(){
		Stack stack = new Stack();
		stack.setStackId(391);
		stack.setStackOsid("bcd7aa8c-f739-498c-86fb-3103b5f6955b");
		stack.setStackName("stack391");
		stack.setStackType("stack");
		stack.setStackIp("0.00.0.0");
		stackService.insertStack(stack);
	}
}
