USE `ny6design`;

#
# Table structure for table t_question
#

DROP TABLE IF EXISTS `t_question`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='question table';

