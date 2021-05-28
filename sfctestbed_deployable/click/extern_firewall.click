elementclass GatewayDevice {
  $device |
  from :: FromDevice($device)
        -> output;
  input -> q :: Queue(1024)
        -> to :: ToDevice($device);
  ScheduleInfo(from .1, to 1);
}

// The following version of GatewayDevice sends a copy of every packet to
// ToHostSniffers, so that you can use tcpdump(1) to debug the gateway.

elementclass SniffGatewayDevice {
  $device |
  from :: FromDevice($device)
        -> t1 :: Tee
        -> output;
  input -> q :: Queue(1024)
        -> t2 :: PullTee
        -> to :: ToDevice($device);
  t1[1] -> ToHostSniffers;
  t2[1] -> ToHostSniffers($device);
  ScheduleInfo(from .1, to 1);
}

extern_dev :: SniffGatewayDevice(p2);
intern_dev :: SniffGatewayDevice(p1);

extern_arp_class, intern_arp_class
	:: Classifier(12/0806, 12/0800, -);

extern_dev -> extern_arp_class;
extern_arp_class[0] -> intern_dev;
extern_arp_class[2] -> Discard;

intern_dev -> intern_arp_class;
intern_arp_class[0] -> extern_dev;
intern_arp_class[2] -> Discard;

iprw :: IPRewriterPatterns(FIREWALL - - - -);

fw :: Firewall(pattern FIREWALL 0 1,
                 pass 1,
		DENY_SYNFLOOD 200);

extern_arp_class[1] -> extern_ipclass :: IPClassifier(
					icmp,
					-);

intern_arp_class[1] -> intern_ipclass :: IPClassifier(
                                        icmp,
                                        -);


extern_ipclass[1] -> [0]fw;
extern_ipclass[0] -> intern_dev;

intern_ipclass[1] -> [1]fw;
intern_ipclass[0] -> extern_dev;

fw[0] -> intern_dev;

fw[1] -> extern_dev;

