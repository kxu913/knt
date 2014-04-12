CREATE TABLE `ny6design`.`e_ship_method` (
  `id` INT NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `cost` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `ny6design`.`e_ship_method` (`id`, `description`, `cost`) VALUES ('1', 'Default Postal mail:', '4.95');
INSERT INTO `ny6design`.`e_ship_method` (`id`, `description`, `cost`) VALUES ('2', 'USA Postal mail:', '5.95');
INSERT INTO `ny6design`.`e_ship_method` (`id`, `description`, `cost`) VALUES ('3', 'International Postal:', '6.95');
ALTER TABLE `ny6design`.`e_ship_method` 
ADD COLUMN `fdefault` SMALLINT NULL AFTER `cost`;

UPDATE `ny6design`.`e_ship_method` SET `fdefault`='1' WHERE `id`='1';
UPDATE `ny6design`.`e_ship_method` SET `fdefault`='0' WHERE `id`='2';
UPDATE `ny6design`.`e_ship_method` SET `fdefault`='0' WHERE `id`='3';

ALTER TABLE `ny6design`.`e_ship_method` 
CHANGE COLUMN `fdefault` `fdefault` SMALLINT(1) NULL DEFAULT NULL ,
ADD COLUMN `forder` SMALLINT(1) NULL AFTER `fdefault`;

UPDATE `ny6design`.`e_ship_method` SET `forder`='0' WHERE `id`='1';
UPDATE `ny6design`.`e_ship_method` SET `forder`='1' WHERE `id`='2';
UPDATE `ny6design`.`e_ship_method` SET `forder`='1' WHERE `id`='3';

CREATE TABLE `ny6design`.`e_ship_method` (
  `id` INT NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `cost` DOUBLE NOT NULL,
  `fdefault` INT(1) NOT NULL,
  `forder` INT(1) NOT NULL,
  PRIMARY KEY (`id`));

