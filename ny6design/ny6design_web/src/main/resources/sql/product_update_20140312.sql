
CREATE TABLE `t_product` (
  `product_id` int(11) NOT NULL auto_increment,
  `model` varchar(64) collate utf8_bin default NULL,
  `sku` varchar(64) collate utf8_bin default NULL,
  `location` varchar(128) collate utf8_bin default NULL,
  `quantity` int(4) default '0',
  `stock_status_id` int(11) default NULL,
  `image` varchar(255) collate utf8_bin default NULL,
  `manufacturer_id` int(11) default NULL,
  `shipping` int(1) default '1',
  `price` decimal(15,4) default '0.0000',
  `tax_class_id` int(11) default NULL,
  `date_available` date default NULL,
  `weight` decimal(5,2) default '0.00',
  `weight_class_id` int(11) default '0',
  `length` decimal(5,2) default '0.00',
  `width` decimal(5,2) default '0.00',
  `height` decimal(5,2) default '0.00',
  `length_class_id` int(11) default '0',
  `status` int(1) default '0',
  `date_added` datetime default '0000-00-00 00:00:00',
  `date_modified` datetime default '0000-00-00 00:00:00',
  `viewed` int(5) default '0',
  `sort_order` int(11) default '0',
  `subtract` int(1) default '1',
  `minimum` int(11) default '1',
  `cost` decimal(15,4) default '0.0000',
  `as_index` int(1) default '0',
  PRIMARY KEY  (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*
-- Query: SELECT * FROM ny6design.t_product
LIMIT 0, 1000

-- Date: 2014-03-24 22:30
*/
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (49,'test','1','USA',432,1,'static/img/p1.jpg',1,1,45.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,0,'2014-03-23 23:09:49','2014-03-23 23:09:49',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (50,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,0,'2014-03-23 23:33:22','2014-03-23 23:33:22',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (103,'test22','1','USA',438,1,'static/img/p1.jpg',1,1,41.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:37:41','2014-03-24 00:37:41',0,0,1,1,0.0000,1);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (102,'abc','1','USA',30,1,'static/img/p3.jpg',1,1,25.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,0,'2014-03-23 23:44:00','2014-03-23 23:44:00',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (100,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,0,'2014-03-24 00:20:41','2014-03-24 00:20:41',0,0,1,1,0.0000,1);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (101,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,0,'2014-03-24 00:21:32','2014-03-24 00:21:32',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (104,'test','1','USA',432,1,'static/img/p1.jpg',1,1,45.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,1,'2014-03-23 12:24:07','2014-03-23 12:24:07',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (105,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:21:26','2014-03-24 00:21:26',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (106,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:21:06','2014-03-24 00:21:06',0,0,1,1,0.0000,1);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (51,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,0,'2014-03-24 00:19:03','2014-03-24 00:19:03',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (107,'abc','1','USA',30,1,'static/img/p3.jpg',1,1,25.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,1,'2014-03-23 12:24:07','2014-03-23 12:24:07',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (109,'testbb','1','USA',25,1,'static/img/p2.jpg',1,1,36.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:21:06','2014-03-24 00:21:06',0,0,1,1,0.0000,1);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (110,'tedsaflj','1','USA',28,1,'static/img/p3.jpg',1,1,21.0000,1,'2014-03-24',0.00,0,0.00,0.00,0.00,0,1,'2014-03-24 00:37:41','2014-03-24 00:37:41',0,0,1,1,0.0000,1);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (111,'test22','1','USA',438,1,'static/img/p1.jpg',1,1,41.0000,1,'2014-03-23',0.00,0,0.00,0.00,0.00,0,1,'2014-03-23 12:24:07','2014-03-23 12:24:07',0,0,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (112,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:03:26','2014-03-23 20:03:26',12,1,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (113,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:07:12','2014-03-23 20:07:12',12,1,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (114,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:10:39','2014-03-23 20:10:39',12,1,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (115,'iphone','aaa','shenzhen',432,3,'data/iphone3.jpg',1,1,21.0000,1,'2014-03-23',32.00,0,1.00,1.00,1.00,12,0,'2014-03-23 20:12:36','2014-03-23 20:12:36',12,1,1,1,0.0000,0);
