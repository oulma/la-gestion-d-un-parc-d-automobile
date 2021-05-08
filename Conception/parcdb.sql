-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 08 mai 2021 à 07:30
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `parcdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `liste noir`
--

CREATE TABLE `liste noir` (
  `id` int(20) NOT NULL,
  `matricule` varchar(100) NOT NULL,
  `marque` varchar(40) NOT NULL,
  `etat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `parc`
--

CREATE TABLE `parc` (
  `id` int(40) NOT NULL,
  `Matricule` varchar(70) NOT NULL,
  `Montant` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `parc`
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
-- Structure de la table `placeparc`
--

CREATE TABLE `placeparc` (
  `id` int(23) NOT NULL,
  `etat de place` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `réservation`
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
-- Déchargement des données de la table `réservation`
--

INSERT INTO `réservation` (`id`, `nom`, `CIN`, `Matricule`, `date d'entrée`, `date de sortie`) VALUES
(1, 'hamid', 'i24324325', '61-B-181841', '2021-04-03', '2021-04-04'),
(4, 'atiqa kacem', 'sh64343', '61-B3-24242', '2021-04-03', '2021-04-04');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
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
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `serieU`, `nomU`, `motPasse`, `emailU`, `cinU`, `PrenomU`) VALUES
(1, 'BBBB-BBBB-BBBB-BBBB', 'mahdi', 'admin123', 'mahdiaatmani@gmail.com', 'i3463634', 'mahdi'),
(2, 'AAAA-AAAA-AAAA-AAAA', 'tijja', 'admin123', 'tijjaoumaima@gmail.com', 'i3463634', 'oumaima');

-- --------------------------------------------------------

--
-- Structure de la table `voitsortie`
--

CREATE TABLE `voitsortie` (
  `id` int(20) NOT NULL,
  `matricule` varchar(36) NOT NULL,
  `date sortie` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE `voiture` (
  `id` int(10) NOT NULL,
  `matricule` varchar(40) NOT NULL,
  `date d'entrée` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `liste noir`
--
ALTER TABLE `liste noir`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `parc`
--
ALTER TABLE `parc`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `placeparc`
--
ALTER TABLE `placeparc`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `réservation`
--
ALTER TABLE `réservation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- Index pour la table `voitsortie`
--
ALTER TABLE `voitsortie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `parc`
--
ALTER TABLE `parc`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1014;

--
-- AUTO_INCREMENT pour la table `réservation`
--
ALTER TABLE `réservation`
  MODIFY `id` int(29) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
