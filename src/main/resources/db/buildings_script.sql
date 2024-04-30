-- MySQL Script generated by MySQL Workbench
-- Fri Apr 26 19:11:51 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema genericshop
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `genericshop` ;

-- -----------------------------------------------------
-- Schema genericshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `genericshop` DEFAULT CHARACTER SET utf8 ;
USE `genericshop` ;

-- -----------------------------------------------------
-- Table `genericshop`.`addresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genericshop`.`addresses` ;

CREATE TABLE IF NOT EXISTS `genericshop`.`addresses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `streen_num` DOUBLE UNSIGNED ZEROFILL NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genericshop`.`buildings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genericshop`.`buildings` ;

CREATE TABLE IF NOT EXISTS `genericshop`.`buildings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` DOUBLE UNSIGNED ZEROFILL NULL,
  `square` DOUBLE UNSIGNED ZEROFILL NULL,
  `addresses_id` INT NOT NULL,
  PRIMARY KEY (`id`, `addresses_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_buildings_addresses_idx` (`addresses_id` ASC) VISIBLE,
  CONSTRAINT `fk_buildings_addresses`
    FOREIGN KEY (`addresses_id`)
    REFERENCES `genericshop`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
