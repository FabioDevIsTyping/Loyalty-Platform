-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Creato il: Giu 05, 2023 alle 10:02
-- Versione del server: 8.0.31
-- Versione PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loyaltyplatform`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `acquisti`
--

DROP TABLE IF EXISTS `acquisti`;
CREATE TABLE IF NOT EXISTS `acquisti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_acquisto` datetime(6) DEFAULT NULL,
  `importo_acquisto` double NOT NULL,
  `client_id` int DEFAULT NULL,
  `punto_vendita_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd0pjvpu264gq9na0qjdksq3bs` (`client_id`),
  KEY `FKon9xjodfdfniw56o67gouojra` (`punto_vendita_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `acquisti`
--

INSERT INTO `acquisti` (`id`, `data_acquisto`, `importo_acquisto`, `client_id`, `punto_vendita_id`) VALUES
(1, '2023-05-19 02:00:00.000000', 200, 4, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_telefonico` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `punto_vendita_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2wsvpy4yiyqfk9pcokgfo5lke` (`punto_vendita_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `cognome`, `email`, `nome`, `numero_telefonico`, `password`, `username`, `punto_vendita_id`) VALUES
(1, 'Butler', 'JimmyButler@example.com', 'Jimmy', '+1-202-555-0149', 'miamiIsHeated', 'JimmyButler', 2),
(2, 'Shaw', 'BrianShaw@example.com', 'Brian', '+1-613-555-0119', 'shawBrianpass', 'BrianShaw93', 1),
(3, 'Rossi', 'rossiMarco@example.com', 'Marco', '+39 331 349 3131', 'rossiMarco', 'MarcoRossi', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `azienda`
--

DROP TABLE IF EXISTS `azienda`;
CREATE TABLE IF NOT EXISTS `azienda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `localita_azienda` varchar(255) DEFAULT NULL,
  `nome_azienda` varchar(255) DEFAULT NULL,
  `titolare_azienda_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7iy6doy0dw155cpawh66pe2op` (`titolare_azienda_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `azienda`
--

INSERT INTO `azienda` (`id`, `localita_azienda`, `nome_azienda`, `titolare_azienda_id`) VALUES
(1, 'Dublin, Ohio, United States', 'Wendy\'s Company', 1),
(2, 'Neckarsulm, Germany', 'Lidl Stiftung & Co. KG', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `carta_fedelta`
--

DROP TABLE IF EXISTS `carta_fedelta`;
CREATE TABLE IF NOT EXISTS `carta_fedelta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_scadenza` datetime(6) DEFAULT NULL,
  `livello` int NOT NULL,
  `nome_servizio` varchar(255) DEFAULT NULL,
  `percentuale_cashback` double NOT NULL,
  `punti` double NOT NULL,
  `totale_acquisti` double NOT NULL,
  `client_id` int DEFAULT NULL,
  `portafoglio_id` int DEFAULT NULL,
  `programma_fedelta_id` int DEFAULT NULL,
  `punto_vendita_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmwipoa1c8pe9gd62wbm559103` (`client_id`),
  KEY `FKrmk0tipi5ob1x7bme3uonu8ek` (`portafoglio_id`),
  KEY `FK9qb0t6h025knki95m4f5r2tks` (`programma_fedelta_id`),
  KEY `FK1u5evi88h4csha2i0x7384mxd` (`punto_vendita_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `carta_fedelta`
--

INSERT INTO `carta_fedelta` (`id`, `data_scadenza`, `livello`, `nome_servizio`, `percentuale_cashback`, `punti`, `totale_acquisti`, `client_id`, `portafoglio_id`, `programma_fedelta_id`, `punto_vendita_id`) VALUES
(1, '2023-06-30 02:00:00.000000', 0, NULL, 0, 0, 0, 2, 1, 2, 1),
(2, '2023-06-30 02:00:00.000000', 0, NULL, 0, 0, 0, 2, 1, 1, 1),
(4, '2023-06-30 02:00:00.000000', 0, NULL, 0, 0, 0, 1, 2, 1, 1),
(5, '2023-07-30 02:00:00.000000', 0, NULL, 0, 0, 0, 3, 3, 1, 2),
(6, '2024-07-30 02:00:00.000000', 0, NULL, 0, 200, 200, 4, 4, 1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `carta_fedelta_aziende_associate`
--

DROP TABLE IF EXISTS `carta_fedelta_aziende_associate`;
CREATE TABLE IF NOT EXISTS `carta_fedelta_aziende_associate` (
  `carta_fedelta_id` int NOT NULL,
  `aziende_associate_id` int NOT NULL,
  UNIQUE KEY `UK_mtdfva73awq6h55113dbm1poi` (`aziende_associate_id`),
  KEY `FKfvg44jqm8y612rdag98frn1v5` (`carta_fedelta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_telefonico` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`id`, `cognome`, `email`, `nome`, `numero_telefonico`, `password`, `username`) VALUES
(1, 'Demarcus', 'demarcusGreen@example.com', 'Green', '+1-613-555-0131', 'password1233', 'Gdemarcus'),
(2, 'Demarcus', 'danteDeMarcus@example.com', 'Dante', '+1-613-555-0113', 'password12', 'Dantedemarcus'),
(3, 'Wallace', 'WallaceBen@example.com', 'Ben', '+1-443-555-0113', 'passwordWallaceBen', 'WallaceBen'),
(4, 'Sivan', 'TroySv@example.com', 'Troy', '+1-432-523-0133', 'passwordTroySv', 'TroySv'),
(5, 'Togni', 'Marchino@example.com', 'Marco', '+39 337 212 3423', 'passwordMarchino', 'Marchino');

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente_punti_vendita`
--

DROP TABLE IF EXISTS `cliente_punti_vendita`;
CREATE TABLE IF NOT EXISTS `cliente_punti_vendita` (
  `clienti_id` int NOT NULL,
  `punti_vendita_id` int NOT NULL,
  KEY `FKp8ra9ycm8w8usnng50r5kodk5` (`punti_vendita_id`),
  KEY `FK624qpk7vj1w0o66x7ywu8rbx0` (`clienti_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `cliente_punti_vendita`
--

INSERT INTO `cliente_punti_vendita` (`clienti_id`, `punti_vendita_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 1),
(5, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `comunicazioni promozionali`
--

DROP TABLE IF EXISTS `comunicazioni promozionali`;
CREATE TABLE IF NOT EXISTS `comunicazioni promozionali` (
  `id` int NOT NULL AUTO_INCREMENT,
  `messaggio` varchar(255) NOT NULL,
  `orario_di_invio` datetime(6) DEFAULT NULL,
  `punto_vendita_id` int NOT NULL,
  `tipo_comunicazione_promozionale_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6ve9e0ukixe4vg2e41jx3uc1g` (`punto_vendita_id`),
  KEY `FKoeg4cdfdlyhfuaxw9sbg0ij97` (`tipo_comunicazione_promozionale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `comunicazioni promozionali`
--

INSERT INTO `comunicazioni promozionali` (`id`, `messaggio`, `orario_di_invio`, `punto_vendita_id`, `tipo_comunicazione_promozionale_id`) VALUES
(1, 'Sconto del 30% su tutti i nostri hamburger con pollo', '2023-06-05 10:53:47.709357', 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `comunicazioni promozionali_clienti_destinatari`
--

DROP TABLE IF EXISTS `comunicazioni promozionali_clienti_destinatari`;
CREATE TABLE IF NOT EXISTS `comunicazioni promozionali_clienti_destinatari` (
  `comunicazione_promozionale_id` int NOT NULL,
  `clienti_destinatari_id` int NOT NULL,
  KEY `FKdnsi7w67sw4fj1kiranonf7oy` (`clienti_destinatari_id`),
  KEY `FKsm5wa1gpuyi6el0dgibn9dr6f` (`comunicazione_promozionale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `comunicazioni promozionali_clienti_destinatari`
--

INSERT INTO `comunicazioni promozionali_clienti_destinatari` (`comunicazione_promozionale_id`, `clienti_destinatari_id`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendenti`
--

DROP TABLE IF EXISTS `dipendenti`;
CREATE TABLE IF NOT EXISTS `dipendenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `data_fine_contratto` date DEFAULT NULL,
  `data_inizio_contratto` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_telefonico` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `punto_vendita_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnrud0lrtsye89dx77en5uuu6m` (`punto_vendita_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `dipendenti`
--

INSERT INTO `dipendenti` (`id`, `cognome`, `data_fine_contratto`, `data_inizio_contratto`, `email`, `nome`, `numero_telefonico`, `password`, `username`, `punto_vendita_id`) VALUES
(1, 'Pierce', '2023-12-31', '2021-03-01', 'PaulPierce@example.com', 'Paul', '+1-613-555-0119', 'paulpiercepass', 'PaulPierce', 1),
(2, 'Pierce', '2023-12-31', '2021-03-03', 'MarcusPierce@example.com', 'Marcus', '+1-613-355-0119', 'Marcuspiercepass', 'MarcusPierce', 1),
(3, 'Worthy', '2024-12-31', '2020-03-04', 'JamesWorthy@example.com', 'James', '+1-613-353-0129', 'JamesWorthypass', 'JamesWorthy', 2),
(4, 'Paul', '2024-12-31', '2020-03-04', 'ChrisPaul@example.com', 'Chris', '+1-513-353-0129', 'ChrisPaulpass', 'ChrisPaul', 2),
(5, 'Biscardi', '2023-12-31', '2020-03-04', 'filippo@example.com', 'Filippo', '+39 323 323 3120', 'biscardipassword', 'Bisc', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `portafogli`
--

DROP TABLE IF EXISTS `portafogli`;
CREATE TABLE IF NOT EXISTS `portafogli` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_carte` int NOT NULL,
  `ultimo_aggiornamento` datetime(6) DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbvsnhw0wrx55gswaujwqir83f` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `portafogli`
--

INSERT INTO `portafogli` (`id`, `numero_carte`, `ultimo_aggiornamento`, `client_id`) VALUES
(1, 2, '2023-06-05 10:28:13.687475', 2),
(2, 1, '2023-06-05 10:31:11.671867', 1),
(3, 1, '2023-06-05 10:32:26.490366', 3),
(4, 1, '2023-06-05 10:32:39.569917', 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `programma_fedelta`
--

DROP TABLE IF EXISTS `programma_fedelta`;
CREATE TABLE IF NOT EXISTS `programma_fedelta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_programma` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `programma_fedelta`
--

INSERT INTO `programma_fedelta` (`id`, `nome_programma`) VALUES
(1, 'Programma a Punti'),
(2, 'Programma a livelli'),
(3, 'Programma VIP'),
(4, 'Programma Cashback'),
(5, 'Programma coalizione');

-- --------------------------------------------------------

--
-- Struttura della tabella `puntovendita`
--

DROP TABLE IF EXISTS `puntovendita`;
CREATE TABLE IF NOT EXISTS `puntovendita` (
  `id` int NOT NULL AUTO_INCREMENT,
  `localita` varchar(255) DEFAULT NULL,
  `nome_punto_vendita` varchar(255) DEFAULT NULL,
  `azienda_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK31tqo2kxrvw41l9rd7nammj9y` (`azienda_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `puntovendita`
--

INSERT INTO `puntovendita` (`id`, `localita`, `nome_punto_vendita`, `azienda_id`) VALUES
(1, '482 Queen St W, Toronto, ON M5V 2B3, Canada', 'Wendy\'s Toronto', 1),
(2, '938 8th Ave, New York, NY 10019, United States', 'Wendy\'s NY', 1),
(3, 'Via Nazionale Adriatica, 24, 64018 Tortoreto Lido TE', 'LIDL Tortoreto', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `puntovendita_programma_fedelta`
--

DROP TABLE IF EXISTS `puntovendita_programma_fedelta`;
CREATE TABLE IF NOT EXISTS `puntovendita_programma_fedelta` (
  `punto_vendita_id` int NOT NULL,
  `programma_fedelta_id` int NOT NULL,
  KEY `FKhheug6fmffd4gcrjmpkqv4k6m` (`programma_fedelta_id`),
  KEY `FKjqbyrq97r851vjcb1ahsmuy7e` (`punto_vendita_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `puntovendita_programma_fedelta`
--

INSERT INTO `puntovendita_programma_fedelta` (`punto_vendita_id`, `programma_fedelta_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 1),
(3, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `recensioni`
--

DROP TABLE IF EXISTS `recensioni`;
CREATE TABLE IF NOT EXISTS `recensioni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) NOT NULL,
  `voto` int NOT NULL,
  `cliente_id` int NOT NULL,
  `punto_vendita_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKhtvp42breqxy113u2a4m1vhl8` (`punto_vendita_id`,`cliente_id`),
  KEY `FK4ghayao9castrlokumw8badh0` (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `recensioni`
--

INSERT INTO `recensioni` (`id`, `descrizione`, `voto`, `cliente_id`, `punto_vendita_id`) VALUES
(5, 'Molto buono!', 9, 1, 1),
(6, 'Ottimo punto vendita!', 8, 2, 1),
(7, 'Mi aspettavo di meglio', 6, 3, 2),
(8, 'Scadente', 4, 4, 2),
(9, 'Perfetto', 10, 5, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `tipi comunicazioni promozionali`
--

DROP TABLE IF EXISTS `tipi comunicazioni promozionali`;
CREATE TABLE IF NOT EXISTS `tipi comunicazioni promozionali` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_comunicazione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `tipi comunicazioni promozionali`
--

INSERT INTO `tipi comunicazioni promozionali` (`id`, `nome_comunicazione`) VALUES
(1, 'SMS'),
(2, 'Notifica'),
(3, 'Email');

-- --------------------------------------------------------

--
-- Struttura della tabella `titolari azienda`
--

DROP TABLE IF EXISTS `titolari azienda`;
CREATE TABLE IF NOT EXISTS `titolari azienda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_telefonico` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `titolari azienda`
--

INSERT INTO `titolari azienda` (`id`, `cognome`, `email`, `nome`, `numero_telefonico`, `password`, `username`) VALUES
(1, 'Penegor', 'PenegorTodd@example.com', 'Todd', '+39 331 457 9323', 'Penegor1984', 'PenegorTodd'),
(2, 'Schwarz', 'Schwarz@example.com', 'Josef', '+39 331 347 9533', 'Schwarz', 'JosefSchwarz');

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `acquisti`
--
ALTER TABLE `acquisti`
  ADD CONSTRAINT `FKd0pjvpu264gq9na0qjdksq3bs` FOREIGN KEY (`client_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKon9xjodfdfniw56o67gouojra` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`);

--
-- Limiti per la tabella `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK2wsvpy4yiyqfk9pcokgfo5lke` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`);

--
-- Limiti per la tabella `azienda`
--
ALTER TABLE `azienda`
  ADD CONSTRAINT `FK7iy6doy0dw155cpawh66pe2op` FOREIGN KEY (`titolare_azienda_id`) REFERENCES `titolari azienda` (`id`) ON DELETE CASCADE;

--
-- Limiti per la tabella `carta_fedelta`
--
ALTER TABLE `carta_fedelta`
  ADD CONSTRAINT `FK1u5evi88h4csha2i0x7384mxd` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`),
  ADD CONSTRAINT `FK9qb0t6h025knki95m4f5r2tks` FOREIGN KEY (`programma_fedelta_id`) REFERENCES `programma_fedelta` (`id`),
  ADD CONSTRAINT `FKmwipoa1c8pe9gd62wbm559103` FOREIGN KEY (`client_id`) REFERENCES `cliente` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKrmk0tipi5ob1x7bme3uonu8ek` FOREIGN KEY (`portafoglio_id`) REFERENCES `portafogli` (`id`);

--
-- Limiti per la tabella `carta_fedelta_aziende_associate`
--
ALTER TABLE `carta_fedelta_aziende_associate`
  ADD CONSTRAINT `FKa7hegs65mtjgawhmhqgrnj5ml` FOREIGN KEY (`aziende_associate_id`) REFERENCES `azienda` (`id`),
  ADD CONSTRAINT `FKfvg44jqm8y612rdag98frn1v5` FOREIGN KEY (`carta_fedelta_id`) REFERENCES `carta_fedelta` (`id`);

--
-- Limiti per la tabella `cliente_punti_vendita`
--
ALTER TABLE `cliente_punti_vendita`
  ADD CONSTRAINT `FK624qpk7vj1w0o66x7ywu8rbx0` FOREIGN KEY (`clienti_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKp8ra9ycm8w8usnng50r5kodk5` FOREIGN KEY (`punti_vendita_id`) REFERENCES `puntovendita` (`id`);

--
-- Limiti per la tabella `comunicazioni promozionali`
--
ALTER TABLE `comunicazioni promozionali`
  ADD CONSTRAINT `FK6ve9e0ukixe4vg2e41jx3uc1g` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`),
  ADD CONSTRAINT `FKoeg4cdfdlyhfuaxw9sbg0ij97` FOREIGN KEY (`tipo_comunicazione_promozionale_id`) REFERENCES `tipi comunicazioni promozionali` (`id`);

--
-- Limiti per la tabella `comunicazioni promozionali_clienti_destinatari`
--
ALTER TABLE `comunicazioni promozionali_clienti_destinatari`
  ADD CONSTRAINT `FKdnsi7w67sw4fj1kiranonf7oy` FOREIGN KEY (`clienti_destinatari_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKsm5wa1gpuyi6el0dgibn9dr6f` FOREIGN KEY (`comunicazione_promozionale_id`) REFERENCES `comunicazioni promozionali` (`id`);

--
-- Limiti per la tabella `dipendenti`
--
ALTER TABLE `dipendenti`
  ADD CONSTRAINT `FKnrud0lrtsye89dx77en5uuu6m` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`);

--
-- Limiti per la tabella `portafogli`
--
ALTER TABLE `portafogli`
  ADD CONSTRAINT `FKbvsnhw0wrx55gswaujwqir83f` FOREIGN KEY (`client_id`) REFERENCES `cliente` (`id`);

--
-- Limiti per la tabella `puntovendita`
--
ALTER TABLE `puntovendita`
  ADD CONSTRAINT `FK31tqo2kxrvw41l9rd7nammj9y` FOREIGN KEY (`azienda_id`) REFERENCES `azienda` (`id`) ON DELETE CASCADE;

--
-- Limiti per la tabella `puntovendita_programma_fedelta`
--
ALTER TABLE `puntovendita_programma_fedelta`
  ADD CONSTRAINT `FKhheug6fmffd4gcrjmpkqv4k6m` FOREIGN KEY (`programma_fedelta_id`) REFERENCES `programma_fedelta` (`id`),
  ADD CONSTRAINT `FKjqbyrq97r851vjcb1ahsmuy7e` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`);

--
-- Limiti per la tabella `recensioni`
--
ALTER TABLE `recensioni`
  ADD CONSTRAINT `FK4ghayao9castrlokumw8badh0` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKig197qdd14krvx6woicyoqyws` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
