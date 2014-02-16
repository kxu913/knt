USE `ny6design`;

#
# Table structure for table t_address
#

DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `countryCode` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `stateCode` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `town` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '',
  `zipcode` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `address` varchar(60) COLLATE utf8_bin NOT NULL DEFAULT '',
  `fdefault` smallint(6) NOT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;