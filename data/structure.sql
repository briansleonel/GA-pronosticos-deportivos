# crear la BD
CREATE DATABASE IF NOT EXISTS `pronostico_deportivo` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;

USE `pronostico_deportivo`;

# Eliminar si existen las tablas
DROP TABLE IF EXISTS `equipos`;

DROP TABLE IF EXISTS `rondas`;

DROP TABLE IF EXISTS `usuarios`;

DROP TABLE IF EXISTS `partidos`;

DROP TABLE IF EXISTS `pronosticos`;

CREATE TABLE `equipos` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(150) DEFAULT NULL,
    `descripcion` VARCHAR(300) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `rondas` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nro` INT(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `partidos` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `equipo_1` INT(11) NOT NULL,
    `equipo_2` INT(11) NOT NULL,
    `goles_equipo_1` INT(11) NOT NULL,
    `goles_equipo_2` INT(11) NOT NULL,
    `ronda_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `equipo_1` (`equipo_1`),
    KEY `equipo_2` (`equipo_2`),
    KEY `ronda_id` (`ronda_id`),
    CONSTRAINT `equipo_1` FOREIGN KEY (`equipo_1`)
        REFERENCES `equipos` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `equipo_2` FOREIGN KEY (`equipo_2`)
        REFERENCES `equipos` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `ronda_id` FOREIGN KEY (`ronda_id`)
        REFERENCES `rondas` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `usuarios` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(200) NOT NULL,
    PRIMARY KEY (`id`)
);
  
CREATE TABLE `pronosticos` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `partido_id` INT(11) NOT NULL,
    `equipo_id` INT(11) NOT NULL,
    `resultado` VARCHAR(45) NOT NULL,
    `usuario_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `usuario_id` (`usuario_id`),
    KEY `partido_id` (`partido_id`),
    KEY `equipo_id` (`equipo_id`),
    CONSTRAINT `equipo_id` FOREIGN KEY (`equipo_id`)
        REFERENCES `equipos` (`id`),
    CONSTRAINT `partido_id` FOREIGN KEY (`partido_id`)
        REFERENCES `partidos` (`id`),
    CONSTRAINT `usuario_id` FOREIGN KEY (`usuario_id`)
        REFERENCES `usuarios` (`id`)
);

## Tabla Fases
#CREATE TABLE `pronostico_deportivo`.`fases` (`id` INT NOT NULL,`nombre` VARCHAR(250) NOT NULL,PRIMARY KEY (`id`));