# MySQL-Front 5.0  (Build 1.78)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost:3307    Database: ny6design
# ------------------------------------------------------
# Server version 5.6.7-rc

USE `ny6design`;

#
# Table structure for table t_user
#

DROP TABLE IF EXISTS `t_user`;
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
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
