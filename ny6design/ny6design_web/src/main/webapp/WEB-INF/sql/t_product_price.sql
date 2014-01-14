CREATE DATABASE  IF NOT EXISTS `beadswholesale` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `beadswholesale`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: beadswholesale
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `t_product_price`
--
USE ny6design;
DROP TABLE IF EXISTS `t_product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_price` (
  `fpriceid` int(10) NOT NULL AUTO_INCREMENT,
  `fproductid` int(10) NOT NULL,
  `fcolor` varchar(100) DEFAULT NULL,
  `funit` varchar(50) DEFAULT NULL,
  `fweight` varchar(100) DEFAULT NULL,
  `fourprice` decimal(8,2) DEFAULT NULL,
  `fqty` int(10) DEFAULT NULL,
  `fcondition` varchar(100) DEFAULT NULL,
  `fupdatedtime` datetime DEFAULT NULL,
  `forginalprice` decimal(8,2) DEFAULT NULL,
  `fsaleprice1` decimal(8,2) DEFAULT NULL,
  `fsaleprice2` decimal(8,2) DEFAULT NULL,
  `fsaleprice3` decimal(8,2) DEFAULT NULL,
  `fspecialprice` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`fpriceid`),
  UNIQUE KEY `fproductpriceid_UNIQUE` (`fpriceid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-13  9:54:58
