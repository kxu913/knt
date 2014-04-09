USE `ny6design`;
DROP TABLE IF EXISTS `t_shopping_rule`;
CREATE TABLE `ny6design`.`t_shopping_rule` (
  `id` INT NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `html` VARCHAR(40) NOT NULL COMMENT 'which page used to display',
  `active` INT(1) NOT NULL COMMENT 'need to be display',
  `forder` INT(1) NOT NULL COMMENT 'used to determine display order',
  PRIMARY KEY (`id`))
COMMENT = 'used to describe shopping rule, such as free shipping, amout rules';

INSERT INTO `ny6design`.`t_shopping_rule` (`id`, `description`, `html`, `active`, `forder`) VALUES ('1', '<strong>*Free Shipping!</strong>  On order over $50 for U.S. $75 for Canada (Regular Postal mail) .   $250 for International orders (up to $25 shipping discount credit for Regular Air mail).   <strong>Please add item to save on shipping!</strong>', 'checkout', '1', '1');
INSERT INTO `ny6design`.`t_shopping_rule` (`id`, `description`, `html`, `active`, `forder`) VALUES ('2', '<strong>Domestic Express Mail pls Call 214-244-5851!</strong><br/>', 'checkout', '1', '2');
UPDATE `ny6design`.`t_shopping_rule` SET `html`='shoppingcart/checkout' WHERE `id`='1';
UPDATE `ny6design`.`t_shopping_rule` SET `html`='shoppingcart/checkout' WHERE `id`='2';
UPDATE `ny6design`.`t_shopping_rule` SET `description`='<strong>Domestic Express Mail pls Call 214-244-5851!</strong><br/>Otherwise: USA & Canadian buyer will pay S/H $4.95 for first items and $1.95 for each additional items. INTERNATIONAL buyer will pay $7.95 for first items and $2.95 for each additional items.' WHERE `id`='2';


