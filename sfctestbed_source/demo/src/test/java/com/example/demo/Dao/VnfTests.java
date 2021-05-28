package com.example.demo.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.VnfDao;
import com.example.demo.modular.Vnf;
import com.example.demo.service.VnfService;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VnfTests {

	@Autowired
	VnfDao vnfDao;
	
	@Autowired
	VnfService vnfService;
	
//	@Test
//	public void getAll(){
//		System.out.println(vnfService.getAll());
//	}
	
//	@Test
//	public void getByVnfId(){
//		System.out.println(vnfService.getByVnfId("vnf1~2017-06-01 18:16:33~1"));
//	}
	
//	@Test
//	public void getByVnfName(){
//		System.out.println(vnfService.getByVnfName("vnf1"));
//	}
	
//	@Test
//	public void getByStackId(){
//		System.out.println(vnfService.getByStackId(337));
//	}
	
//	@Test
//	public void getBySfcId(){
//		System.out.println(vnfService.getBySfcId("sfc1~2017-06-01 18:16:33~1"));
//	}
	
	@Test
	public void testInsert(){
		Object vnfList = "{\"vnfId\": \"vnf1~2017-06-01 18:16:33~1\",\"vnfName\": \"vnf1\",\"vnfType\": \"Firewall\",\"vnfStatus\": \"wait\",\"vnfTimestamp\": \"2017-06-01 18:16:33\",\"vnfConfig\": \"elementclass GatewayDevice { $device | from :: FromDevice($device) -> output; input -> q :: Queue(1024) -> to :: ToDevice($device); ScheduleInfo(from .1, to 1); } elementclass SniffGatewayDevice { $device | from :: FromDevice($device) -> t1 :: Tee -> output; input -> q :: Queue(1024) -> t2 :: PullTee -> to :: ToDevice($device); t1[1] -> ToHostSniffers; t2[1] -> ToHostSniffers($device); ScheduleInfo(from .1, to 1); } extern_dev :: SniffGatewayDevice(p2); intern_dev :: SniffGatewayDevice(p1); extern_arp_class, intern_arp_class :: Classifier(12/0806, 12/0800, -); extern_dev -> extern_arp_class; extern_arp_class[0] -> intern_dev; extern_arp_class[2] -> Discard; intern_dev -> intern_arp_class; intern_arp_class[0] -> extern_dev; intern_arp_class[2] -> Discard; iprw :: IPRewriterPatterns(FIREWALL - - - -); fw :: Firewall(pattern FIREWALL 0 1, pass 1, DENY_SYNFLOOD 200); extern_arp_class[1] -> extern_ipclass :: IPClassifier( icmp, -); intern_arp_class[1] -> intern_ipclass :: IPClassifier( icmp, -); extern_ipclass[1] -> [1]fw; extern_ipclass[0] -> intern_dev; intern_ipclass[1] -> [0]fw; intern_ipclass[0] -> extern_dev; fw[1] -> intern_dev; fw[0] -> extern_dev;\"}";
		JSONObject jsonObject = JSONObject.fromObject(vnfList);
		System.out.println(jsonObject);
		Vnf vnf = (Vnf)JSONObject.toBean(jsonObject, Vnf.class);
		vnfService.insertVnf(vnf);
		System.out.println(vnf);
	}
}
