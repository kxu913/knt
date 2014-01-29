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
  `isAdmin` tinyint(3) NOT NULL DEFAULT '0',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;