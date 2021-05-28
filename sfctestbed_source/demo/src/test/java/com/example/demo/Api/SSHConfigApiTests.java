package com.example.demo.Api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.configplatform.SSHConfigApi;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SSHConfigApiTests {

	@Autowired
	SSHConfigApi sshConfigApi;
	
	@Test
	public void config(){
//		sshConfigApi.addLink("ingress", "192.168.2.4", "192.168.2.3", "192.168.2.5", "Firewall", "", "10.1.0.100");
//		sshConfigApi.addLink("ingress", "192.168.2.4", "192.168.2.3", "192.168.2.5", vnfType, instanceIp2, internServer)
//		sshConfigApi.createBridge("ingress", "192.168.2.3", "vm1~2017-06-01 18:16:33~1", "10.1.0.100");
//		sshConfigApi.addConfig("ingress", "Firewall", "elementclass GatewayDevice { $device | from :: FromDevice($device) -> output;input -> q :: Queue(1024)-> to :: ToDevice($device);ScheduleInfo(from .1, to 1);}extern_dev :: GatewayDevice(p2);intern_dev :: GatewayDevice(p1);extern_arp_class,intern_arp_class :: Classifier(12/0806, 12/0800, -);extern_dev -> extern_arp_class;extern_arp_class[0] -> intern_dev;extern_arp_class[2] -> Discard;intern_dev -> intern_arp_class;intern_arp_class[0] -> extern_dev;intern_arp_class[2] -> Discard;iprw :: IPRewriterPatterns(FIREWALL - - - -);fw :: Firewall(pattern FIREWALL 0 1,pass 1,DENY_SYNFLOOD 200);extern_arp_class[1] -> extern_ipclass :: IPClassifier(icmp,-);intern_arp_class[1] -> intern_ipclass :: IPClassifier(icmp,-);extern_ipclass[1] -> [1]fw;extern_ipclass[0] -> intern_dev;intern_ipclass[1] -> [0]fw;intern_ipclass[0] -> extern_dev;fw[1] -> intern_dev;fw[0] -> extern_dev;","172.18.0.101","10.1.0.100","192.168.2.3");
	}
}
