-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 16, 2018 alle 10:40
-- Versione del server: 10.1.30-MariaDB
-- Versione PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `logger`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `log`
--

CREATE TABLE `log` (
  `ID` int(10) UNSIGNED NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `appId` varchar(20) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `log`
--

INSERT INTO `log` (`ID`, `timestamp`, `appId`, `message`, `level`) VALUES
(1, '2018-02-01 14:39:29', 'qwertyuiop', 'This is the first log message inserted manually.', 'INFO'),
(2, '2018-02-01 14:41:43', 'qwertyuiop', 'This is the second test message.', 'INFO'),
(3, '2018-02-01 15:25:03', 'poiuytrewq', 'hgfsdjfgdjfhgsdjhf', 'SEVERE'),
(4, '2018-02-01 17:58:35', 'cvbvc', 'Test post', 'SEVERE'),
(5, '2018-02-01 17:58:52', 'cvbvc', 'Test post', 'SEVERE'),
(6, '2018-02-01 19:26:45', 'qwertyuiop', 'This is the second test message.', 'INFO'),
(7, '2018-02-01 19:27:23', 'qwertyuiop', 'This is the second tasdasdest message.', 'INFO'),
(8, '2018-02-01 21:33:18', 'asd', 'asdsadsad', 'FINE');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `log`
--
ALTER TABLE `log`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
