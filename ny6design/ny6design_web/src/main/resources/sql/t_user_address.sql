USE `ny6design`;

#
# Table structure for table t_user_address
#

DROP TABLE IF EXISTS `t_user_address`;
CREATE TABLE `t_user_address` (
  `id` INT NOT NULL,
  `userId` INT NOT NULL,
  `addressId` INT NULL COMMENT 'mapping of user and address',
  PRIMARY KEY (`id`))
ENGINE = InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;