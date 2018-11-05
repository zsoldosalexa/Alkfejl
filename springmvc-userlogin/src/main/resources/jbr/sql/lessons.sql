CREATE DATABASE IF NOT EXISTS myusers;
USE myusers;

DROP TABLE IF EXISTS `myusers`.`lessons`;
CREATE TABLE `myusers`.`lessons` (
  `name` VARCHAR(45) NOT NULL,
  `trainer` VARCHAR(45) NULL,
  `begin` VARCHAR(45) NOT NULL,
  `end` VARCHAR(45) NOT NULL,
  );