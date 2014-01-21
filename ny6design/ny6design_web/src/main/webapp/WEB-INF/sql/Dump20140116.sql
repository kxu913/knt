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
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_category` (
  `fcategoryid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `forder` int(3) DEFAULT '1',
  `fparentid` int(11) DEFAULT '-1' COMMENT ' -1 is for parent category.',
  `fvalidated` tinyint(1) DEFAULT '1' COMMENT '0 for invalidated; \n1 for validated\n',
  `fupdatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`fcategoryid`),
  UNIQUE KEY `category_id_UNIQUE` (`fcategoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES (164,'CLEARANCE!!',1,-1,1,'2014-01-03 17:28:05'),(165,'This_Month_items',1,164,1,'2014-01-03 17:28:05'),(166,'Wholesale Beads',2,-1,1,'2014-01-03 17:50:03'),(167,'Coral Beads',1,166,1,'2014-01-03 17:28:05'),(168,'Turquoise Beads',2,166,1,'2014-01-03 17:28:06'),(169,'Pearl Beads',3,166,1,'2014-01-03 17:28:06'),(170,'Quartz Beads',4,166,1,'2014-01-03 17:28:06'),(171,'Special GemStone',5,166,1,'2014-01-03 17:28:06'),(172,'Jade Beads',6,166,1,'2014-01-03 17:28:06'),(173,'Round Beads',3,-1,1,'2014-01-03 17:28:06'),(174,'Quartz beads',1,173,1,'2014-01-03 17:28:06'),(175,'Jasper beads',2,173,1,'2014-01-03 17:28:06'),(176,'Agate / Onyx',3,173,1,'2014-01-03 17:28:06'),(177,'Turquoise / Coral',4,173,1,'2014-01-03 17:28:06'),(178,'Jade beads',5,173,1,'2014-01-03 17:28:06'),(179,'Other semi gemstone',6,173,1,'2014-01-03 17:28:06'),(180,'Gold stone beads',7,173,1,'2014-01-03 17:28:06'),(181,'Semi-Gem beads',4,-1,1,'2014-01-03 17:50:20'),(182,'Agate',1,181,1,'2014-01-03 17:28:07'),(183,'Chrysocolla',2,181,1,'2014-01-03 17:28:07'),(184,'Jasper',3,181,1,'2014-01-03 17:28:07'),(185,'Necklaces / sets',5,-1,1,'2014-01-03 17:28:07'),(186,'Coral',1,185,1,'2014-01-03 17:28:07'),(187,'Turquoise',2,185,1,'2014-01-03 17:28:07'),(188,'LampWorks',3,185,1,'2014-01-03 17:28:07'),(189,'Freshwater Pearl',4,185,1,'2014-01-03 17:28:07'),(190,'Quartz',5,185,1,'2014-01-03 17:28:08'),(191,'Set jewelry',6,185,1,'2014-01-03 17:28:08'),(192,'Shell Pearl',7,185,1,'2014-01-03 17:28:08'),(193,'Special gemstone',8,185,1,'2014-01-03 17:28:08'),(194,'BraceLets',6,-1,1,'2014-01-03 17:28:08'),(195,'Coral',1,194,1,'2014-01-03 17:28:08'),(196,'Turquoise',2,194,1,'2014-01-03 17:28:08'),(197,'Freshwater Pearl',3,194,1,'2014-01-03 17:28:08'),(198,'Quartz',4,194,1,'2014-01-03 17:28:08'),(199,'Shell pearl',5,194,1,'2014-01-03 17:28:08'),(200,'Other gemstone',6,194,1,'2014-01-03 17:28:08'),(201,'Pendants',7,-1,1,'2014-01-03 17:28:09'),(202,'.925 Silver Pendants',1,201,1,'2014-01-03 17:28:09'),(203,'Shell Pendants',2,201,1,'2014-01-03 17:28:09'),(204,'Other Pendants',3,201,1,'2014-01-03 17:28:09'),(205,'Caved Pendants',4,201,1,'2014-01-03 17:28:09'),(206,'Earring / Rings',8,-1,1,'2014-01-03 17:28:09'),(207,'Earrings_silver',1,206,1,'2014-01-03 17:28:09'),(208,'Earrings_gold',2,206,1,'2014-01-03 17:28:09'),(209,'Rings',3,206,1,'2014-01-03 17:28:10'),(210,'Lampwork Beads',9,-1,1,'2014-01-03 17:28:10'),(211,'Lampwork Beads',1,210,1,'2014-01-03 17:28:10'),(212,'Pearl Jewelry',10,-1,1,'2014-01-03 17:28:10'),(213,'Pearl Jewelry',1,212,1,'2014-01-03 17:28:10'),(214,'Findings: (Silver /14K /Pewter)',11,-1,1,'2014-01-03 17:28:10'),(215,'-925 Sterling Silver',1,214,1,'2014-01-03 17:28:11'),(216,'-14K Gold Filled',2,214,1,'2014-01-03 17:28:11'),(217,'-Pewter (LEAD FREE)',3,214,1,'2014-01-03 17:28:11'),(218,'Beading supply etc.',12,-1,1,'2014-01-03 17:28:11'),(219,'beading wire',1,218,1,'2014-01-03 17:28:11'),(220,'Trendy_Handbag',13,-1,1,'2014-01-03 17:28:11'),(221,'Trendy_Handbag',1,220,1,'2014-01-03 17:28:11'),(222,'Others',14,-1,1,'2014-01-03 17:28:11'),(223,'Jewelry Class',1,222,1,'2014-01-03 17:28:11'),(224,'Others gemstone',2,222,1,'2014-01-03 17:28:11');
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'beadswholesale'
--

--
-- Dumping routines for database 'beadswholesale'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-16 22:17:10
