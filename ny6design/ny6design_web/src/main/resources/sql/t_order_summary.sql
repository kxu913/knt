CREATE TABLE `ny6design`.`t_order_summary` (
  `id` INT NOT NULL,
  `shipmethodId` INT(11) NOT NULL,
  `paymethodId` INT(11) NOT NULL,
  `discountId` INT(11) NOT NULL,
  `subtotal` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `notice` VARCHAR(500) NULL,
  `userId` INT(11) NOT NULL,
  `status` INT(1) NOT NULL,
  `createTime` DATETIME NOT NULL,
  `lastupdateTime` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'used to store order total information';

ALTER TABLE `ny6design`.`t_order_summary` 
ADD COLUMN `orderNumber` VARCHAR(30) NOT NULL AFTER `id`;

ALTER TABLE `ny6design`.`t_order_summary` 
ADD COLUMN `addressId` INT(11) NOT NULL AFTER `orderNumber`;