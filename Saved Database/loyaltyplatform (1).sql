-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 19, 2023 alle 19:02
-- Versione del server: 10.4.28-MariaDB
-- Versione PHP: 8.2.4

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

CREATE TABLE `acquisti` (
  `id` int(11) NOT NULL,
  `data_acquisto` datetime DEFAULT NULL,
  `importo_acquisto` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `punto_vendita_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `punto_vendita_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `cognome`, `nome`, `punto_vendita_id`) VALUES
(1, 'Rossi', 'Mario', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `azienda`
--

CREATE TABLE `azienda` (
  `id` int(11) NOT NULL,
  `localita_azienda` varchar(255) DEFAULT NULL,
  `nome_azienda` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `azienda`
--

INSERT INTO `azienda` (`id`, `localita_azienda`, `nome_azienda`) VALUES
(1, 'Teramo', 'Conad SrL');

-- --------------------------------------------------------

--
-- Struttura della tabella `carta_fedelta`
--

CREATE TABLE `carta_fedelta` (
  `id` int(11) NOT NULL,
  `data_scadenza` datetime DEFAULT NULL,
  `punti` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `portafoglio_id` int(11) DEFAULT NULL,
  `programma_fedelta_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `carta_fedelta`
--

INSERT INTO `carta_fedelta` (`id`, `data_scadenza`, `punti`, `client_id`, `portafoglio_id`, `programma_fedelta_id`) VALUES
(1, '2023-11-03 01:00:00', 120, 1, 1, 1),
(2, '2023-11-03 01:00:00', 20, 1, 1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_telefonico` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`id`, `cognome`, `email`, `nome`, `numero_telefonico`, `password`, `username`) VALUES
(1, 'Dev', 'fabioadmin@hotmail.it', 'Fabio', '334 423 3234', 'fabio123', 'fabioadmin'),
(2, 'Cagg', 'cagg@hotmail.it', 'Matteo', '334 323 3234', 'fcagg123', 'cagg');

-- --------------------------------------------------------

--
-- Struttura della tabella `messaggio`
--

CREATE TABLE `messaggio` (
  `id` int(11) NOT NULL,
  `messaggio` varchar(255) NOT NULL,
  `admin_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `messaggio`
--

INSERT INTO `messaggio` (`id`, `messaggio`, `admin_id`) VALUES
(1, 'Questo è un messaggio di prova', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `messaggio_clienti_destinatari`
--

CREATE TABLE `messaggio_clienti_destinatari` (
  `messaggio_id` int(11) NOT NULL,
  `clienti_destinatari_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `messaggio_clienti_destinatari`
--

INSERT INTO `messaggio_clienti_destinatari` (`messaggio_id`, `clienti_destinatari_id`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `portafogli`
--

CREATE TABLE `portafogli` (
  `id` int(11) NOT NULL,
  `numero_carte` int(11) NOT NULL,
  `ultimo_aggiornamento` datetime DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `portafogli`
--

INSERT INTO `portafogli` (`id`, `numero_carte`, `ultimo_aggiornamento`, `client_id`) VALUES
(1, 2, '2023-05-19 18:58:03', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `programma_fedelta`
--

CREATE TABLE `programma_fedelta` (
  `id` int(11) NOT NULL,
  `nome_programma` varchar(255) DEFAULT NULL,
  `punto_vendita_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `programma_fedelta`
--

INSERT INTO `programma_fedelta` (`id`, `nome_programma`, `punto_vendita_id`) VALUES
(1, 'Programma Fedeltà Premium', 1),
(2, 'Programma Fedeltà Punti', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `puntovendita`
--

CREATE TABLE `puntovendita` (
  `id` int(11) NOT NULL,
  `localita` varchar(255) DEFAULT NULL,
  `nome_punto_vendita` varchar(255) DEFAULT NULL,
  `azienda_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `puntovendita`
--

INSERT INTO `puntovendita` (`id`, `localita`, `nome_punto_vendita`, `azienda_id`) VALUES
(1, 'Teramo', 'Punto Vendita Teramo', 1),
(2, 'Milano', 'Punto Vendita Milano', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `recensioni`
--

CREATE TABLE `recensioni` (
  `id` int(11) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `voto` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `punto_vendita_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `recensioni`
--

INSERT INTO `recensioni` (`id`, `descrizione`, `voto`, `cliente_id`, `punto_vendita_id`) VALUES
(1, 'Molto buono!', 4, 1, 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `acquisti`
--
ALTER TABLE `acquisti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd0pjvpu264gq9na0qjdksq3bs` (`client_id`),
  ADD KEY `FKon9xjodfdfniw56o67gouojra` (`punto_vendita_id`);

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2wsvpy4yiyqfk9pcokgfo5lke` (`punto_vendita_id`);

--
-- Indici per le tabelle `azienda`
--
ALTER TABLE `azienda`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `carta_fedelta`
--
ALTER TABLE `carta_fedelta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmwipoa1c8pe9gd62wbm559103` (`client_id`),
  ADD KEY `FKrmk0tipi5ob1x7bme3uonu8ek` (`portafoglio_id`),
  ADD KEY `FK9qb0t6h025knki95m4f5r2tks` (`programma_fedelta_id`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `messaggio`
--
ALTER TABLE `messaggio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7oyp2s6xj2goke7h6t0p47gdb` (`admin_id`);

--
-- Indici per le tabelle `messaggio_clienti_destinatari`
--
ALTER TABLE `messaggio_clienti_destinatari`
  ADD UNIQUE KEY `UK_4ht9kac1gghghkye3inu3db4a` (`clienti_destinatari_id`),
  ADD KEY `FK4ttwb3wmukxojepd07v6160g` (`messaggio_id`);

--
-- Indici per le tabelle `portafogli`
--
ALTER TABLE `portafogli`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbvsnhw0wrx55gswaujwqir83f` (`client_id`);

--
-- Indici per le tabelle `programma_fedelta`
--
ALTER TABLE `programma_fedelta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfbvvjthh15038pmmbb9el656q` (`punto_vendita_id`);

--
-- Indici per le tabelle `puntovendita`
--
ALTER TABLE `puntovendita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK31tqo2kxrvw41l9rd7nammj9y` (`azienda_id`);

--
-- Indici per le tabelle `recensioni`
--
ALTER TABLE `recensioni`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKhtvp42breqxy113u2a4m1vhl8` (`punto_vendita_id`,`cliente_id`),
  ADD KEY `FK4ghayao9castrlokumw8badh0` (`cliente_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `acquisti`
--
ALTER TABLE `acquisti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `azienda`
--
ALTER TABLE `azienda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `carta_fedelta`
--
ALTER TABLE `carta_fedelta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `messaggio`
--
ALTER TABLE `messaggio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `portafogli`
--
ALTER TABLE `portafogli`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `programma_fedelta`
--
ALTER TABLE `programma_fedelta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `puntovendita`
--
ALTER TABLE `puntovendita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `recensioni`
--
ALTER TABLE `recensioni`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
-- Limiti per la tabella `carta_fedelta`
--
ALTER TABLE `carta_fedelta`
  ADD CONSTRAINT `FK9qb0t6h025knki95m4f5r2tks` FOREIGN KEY (`programma_fedelta_id`) REFERENCES `programma_fedelta` (`id`),
  ADD CONSTRAINT `FKmwipoa1c8pe9gd62wbm559103` FOREIGN KEY (`client_id`) REFERENCES `cliente` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKrmk0tipi5ob1x7bme3uonu8ek` FOREIGN KEY (`portafoglio_id`) REFERENCES `portafogli` (`id`);

--
-- Limiti per la tabella `messaggio`
--
ALTER TABLE `messaggio`
  ADD CONSTRAINT `FK7oyp2s6xj2goke7h6t0p47gdb` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`);

--
-- Limiti per la tabella `messaggio_clienti_destinatari`
--
ALTER TABLE `messaggio_clienti_destinatari`
  ADD CONSTRAINT `FK4ttwb3wmukxojepd07v6160g` FOREIGN KEY (`messaggio_id`) REFERENCES `messaggio` (`id`),
  ADD CONSTRAINT `FKmy0637a2661nrcx26pgq4f3a2` FOREIGN KEY (`clienti_destinatari_id`) REFERENCES `cliente` (`id`);

--
-- Limiti per la tabella `portafogli`
--
ALTER TABLE `portafogli`
  ADD CONSTRAINT `FKbvsnhw0wrx55gswaujwqir83f` FOREIGN KEY (`client_id`) REFERENCES `cliente` (`id`);

--
-- Limiti per la tabella `programma_fedelta`
--
ALTER TABLE `programma_fedelta`
  ADD CONSTRAINT `FKfbvvjthh15038pmmbb9el656q` FOREIGN KEY (`punto_vendita_id`) REFERENCES `puntovendita` (`id`) ON DELETE CASCADE;

--
-- Limiti per la tabella `puntovendita`
--
ALTER TABLE `puntovendita`
  ADD CONSTRAINT `FK31tqo2kxrvw41l9rd7nammj9y` FOREIGN KEY (`azienda_id`) REFERENCES `azienda` (`id`) ON DELETE CASCADE;

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
