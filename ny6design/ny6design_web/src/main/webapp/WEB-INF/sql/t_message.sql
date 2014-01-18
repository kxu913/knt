use ny6design;
DROP TABLE IF EXISTS `t_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_message` (
  `fmessageId` int(11) NOT NULL AUTO_INCREMENT,
  `fuserId` int(11)  NOT NULL,
  `fdescription` varchar(1000) NOT NULL,
  `fupdatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`fmessageId`),
  UNIQUE KEY `message_id_UNIQUE` (`fmessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

