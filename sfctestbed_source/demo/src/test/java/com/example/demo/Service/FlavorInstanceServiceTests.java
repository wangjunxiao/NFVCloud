package com.example.demo.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.modular.FlavorInstance;
import com.example.demo.service.FlavorInstanceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlavorInstanceServiceTests {

	@Autowired
	FlavorInstanceService flavorInstanceService;
	
	@Test
	public void insertFlavorInstance(){
		FlavorInstance flavorInstance = new FlavorInstance(2,"vm1~2017-06-01 18:16:33~1");
		flavorInstanceService.insertFlavorInstance(flavorInstance);
	}
}
