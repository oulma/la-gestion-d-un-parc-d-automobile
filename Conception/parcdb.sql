-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2021 at 09:03 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parcdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `liste noir`
--

CREATE TABLE `liste noir` (
  `id` int(20) NOT NULL,
  `matricule` varchar(100) NOT NULL,
  `marque` varchar(40) NOT NULL,
  `etat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `liste noir`
--

INSERT INTO `liste noir` (`id`, `matricule`, `marque`, `etat`) VALUES
(1, 'MA-EGEG', 'dacia', 'Violations de la circulation'),
(3, 'MA-EGEG54', 'ASASA', 'Violations de la circulation');

-- --------------------------------------------------------

--
-- Table structure for table `parc`
--

CREATE TABLE `parc` (
  `id` int(40) NOT NULL,
  `Matricule` varchar(70) NOT NULL,
  `Montant` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parc`
--

INSERT INTO `parc` (`id`, `Matricule`, `Montant`) VALUES
(1, 'SSJJ77LL', 30),
(2, 'SSHH88', 150),
(3, 'SSGGHH9', 90),
(4, 'MPOAZR45', 90),
(5, 'MLKJD23', 105),
(6, 'LLOER125', 135),
(7, 'KLRE123', 30),
(8, 'KLOA1265', 135),
(9, 'KDSEE45', 60),
(10, 'JLLO342', 45),
(11, 'JJK123J', 255),
(12, 'HTYRLP12', 255),
(1001, 'XX66HH99', 330);

-- --------------------------------------------------------

--
-- Table structure for table `placeparc`
--

CREATE TABLE `placeparc` (
  `id` int(23) NOT NULL,
  `etat de place` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `réservation`
--

CREATE TABLE `réservation` (
  `id` int(29) NOT NULL,
  `nom` varchar(90) NOT NULL,
  `CIN` varchar(49) NOT NULL,
  `Matricule` varchar(70) NOT NULL,
  `date d'entrée` date NOT NULL,
  `date de sortie` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `réservation`
--

INSERT INTO `réservation` (`id`, `nom`, `CIN`, `Matricule`, `date d'entrée`, `date de sortie`) VALUES
(1, 'hamid bot', 'i24324325', '61-B-181841', '2021-04-04', '2021-04-04'),
(4, 'atiqa kacem', 'sh64343', '61-B3-24242', '2021-04-03', '2021-04-04'),
(8, 'mohamed oulm', 'I34634', '61-B-181841', '2020-05-07', '2020-05-09'),
(19, 'mohamed oulm', 'I34634', '61-B-1818477', '2020-05-07', '2020-05-09');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(10) NOT NULL,
  `serieU` varchar(90) NOT NULL,
  `nomU` varchar(70) NOT NULL,
  `motPasse` varchar(40) NOT NULL,
  `emailU` varchar(80) NOT NULL,
  `cinU` varchar(25) NOT NULL,
  `PrenomU` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `serieU`, `nomU`, `motPasse`, `emailU`, `cinU`, `PrenomU`) VALUES
(1, 'BBBB-BBBB-BBBB-BBBB', 'mahdi', 'a', 'mahdiaatmani@gmail.com', 'i3463634', 'mahdi'),
(2, 'AAAA-AAAA-AAAA-AAAA', 'tijja', 'admin123', 'tijjaoumaima@gmail.com', 'i3463634', 'oumaima'),
(7, 'KKKK-KKKK-KKKK-KKKK', 'oulma', 'azerty', 'mohamedoulma@gmail.com', 'I54645', 'mohamed'),
(8, 'a', 'a', 'a', 'mahdiaatmani@gmail.com', 'a', 'aa');

-- --------------------------------------------------------

--
-- Table structure for table `voitsortie`
--

CREATE TABLE `voitsortie` (
  `id` int(20) NOT NULL,
  `matricule` varchar(36) NOT NULL,
  `date sortie` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `voiture`
--

CREATE TABLE `voiture` (
  `id` int(10) NOT NULL,
  `matricule` varchar(40) NOT NULL,
  `nom` varchar(32) DEFAULT NULL,
  `date_dentrer` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `voiture`
--

INSERT INTO `voiture` (`id`, `matricule`, `nom`, `date_dentrer`) VALUES
(69, 'MA-ADLAKD', 'Mahdi Atmandla^d', '2021-05-31 18:14:09'),
(70, 'BM-38842', 'mohamed oulma', '2001-20-01'),
(71, 'CM-38843', 'atika kacem', '2001-20-01'),
(104, 'KI006SD', NULL, '2021-05-31 19:54:17'),
(106, 'K006SD', NULL, '2021-05-31 19:54:17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `liste noir`
--
ALTER TABLE `liste noir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `parc`
--
ALTER TABLE `parc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `placeparc`
--
ALTER TABLE `placeparc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `réservation`
--
ALTER TABLE `réservation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- Indexes for table `voitsortie`
--
ALTER TABLE `voitsortie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `liste noir`
--
ALTER TABLE `liste noir`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `parc`
--
ALTER TABLE `parc`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT for table `réservation`
--
ALTER TABLE `réservation`
  MODIFY `id` int(29) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `voiture`
--
ALTER TABLE `voiture`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
