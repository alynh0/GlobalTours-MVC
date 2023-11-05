-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema globaltoursdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema globaltoursdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `globaltoursdb` DEFAULT CHARACTER SET utf8mb3 ;
USE `globaltoursdb` ;

-- -----------------------------------------------------
-- Table `globaltoursdb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globaltoursdb`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome_cliente` VARCHAR(255) NOT NULL,
  `telefone_cliente` VARCHAR(11) NOT NULL,
  `email_cliente` VARCHAR(100) NOT NULL,
  `dataNascimento` DATETIME NOT NULL,
  `senha_cliente` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `globaltoursdb`.`promoção`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globaltoursdb`.`promoção` (
  `id_promo` INT NOT NULL AUTO_INCREMENT,
  `descricao_promo` VARCHAR(255) NOT NULL,
  `inicio_promo` VARCHAR(45) NOT NULL,
  `fim_promo` VARCHAR(45) NOT NULL,
  `desconto_promo` FLOAT NOT NULL,
  PRIMARY KEY (`id_promo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `globaltoursdb`.`viagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globaltoursdb`.`viagem` (
  `id_viagem` INT NOT NULL AUTO_INCREMENT,
  `destino_viagem` VARCHAR(45) NOT NULL,
  `inicio_viagem` VARCHAR(45) NOT NULL,
  `fim_viagem` VARCHAR(45) NOT NULL,
  `preco_viagem` FLOAT NULL DEFAULT NULL,
  `Promoção_id_promo` INT NOT NULL,
  PRIMARY KEY (`id_viagem`, `Promoção_id_promo`),
  INDEX `fk_Viagem_Promoção_idx` (`Promoção_id_promo` ASC) VISIBLE,
  CONSTRAINT `fk_Viagem_Promoção`
    FOREIGN KEY (`Promoção_id_promo`)
    REFERENCES `globaltoursdb`.`promoção` (`id_promo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `globaltoursdb`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globaltoursdb`.`reserva` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `data_reserva` VARCHAR(45) NOT NULL,
  `qtd_passageiros` INT NOT NULL,
  `Viagem_id_viagem` INT NOT NULL,
  `Viagem_Promoção_id_promo` INT NOT NULL,
  `Cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_reserva`, `Viagem_id_viagem`, `Viagem_Promoção_id_promo`),
  INDEX `fk_Reserva_Viagem1_idx` (`Viagem_id_viagem` ASC, `Viagem_Promoção_id_promo` ASC) VISIBLE,
  INDEX `fk_Reserva_Cliente1_idx` (`Cliente_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_Reserva_Cliente1`
    FOREIGN KEY (`Cliente_id_cliente`)
    REFERENCES `globaltoursdb`.`cliente` (`id_cliente`),
  CONSTRAINT `fk_Reserva_Viagem1`
    FOREIGN KEY (`Viagem_id_viagem` , `Viagem_Promoção_id_promo`)
    REFERENCES `globaltoursdb`.`viagem` (`id_viagem` , `Promoção_id_promo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
