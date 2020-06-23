-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_pas
-- -----------------------------------------------------

-- LIMPAR TUDO --
DROP TABLE IF EXISTS `subscription`;
DROP TABLE IF EXISTS `image`;
DROP TABLE IF EXISTS `news`;
DROP TABLE IF EXISTS `category`;

-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(5000) NOT NULL,
  `title` VARCHAR(500) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_news_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_news_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `source` VARCHAR(255) NOT NULL,
  `news_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_image_news_idx` (`news_id` ASC),
  CONSTRAINT `image_fk_news_id`
    FOREIGN KEY (`news_id`)
    REFERENCES `news` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `subscription` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(255) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_subscription_category1_idx` (`category_id` ASC),
  CONSTRAINT `subscription_fk_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- INSERIR DADOS

--		 CATEGORY		*/ -- (id, "name")
INSERT INTO category VALUES (1, "cat_x_1");
INSERT INTO category VALUES (2, "cat_y_2");

--		   NEWS			*/ -- (id, "text", "title", "category_id")
INSERT INTO news VALUES (1, "texto_1", "titulo_1", 1);
INSERT INTO news VALUES (2, "texto_2", "titulo_1", 1);
INSERT INTO news VALUES (3, "texto_3", "titulo_1", 1);
INSERT INTO news VALUES (4, "texto_4", "titulo_1", 2);
INSERT INTO news VALUES (5, "texto_5", "titulo_1", 2);

--		   IMAGE		*/ -- (id, "source", news_id)
INSERT INTO image VALUES (1, "http://url_imagem_1", 1);
INSERT INTO image VALUES (2, "http://url_imagem_1", 4);
INSERT INTO image VALUES (3, "http://url_imagem_1", 4);
INSERT INTO image VALUES (4, "http://url_imagem_1", 4);

--		SUBSCRIPTION 	*/ -- (id, "user_email", category_id)
INSERT INTO subscription VALUES (1, "email_1@prov.com", 1);
INSERT INTO subscription VALUES (2, "email_2@prov.com", 1);
INSERT INTO subscription VALUES (3, "email_3@prov.com", 2);
INSERT INTO subscription VALUES (4, "email_4@prov.com", 2);
INSERT INTO subscription VALUES (5, "email_5@prov.com", 2);