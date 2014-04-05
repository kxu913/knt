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
# Table structure for table t_cart_order
#

DROP TABLE IF EXISTS `t_cart_order`;
CREATE TABLE `t_cart_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cartId` int(11) NOT NULL DEFAULT '0',
  `orderId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='used to store mapping of cart and order';

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
