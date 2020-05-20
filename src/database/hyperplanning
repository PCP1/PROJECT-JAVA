-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 20 mai 2020 à 18:40
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `hyperplanning`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `IDCours` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`IDCours`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`IDCours`, `Nom`) VALUES
(1, 'Traitement du signal'),
(2, 'Electronique fondamentale'),
(3, 'POO Java');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `IDUtilisateur` int(10) NOT NULL AUTO_INCREMENT,
  `IDCours` int(10) NOT NULL,
  PRIMARY KEY (`IDUtilisateur`,`IDCours`),
  KEY `IDUtilisateur` (`IDUtilisateur`),
  KEY `IDCours` (`IDCours`)
) ENGINE=MyISAM AUTO_INCREMENT=40007 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`IDUtilisateur`, `IDCours`) VALUES
(40001, 60001),
(40002, 60002),
(40003, 60003),
(40004, 60004),
(40005, 60005),
(40006, 60006);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `IDUtilisateur` int(10) NOT NULL AUTO_INCREMENT,
  `Numero` int(10) NOT NULL,
  `IDGroupe` int(10) NOT NULL,
  PRIMARY KEY (`IDUtilisateur`),
  KEY `IDGroupe` (`IDGroupe`),
  KEY `IDUtilisateur` (`IDUtilisateur`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`IDUtilisateur`, `Numero`, `IDGroupe`) VALUES
(1, 10000001, 1),
(2, 10000002, 1),
(3, 10000003, 2),
(4, 10000004, 2),
(5, 10000005, 3),
(6, 10000006, 3),
(7, 10000007, 4),
(8, 10000008, 4),
(9, 10000009, 5),
(10, 10000009, 5),
(11, 10000010, 6),
(12, 10000010, 6);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `IDGroupe` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `IDPromotion` int(10) NOT NULL,
  PRIMARY KEY (`IDGroupe`),
  KEY `IDPromotion` (`IDPromotion`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`IDGroupe`, `Nom`, `IDPromotion`) VALUES
(1, 'TD01', 2),
(2, 'TD02', 2),
(3, 'TD01', 3),
(4, 'TD02', 3),
(5, 'TD01', 4),
(6, 'TD02', 4);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `IDPromotion` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`IDPromotion`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`IDPromotion`, `Nom`) VALUES
(2, '2022'),
(3, '2023'),
(4, '2024');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `IDSalle` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Capacité` int(10) NOT NULL,
  `IDSite` int(10) NOT NULL,
  PRIMARY KEY (`IDSalle`),
  KEY `IDSite` (`IDSite`)
) ENGINE=MyISAM AUTO_INCREMENT=1007 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`IDSalle`, `Nom`, `Capacité`, `IDSite`) VALUES
(1001, 'P330', 30, 1),
(1002, 'P445', 150, 1),
(1003, 'E145', 100, 2),
(1004, 'E225', 45, 2),
(1005, 'Amphi A', 245, 3),
(1006, 'Amphi B', 300, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `IDSeance` int(10) NOT NULL AUTO_INCREMENT,
  `Semaine` varchar(255) NOT NULL,
  `Date` date NOT NULL,
  `HeureDebut` int(10) NOT NULL,
  `HeureFin` int(10) NOT NULL,
  `Etat` varchar(255) NOT NULL,
  `IDCours` int(10) NOT NULL,
  `IDTypeCours` int(10) NOT NULL,
  PRIMARY KEY (`IDSeance`),
  KEY `IDCours` (`IDCours`),
  KEY `IDTypeCours` (`IDTypeCours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `IDSeance` int(10) NOT NULL,
  `IDEnseignant` int(10) NOT NULL,
  PRIMARY KEY (`IDSeance`,`IDEnseignant`),
  KEY `IDSeance` (`IDSeance`),
  KEY `IDEnseignant` (`IDEnseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `IDSeance` int(10) NOT NULL,
  `IDGroupe` int(10) NOT NULL,
  PRIMARY KEY (`IDSeance`,`IDGroupe`),
  KEY `IDSeance` (`IDSeance`),
  KEY `IDGroupe` (`IDGroupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `IDSeance` int(10) NOT NULL,
  `IDSalle` int(10) NOT NULL,
  PRIMARY KEY (`IDSeance`,`IDSalle`),
  KEY `IDSeance` (`IDSeance`),
  KEY `IDSalle` (`IDSalle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `IDSite` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`IDSite`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`IDSite`, `Nom`) VALUES
(1, 'Eiffel 1'),
(2, 'Eiffel 2'),
(3, 'Eiffel 3');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `IDTypecours` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`IDTypecours`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`IDTypecours`, `Nom`) VALUES
(1, 'Travaux Dirigés'),
(2, 'Cours Magistral'),
(3, 'Soutien'),
(4, 'Travaux Pratiques');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `IDUtilisateur` int(10) NOT NULL AUTO_INCREMENT,
  `AdresseMail` varchar(255) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prénom` varchar(255) NOT NULL,
  `Droit` int(1) NOT NULL,
  PRIMARY KEY (`IDUtilisateur`)
) ENGINE=MyISAM AUTO_INCREMENT=400005 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`IDUtilisateur`, `AdresseMail`, `MotDePasse`, `Nom`, `Prénom`, `Droit`) VALUES
(400001, 'aurele.duparc@edu.ece.fr', 'ACD1999', 'Duparc', 'Aurèle', 4),
(400004, 'stephen.hawking@edu.ece.fr', 'HRadiation', 'Hawking', 'Stephen', 3),
(400002, 'justine.referent@edu.ece.fr', 'RP', 'Référent', 'Justine', 2),
(400003, 'kennedy@edu.ece.fr', 'bornintheusa', 'Kennedy', 'John Fitzgerald', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
