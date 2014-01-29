use ny6design;

DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `product_id` int(11) NOT NULL auto_increment,
  `model` varchar(64) collate utf8_bin NOT NULL,
  `sku` varchar(64) collate utf8_bin NOT NULL,
  `location` varchar(128) collate utf8_bin NOT NULL,
  `quantity` int(4) NOT NULL default '0',
  `stock_status_id` int(11) NOT NULL,
  `image` varchar(255) collate utf8_bin default NULL,
  `manufacturer_id` int(11) NOT NULL,
  `shipping` int(1) NOT NULL default '1',
  `price` decimal(15,4) NOT NULL default '0.0000',
  `tax_class_id` int(11) NOT NULL,
  `date_available` date NOT NULL,
  `weight` decimal(5,2) NOT NULL default '0.00',
  `weight_class_id` int(11) NOT NULL default '0',
  `length` decimal(5,2) NOT NULL default '0.00',
  `width` decimal(5,2) NOT NULL default '0.00',
  `height` decimal(5,2) NOT NULL default '0.00',
  `length_class_id` int(11) NOT NULL default '0',
  `status` int(1) NOT NULL default '0',
  `date_added` datetime NOT NULL default '0000-00-00 00:00:00',
  `date_modified` datetime NOT NULL default '0000-00-00 00:00:00',
  `viewed` int(5) NOT NULL default '0',
  `sort_order` int(11) NOT NULL default '0',
  `subtract` int(1) NOT NULL default '1',
  `minimum` int(11) NOT NULL default '1',
  `cost` decimal(15,4) NOT NULL default '0.0000',
  PRIMARY KEY  (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`) VALUES (49,'test','ddd','shenzhen',432,3,'static/img/p1.jpg',1,1,21.0000,1,'2014-01-27',32.00,0,1.00,1.00,1.00,12,0,'2014-01-27 04:00:34','2014-01-27 04:00:34',12,1,1,1,0.0000);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`) VALUES (50,'test','not more','shenzhen',25,3,'static/img/p2.jpg',1,1,21.0000,1,'2014-01-27',32.00,0,1.00,1.00,1.00,12,0,'2014-01-27 04:09:27','2014-01-27 04:09:27',12,1,1,1,0.0000);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`) VALUES (51,'test','only one','shenzhen',28,3,'static/img/p3.jpg',1,1,21.0000,1,'2014-01-27',32.00,0,1.00,1.00,1.00,12,0,'2014-01-27 04:30:30','2014-01-27 04:30:30',12,1,1,1,0.0000);

DROP TABLE IF EXISTS `t_product_price`;
CREATE TABLE `t_product_price` (
  `product_discount_id` int(11) NOT NULL auto_increment,
  `product_id` int(11) NOT NULL,
  `customer_group_id` int(11) NOT NULL,
  `quantity` int(4) NOT NULL default '0',
  `priority` int(5) NOT NULL default '1',
  `price` decimal(15,4) NOT NULL default '0.0000',
  `date_start` date NOT NULL default '0000-00-00',
  `date_end` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`product_discount_id`),
  KEY `product_id` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('1', '49', '1', '1', '1', '3.99');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('2', '49', '1', '5', '2', '3.39');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('3', '49', '1', '20', '3', '2.80');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('4', '51', '1', '1', '1', '4.49');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('5', '51', '1', '5', '2', '3.99');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('6', '51', '1', '20', '3', '3.19');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('7', '50', '1', '1', '1', '1.99');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('8', '50', '1', '5', '2', '1.69');
INSERT INTO `ny6design`.`t_product_price` (`product_discount_id`, `product_id`, `customer_group_id`, `quantity`, `priority`, `price`) VALUES ('9', '50', '1', '20', '3', '1.39');



DROP TABLE IF EXISTS `t_product_description`;
CREATE TABLE `t_product_description` (
  `product_id` int(11) NOT NULL auto_increment,
  `language_id` int(11) NOT NULL,
  `name` varchar(255) collate utf8_bin NOT NULL,
  `meta_keywords` varchar(255) collate utf8_bin NOT NULL,
  `meta_description` varchar(255) collate utf8_bin NOT NULL,
  `description` text collate utf8_bin NOT NULL,
  PRIMARY KEY  (`product_id`,`language_id`),
  KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `t_product_description` (`product_id`,`language_id`,`name`,`meta_keywords`,`meta_description`,`description`) VALUES (49,1,'N3_1016_39 Yellow Natural Agate & Drusy druzy agate Butterfly Pendant Stretch Bracelet','Drusy druzy a','Drusy druzy a','Drusy druzy a');
INSERT INTO `t_product_description` (`product_id`,`language_id`,`name`,`meta_keywords`,`meta_description`,`description`) VALUES (51,1,'(CR669)a 14x9mm Purple Crystal Faceted Teardrop Beads 11.5\" a','Crystal Faceted','Crystal Faceted','Crystal Faceted');
INSERT INTO `t_product_description` (`product_id`,`language_id`,`name`,`meta_keywords`,`meta_description`,`description`) VALUES (50,1,'M4 30x28mm Lampwork Handmade Heart Pendant Bead a','Lampwork Handmade ','Lampwork Handmade ','Lampwork Handmade ');


DROP TABLE IF EXISTS `t_product_image`;
CREATE TABLE `t_product_image` (
  `product_image_id` int(11) NOT NULL auto_increment,
  `product_id` int(11) NOT NULL,
  `image` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`product_image_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1338 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `ny6design`.`t_product_image` (`product_image_id`, `product_id`, `image`) VALUES ('1', '49', 'static/img/p1.jpg');
INSERT INTO `ny6design`.`t_product_image` (`product_image_id`, `product_id`, `image`) VALUES ('2', '49', 'static/img/p2.jpg');
INSERT INTO `ny6design`.`t_product_image` (`product_image_id`, `product_id`, `image`) VALUES ('3', '49', 'static/img/p3.jpg');




DROP TABLE IF EXISTS `t_product_to_category`;
CREATE TABLE `t_product_to_category` (
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY  (`product_id`,`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `ny6design`.`t_product_to_category` (`product_id`, `category_id`) VALUES ('49', '184');
INSERT INTO `ny6design`.`t_product_to_category` (`product_id`, `category_id`) VALUES ('50', '184');
INSERT INTO `ny6design`.`t_product_to_category` (`product_id`, `category_id`) VALUES ('50', '184');


DROP TABLE IF EXISTS `t_stock_status`;
CREATE TABLE `t_stock_status` (
  `stock_status_id` int(11) NOT NULL auto_increment,
  `language_id` int(11) NOT NULL,
  `name` varchar(32) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`stock_status_id`,`language_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `ny6design`.`t_stock_status` (`stock_status_id`, `language_id`, `name`) VALUES ('1', '1', 'In Stock');
INSERT INTO `ny6design`.`t_stock_status` (`stock_status_id`, `language_id`, `name`) VALUES ('2', '1', 'Out Of Stock');
INSERT INTO `ny6design`.`t_stock_status` (`stock_status_id`, `language_id`, `name`) VALUES ('3', '1', '2 - 3 Days');
INSERT INTO `ny6design`.`t_stock_status` (`stock_status_id`, `language_id`, `name`) VALUES ('4', '1', 'Pre-Order');







