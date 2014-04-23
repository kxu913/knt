-- MySQL dump 10.13  Distrib 5.6.15, for Win64 (x86_64)
--
-- Host: localhost    Database: ny6design
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `e_country`
--

DROP TABLE IF EXISTS `e_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_country` (
  `code` varchar(8) COLLATE utf8_bin NOT NULL DEFAULT '',
  `fdescription` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_country`
--

LOCK TABLES `e_country` WRITE;
/*!40000 ALTER TABLE `e_country` DISABLE KEYS */;
INSERT INTO `e_country` VALUES ('AD','Andorra'),('AE','United Arab Emirates'),('AF','Afghanistan'),('AG','Antigua and Barbuda'),('AI','Anguilla'),('AL','Albania'),('AN','Netherlands Antilles'),('AO','Angola'),('AQ','Antarctica'),('AR','Argentina'),('AS','American Samoa'),('AT','Austria'),('AU','Australia'),('AW','Aruba'),('BB','Barbados'),('BD','Bangladesh'),('BE','Belgium'),('BF','Burkina Faso'),('BG','Bulgaria'),('BH','Bahrain'),('BI','Burundi'),('BJ','Benin'),('BM','Bermuda'),('BN','Brunei Darussalam'),('BO','Bolivia'),('BR','Brazil'),('BS','Bahamas'),('BT','Bhutan'),('BV','Bouvet Island'),('BW','Botswana'),('BY','Byelorussian'),('BZ','Belize'),('CA','Canada'),('CC','Cocos (Keeling) Islands'),('CF','Central African Republic'),('CG','Congo'),('CH','Switzerland'),('CI','Cote D\'Ivoire'),('CK','Cook Islands'),('CL','Chile'),('CM','Cameroon'),('CN','China'),('CO','Colombia'),('CR','Costa Rica'),('CS','Czechoslovakia'),('CV','Cape Verde'),('CX','Christmas Island'),('CY','Cyprus'),('DE','Germany'),('DJ','Djibouti'),('DK','Denmark'),('DM','Dominica'),('DO','Dominican Republic'),('DZ','Algeria'),('EC','Ecuador'),('EG','Egypt'),('EH','Western Sahara'),('ES','Spain'),('ET','Ethiopia'),('FI','Finland'),('FJ','FJ'),('FK','Falkland Islands'),('FM','Micronesia'),('FO','Faroe Islands'),('FR','France'),('GA','Gabon'),('GB','United Kingdom'),('GD','Grenada'),('GF','French Guiana'),('GH','Ghana'),('GI','Gibraltar'),('GL','Greenland'),('GM','Gambia'),('GN','GN'),('GP','Gudeloupe'),('GQ','Equatorial Guinea'),('GR','Greece'),('GT','Guatemala'),('GU','Guam'),('GW','Guinea-Bissau'),('GY','Guyana'),('HK','Hong Kong'),('HM','Heard and Mc Donald Isls'),('HN','Honduras'),('HT','Haiti'),('HU','Hungary'),('ID','Indonesia'),('IE','Ireland'),('IL','Israel'),('IN','India'),('IO','British Indian Ocean T'),('IS','Iceland'),('IT','Italy'),('JM','Jamaica'),('JO','JO'),('JP','Japan'),('KE','Kenya'),('KH','Kampuchea Democratic'),('KI','Kiribati'),('KM','Comoros'),('KN','Saint Kitts and Nevis'),('KR','Korea Republic'),('US','United States');
/*!40000 ALTER TABLE `e_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_from`
--

DROP TABLE IF EXISTS `e_from`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_from` (
  `fromId` int(8) NOT NULL DEFAULT '0',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`fromId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='How did you hear about us';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_from`
--

LOCK TABLES `e_from` WRITE;
/*!40000 ALTER TABLE `e_from` DISABLE KEYS */;
INSERT INTO `e_from` VALUES (1,'Link from another site'),(2,'Yahoo Search engine'),(3,'Google Search Engine'),(4,'Email promotion'),(5,'Referred by friend'),(6,'Saw an Ad'),(7,'Other');
/*!40000 ALTER TABLE `e_from` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_pay_method`
--

DROP TABLE IF EXISTS `e_pay_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_pay_method` (
  `id` int(11) NOT NULL,
  `description` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `active` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_pay_method`
--

LOCK TABLES `e_pay_method` WRITE;
/*!40000 ALTER TABLE `e_pay_method` DISABLE KEYS */;
INSERT INTO `e_pay_method` VALUES (1,'Paypal',1),(2,'Credit Card',1),(3,'Check',1),(4,'Email your orders',1);
/*!40000 ALTER TABLE `e_pay_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_ship_method`
--

DROP TABLE IF EXISTS `e_ship_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_ship_method` (
  `id` int(11) NOT NULL,
  `description` varchar(100) COLLATE utf8_bin NOT NULL,
  `cost` double NOT NULL,
  `fdefault` int(1) NOT NULL,
  `forder` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_ship_method`
--

LOCK TABLES `e_ship_method` WRITE;
/*!40000 ALTER TABLE `e_ship_method` DISABLE KEYS */;
INSERT INTO `e_ship_method` VALUES (1,'Default Postal mail:',4.95,1,0),(2,'USA Postal mail:',5.95,0,1),(3,'International Postal:',6.95,0,2);
/*!40000 ALTER TABLE `e_ship_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_states`
--

DROP TABLE IF EXISTS `e_states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_states` (
  `code` varchar(8) COLLATE utf8_bin NOT NULL DEFAULT '',
  `fdescription` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_states`
--

LOCK TABLES `e_states` WRITE;
/*!40000 ALTER TABLE `e_states` DISABLE KEYS */;
INSERT INTO `e_states` VALUES ('AA','Armed Forces Americas'),('FL','Florida'),('GA','Georgia'),('NY','New York'),('TX','Texas');
/*!40000 ALTER TABLE `e_states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_address`
--

DROP TABLE IF EXISTS `t_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `countryCode` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `stateCode` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `town` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '',
  `zipcode` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `address` varchar(60) COLLATE utf8_bin NOT NULL DEFAULT '',
  `fdefault` smallint(6) NOT NULL,
  `firstName` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `lastName` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `emailAddress` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `telephone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_address`
--

LOCK TABLES `t_address` WRITE;
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT INTO `t_address` VALUES (1,'US','AA','1','s','1',1,NULL,NULL,NULL,NULL),(2,'US','AA','1','s','1',1,NULL,NULL,NULL,NULL),(3,'US','TAX','town','ts','test',1,NULL,NULL,NULL,NULL),(4,'US','TAX','town','ts','test',1,NULL,NULL,NULL,NULL),(5,'US','AA','1','s','1',1,NULL,NULL,NULL,NULL),(6,'US','AA','1','s','1',1,NULL,NULL,NULL,NULL),(7,'US','AA','1','1','1',1,NULL,NULL,NULL,NULL),(8,'US','AA','1','1','1',1,NULL,NULL,NULL,NULL),(9,'US','AA','1','1','1',1,NULL,NULL,NULL,NULL),(10,'BN','NY','1','1','1',1,NULL,NULL,NULL,NULL),(11,'BF','NY','18','18','18',1,NULL,NULL,NULL,NULL),(12,'BF','NY','18','18','18',1,NULL,NULL,NULL,NULL),(13,'AD','NY','18','18','18',1,NULL,NULL,NULL,NULL),(14,'AD','NY','18','18','18',1,NULL,NULL,NULL,NULL),(15,'AD','NY','18','18','18',1,NULL,NULL,NULL,NULL),(16,'AD','NY','18','18','18',1,NULL,NULL,NULL,NULL),(17,'AD','NY','18','18','18',1,NULL,NULL,NULL,NULL),(18,'GN','FL','1','1','1',1,NULL,NULL,NULL,NULL),(19,'AD','NY','18','18','18',1,NULL,NULL,NULL,NULL),(20,'KM','FL','1','1','1',1,NULL,NULL,NULL,NULL),(21,'AD','FL','1','1','1',1,NULL,NULL,NULL,NULL),(22,'KR','FL','2','2','2',1,NULL,NULL,NULL,NULL),(23,'AD','FL','2','2','2',1,NULL,NULL,NULL,NULL),(24,'US','AA','ptny6','ptny6','ptny6',1,NULL,NULL,NULL,NULL),(25,'KN','FL','t1','1','t1',1,NULL,NULL,NULL,NULL),(26,'KH','FL','2','2','22',1,NULL,NULL,NULL,NULL),(27,'US','TX','3','3','3',1,NULL,NULL,NULL,NULL),(28,'US','AA','k1','123456','k1',1,NULL,NULL,NULL,NULL),(29,'US','AA','k1','123456','k1',1,NULL,NULL,NULL,NULL),(30,'US','AA','k1','123456','k1',1,NULL,NULL,NULL,NULL),(31,'US','AA','k1','123456','k1',1,NULL,NULL,NULL,NULL),(32,'US','AA','k2','111','k2',1,'k2','k2','k2@test.com','111'),(33,'AO','FL','1','2','12',0,'kk2','kk2','12','12'),(34,'AN','NY','2','2','2',0,'kkk2','kkk2','2','2'),(35,'US','AA','x1','111111','x1',1,'x1','x1','x1@test.com','777777');
/*!40000 ALTER TABLE `t_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cart_order`
--

DROP TABLE IF EXISTS `t_cart_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cart_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cartId` int(11) NOT NULL DEFAULT '0',
  `orderId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='used to store mapping of cart and order';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cart_order`
--

LOCK TABLES `t_cart_order` WRITE;
/*!40000 ALTER TABLE `t_cart_order` DISABLE KEYS */;
INSERT INTO `t_cart_order` VALUES (2,1,2),(3,4,3);
/*!40000 ALTER TABLE `t_cart_order` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Table structure for table `t_message`
--

DROP TABLE IF EXISTS `t_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_message` (
  `fmessageId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(40) NOT NULL DEFAULT '',
  `lastName` varchar(40) NOT NULL DEFAULT '',
  `fuserId` int(11) DEFAULT NULL,
  `fdescription` varchar(1000) NOT NULL,
  `fupdatetime` datetime DEFAULT NULL,
  `telephone` varchar(40) DEFAULT NULL,
  `emailAddress` varchar(40) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `recommend` smallint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`fmessageId`),
  UNIQUE KEY `message_id_UNIQUE` (`fmessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_message`
--

LOCK TABLES `t_message` WRITE;
/*!40000 ALTER TABLE `t_message` DISABLE KEYS */;
INSERT INTO `t_message` VALUES (1,'test','test',1,'The \"CUSTOM MAKE JEWELRY ORDER\" was great! \"MAKE IN U.S.A.\" Finished Jewelry Order with small quantity and COMPARATIVE PRICE are what you looking for!','2014-01-18 12:34:44','123456','test',NULL,0),(2,'t1','t1',1,'These bead strands are so perfect &amp; the quality is above all other suppliers!!! Can\'t wait to make them into some beautiful jewelry!!!','2014-01-18 12:34:44','1','t1',NULL,1),(3,'t2','t2',1,'How amzing your stones are!! I love every bead that I have gotten &amp; the quality is unsurpassed!!! wow!!','2014-01-18 12:34:44','2','t2',NULL,1),(4,'t3','t3',1,'I received my order quickly. It was well packed and I found all of my order packed and precious. Couldn\'t wait to get my hands on them. Great job NY6 Designs.','2014-01-18 12:34:44','3','t3',NULL,0),(5,'t4','t4',1,'The necklace was beautiful!Item as described and received promptly, thank you for working hard!!!','2014-01-18 12:34:44','4','t4',NULL,1),(6,'t5','t5',1,'I LOVE this website!!! Great quality!! I just wish they had more sets because I want to match everything!!I WILL shop again and again!!!','2014-01-18 12:34:44','5','t5',NULL,1),(7,'t6','t6',1,'I recently became interested in making jewelry using beads so I visited retail stores in my area and was shocked to see how much beads cost. I went to the Ebay website with great reluctance to try to find beads at a reasonable price. After receiving my first shipment fromNY6 Design, I realized that your beads were of a higher quality than the ones in the stores and your prices are great! I have been telling my friends who are interested in making jewelry from beads that they should check out yourwebsite before paying hugh prices in retail stores. Quality, value and great customer service are the three most important things I look for when spending money. NY6 has all three of these and you are #1 on my list of suppliers!!!','2014-01-18 12:34:44','6','t6',NULL,1),(8,'t7','t7',1,'Thank you for your wonderful service. My order was delivered very quickly and with the extra care taken in packing everything arrived in perfect condition.','2014-01-18 12:34:45','7','t7',NULL,1),(9,'t8','t8',1,'LOVEEEE THE BEADS, I LEFT A SUPER MARVELOUS FEEDBACK BECAUSE YOU GUYS DESERVED. I WILL KEEP SHOPPING WITH YOU GUYS. THANKS YOU SO MUCH FOR THE FAST SERVICE, THE EXCELLENT WELL PACKEDAND TGHE CARE YOU PUT WHEN WRAPING AND SHIPPING THIS FOR ME. IT MAKE ME TRUST AND FEEL TRANQUIL WHEN BUYING WITH YOU.... CONGRATULATIONS AND KEEP IT UP GUYS. I SAVED YOU IN MY FAVORITE SELLER LIST AND WILL SEE YOU SOON IN THE SHOW ROOM;O) KIND REGARDS, CLAUDIA H','2014-01-18 12:34:45','8','t8',NULL,1),(10,'t9','t9',1,'Quality of beads is excellent and choices are immense! Order enough items and shipping is free and cost of items reduces nicely. Will come back for more; highly recommend this seller!','2014-01-18 12:34:45','9','t9',NULL,1),(11,'test','test',NULL,'11111111111111111111111111','2014-02-13 15:10:16','123456','123','123',0),(12,'t1','t1',NULL,'t11111111111111111','2014-02-13 15:12:25','t1','t1','t1',0),(13,'t1','t1',9,'ssssssssssssss','2014-02-28 16:45:09','t1','t1','51',0),(14,'532','sd',1,'teststet','2014-03-03 12:13:46','sd','sd','sd',0);
/*!40000 ALTER TABLE `t_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL DEFAULT '0',
  `amount` int(11) DEFAULT NULL,
  `cost` decimal(10,2) NOT NULL DEFAULT '0.00',
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '0: add, -1: cancel, 1: payed',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastUpdateTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='shopping cart';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,49,1,3.99,1,'2014-04-22 12:01:23','2014-04-22 12:01:23'),(2,51,2,8.98,1,'2014-04-23 17:29:09','2014-04-23 17:29:09'),(3,50,3,5.97,1,'2014-04-23 17:36:29','2014-04-23 17:36:29'),(4,49,1,3.99,1,'2014-04-23 17:48:26','2014-04-23 17:48:26'),(5,51,2,8.98,1,'2014-04-23 17:48:33','2014-04-23 17:48:33');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_mapping`
--

DROP TABLE IF EXISTS `t_order_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordersummaryId` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='used to store mapping of summary and order';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_mapping`
--

LOCK TABLES `t_order_mapping` WRITE;
/*!40000 ALTER TABLE `t_order_mapping` DISABLE KEYS */;
INSERT INTO `t_order_mapping` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,4,5);
/*!40000 ALTER TABLE `t_order_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_summary`
--

DROP TABLE IF EXISTS `t_order_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(30) COLLATE utf8_bin NOT NULL,
  `addressId` int(11) NOT NULL,
  `shipmethodId` int(11) NOT NULL,
  `paymethodId` int(11) NOT NULL,
  `discountId` int(11) NOT NULL,
  `subtotal` double NOT NULL,
  `total` double NOT NULL,
  `notice` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  `createTime` datetime NOT NULL,
  `lastupdateTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='used to store order total information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_summary`
--

LOCK TABLES `t_order_summary` WRITE;
/*!40000 ALTER TABLE `t_order_summary` DISABLE KEYS */;
INSERT INTO `t_order_summary` VALUES (1,'201404221201367473',0,2,4,1,7.94,7.94,'',8,1,'2014-04-22 12:01:37','2014-04-22 12:01:37'),(2,'201404231732488432',0,1,4,1,12.93,12.93,'',8,1,'2014-04-23 17:32:48','2014-04-23 17:32:48'),(3,'201404231739548640',32,1,4,1,9.92,9.92,'',8,1,'2014-04-23 17:39:54','2014-04-23 17:39:54'),(4,'201404231749095569',32,1,4,1,16.92,16.92,'',8,1,'2014-04-23 17:49:10','2014-04-23 17:49:10');
/*!40000 ALTER TABLE `t_order_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `sku` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `location` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `quantity` int(4) DEFAULT '0',
  `stock_status_id` int(11) DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `manufacturer_id` int(11) DEFAULT NULL,
  `shipping` int(1) DEFAULT '1',
  `price` decimal(15,4) DEFAULT '0.0000',
  `tax_class_id` int(11) DEFAULT NULL,
  `date_available` date DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT '0.00',
  `weight_class_id` int(11) DEFAULT '0',
  `length` decimal(5,2) DEFAULT '0.00',
  `width` decimal(5,2) DEFAULT '0.00',
  `height` decimal(5,2) DEFAULT '0.00',
  `length_class_id` int(11) DEFAULT '0',
  `status` int(1) DEFAULT '0',
  `date_added` datetime DEFAULT '0000-00-00 00:00:00',
  `date_modified` datetime DEFAULT '0000-00-00 00:00:00',
  `viewed` int(5) DEFAULT '0',
  `sort_order` int(11) DEFAULT '0',
  `subtract` int(1) DEFAULT '1',
  `minimum` int(11) DEFAULT '1',
  `cost` decimal(15,4) DEFAULT '0.0000',
  `as_index` int(1) DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (49,'test','1','USA',432,1,'static/img/p1.jpg',1,1,45.0000,1,'2014-04-21',0.00,0,0.00,0.00,0.00,0,0,'2014-04-21 18:20:17','2014-04-21 18:20:17',0,0,1,1,0.0000,1),(50,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-04-21',0.00,0,0.00,0.00,0.00,0,0,'2014-04-21 18:20:17','2014-04-21 18:20:17',0,0,1,1,0.0000,1),(103,'test22','1','USA',438,1,'static/img/p1.jpg',1,1,41.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:37:41','2014-03-24 00:37:41',0,0,1,1,0.0000,1),(102,'abc','1','USA',30,1,'static/img/p3.jpg',1,1,25.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,0,'2014-03-23 23:44:00','2014-03-23 23:44:00',0,0,1,1,0.0000,0),(100,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,0,'2014-03-24 00:20:41','2014-03-24 00:20:41',0,0,1,1,0.0000,1),(101,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,0,'2014-03-24 00:21:32','2014-03-24 00:21:32',0,0,1,1,0.0000,0),(104,'test','1','USA',432,1,'static/img/p1.jpg',1,1,45.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,1,'2014-03-23 12:24:07','2014-03-23 12:24:07',0,0,1,1,0.0000,0),(105,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:21:26','2014-03-24 00:21:26',0,0,1,1,0.0000,0),(106,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:21:06','2014-03-24 00:21:06',0,0,1,1,0.0000,1),(51,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-04-21',0.00,0,0.00,0.00,0.00,0,0,'2014-04-21 18:20:17','2014-04-21 18:20:17',0,0,1,1,0.0000,1),(107,'abc','1','USA',30,1,'static/img/p3.jpg',1,1,25.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,1,'2014-03-23 12:24:07','2014-03-23 12:24:07',0,0,1,1,0.0000,0),(109,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:21:06','2014-03-24 00:21:06',0,0,1,1,0.0000,1),(110,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:37:41','2014-03-24 00:37:41',0,0,1,1,0.0000,1),(111,'test22','1','USA',438,1,'static/img/p1.jpg',1,1,41.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,1,'2014-03-23 12:24:07','2014-03-23 12:24:07',0,0,1,1,0.0000,0),(112,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:03:26','2014-03-23 20:03:26',12,1,1,1,0.0000,0),(113,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:07:12','2014-03-23 20:07:12',12,1,1,1,0.0000,0),(114,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:10:39','2014-03-23 20:10:39',12,1,1,1,0.0000,0),(115,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:12:36','2014-03-23 20:12:36',12,1,1,1,0.0000,0);
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_description`
--

DROP TABLE IF EXISTS `t_product_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_description` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `language_id` int(11) DEFAULT '0',
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `meta_keywords` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `meta_description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_description`
--

LOCK TABLES `t_product_description` WRITE;
/*!40000 ALTER TABLE `t_product_description` DISABLE KEYS */;
INSERT INTO `t_product_description` VALUES (49,1,'N3_1016_39 Yellow Natural Agate & Drusy druzy agate Butterfly Pendant Stretch Bracelet','Drusy druzy a','Drusy druzy a','Drusy druzy a'),(51,1,'(CR669)a 14x9mm Purple Crystal Faceted Teardrop Beads 11.5\" a','Crystal Faceted','Crystal Faceted','Crystal Faceted'),(50,1,'M4 30x28mm Lampwork Handmade Heart Pendant Bead a','Lampwork Handmade ','Lampwork Handmade ','Lampwork Handmade '),(53,NULL,'N3_1016_39 Yellow Natural Agate & Drusy druzy agate Butterfly Pendant Stretch Bracelet',NULL,NULL,'Drusy druzy a'),(54,NULL,'(CR669)a 14x9mm Purple Crystal Faceted Teardrop Beads 11.5\" a',NULL,NULL,'Crystal Faceted'),(55,NULL,'N3_1016_39 Yellow Natural Agate & Drusy druzy agate Butterfly Pendant Stretch Bracelet',NULL,NULL,'Drusy druzy a');
/*!40000 ALTER TABLE `t_product_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_image`
--

DROP TABLE IF EXISTS `t_product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_image` (
  `product_image_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`product_image_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1338 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_image`
--

LOCK TABLES `t_product_image` WRITE;
/*!40000 ALTER TABLE `t_product_image` DISABLE KEYS */;
INSERT INTO `t_product_image` VALUES (1,49,'static/img/p1.jpg'),(2,49,'static/img/p2.jpg'),(3,49,'static/img/p3.jpg');
/*!40000 ALTER TABLE `t_product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_price`
--

DROP TABLE IF EXISTS `t_product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_price` (
  `product_discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `customer_group_id` int(11) NOT NULL,
  `quantity` int(4) NOT NULL DEFAULT '0',
  `priority` int(5) NOT NULL DEFAULT '1',
  `price` decimal(15,4) NOT NULL DEFAULT '0.0000',
  `date_start` date NOT NULL DEFAULT '0000-00-00',
  `date_end` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`product_discount_id`),
  KEY `product_id` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_price`
--

LOCK TABLES `t_product_price` WRITE;
/*!40000 ALTER TABLE `t_product_price` DISABLE KEYS */;
INSERT INTO `t_product_price` VALUES (1,49,1,1,1,3.9900,'0000-00-00','0000-00-00'),(2,49,1,5,2,3.3900,'0000-00-00','0000-00-00'),(3,49,1,20,3,2.8000,'0000-00-00','0000-00-00'),(4,51,1,1,1,4.4900,'0000-00-00','0000-00-00'),(5,51,1,5,2,3.9900,'0000-00-00','0000-00-00'),(6,51,1,20,3,3.1900,'0000-00-00','0000-00-00'),(7,50,1,1,1,1.9900,'0000-00-00','0000-00-00'),(8,50,1,5,2,1.6900,'0000-00-00','0000-00-00'),(9,50,1,20,3,1.3900,'0000-00-00','0000-00-00'),(106,53,0,20,3,2.8000,'2014-01-01','2014-01-01'),(105,53,0,5,2,3.3900,'2014-01-01','2014-01-01'),(104,53,0,1,1,3.9900,'2014-01-01','2014-01-01'),(107,54,0,1,1,4.4900,'2014-01-01','2014-01-01'),(108,54,0,5,2,3.9900,'2014-01-01','2014-01-01'),(109,54,0,20,3,3.1900,'2014-01-01','2014-01-01'),(110,55,0,20,3,2.8000,'2014-01-01','2014-01-01'),(111,55,0,5,2,3.3900,'2014-01-01','2014-01-01'),(112,55,0,1,1,3.9900,'2014-01-01','2014-01-01');
/*!40000 ALTER TABLE `t_product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_to_category`
--

DROP TABLE IF EXISTS `t_product_to_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_to_category` (
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`product_id`,`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_to_category`
--

LOCK TABLES `t_product_to_category` WRITE;
/*!40000 ALTER TABLE `t_product_to_category` DISABLE KEYS */;
INSERT INTO `t_product_to_category` VALUES (49,184),(50,184),(51,184);
/*!40000 ALTER TABLE `t_product_to_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_question`
--

DROP TABLE IF EXISTS `t_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(40) NOT NULL DEFAULT '',
  `lastName` varchar(40) NOT NULL DEFAULT '',
  `telephone` varchar(20) NOT NULL DEFAULT '',
  `emailAddress` varchar(40) NOT NULL DEFAULT '',
  `extra` varchar(255) NOT NULL DEFAULT '',
  `address` varchar(80) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0: new question; 1: replied',
  `userId` int(10) DEFAULT NULL COMMENT 'relevance with t_user',
  `submitTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `replyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='question table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_question`
--

LOCK TABLES `t_question` WRITE;
/*!40000 ALTER TABLE `t_question` DISABLE KEYS */;
INSERT INTO `t_question` VALUES (1,'test','teest','test','test','111111sssssssssssss','test',0,NULL,'2014-02-13 07:12:08',NULL),(2,'t2','t2','1234','1234','for test','1234',0,1,'2014-02-16 03:03:01',NULL);
/*!40000 ALTER TABLE `t_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_shopping_rule`
--

DROP TABLE IF EXISTS `t_shopping_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_shopping_rule` (
  `id` int(11) NOT NULL,
  `description` varchar(500) COLLATE utf8_bin NOT NULL,
  `html` varchar(40) COLLATE utf8_bin NOT NULL COMMENT 'which page used to display',
  `active` int(1) NOT NULL COMMENT 'need to be display',
  `forder` int(1) NOT NULL COMMENT 'used to determine display order',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='used to describe shopping rule, such as free shipping, amout rules';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_shopping_rule`
--

LOCK TABLES `t_shopping_rule` WRITE;
/*!40000 ALTER TABLE `t_shopping_rule` DISABLE KEYS */;
INSERT INTO `t_shopping_rule` VALUES (1,'<strong>*Free Shipping!</strong>  On order over $50 for U.S. $75 for Canada (Regular Postal mail) .   $250 for International orders (up to $25 shipping discount credit for Regular Air mail).   <strong>Please add item to save on shipping!</strong>','shoppingcart/checkout',1,1),(2,'<strong>Domestic Express Mail pls Call 214-244-5851!</strong><br/>Otherwise: USA & Canadian buyer will pay S/H $4.95 for first items and $1.95 for each additional items. INTERNATIONAL buyer will pay $7.95 for first items and $2.95 for each additional items.','shoppingcart/checkout',1,2),(3,'When you continue with checkout Voucher Code will be calculated.<br/>DISCOUNT VOUCHER will be calculated in subtotal page after checkout. <br/>Please be patient, this may take a minute.','shoppingcart/discount',1,1);
/*!40000 ALTER TABLE `t_shopping_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_shoppingcart`
--

DROP TABLE IF EXISTS `t_shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_shoppingcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `orderId` int(11) DEFAULT NULL,
  `lastUpdateTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_shoppingcart`
--

LOCK TABLES `t_shoppingcart` WRITE;
/*!40000 ALTER TABLE `t_shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_stock_status`
--

DROP TABLE IF EXISTS `t_stock_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_stock_status` (
  `stock_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `language_id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`stock_status_id`,`language_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_stock_status`
--

LOCK TABLES `t_stock_status` WRITE;
/*!40000 ALTER TABLE `t_stock_status` DISABLE KEYS */;
INSERT INTO `t_stock_status` VALUES (1,1,'In Stock'),(2,1,'Out Of Stock'),(3,1,'2 - 3 Days'),(4,1,'Pre-Order');
/*!40000 ALTER TABLE `t_stock_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `emailAddress` varchar(80) COLLATE utf8_bin NOT NULL DEFAULT '',
  `password` varchar(80) COLLATE utf8_bin NOT NULL DEFAULT '',
  `salt` blob NOT NULL,
  `firstName` varchar(80) COLLATE utf8_bin NOT NULL DEFAULT '',
  `lastName` varchar(80) COLLATE utf8_bin NOT NULL DEFAULT '',
  `addressId` int(11) NOT NULL DEFAULT '0',
  `telephone` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `fax` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `taxId` decimal(10,3) DEFAULT NULL,
  `fromId` int(11) NOT NULL DEFAULT '0',
  `factive` varchar(1) COLLATE utf8_bin NOT NULL DEFAULT '',
  `isAdmin` tinyint(3) NOT NULL DEFAULT '0',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isPublicTel` tinyint(3) NOT NULL DEFAULT '1',
  `isPublicEmail` tinyint(3) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'ptny6','cdac894bb6a4cb80e846bc3a025fd262349b839c','%&V† ÎÍ','ptny6','ptny6',24,'123456','123456',1.000,1,'0',1,'2014-01-26 06:06:48',1,1),(2,'t1@test.com','925c62e35dd303f719e9ce382e8a35f86e2d1e53','Ä%í©?Ðî','t1','t1',25,'1','1',1.000,1,'0',0,'2014-01-26 06:03:27',1,1),(3,'t2@test.com','1f1fb6431a2de8bb6dcf43c8b4878ee0dae3e4fa','~è³>‡Ÿ[','2','2',26,'2','2',2.000,5,'0',0,'2014-01-26 06:04:45',1,1),(4,'t3@test.com','22e6673fd5335b1a580e8cb0cfa01396c2dc8118','f³æ¹ãH-','3','3',27,'3','3',3.000,6,'0',0,'2014-01-26 06:05:12',1,1),(7,'kevin.xu@morningstar.com','eba700bc12dc23fa8003ae01bfb7176146620eec','†Êm¯8¹E','k1','k1',31,'12345678','123',12.000,6,'0',0,'2014-03-14 08:21:42',1,1),(8,'k2@test.com','d12dbb10a5ad724308319e1ee4aafeb784bd0ea6','Ú­ï”ßuß@','k2','k2',32,'111','111',111.000,1,'0',0,'2014-02-16 09:15:10',1,1),(9,'x1@test.com','7fc18f70f8e5a3620e1870618ab1afc4d1a475f0','¶v­~¾#','x1','x1',35,'777777','7',7.000,6,'0',0,'2014-02-28 08:42:48',1,1);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_address`
--

DROP TABLE IF EXISTS `t_user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `addressId` int(11) DEFAULT NULL COMMENT 'mapping of user and address',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_address`
--

LOCK TABLES `t_user_address` WRITE;
/*!40000 ALTER TABLE `t_user_address` DISABLE KEYS */;
INSERT INTO `t_user_address` VALUES (1,7,31),(2,8,32),(3,8,33),(4,8,34),(5,9,35);
/*!40000 ALTER TABLE `t_user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wishlist`
--

DROP TABLE IF EXISTS `t_wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wishlist` (
  `product_id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`product_id`,`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wishlist`
--

LOCK TABLES `t_wishlist` WRITE;
/*!40000 ALTER TABLE `t_wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-23 18:20:46
