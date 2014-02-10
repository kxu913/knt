
USE `ny6design`;

#
# Table structure for table t_message
#

DROP TABLE IF EXISTS `t_message`;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_message
#

INSERT INTO `t_message` VALUES (1,'test','test',1,'The \"CUSTOM MAKE JEWELRY ORDER\" was great! \"MAKE IN U.S.A.\" Finished Jewelry Order with small quantity and COMPARATIVE PRICE are what you looking for!','2014-01-18 12:34:44','123456','test',NULL,0);
INSERT INTO `t_message` VALUES (2,'t1','t1',1,'These bead strands are so perfect &amp; the quality is above all other suppliers!!! Can\'t wait to make them into some beautiful jewelry!!!','2014-01-18 12:34:44','1','t1',NULL,0);
INSERT INTO `t_message` VALUES (3,'t2','t2',1,'How amzing your stones are!! I love every bead that I have gotten &amp; the quality is unsurpassed!!! wow!!','2014-01-18 12:34:44','2','t2',NULL,0);
INSERT INTO `t_message` VALUES (4,'t3','t3',1,'I received my order quickly. It was well packed and I found all of my order packed and precious. Couldn\'t wait to get my hands on them. Great job NY6 Designs.','2014-01-18 12:34:44','3','t3',NULL,0);
INSERT INTO `t_message` VALUES (5,'t4','t4',1,'The necklace was beautiful!Item as described and received promptly, thank you for working hard!!!','2014-01-18 12:34:44','4','t4',NULL,0);
INSERT INTO `t_message` VALUES (6,'t5','t5',1,'I LOVE this website!!! Great quality!! I just wish they had more sets because I want to match everything!!I WILL shop again and again!!!','2014-01-18 12:34:44','5','t5',NULL,0);
INSERT INTO `t_message` VALUES (7,'t6','t6',1,'I recently became interested in making jewelry using beads so I visited retail stores in my area and was shocked to see how much beads cost. I went to the Ebay website with great reluctance to try to find beads at a reasonable price. After receiving my first shipment fromNY6 Design, I realized that your beads were of a higher quality than the ones in the stores and your prices are great! I have been telling my friends who are interested in making jewelry from beads that they should check out yourwebsite before paying hugh prices in retail stores. Quality, value and great customer service are the three most important things I look for when spending money. NY6 has all three of these and you are #1 on my list of suppliers!!!','2014-01-18 12:34:44','6','t6',NULL,0);
INSERT INTO `t_message` VALUES (8,'t7','t7',1,'Thank you for your wonderful service. My order was delivered very quickly and with the extra care taken in packing everything arrived in perfect condition.','2014-01-18 12:34:45','7','t7',NULL,0);
INSERT INTO `t_message` VALUES (9,'t8','t8',1,'LOVEEEE THE BEADS, I LEFT A SUPER MARVELOUS FEEDBACK BECAUSE YOU GUYS DESERVED. I WILL KEEP SHOPPING WITH YOU GUYS. THANKS YOU SO MUCH FOR THE FAST SERVICE, THE EXCELLENT WELL PACKEDAND TGHE CARE YOU PUT WHEN WRAPING AND SHIPPING THIS FOR ME. IT MAKE ME TRUST AND FEEL TRANQUIL WHEN BUYING WITH YOU.... CONGRATULATIONS AND KEEP IT UP GUYS. I SAVED YOU IN MY FAVORITE SELLER LIST AND WILL SEE YOU SOON IN THE SHOW ROOM;O) KIND REGARDS, CLAUDIA H','2014-01-18 12:34:45','8','t8',NULL,0);
INSERT INTO `t_message` VALUES (10,'t9','t9',1,'Quality of beads is excellent and choices are immense! Order enough items and shipping is free and cost of items reduces nicely. Will come back for more; highly recommend this seller!','2014-01-18 12:34:45','9','t9',NULL,0);

