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
# Table structure for table t_order
#

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL DEFAULT '0',
  `amount` int(11) DEFAULT NULL,
  `cost` decimal(10,2) NOT NULL DEFAULT '0.00',
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '0: add, -1: cancel, 1: payed',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastUpdateTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='shopping cart';

#
# Dumping data for table t_order
#


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
