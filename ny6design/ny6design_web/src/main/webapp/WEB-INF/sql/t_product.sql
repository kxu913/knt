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
-- Table structure for table `t_product`
--
USE ny6design;
DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `fproductid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `fdisplayname` varchar(100) DEFAULT NULL,
  `fdescription` varchar(100) DEFAULT NULL,
  `fcategoryid` int(10) DEFAULT NULL,
  `fsaleflag` tinyint(5) DEFAULT NULL COMMENT 'bit represition: 00001 for hot item, 00010 for specials, 00100 for new item,01000 for mixsale\n',
  `fshiptime` varchar(100) DEFAULT NULL,
  `fsellqty` int(10) DEFAULT NULL,
  `finventoryqty` int(10) DEFAULT NULL,
  `fvalidation` tinyint(1) DEFAULT '1',
  `favailabledate` date DEFAULT NULL,
  `fupdatedtime` datetime DEFAULT NULL,
  `fcreatetime` datetime DEFAULT NULL,
  `fsoldoutflag` tinyint(1) DEFAULT '1' COMMENT '0 is for  not showing, 1 is for showing  on the picture.',
  `frecommend` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`fproductid`),
  UNIQUE KEY `fid_UNIQUE` (`fproductid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-13  9:54:57
