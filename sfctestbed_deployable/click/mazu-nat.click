// DEVICE SETUP

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

ip_to_host :: EtherEncap(0x0800, 1:1:1:1:1:1, intern)
	-> ToHost;


// ARP MACHINERY

extern_arp_class, intern_arp_class
	:: Classifier(12/0806 20/0001, 12/0806 20/0002, 12/0800, -);
intern_arpq :: ARPQuerier(intern);
extern_arpq :: ARPQuerier(extern);

extern_dev -> extern_arp_class;
extern_arp_class[0] -> ARPResponder(extern)	// ARP queries
	-> extern_dev;
extern_arp_class[1] -> extern_arpr_t :: Tee;
	extern_arpr_t[0] -> ToHost;			// ARP responses
	extern_arpr_t[1] -> [1]extern_arpq;	
extern_arp_class[3] -> Discard;

intern_dev -> intern_arp_class;
intern_arp_class[0] -> ARPResponder(intern)	// ARP queries
	-> intern_dev;
intern_arp_class[1] -> intern_arpr_t :: Tee;
	intern_arpr_t[0] -> ToHost;
	intern_arpr_t[1] -> [1]intern_arpq;
intern_arp_class[3] -> Discard;


// REWRITERS

IPRewriterPatterns(to_world_pat extern 50000-65535 - -,
		to_server_pat intern 50000-65535 intern_server -);

rw :: IPRewriter(// internal traffic to outside world
		 pattern to_world_pat 0 1,
		 // external traffic redirected to 'intern_server'
		 pattern to_server_pat 1 0,
		 // internal traffic redirected to 'intern_server'
		 pattern to_server_pat 1 1,
		 // virtual wire to output 0 if no mapping
		 pass 0,
		 // virtual wire to output 2 if no mapping
		 pass 2);

tcp_rw :: TCPRewriter(// internal traffic to outside world
		pattern to_world_pat 0 1,
		// everything else is dropped
		drop);
irw :: ICMPPingRewriter(pattern to_world_pat 0 1,pass 1);

// OUTPUT PATH

ip_to_extern :: GetIPAddress(16)
      -> CheckIPHeader
      -> [0]extern_arpq
      -> extern_dev;
ip_to_intern :: GetIPAddress(16)
      -> CheckIPHeader
      -> [0]intern_arpq
      -> intern_dev;


// to outside world or gateway from inside network
rw[0] -> ip_to_extern_class :: IPClassifier(dst host intern, -);
  ip_to_extern_class[0] -> ip_to_host;
  ip_to_extern_class[1] -> ip_to_extern;
// to server
rw[1] -> ip_to_intern;
// only accept packets from outside world to gateway
rw[2] -> IPClassifier(dst host extern)
	-> ip_to_host;

// tcp_rw is used only for FTP control traffic
tcp_rw[0] -> ip_to_extern;
tcp_rw[1] -> ip_to_intern;

// irw is used only for icmp package
irw[0] -> ip_to_extern;
irw[1] -> icmp_me_or_intern :: IPClassifier(dst host extern, -);
          icmp_me_or_intern[0] -> ip_to_host;
          icmp_me_or_intern[1] -> ip_to_intern;

// FILTER & REWRITE IP PACKETS FROM OUTSIDE

ip_from_extern :: IPClassifier(dst host extern,
			-);
my_ip_from_extern :: IPClassifier(dst tcp ssh,
			dst tcp www or https,
			src tcp port ftp,
			tcp or udp,
			icmp,
			-);

extern_arp_class[2] -> Strip(14)
  	-> CheckIPHeader
	-> ip_from_extern;
ip_from_extern[0] -> my_ip_from_extern;
  my_ip_from_extern[0] -> [1]rw; // SSH traffic (rewrite to server)
  my_ip_from_extern[1] -> [1]rw; // HTTP(S) traffic (rewrite to server)
  my_ip_from_extern[2] -> [1]tcp_rw; // FTP control traffic, rewrite w/tcp_rw
  my_ip_from_extern[3] -> [4]rw; // other TCP or UDP traffic, rewrite or to gw
  my_ip_from_extern[4] -> [1]irw; //icmp package from outside to extern
  my_ip_from_extern[5] -> Discard; // non TCP or UDP traffic is dropped
ip_from_extern[1] -> Discard;	// stuff for other people


// FILTER & REWRITE IP PACKETS FROM INSIDE

ip_from_intern :: IPClassifier(dst host intern,
			dst net intern,
			dst tcp port ftp,
			-);
my_ip_from_intern :: IPClassifier(dst tcp ssh,
			dst tcp www or https,
			src or dst port dns,
			dst tcp port auth,
			tcp or udp,
			-);

intern_arp_class[2] -> Strip(14)
  	-> CheckIPHeader
	-> ip_from_intern;
ip_from_intern[0] -> my_ip_from_intern; // stuff for 10.0.0.1 from inside
  my_ip_from_intern[0] -> ip_to_host; // SSH traffic to gw
  my_ip_from_intern[1] -> [2]rw; // HTTP(S) traffic, redirect to server instead
  my_ip_from_intern[2] -> Discard;  // DNS (no DNS allowed yet)
  my_ip_from_intern[3] -> ip_to_host; // auth traffic, gw will reject it
  my_ip_from_intern[4] -> [3]rw; // other TCP or UDP traffic, send to linux
                             	// but pass it thru rw in case it is the
				// returning redirect HTTP traffic from server
  my_ip_from_intern[5] -> ip_to_host; // non TCP or UDP traffic, to linux
ip_from_intern[1] -> ip_to_host; // other net 10 stuff, like broadcasts
ip_from_intern[2] -> FTPPortMapper(tcp_rw, rw, 0)
		-> [0]tcp_rw;	// FTP traffic for outside needs special
				// treatment
ip_from_intern[3] -> ipclass :: IPClassifier(icmp, -)
  ipclass[0] -> [0]irw
  ipclass[1] -> [0]rw;	// stuff for outside