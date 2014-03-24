
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

INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (49,'test','ddd','shenzhen',432,3,'static/img/p1.jpg',1,1,21.0000,1,'2014-01-27',32.00,0,1.00,1.00,1.00,12,0,'2014-01-27 04:00:34','2014-01-27 04:00:34',12,1,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (50,'test','not more','shenzhen',25,3,'static/img/p2.jpg',1,1,21.0000,1,'2014-01-27',32.00,0,1.00,1.00,1.00,12,0,'2014-01-27 04:09:27','2014-01-27 04:09:27',12,1,1,1,0.0000,0);
INSERT INTO `t_product` (`product_id`,`model`,`sku`,`location`,`quantity`,`stock_status_id`,`image`,`manufacturer_id`,`shipping`,`price`,`tax_class_id`,`date_available`,`weight`,`weight_class_id`,`length`,`width`,`height`,`length_class_id`,`status`,`date_added`,`date_modified`,`viewed`,`sort_order`,`subtract`,`minimum`,`cost`,`as_index`) VALUES (51,'test','only one','shenzhen',28,3,'static/img/p3.jpg',1,1,21.0000,1,'2014-01-27',32.00,0,1.00,1.00,1.00,12,0,'2014-01-27 04:30:30','2014-01-27 04:30:30',12,1,1,1,0.0000,0);