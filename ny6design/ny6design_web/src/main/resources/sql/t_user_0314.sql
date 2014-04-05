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
  `isPublicTel` tinyint(3) NOT NULL DEFAULT '1',
  `isPublicEmail` tinyint(3) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `t_user` VALUES (1,'ptny6','cdac894bb6a4cb80e846bc3a025fd262349b839c','%&VÂïùÁìÆ','ptny6','ptny6',24,'123456','123456',1.000,1,'0',1,'2014-01-26 06:06:48',1,1),(2,'t1@test.com','925c62e35dd303f719e9ce382e8a35f86e2d1e53','?ÊÑ?Ëì?','t1','t1',25,'1','1',1.000,1,'0',0,'2014-01-26 06:03:27',1,1),(3,'t2@test.com','1f1fb6431a2de8bb6dcf43c8b4878ee0dae3e4fa','~Áí??ÁÑ?,'2','2',26,'2','2',2.000,5,'0',0,'2014-01-26 06:04:45',1,1),(4,'t3@test.com','22e6673fd5335b1a580e8cb0cfa01396c2dc8118','fËô?ÂπøH-','3','3',27,'3','3',3.000,6,'0',0,'2014-01-26 06:05:12',1,1),(7,'kevin.xu@morningstar.com','eba700bc12dc23fa8003ae01bfb7176146620eec','Âñ™m?8Á¨?,'k1','k1',31,'12345678','123',12.000,6,'0',0,'2014-03-14 08:21:42',1,1),(8,'k2@test.com','d12dbb10a5ad724308319e1ee4aafeb784bd0ea6','ËØÉÈ£ªÈÅ≥ÈÄ?,'k2','k2',32,'111','111',111.000,1,'0',0,'2014-02-16 09:15:10',1,1),(9,'x1@test.com','7fc18f70f8e5a3620e1870618ab1afc4d1a475f0','ÁßúÁìá?','x1','x1',35,'777777','7',7.000,6,'0',0,'2014-02-28 08:42:48',1,1);

