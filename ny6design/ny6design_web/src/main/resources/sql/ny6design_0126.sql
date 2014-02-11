# MySQL-Front 5.0  (Build 1.78)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost:3306    Database: ny6design
# ------------------------------------------------------
# Server version 5.6.7-rc
DROP DATABASE IF EXISTS `ny6design`;
CREATE DATABASE `ny6design` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;


USE `ny6design`;

#
# Table structure for table e_country
#

CREATE TABLE `e_country` (
  `code` varchar(8) COLLATE utf8_bin NOT NULL DEFAULT '',
  `fdescription` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#
# Dumping data for table e_country
#

INSERT INTO `e_country` VALUES ('AD','Andorra');
INSERT INTO `e_country` VALUES ('AE','United Arab Emirates');
INSERT INTO `e_country` VALUES ('AF','Afghanistan');
INSERT INTO `e_country` VALUES ('AG','Antigua and Barbuda');
INSERT INTO `e_country` VALUES ('AI','Anguilla');
INSERT INTO `e_country` VALUES ('AL','Albania');
INSERT INTO `e_country` VALUES ('AN','Netherlands Antilles');
INSERT INTO `e_country` VALUES ('AO','Angola');
INSERT INTO `e_country` VALUES ('AQ','Antarctica');
INSERT INTO `e_country` VALUES ('AR','Argentina');
INSERT INTO `e_country` VALUES ('AS','American Samoa');
INSERT INTO `e_country` VALUES ('AT','Austria');
INSERT INTO `e_country` VALUES ('AU','Australia');
INSERT INTO `e_country` VALUES ('AW','Aruba');
INSERT INTO `e_country` VALUES ('BB','Barbados');
INSERT INTO `e_country` VALUES ('BD','Bangladesh');
INSERT INTO `e_country` VALUES ('BE','Belgium');
INSERT INTO `e_country` VALUES ('BF','Burkina Faso');
INSERT INTO `e_country` VALUES ('BG','Bulgaria');
INSERT INTO `e_country` VALUES ('BH','Bahrain');
INSERT INTO `e_country` VALUES ('BI','Burundi');
INSERT INTO `e_country` VALUES ('BJ','Benin');
INSERT INTO `e_country` VALUES ('BM','Bermuda');
INSERT INTO `e_country` VALUES ('BN','Brunei Darussalam');
INSERT INTO `e_country` VALUES ('BO','Bolivia');
INSERT INTO `e_country` VALUES ('BR','Brazil');
INSERT INTO `e_country` VALUES ('BS','Bahamas');
INSERT INTO `e_country` VALUES ('BT','Bhutan');
INSERT INTO `e_country` VALUES ('BV','Bouvet Island');
INSERT INTO `e_country` VALUES ('BW','Botswana');
INSERT INTO `e_country` VALUES ('BY','Byelorussian');
INSERT INTO `e_country` VALUES ('BZ','Belize');
INSERT INTO `e_country` VALUES ('CA','Canada');
INSERT INTO `e_country` VALUES ('CC','Cocos (Keeling) Islands');
INSERT INTO `e_country` VALUES ('CF','Central African Republic');
INSERT INTO `e_country` VALUES ('CG','Congo');
INSERT INTO `e_country` VALUES ('CH','Switzerland');
INSERT INTO `e_country` VALUES ('CI','Cote D\'Ivoire');
INSERT INTO `e_country` VALUES ('CK','Cook Islands');
INSERT INTO `e_country` VALUES ('CL','Chile');
INSERT INTO `e_country` VALUES ('CM','Cameroon');
INSERT INTO `e_country` VALUES ('CN','China');
INSERT INTO `e_country` VALUES ('CO','Colombia');
INSERT INTO `e_country` VALUES ('CR','Costa Rica');
INSERT INTO `e_country` VALUES ('CS','Czechoslovakia');
INSERT INTO `e_country` VALUES ('CV','Cape Verde');
INSERT INTO `e_country` VALUES ('CX','Christmas Island');
INSERT INTO `e_country` VALUES ('CY','Cyprus');
INSERT INTO `e_country` VALUES ('DE','Germany');
INSERT INTO `e_country` VALUES ('DJ','Djibouti');
INSERT INTO `e_country` VALUES ('DK','Denmark');
INSERT INTO `e_country` VALUES ('DM','Dominica');
INSERT INTO `e_country` VALUES ('DO','Dominican Republic');
INSERT INTO `e_country` VALUES ('DZ','Algeria');
INSERT INTO `e_country` VALUES ('EC','Ecuador');
INSERT INTO `e_country` VALUES ('EG','Egypt');
INSERT INTO `e_country` VALUES ('EH','Western Sahara');
INSERT INTO `e_country` VALUES ('ES','Spain');
INSERT INTO `e_country` VALUES ('ET','Ethiopia');
INSERT INTO `e_country` VALUES ('FI','Finland');
INSERT INTO `e_country` VALUES ('FJ','FJ');
INSERT INTO `e_country` VALUES ('FK','Falkland Islands');
INSERT INTO `e_country` VALUES ('FM','Micronesia');
INSERT INTO `e_country` VALUES ('FO','Faroe Islands');
INSERT INTO `e_country` VALUES ('FR','France');
INSERT INTO `e_country` VALUES ('GA','Gabon');
INSERT INTO `e_country` VALUES ('GB','United Kingdom');
INSERT INTO `e_country` VALUES ('GD','Grenada');
INSERT INTO `e_country` VALUES ('GF','French Guiana');
INSERT INTO `e_country` VALUES ('GH','Ghana');
INSERT INTO `e_country` VALUES ('GI','Gibraltar');
INSERT INTO `e_country` VALUES ('GL','Greenland');
INSERT INTO `e_country` VALUES ('GM','Gambia');
INSERT INTO `e_country` VALUES ('GN','GN');
INSERT INTO `e_country` VALUES ('GP','Gudeloupe');
INSERT INTO `e_country` VALUES ('GQ','Equatorial Guinea');
INSERT INTO `e_country` VALUES ('GR','Greece');
INSERT INTO `e_country` VALUES ('GT','Guatemala');
INSERT INTO `e_country` VALUES ('GU','Guam');
INSERT INTO `e_country` VALUES ('GW','Guinea-Bissau');
INSERT INTO `e_country` VALUES ('GY','Guyana');
INSERT INTO `e_country` VALUES ('HK','Hong Kong');
INSERT INTO `e_country` VALUES ('HM','Heard and Mc Donald Isls');
INSERT INTO `e_country` VALUES ('HN','Honduras');
INSERT INTO `e_country` VALUES ('HT','Haiti');
INSERT INTO `e_country` VALUES ('HU','Hungary');
INSERT INTO `e_country` VALUES ('ID','Indonesia');
INSERT INTO `e_country` VALUES ('IE','Ireland');
INSERT INTO `e_country` VALUES ('IL','Israel');
INSERT INTO `e_country` VALUES ('IN','India');
INSERT INTO `e_country` VALUES ('IO','British Indian Ocean T');
INSERT INTO `e_country` VALUES ('IS','Iceland');
INSERT INTO `e_country` VALUES ('IT','Italy');
INSERT INTO `e_country` VALUES ('JM','Jamaica');
INSERT INTO `e_country` VALUES ('JO','JO');
INSERT INTO `e_country` VALUES ('JP','Japan');
INSERT INTO `e_country` VALUES ('KE','Kenya');
INSERT INTO `e_country` VALUES ('KH','Kampuchea Democratic');
INSERT INTO `e_country` VALUES ('KI','Kiribati');
INSERT INTO `e_country` VALUES ('KM','Comoros');
INSERT INTO `e_country` VALUES ('KN','Saint Kitts and Nevis');
INSERT INTO `e_country` VALUES ('KR','Korea Republic');
INSERT INTO `e_country` VALUES ('US','United States');

#
# Table structure for table e_from
#

CREATE TABLE `e_from` (
  `fromId` int(8) NOT NULL DEFAULT '0',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`fromId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='How did you hear about us';

#
# Dumping data for table e_from
#

INSERT INTO `e_from` VALUES (1,'Link from another site');
INSERT INTO `e_from` VALUES (2,'Yahoo Search engine');
INSERT INTO `e_from` VALUES (3,'Google Search Engine');
INSERT INTO `e_from` VALUES (4,'Email promotion');
INSERT INTO `e_from` VALUES (5,'Referred by friend');
INSERT INTO `e_from` VALUES (6,'Saw an Ad');
INSERT INTO `e_from` VALUES (7,'Other');

#
# Table structure for table e_states
#

CREATE TABLE `e_states` (
  `code` varchar(8) COLLATE utf8_bin NOT NULL DEFAULT '',
  `fdescription` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#
# Dumping data for table e_states
#

INSERT INTO `e_states` VALUES ('AA','Armed Forces Americas');
INSERT INTO `e_states` VALUES ('FL','Florida');
INSERT INTO `e_states` VALUES ('GA','Georgia');
INSERT INTO `e_states` VALUES ('NY','New York');
INSERT INTO `e_states` VALUES ('TX','Texas');

#
# Table structure for table t_address
#

CREATE TABLE `t_address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `countryCode` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `stateCode` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `town` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '',
  `zipcode` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `address` varchar(60) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#
# Dumping data for table t_address
#

INSERT INTO `t_address` VALUES (1,'US','AA','1','s','1');
INSERT INTO `t_address` VALUES (2,'US','AA','1','s','1');
INSERT INTO `t_address` VALUES (3,'US','TAX','town','ts','test');
INSERT INTO `t_address` VALUES (4,'US','TAX','town','ts','test');
INSERT INTO `t_address` VALUES (5,'US','AA','1','s','1');
INSERT INTO `t_address` VALUES (6,'US','AA','1','s','1');
INSERT INTO `t_address` VALUES (7,'US','AA','1','1','1');
INSERT INTO `t_address` VALUES (8,'US','AA','1','1','1');
INSERT INTO `t_address` VALUES (9,'US','AA','1','1','1');
INSERT INTO `t_address` VALUES (10,'BN','NY','1','1','1');
INSERT INTO `t_address` VALUES (11,'BF','NY','18','18','18');
INSERT INTO `t_address` VALUES (12,'BF','NY','18','18','18');
INSERT INTO `t_address` VALUES (13,'AD','NY','18','18','18');
INSERT INTO `t_address` VALUES (14,'AD','NY','18','18','18');
INSERT INTO `t_address` VALUES (15,'AD','NY','18','18','18');
INSERT INTO `t_address` VALUES (16,'AD','NY','18','18','18');
INSERT INTO `t_address` VALUES (17,'AD','NY','18','18','18');
INSERT INTO `t_address` VALUES (18,'GN','FL','1','1','1');
INSERT INTO `t_address` VALUES (19,'AD','NY','18','18','18');
INSERT INTO `t_address` VALUES (20,'KM','FL','1','1','1');
INSERT INTO `t_address` VALUES (21,'AD','FL','1','1','1');
INSERT INTO `t_address` VALUES (22,'KR','FL','2','2','2');
INSERT INTO `t_address` VALUES (23,'AD','FL','2','2','2');
INSERT INTO `t_address` VALUES (24,'US','AA','ptny6','ptny6','ptny6');
INSERT INTO `t_address` VALUES (25,'KN','FL','t1','1','t1');
INSERT INTO `t_address` VALUES (26,'KH','FL','2','2','22');
INSERT INTO `t_address` VALUES (27,'US','TX','3','3','3');

#
# Table structure for table t_category
#

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

#
# Dumping data for table t_category
#

INSERT INTO `t_category` VALUES (164,'CLEARANCE!!',1,-1,1,'2014-01-03 17:28:05');
INSERT INTO `t_category` VALUES (165,'This_Month_items',1,164,1,'2014-01-03 17:28:05');
INSERT INTO `t_category` VALUES (166,'Wholesale Beads',2,-1,1,'2014-01-03 17:50:03');
INSERT INTO `t_category` VALUES (167,'Coral Beads',1,166,1,'2014-01-03 17:28:05');
INSERT INTO `t_category` VALUES (168,'Turquoise Beads',2,166,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (169,'Pearl Beads',3,166,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (170,'Quartz Beads',4,166,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (171,'Special GemStone',5,166,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (172,'Jade Beads',6,166,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (173,'Round Beads',3,-1,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (174,'Quartz beads',1,173,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (175,'Jasper beads',2,173,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (176,'Agate / Onyx',3,173,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (177,'Turquoise / Coral',4,173,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (178,'Jade beads',5,173,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (179,'Other semi gemstone',6,173,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (180,'Gold stone beads',7,173,1,'2014-01-03 17:28:06');
INSERT INTO `t_category` VALUES (181,'Semi-Gem beads',4,-1,1,'2014-01-03 17:50:20');
INSERT INTO `t_category` VALUES (182,'Agate',1,181,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (183,'Chrysocolla',2,181,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (184,'Jasper',3,181,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (185,'Necklaces / sets',5,-1,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (186,'Coral',1,185,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (187,'Turquoise',2,185,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (188,'LampWorks',3,185,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (189,'Freshwater Pearl',4,185,1,'2014-01-03 17:28:07');
INSERT INTO `t_category` VALUES (190,'Quartz',5,185,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (191,'Set jewelry',6,185,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (192,'Shell Pearl',7,185,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (193,'Special gemstone',8,185,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (194,'BraceLets',6,-1,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (195,'Coral',1,194,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (196,'Turquoise',2,194,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (197,'Freshwater Pearl',3,194,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (198,'Quartz',4,194,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (199,'Shell pearl',5,194,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (200,'Other gemstone',6,194,1,'2014-01-03 17:28:08');
INSERT INTO `t_category` VALUES (201,'Pendants',7,-1,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (202,'.925 Silver Pendants',1,201,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (203,'Shell Pendants',2,201,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (204,'Other Pendants',3,201,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (205,'Caved Pendants',4,201,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (206,'Earring / Rings',8,-1,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (207,'Earrings_silver',1,206,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (208,'Earrings_gold',2,206,1,'2014-01-03 17:28:09');
INSERT INTO `t_category` VALUES (209,'Rings',3,206,1,'2014-01-03 17:28:10');
INSERT INTO `t_category` VALUES (210,'Lampwork Beads',9,-1,1,'2014-01-03 17:28:10');
INSERT INTO `t_category` VALUES (211,'Lampwork Beads',1,210,1,'2014-01-03 17:28:10');
INSERT INTO `t_category` VALUES (212,'Pearl Jewelry',10,-1,1,'2014-01-03 17:28:10');
INSERT INTO `t_category` VALUES (213,'Pearl Jewelry',1,212,1,'2014-01-03 17:28:10');
INSERT INTO `t_category` VALUES (214,'Findings: (Silver /14K /Pewter)',11,-1,1,'2014-01-03 17:28:10');
INSERT INTO `t_category` VALUES (215,'-925 Sterling Silver',1,214,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (216,'-14K Gold Filled',2,214,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (217,'-Pewter (LEAD FREE)',3,214,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (218,'Beading supply etc.',12,-1,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (219,'beading wire',1,218,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (220,'Trendy_Handbag',13,-1,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (221,'Trendy_Handbag',1,220,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (222,'Others',14,-1,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (223,'Jewelry Class',1,222,1,'2014-01-03 17:28:11');
INSERT INTO `t_category` VALUES (224,'Others gemstone',2,222,1,'2014-01-03 17:28:11');

#
# Table structure for table t_message
#

CREATE TABLE `t_message` (
  `fmessageId` int(11) NOT NULL AUTO_INCREMENT,
  `fuserId` int(11) NOT NULL,
  `fdescription` varchar(1000) NOT NULL,
  `fupdatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`fmessageId`),
  UNIQUE KEY `message_id_UNIQUE` (`fmessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_message
#

INSERT INTO `t_message` VALUES (1,1,'The \"CUSTOM MAKE JEWELRY ORDER\" was great! \"MAKE IN U.S.A.\" Finished Jewelry Order with small quantity and COMPARATIVE PRICE are what you looking for!','2014-01-18 12:34:44');
INSERT INTO `t_message` VALUES (2,1,'These bead strands are so perfect &amp; the quality is above all other suppliers!!! Can\'t wait to make them into some beautiful jewelry!!!','2014-01-18 12:34:44');
INSERT INTO `t_message` VALUES (3,1,'How amzing your stones are!! I love every bead that I have gotten &amp; the quality is unsurpassed!!! wow!!','2014-01-18 12:34:44');
INSERT INTO `t_message` VALUES (4,1,'I received my order quickly. It was well packed and I found all of my order packed and precious. Couldn\'t wait to get my hands on them. Great job NY6 Designs.','2014-01-18 12:34:44');
INSERT INTO `t_message` VALUES (5,1,'The necklace was beautiful!Item as described and received promptly, thank you for working hard!!!','2014-01-18 12:34:44');
INSERT INTO `t_message` VALUES (6,1,'I LOVE this website!!! Great quality!! I just wish they had more sets because I want to match everything!!I WILL shop again and again!!!','2014-01-18 12:34:44');
INSERT INTO `t_message` VALUES (7,1,'I recently became interested in making jewelry using beads so I visited retail stores in my area and was shocked to see how much beads cost. I went to the Ebay website with great reluctance to try to find beads at a reasonable price. After receiving my first shipment fromNY6 Design, I realized that your beads were of a higher quality than the ones in the stores and your prices are great! I have been telling my friends who are interested in making jewelry from beads that they should check out yourwebsite before paying hugh prices in retail stores. Quality, value and great customer service are the three most important things I look for when spending money. NY6 has all three of these and you are #1 on my list of suppliers!!!','2014-01-18 12:34:44');
INSERT INTO `t_message` VALUES (8,1,'Thank you for your wonderful service. My order was delivered very quickly and with the extra care taken in packing everything arrived in perfect condition.','2014-01-18 12:34:45');
INSERT INTO `t_message` VALUES (9,1,'LOVEEEE THE BEADS, I LEFT A SUPER MARVELOUS FEEDBACK BECAUSE YOU GUYS DESERVED. I WILL KEEP SHOPPING WITH YOU GUYS. THANKS YOU SO MUCH FOR THE FAST SERVICE, THE EXCELLENT WELL PACKEDAND TGHE CARE YOU PUT WHEN WRAPING AND SHIPPING THIS FOR ME. IT MAKE ME TRUST AND FEEL TRANQUIL WHEN BUYING WITH YOU.... CONGRATULATIONS AND KEEP IT UP GUYS. I SAVED YOU IN MY FAVORITE SELLER LIST AND WILL SEE YOU SOON IN THE SHOW ROOM;O) KIND REGARDS, CLAUDIA H','2014-01-18 12:34:45');
INSERT INTO `t_message` VALUES (10,1,'Quality of beads is excellent and choices are immense! Order enough items and shipping is free and cost of items reduces nicely. Will come back for more; highly recommend this seller!','2014-01-18 12:34:45');



#
# Table structure for table t_user
#

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
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#
# Dumping data for table t_user
#

INSERT INTO `t_user` VALUES (1,'ptny6','cdac894bb6a4cb80e846bc3a025fd262349b839c',Char(0x25,0x26,0x56,0x15,0x86,0xA0,0xCE,0xCD),'ptny6','ptny6',24,'123456','123456',1,1,'0',1,'2014-01-26 14:06:48');
INSERT INTO `t_user` VALUES (2,'t1@test.com','925c62e35dd303f719e9ce382e8a35f86e2d1e53',Char(0xC4,0x25,0xED,0xA9,0x3F,0xD0,0xEE,0x04),'t1','t1',25,'1','1',1,1,'0',0,'2014-01-26 14:03:27');
INSERT INTO `t_user` VALUES (3,'t2@test.com','1f1fb6431a2de8bb6dcf43c8b4878ee0dae3e4fa',Char(0x7E,0xE8,0xB3,0x3E,0x87,0x02,0x9F,0x5B),'2','2',26,'2','2',2,5,'0',0,'2014-01-26 14:04:45');
INSERT INTO `t_user` VALUES (4,'t3@test.com','22e6673fd5335b1a580e8cb0cfa01396c2dc8118',Char(0x66,0xB3,0xE6,0x1E,0xB9,0xE3,0x48,0x2D),'3','3',27,'3','3',3,6,'0',0,'2014-01-26 14:05:12');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
