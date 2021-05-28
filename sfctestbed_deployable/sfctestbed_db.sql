CREATE DATABASE  IF NOT EXISTS `vfunc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vfunc`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: vfunc
-- ------------------------------------------------------
-- Server version	5.5.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vnf`
--

DROP TABLE IF EXISTS `vnf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vnf` (
  `vnf_id` varchar(60) NOT NULL,
  `vnf_name` varchar(45) DEFAULT NULL,
  `vnf_type` varchar(45) DEFAULT NULL,
  `vnf_config` varchar(5000) DEFAULT NULL,
  `vnf_status` varchar(45) DEFAULT NULL,
  `vnf_timestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vnf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vnf`
--

LOCK TABLES `vnf` WRITE;
/*!40000 ALTER TABLE `vnf` DISABLE KEYS */;
/*!40000 ALTER TABLE `vnf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_instance`
--

DROP TABLE IF EXISTS `image_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image_instance` (
  `image_instance_id` int(11) NOT NULL AUTO_INCREMENT,
  `instance_id` varchar(60) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`image_instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_instance`
--

LOCK TABLES `image_instance` WRITE;
/*!40000 ALTER TABLE `image_instance` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_instance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vnf_stack`
--

DROP TABLE IF EXISTS `vnf_stack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vnf_stack` (
  `vnf_stack_id` int(11) NOT NULL AUTO_INCREMENT,
  `vnf_id` varchar(45) DEFAULT NULL,
  `stack_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`vnf_stack_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vnf_stack`
--

LOCK TABLES `vnf_stack` WRITE;
/*!40000 ALTER TABLE `vnf_stack` DISABLE KEYS */;
/*!40000 ALTER TABLE `vnf_stack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vtenant`
--

DROP TABLE IF EXISTS `vtenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vtenant` (
  `tenant_id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_name` varchar(45) DEFAULT NULL,
  `tenant_password` varchar(45) DEFAULT NULL,
  `tenant_role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vtenant`
--

LOCK TABLES `vtenant` WRITE;
/*!40000 ALTER TABLE `vtenant` DISABLE KEYS */;
INSERT INTO `vtenant` VALUES (1,'admin','0000','admin');
/*!40000 ALTER TABLE `vtenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_osid` varchar(45) DEFAULT NULL,
  `image_name` varchar(45) DEFAULT NULL,
  `image_format` varchar(45) DEFAULT NULL,
  `image_size` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (12,'1a9d3be6-84ae-48d1-91ec-c8fe42fd5d7a','clickOS','qcow2','1057903104'),(13,'a99eab30-2ce5-4223-abe7-925dd13d624c','hadoop2.7','qcow2','1488168960'),(14,'f01e6751-b0d5-42b4-8aae-26c2411049ba','config_node','qcow2','1849950208'),(15,'aaa3cc7d-70de-410d-8d0f-794b9844b2e6','flovs','qcow2','732058624'),(16,'4706a342-69d6-4af1-bdd7-70a73f3d1eff','ovs','qcow2','435457536'),(17,'f582c468-aa98-440f-a65a-44ab0dd296f9','tty','qcow2','291831808'),(18,'8d5d9e5d-f49e-493e-a839-8480604451ec','floodlight','qcow2','619943424'),(19,'ca0e7d67-de4d-4e69-894d-f90f9d13955d','ubuntu-plain','qcow2','291766272'),(20,'f11b370b-c912-426d-8339-c93eeae2d62b','rhel-6.5-x86_64','qcow2','745603072'),(21,'d0805879-2713-4658-b93b-f4d9f9496b32','cirros-0.3.4-x86_64','qcow2','13287936');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quota`
--

DROP TABLE IF EXISTS `quota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quota` (
  `quota_id` int(11) NOT NULL AUTO_INCREMENT,
  `quota_cpu` int(11) DEFAULT NULL,
  `quota_ram` int(11) DEFAULT NULL,
  `quota_disk` int(11) DEFAULT NULL,
  `quota_sfc` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`quota_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quota`
--

LOCK TABLES `quota` WRITE;
/*!40000 ALTER TABLE `quota` DISABLE KEYS */;
/*!40000 ALTER TABLE `quota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instance_stack`
--

DROP TABLE IF EXISTS `instance_stack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instance_stack` (
  `instance_stack_id` int(11) NOT NULL AUTO_INCREMENT,
  `instance_id` varchar(45) DEFAULT NULL,
  `stack_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`instance_stack_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instance_stack`
--

LOCK TABLES `instance_stack` WRITE;
/*!40000 ALTER TABLE `instance_stack` DISABLE KEYS */;
/*!40000 ALTER TABLE `instance_stack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `link` (
  `link_id` varchar(60) NOT NULL,
  `link_src` varchar(60) DEFAULT NULL,
  `link_dst` varchar(60) DEFAULT NULL,
  `link_status` varchar(45) DEFAULT NULL,
  `link_timestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sfc_network`
--

DROP TABLE IF EXISTS `sfc_network`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sfc_network` (
  `sfc_network_id` int(11) NOT NULL AUTO_INCREMENT,
  `sfc_id` varchar(45) DEFAULT NULL,
  `network_osid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sfc_network_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sfc_network`
--

LOCK TABLES `sfc_network` WRITE;
/*!40000 ALTER TABLE `sfc_network` DISABLE KEYS */;
/*!40000 ALTER TABLE `sfc_network` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sfc_instance`
--

DROP TABLE IF EXISTS `sfc_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sfc_instance` (
  `sfc_instance_id` int(11) NOT NULL AUTO_INCREMENT,
  `sfc_id` varchar(60) DEFAULT NULL,
  `instance_id` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`sfc_instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sfc_instance`
--

LOCK TABLES `sfc_instance` WRITE;
/*!40000 ALTER TABLE `sfc_instance` DISABLE KEYS */;
/*!40000 ALTER TABLE `sfc_instance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flavor`
--

DROP TABLE IF EXISTS `flavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flavor` (
  `flavor_id` int(11) NOT NULL DEFAULT '0',
  `flavor_osid` varchar(45) DEFAULT NULL,
  `flavor_name` varchar(45) DEFAULT NULL,
  `flavor_vcpus` int(11) DEFAULT NULL,
  `flavor_ram` int(11) DEFAULT NULL,
  `flavor_rootdisk` int(11) DEFAULT NULL,
  `flavor_ephemeraldisk` int(11) DEFAULT NULL,
  `flavor_swapdisk` int(11) DEFAULT NULL,
  PRIMARY KEY (`flavor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flavor`
--

LOCK TABLES `flavor` WRITE;
/*!40000 ALTER TABLE `flavor` DISABLE KEYS */;
INSERT INTO `flavor` VALUES (1,'1','m1.tiny',1,512,1,NULL,NULL),(2,'2','m1.small',1,2048,20,NULL,NULL),(3,'3','m1.medium',2,4096,40,NULL,NULL),(4,'4','m1.large',4,8192,80,NULL,NULL),(5,'5','m1.xlarge',8,16384,160,NULL,NULL),(6,'6','m1.micro',1,256,1,NULL,NULL),(7,'7','m1.nano',1,128,1,NULL,NULL),(8,'8','m1.nano2',1,128,5,NULL,NULL),(9,'9','m1.light',1,512,5,NULL,NULL);
/*!40000 ALTER TABLE `flavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sfc`
--

DROP TABLE IF EXISTS `sfc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sfc` (
  `sfc_id` varchar(60) NOT NULL,
  `sfc_name` varchar(45) DEFAULT NULL,
  `sfc_type` varchar(45) DEFAULT NULL,
  `sfc_status` varchar(45) DEFAULT NULL,
  `sfc_timestamp` varchar(45) DEFAULT NULL,
  `sfc_ingress` varchar(45) DEFAULT NULL,
  `sfc_egress` varchar(45) DEFAULT NULL,
  `sfc_bandwidth` varchar(45) DEFAULT NULL,
  `sfc_delay` varchar(45) DEFAULT NULL,
  `sfc_reliability` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sfc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sfc`
--

LOCK TABLES `sfc` WRITE;
/*!40000 ALTER TABLE `sfc` DISABLE KEYS */;
/*!40000 ALTER TABLE `sfc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network`
--

DROP TABLE IF EXISTS `network`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network` (
  `network_id` int(11) NOT NULL AUTO_INCREMENT,
  `network_osid` varchar(45) DEFAULT NULL,
  `subnet_osid` varchar(45) DEFAULT NULL,
  `subnet_cidr` varchar(45) DEFAULT NULL,
  `network_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`network_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network`
--

LOCK TABLES `network` WRITE;
/*!40000 ALTER TABLE `network` DISABLE KEYS */;
INSERT INTO `network` VALUES (8,'4398dc86-812b-432b-a53e-1b36745f8ae6','ed1b5bb4-43dc-486e-9f91-c473fc75cda0','192.168.0.0/24','ACTIVE'),(9,'0e102f24-fb57-427c-9c60-b20afaaef5c9','e91904d9-e722-4fbb-be06-b68eeb2d61a8','192.168.1.0/24','ACTIVE'),(10,'a71d6da7-3872-4b0d-a0d1-fa0334d09412','c106c493-f7e5-4668-9cff-de0254ec51d8','192.168.2.0/24','unused'),(11,'c437c80a-96ba-49d8-806e-56218b0d008e','f6a60fb6-3283-487c-a909-c86b3d35fa75','192.168.3.0/24','unused'),(12,'d6c47b21-fd5c-4ba7-914a-0fca6071a405','ba4f9497-36d3-492e-a44c-8af033afe559','192.168.4.0/24','unused'),(13,'4bfdc5c6-126c-4b6d-8f38-313fb587da5f','af046935-7e4d-46c4-8835-e0ea65b4cf55','192.168.5.0/24','unused'),(14,'9b668770-82cf-45b1-bb0b-49359c7311db','22f611f2-7bcf-4da5-b8f9-f3c4d4192608','192.168.6.0/24','unused');
/*!40000 ALTER TABLE `network` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subnet`
--

DROP TABLE IF EXISTS `subnet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subnet` (
  `subnet_id` varchar(60) NOT NULL,
  `subnet_name` varchar(60) DEFAULT NULL,
  `subnet_type` varchar(60) DEFAULT NULL,
  `subnet_cidr` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subnet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subnet`
--

LOCK TABLES `subnet` WRITE;
/*!40000 ALTER TABLE `subnet` DISABLE KEYS */;
/*!40000 ALTER TABLE `subnet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instance_subnet`
--

DROP TABLE IF EXISTS `instance_subnet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instance_subnet` (
  `instance_subnet_id` int(11) NOT NULL AUTO_INCREMENT,
  `instance_id` varchar(60) DEFAULT NULL,
  `subnet_id` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`instance_subnet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instance_subnet`
--

LOCK TABLES `instance_subnet` WRITE;
/*!40000 ALTER TABLE `instance_subnet` DISABLE KEYS */;
/*!40000 ALTER TABLE `instance_subnet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_sfc`
--

DROP TABLE IF EXISTS `tenant_sfc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant_sfc` (
  `tenant_sfc_id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_id` int(11) DEFAULT NULL,
  `sfc_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tenant_sfc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_sfc`
--

LOCK TABLES `tenant_sfc` WRITE;
/*!40000 ALTER TABLE `tenant_sfc` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant_sfc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floatingip`
--

DROP TABLE IF EXISTS `floatingip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `floatingip` (
  `floating_ip_id` int(11) NOT NULL AUTO_INCREMENT,
  `floating_ip_addr` varchar(45) DEFAULT NULL,
  `floating_ip_status` varchar(45) DEFAULT NULL,
  `floating_ip_osid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`floating_ip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floatingip`
--

LOCK TABLES `floatingip` WRITE;
/*!40000 ALTER TABLE `floatingip` DISABLE KEYS */;
INSERT INTO `floatingip` VALUES (1,'10.3.0.5','ACTIVE','05e5cd16-cdc7-4b96-b0b3-e12ef08e8431'),(2,'10.3.0.21','ACTIVE','134698f2-0b08-4f64-9765-4c462f4fb287'),(3,'10.3.0.3','ACTIVE','136c3f5d-eeeb-47fc-ada8-9f91ae5bb87e'),(4,'10.3.0.26','ACTIVE','1454e363-2be6-407c-8ffc-3f6993ecd6e7'),(5,'10.3.0.20','ACTIVE','1cdc1a33-e7eb-4a57-a9a8-bbc8f2805808'),(6,'10.3.0.2','ACTIVE','1f27b741-c775-48f9-87c0-25596a67ee9f'),(7,'10.3.0.15','ACTIVE','23e549a5-bda2-4e62-aa5c-8cca54b409b3'),(8,'10.3.0.28','ACTIVE','2659c088-eb58-444f-81ff-00601834cdb5'),(9,'10.3.0.11','ACTIVE','345cb2f8-d349-4c04-a01b-d8f3ce8882e1'),(10,'10.3.0.12','ACTIVE','3fba60a0-4fba-4a9a-a278-5ba52ee041ea'),(11,'10.3.0.25','ACTIVE','502bcd52-5ba5-4f22-9da1-38c3d886f0eb'),(12,'10.3.0.7','ACTIVE','571e914d-fb12-4180-946f-00984b439e7a'),(13,'10.3.0.29','ACTIVE','5c650e9c-0cf7-45c4-af0a-fca4a8c6d555'),(14,'10.3.0.23','ACTIVE','6b9f1912-e00e-4a69-a2c1-f30fc5a203c4'),(15,'10.3.0.30','ACTIVE','7dae088a-01a3-4421-b471-088b18062827'),(16,'10.3.0.24','ACTIVE','8baec05d-cfda-4ccc-a0ac-6813dea70d91'),(17,'10.3.0.8','ACTIVE','8c6ba9e3-7feb-4641-a2c3-dc1f63353fea'),(18,'10.3.0.10','ACTIVE','9da25b1c-b7bd-4d59-8db3-510f051113bf'),(19,'10.3.0.22','ACTIVE','a1f574da-cbeb-4052-b558-43f1d185c4ef'),(20,'10.3.0.31','ACTIVE','a3ca5494-1d59-475a-b832-ae53cbfdcfa5'),(21,'10.3.0.9','ACTIVE','a52e336d-ed52-44ae-a2b0-f25651b76a12'),(22,'10.3.0.17','ACTIVE','a5889a1f-3d09-4de4-ad94-404fff995837'),(23,'10.3.0.27','DOWN','a5aca348-bf4c-4916-a1e2-5ad4e2572b43'),(24,'10.3.0.4','DOWN','b1791fdb-f6eb-4792-b7bb-bf644d0a29f4'),(25,'10.3.0.6','DOWN','b9804d09-b9b1-41b7-b43d-120c969eb1ea'),(26,'10.3.0.19','DOWN','d9e36ea7-9de4-4c81-b84c-30cbc22d4651'),(27,'10.3.0.16','DOWN','dc0cefe2-811c-41a2-bdd2-a56c95cd38c5'),(28,'10.3.0.14','DOWN','f07096ab-a659-41cd-bd93-3dd0181513be'),(29,'10.3.0.13','DOWN','f50e72b3-cc20-44e5-abf5-86df7399043d'),(30,'10.3.0.18','ACTIVE','fa943361-9b96-4e7c-a7ea-903ff48ba853');
/*!40000 ALTER TABLE `floatingip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sfc_link`
--

DROP TABLE IF EXISTS `sfc_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sfc_link` (
  `sfc_link_id` int(11) NOT NULL AUTO_INCREMENT,
  `sfc_id` varchar(60) DEFAULT NULL,
  `link_id` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`sfc_link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sfc_link`
--

LOCK TABLES `sfc_link` WRITE;
/*!40000 ALTER TABLE `sfc_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `sfc_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sfc_vnf`
--

DROP TABLE IF EXISTS `sfc_vnf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sfc_vnf` (
  `sfc_vnf_id` int(11) NOT NULL AUTO_INCREMENT,
  `sfc_id` varchar(60) DEFAULT NULL,
  `vnf_id` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`sfc_vnf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sfc_vnf`
--

LOCK TABLES `sfc_vnf` WRITE;
/*!40000 ALTER TABLE `sfc_vnf` DISABLE KEYS */;
/*!40000 ALTER TABLE `sfc_vnf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stack`
--

DROP TABLE IF EXISTS `stack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stack` (
  `stack_id` int(11) NOT NULL AUTO_INCREMENT,
  `stack_osid` varchar(60) DEFAULT NULL,
  `stack_type` varchar(45) DEFAULT NULL,
  `stack_name` varchar(45) DEFAULT NULL,
  `stack_ip` varchar(45) DEFAULT NULL,
  `stack_compute` varchar(45) DEFAULT NULL,
  `stack_status` varchar(45) DEFAULT NULL,
  `stack_timestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stack_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stack`
--

LOCK TABLES `stack` WRITE;
/*!40000 ALTER TABLE `stack` DISABLE KEYS */;
/*!40000 ALTER TABLE `stack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instance`
--

DROP TABLE IF EXISTS `instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instance` (
  `instance_id` varchar(60) NOT NULL,
  `instance_osid` varchar(45) DEFAULT NULL,
  `instance_name` varchar(45) DEFAULT NULL,
  `instance_type` varchar(45) DEFAULT NULL,
  `instance_ip` varchar(45) DEFAULT NULL,
  `instance_zone` varchar(45) DEFAULT NULL,
  `instance_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instance`
--

LOCK TABLES `instance` WRITE;
/*!40000 ALTER TABLE `instance` DISABLE KEYS */;
/*!40000 ALTER TABLE `instance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_quota`
--

DROP TABLE IF EXISTS `tenant_quota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant_quota` (
  `tenant_quota_id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_id` int(11) DEFAULT NULL,
  `quota_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tenant_quota_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_quota`
--

LOCK TABLES `tenant_quota` WRITE;
/*!40000 ALTER TABLE `tenant_quota` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant_quota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vnf_flavor`
--

DROP TABLE IF EXISTS `vnf_flavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vnf_flavor` (
  `vnf_flavor_id` int(11) NOT NULL AUTO_INCREMENT,
  `vnf_id` varchar(45) DEFAULT NULL,
  `flavor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`vnf_flavor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vnf_flavor`
--

LOCK TABLES `vnf_flavor` WRITE;
/*!40000 ALTER TABLE `vnf_flavor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vnf_flavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flavor_instance`
--

DROP TABLE IF EXISTS `flavor_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flavor_instance` (
  `flavor_instance_id` int(11) NOT NULL AUTO_INCREMENT,
  `flavor_id` int(11) DEFAULT NULL,
  `instance_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`flavor_instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flavor_instance`
--

LOCK TABLES `flavor_instance` WRITE;
/*!40000 ALTER TABLE `flavor_instance` DISABLE KEYS */;
/*!40000 ALTER TABLE `flavor_instance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-09 15:38:55
