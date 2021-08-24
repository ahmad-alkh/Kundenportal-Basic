-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               5.7.28-log - MySQL Community Server (GPL)
-- Server Betriebssystem:        Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Exportiere Datenbank Struktur für uebung_kontaktdb
CREATE DATABASE IF NOT EXISTS `uebung_kontaktdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `uebung_kontaktdb`;

-- Exportiere Struktur von Tabelle uebung_kontaktdb.adresse
CREATE TABLE IF NOT EXISTS `adresse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `strasse` varchar(45) DEFAULT NULL,
  `hausnummer` varchar(45) DEFAULT NULL,
  `plz` varchar(10) DEFAULT NULL,
  `ort` varchar(45) DEFAULT NULL,
  `land` varchar(2) DEFAULT NULL,
  `person_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`person_id`),
  KEY `fk_adresse_person_idx` (`person_id`),
  CONSTRAINT `fk_adresse_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Daten Export vom Benutzer nicht ausgewählt

-- Exportiere Struktur von Tabelle uebung_kontaktdb.kontakt
CREATE TABLE IF NOT EXISTS `kontakt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  `mobil` varchar(45) DEFAULT NULL,
  `person_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`person_id`),
  KEY `fk_kontakt_person1_idx` (`person_id`),
  CONSTRAINT `fk_kontakt_person1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=latin1;

-- Daten Export vom Benutzer nicht ausgewählt

-- Exportiere Struktur von Tabelle uebung_kontaktdb.person
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `vorname` varchar(45) NOT NULL,
  `geburtsort` varchar(45) DEFAULT NULL,
  `Staatsangehoerigkeit` varbinary(50) NOT NULL,
  `geburtsdatum` date DEFAULT NULL,
  `geburtsname` varchar(45) DEFAULT NULL,
  `anlagedatum` datetime NOT NULL,
  `aenderungsdatum` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Daten Export vom Benutzer nicht ausgewählt

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
