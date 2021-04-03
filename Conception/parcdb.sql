-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2021 at 11:16 AM
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
(1, 'hamid', 'i24324325', '61-B-181841', '2021-04-03', '2021-04-04'),
(4, 'atiqa kacem', 'sh64343', '61-B3-24242', '2021-04-03', '2021-04-04');

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
(1, 'BBBB-BBBB-BBBB-BBBB', 'mahdi', 'admin123', 'mahdiaatmani@gmail.com', 'i3463634', 'mahdi'),
(2, 'AAAA-AAAA-AAAA-AAAA', 'tijja', 'admin123', 'tijjaoumaima@gmail.com', 'i3463634', 'oumaima');

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
  `date d'entrée` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `liste noir`
--
ALTER TABLE `liste noir`
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
-- AUTO_INCREMENT for table `réservation`
--
ALTER TABLE `réservation`
  MODIFY `id` int(29) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
