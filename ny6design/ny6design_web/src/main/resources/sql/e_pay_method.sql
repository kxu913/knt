CREATE TABLE `ny6design`.`e_pay_method` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `active` INT(1) NULL,
  PRIMARY KEY (`id`));
INSERT INTO `ny6design`.`e_pay_method` (`id`, `description`, `active`) VALUES ('1', 'Paypal', '1');
INSERT INTO `ny6design`.`e_pay_method` (`id`, `description`, `active`) VALUES ('2', 'Credit Card', '1');
INSERT INTO `ny6design`.`e_pay_method` (`id`, `description`, `active`) VALUES ('3', 'Check', '1');
INSERT INTO `ny6design`.`e_pay_method` (`id`, `description`, `active`) VALUES ('4', 'Email your orders', '1');
