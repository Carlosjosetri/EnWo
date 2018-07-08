CREATE DATABASE `DatosJuego`; USE `DatosJuego`;
CREATE TABLE `usuario` (
	`_id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(45) NOT NULL,
	`password` VARCHAR(45) NOT NULL, PRIMARY KEY (`_id`), UNIQUE INDEX `username` (`username`)
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB AUTO_INCREMENT=1
;datosjuego
CREATE TABLE `jugador` (
	`_id` INT(11) NOT NULL AUTO_INCREMENT,
	`maximoNivelAlcanzado` INT(11) NOT NULL DEFAULT '1',
	`cantMonedas` INT(11) NOT NULL DEFAULT '0',
	`idUsuario` INT(11) NOT NULL,
	`puntajeMax` INT(11) NOT NULL DEFAULT '0', PRIMARY KEY (`_id`), UNIQUE INDEX `idUsuario` (`idUsuario`), CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`_id`)
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB AUTO_INCREMENT=1
;
CREATE TABLE `habilidad` (
	`_id` INT(11) NOT NULL AUTO_INCREMENT,
	`nombreHabilidad` VARCHAR(40) NOT NULL,
	`descripcionHabilidad` VARCHAR(600) NOT NULL,
	`nivelDisponibilidad` INT(11) NOT NULL DEFAULT '1',
	`costoHabilidad` INT(11) NOT NULL DEFAULT '1', PRIMARY KEY (`_id`)
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB
;
CREATE TABLE `jugadorxhabilidad` (
	`_id` INT(11) NOT NULL AUTO_INCREMENT,
	`idJugador` INT(11) NOT NULL,
	`idHabilidad` INT(11) NOT NULL, PRIMARY KEY (`_id`, `idJugador`, `idHabilidad`), INDEX `jugadorxhabilidad_jugadores_id_fk` (`idJugador`), INDEX `jugadorxhabilidad_habilidades_id_fk` (`idHabilidad`), CONSTRAINT `jugadorxhabilidad_ibfk_1` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`_id`), CONSTRAINT `jugadorxhabilidad_ibfk_2` FOREIGN KEY (`idHabilidad`) REFERENCES `habilidad` (`_id`)
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB
;
CREATE TABLE `partida` (
	`_id` INT(11) NOT NULL AUTO_INCREMENT,
	`idJugador` INT(11) NOT NULL,
	`puntajeObtenido` INT(11) NOT NULL DEFAULT '0',
	`monedasObtenidas` INT(11) NOT NULL DEFAULT '0', PRIMARY KEY (`_id`), INDEX `idJugador` (`idJugador`), CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`_id`)
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB AUTO_INCREMENT=1
;

