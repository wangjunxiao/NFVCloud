# Prerequisites

#### Minimal Runtime Environment  
1. Hardware:  
(a) x86 Server * 3 with OpenStack node deployed, in which 2 server with more memory and cpu capacity as compute node, 1 server with more nic and disk capacity as control node, network node and storage node  
(b) Web Server * 1 with NFVCloud project and project's database depolyed
(c) Commodity L2 Switch * 1 for connecting all server together  
(d) Commodity L3 Router * 1 for connecting external network
2. Software:  
(a) Database: Mysql Server, create project's database by sfctestbed_db.sql
(b) Web: Jre 
(c) OpenStack: kilo version  
3. Script:  
(a) deleteopenstack_heat.sql: clear zombie stack in OpenStack database  
(b) deleteopenstack_nova.sql: clear zombie instance in OpenStack database  
(c) clear /var/lib/nova/instances/{Instance ID} in compute node  
(d) deleteSDNall.txt: clear project's database  


# Configuration


\target\classes\application.propertiesapache-tomcat-6.0.44-green\webapps\sdn\WEB-INF\classes\config.properties:

    #database connection
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/vfunc
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driverClassName = com.mysql.jdbc.Driver
    spring.jpa.database = MYSQL
    spring.jpa.show-sql = true
    spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
    spring.jpa.hibernate.ddl-auto=update


\target\classes\constans.properties

    #openstack connection
    networkName=sfc-iface-net
    networkOsid=b9d50022-84b7-4d20-9dea-579eead17905
    subnetOsid=37abe2c6-abdd-42d3-a952-15bec967c0df
    computeNum=2
    compute1Name=zone-compute1
    compute1Addr=10.2.0.1
    compute1Ram=10
    compute1Cpu=4
    compute1VnetBr=30.0.0.1
    compute2Name=zone-compute2
    compute2Addr=10.2.0.2
    compute2Ram=10
    compute2Cpu=4
    compute2VnetBr=30.0.0.2
    imageName=clickOS
    imageOsid=1a9d3be6-84ae-48d1-91ec-c8fe42fd5d7a
    userName=demo
    userPassword=0000
    adminName=admin
    adminPassword=0000
    floodlightOpenflowPort=6653
    controlAddr=10.2.0.3
    tenantDemo=2379e521097a4f7986f8f7dde862d922
    configIp=10.3.0.30
    vrouterOsid=1dcb9efe-0899-4b76-958b-b3cea3abcd3d


Config node scripts is set as PowerBoot and stored in the image of ubuntu_plain.vmdk, which should be uploaded into OpenStack Glance in advance. The corresponding management is took over without user participation.

# Click Integration

The part of work has been integrated into the image of ubuntu_plain.vmdk, which VNF instances can used to implement various different type of network services. Such as:

    click\extern_firewall.click 
    click\extern_firewall-type2.click
    click\intern_firewall.click
    click\mazu-nat.click
    click\mazu-nat-type2.click


# Start Up

1. deploy \target into Web server

2. cd \target 

3. run java –jar demo-0.0.1-SNAPSHOT.jar 


# Credits

1. OpenStack 2. Click
