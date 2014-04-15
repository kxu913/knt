CREATE TABLE `ny6design`.`t_order_mapping` (
  `id` INT NOT NULL,
  `ordersummaryId` INT(11) NULL,
  `orderId` INT(11) NULL,
  PRIMARY KEY (`id`))
COMMENT = 'used to store mapping of summary and order';
ALTER TABLE `ny6design`.`t_order_mapping` 
CHANGE COLUMN `ordersummaryId` `ordersummaryId` INT(11) NOT NULL ,
CHANGE COLUMN `orderId` `orderId` INT(11) NOT NULL ;

