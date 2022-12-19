-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Dic 19, 2022 alle 09:18
-- Versione del server: 5.7.33
-- Versione PHP: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qcm`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `qcm`
--

CREATE TABLE `qcm` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `id_qcm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `response`
--

CREATE TABLE `response` (
  `id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `id_question` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `score`
--

CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `score` varchar(255) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_qcm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `qcm`
--
ALTER TABLE `qcm`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_qcm` (`id_qcm`);

--
-- Indici per le tabelle `response`
--
ALTER TABLE `response`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_question` (`id_question`);

--
-- Indici per le tabelle `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`id_user`),
  ADD KEY `fk_id_qcm` (`id_qcm`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `qcm`
--
ALTER TABLE `qcm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `response`
--
ALTER TABLE `response`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `score`
--
ALTER TABLE `score`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_qcm` FOREIGN KEY (`id_qcm`) REFERENCES `qcm` (`id`);

--
-- Limiti per la tabella `response`
--
ALTER TABLE `response`
  ADD CONSTRAINT `fk_question` FOREIGN KEY (`id_question`) REFERENCES `question` (`id`);

--
-- Limiti per la tabella `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `fk_id_qcm` FOREIGN KEY (`id_qcm`) REFERENCES `qcm` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
