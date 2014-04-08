USE `ny6design`;
DROP TABLE IF EXISTS `t_wishlist`;
CREATE TABLE `t_wishlist` (
  `product_id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY  (`product_id`,`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;