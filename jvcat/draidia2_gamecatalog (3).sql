-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 20 Octobre 2016 à 14:39
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `draidia2_gamecatalog`
--
CREATE DATABASE IF NOT EXISTS `draidia2_gamecatalog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `draidia2_gamecatalog`;

-- --------------------------------------------------------

--
-- Structure de la table `developer`
--

DROP TABLE IF EXISTS `developer`;
CREATE TABLE IF NOT EXISTS `developer` (
  `ID_DEV` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_DEV` varchar(35) NOT NULL,
  PRIMARY KEY (`ID_DEV`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `developer`
--

INSERT INTO `developer` (`ID_DEV`, `NAME_DEV`) VALUES
(1, 'Crypton Future Media'),
(2, 'Dice'),
(3, 'Flying Wild Hog'),
(4, '2K Czech'),
(5, 'Hangar 13 Games'),
(6, 'THREAKS'),
(7, 'Nintendo'),
(8, 'The Coalition'),
(9, 'Square Enix'),
(10, 'BioWare'),
(11, 'Bandai Namco Games'),
(12, 'Team ICO'),
(13, 'Warhorse Studios'),
(14, 'Capcom');

-- --------------------------------------------------------

--
-- Structure de la table `develops`
--

DROP TABLE IF EXISTS `develops`;
CREATE TABLE IF NOT EXISTS `develops` (
  `ID_GAME` int(11) NOT NULL,
  `ID_DEV` int(11) NOT NULL,
  PRIMARY KEY (`ID_GAME`,`ID_DEV`),
  KEY `FK_DEVELOPED` (`ID_DEV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `develops`
--

INSERT INTO `develops` (`ID_GAME`, `ID_DEV`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(4, 5),
(5, 6),
(6, 7),
(9, 7),
(7, 8),
(8, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14);

-- --------------------------------------------------------

--
-- Structure de la table `editor`
--

DROP TABLE IF EXISTS `editor`;
CREATE TABLE IF NOT EXISTS `editor` (
  `ID_EDITOR` int(11) NOT NULL,
  `NAME_EDITOR` varchar(35) NOT NULL,
  PRIMARY KEY (`ID_EDITOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `editor`
--

INSERT INTO `editor` (`ID_EDITOR`, `NAME_EDITOR`) VALUES
(1, 'Sega'),
(2, 'Electronic Arts'),
(3, 'Devolver Digital'),
(4, '2K Games'),
(5, 'Reverb Publishing'),
(6, 'Nintendo'),
(7, 'Microsoft'),
(8, 'Square Enix'),
(9, 'Bandai Namco Games'),
(10, 'Sony Computer Entertainment'),
(11, 'Warhorse Studios'),
(12, 'Deep Silver'),
(13, 'Capcom');

-- --------------------------------------------------------

--
-- Structure de la table `edits`
--

DROP TABLE IF EXISTS `edits`;
CREATE TABLE IF NOT EXISTS `edits` (
  `ID_GAME` int(11) NOT NULL,
  `ID_EDITOR` int(11) NOT NULL,
  PRIMARY KEY (`ID_GAME`,`ID_EDITOR`),
  KEY `FK_EDITS` (`ID_EDITOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `edits`
--

INSERT INTO `edits` (`ID_GAME`, `ID_EDITOR`) VALUES
(1, 1),
(2, 2),
(10, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(9, 6),
(7, 7),
(8, 8),
(11, 9),
(12, 10),
(13, 11),
(14, 13);

-- --------------------------------------------------------

--
-- Structure de la table `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `ID_GAME` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_GAME` varchar(50) NOT NULL,
  `RELEASE_DATE` date NOT NULL,
  `PIC_GAME` text,
  `SUMMARY_GAME` text,
  PRIMARY KEY (`ID_GAME`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `game`
--

INSERT INTO `game` (`ID_GAME`, `NAME_GAME`, `RELEASE_DATE`, `PIC_GAME`, `SUMMARY_GAME`) VALUES
(1, 'Hatsune Miku Project Diva X', '2016-08-30', 'HatsuneMikuProjectDIVAX.jpg', 'Hatsune Miku : Project Diva X disponible sur PS4, est un jeu d''action/rythme mettant en avant la chanteuse num?rique de renomm?e mondiale, Hatsune Miku. Menez le meilleur show jamais connu avec Miku et ses amis. Afin que l''excitation soit ? son comble, il sera possible de d?bloquer des effets de transformation sp?ciaux.'),
(2, 'Battlefield 1', '2016-10-21', 'battlefield-1-box-art-eede.jpg', 'Nouvel opus pour la c?l?bre franchise de FPS, et apr?s plusieurs ann?es de conflits contemporains, Battlefield 1 plonge les joueurs dans la premi?re Guerre Mondiale. Fid?le ? ses racines, cet ?pisode proposera une campagne solo et un mode multijoueur sur des cartes vari?es et destructibles.'),
(3, 'Shadow Warrior 2', '2016-10-13', '61-h-LjnkpL.jpg', 'Shadow Warrior 2 met en vedette le guerrier imp?tueux Lo Wang, qui doit de nouveau exercer une combinaison d?vastatrice d''armes ? feu, de lames et de magie pour d?truires les l?gions d?moniaques qui ?crasent le monde.'),
(4, 'Mafia III', '2016-10-07', 'mafia-3-deluxe-boxart.jpg', 'Dans la ville de New Bordeaux en 1968, le joueur incarne Lincoln Clay, un v?t?ran de la guerre du Vietnam, qui voit sa famille ''adoptive'' se faire massacrer par la mafia Italienne. Dans ce troisi?me opus de la s?rie Mafia, Lincoln souhaite prendre sa revanche et s''engage dans une guerre brutale contre les Italiens. Le joueur finira par perturber le pouvoir des mafias dans la ville mais ? quel prix? De nombreux choix seront ? sa port?e pour construire son propre empire du crime afin de prendre le dessus contre les autres criminels et assouvir sa vengeance.'),
(5, 'Beatbuddy : Tale of the Guardians', '2013-08-06', 'beat.jpg', 'Beatbuddy : Tale of the Guardians est un jeu d''aventure musical. Le joueur y incarne Beatbuddy, une entit? immortelle partie sauver ses amis du prince Maestro ? travers six niveaux peints ? la main et aux ambiances musicales r?alis?es par des musiciens tels qu''Austin Wintory ou La Rochelle Band.'),
(6, 'Mario Party : Star Rush', '2016-10-07', '885x.jpg', 'Mario Party : Star Rush est un party-game, spin-off de la s?rie des Mario Party, sur 3DS. Vous pourrez jouer avec de nombreux personnages de la license, plus ou moins connus comme Toadette, Harmonie, Wario, Waluigi ... De nombreux amiibos seront ?galement disponible, issus de ce jeu.'),
(7, 'Gears of War 4', '2016-10-11', '91pke15gshl-_sl1500__zpsdesj6r6t.jpg', 'Gears of War 4 est un jeu d''action sur Xbox One. Gears of War 4, qui reprend les acquis de la franchise. L''histoire se d?roulera vingt-cinq ans apr?s les ?v?nements du troisi?me ?pisode. Suite ? l''utilisation du Rayon de l''Aube, tous les carburants fossiles de la plan?te ont ?t? d?truits et l''humanit? court un grave danger. Les quatre types de m?t?o auront un impact important sur le d?roulement des combats. Pendant la forte bise voleront arbres, feuilles, poussi?re et de nombreuses autres choses.'),
(8, 'Final Fantasy XV', '2016-11-29', 'FinalFantasyXV-1.jpg', 'Anciennement nomm? Final Fantasy XIII Versus, Final Fantasy XV est un J-RPG de la c?l?bre s?rie Final Fantasy. Le joueur y incarne Noctis, h?ritier du roi, accompagn? de ses amis, dans un monde moderne, sombre, et fantastique.'),
(9, 'The Legend of Zelda : Breath of the Wild', '2017-03-01', 'zelda_breath_of_the_wild_box_art.webp', 'Annonc? pour 2015, The Legend of Zelda Wii U est un jeu d''aventure qui promet d''?tre diff?rent de ses pr?d?cesseurs et de se rapprocher de l''organisation du premier opus de la s?rie. Celui-ci se d?roulera dans un monde vaste et ouvert avec des donjons sans ordre impos'),
(10, 'Mass Effect Andromeda', '2017-03-21', 'mass-effect-andromeda-cover.jpg', 'Quatri?me opus de la saga du m?me nom, Mass Effect 4 est un jeu de r?le intergalactique reposant sur l''exploration et la gestion des relations entre les peuples. Le joueur pourra en effet d?couvrir un vaste ensemble de plan?tes, et choisir la fa?on dont il traite les gens qu''il rencontre et ses co?quipiers.'),
(11, 'Tekken 7', '2017-01-01', 'tekken_7_cover_art_for_ps4_by_mortal_kombat_xi-da97as3.png', 'Tekken 7 est le septi?me ?pisode de la s?rie de jeux de combat ?ponyme. Cet ?pisode comprend d''anciens personnages de la s?rie, mais ?galement de nouvelles t?tes telles que Katarina, Claudio et d''autres encore...'),
(12, 'The Last Guardian', '2016-12-07', 'CS_SW_BB_PCKFRNT_FRONT_ART_001B_1434429451.jpg', 'The Last Guardian est un jeu d''aventure sur PlayStation 4. Vous incarnez un jeune gar?on qui, dans des ruines anciennes, d?couvre un animal fabuleux. Le titre se concentre sur les relations entre la cr?ature et le gar?on, qui ?volueront en fonction des actions et attentions de ce dernier pour se transformer en v?ritable amiti'),
(13, 'Kingdom Come : Deliverance', '2017-01-01', 'Kingdom_Come_Deliverance_box_art.jpg', 'Jeu en vue ? la premi?re personne, Kingdom Come : Deliverance prend place dans un univers m?di?val tr?s r?aliste et aux d?tails soign?s. Il propose de nombreux ?l?ments qui sont ? la base de tout RPG qui se respecte, ? savoir : syst?mes de craft et de r?putation, combats en PvP, etc.'),
(14, 'Resident Evil VII', '2017-01-24', 'RE7.jpg', 'Resident Evil VII est un survival-horror en vue ? la premi?re personne. Dans un style sombre et glauque qui semble revenir aux racines de la s?rie, ce nouvel ?pisode a ?galement ?t? pens? pour la r?alit? virtuelle.');

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `ID_GENRE` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_GENRE` varchar(35) NOT NULL,
  PRIMARY KEY (`ID_GENRE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `genre`
--

INSERT INTO `genre` (`ID_GENRE`, `NAME_GENRE`) VALUES
(1, 'Rythme'),
(2, 'FPS'),
(3, 'Action'),
(4, 'Aventure'),
(5, 'RPG'),
(6, 'Sport'),
(7, 'TPS'),
(8, 'Party-Game'),
(9, 'Combat'),
(10, 'Survival-Horror');

-- --------------------------------------------------------

--
-- Structure de la table `of_the_genre`
--

DROP TABLE IF EXISTS `of_the_genre`;
CREATE TABLE IF NOT EXISTS `of_the_genre` (
  `ID_GAME` int(11) NOT NULL,
  `ID_GENRE` int(11) NOT NULL,
  PRIMARY KEY (`ID_GAME`,`ID_GENRE`),
  KEY `FK_ARE_OF_THIS_GENRE` (`ID_GENRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `of_the_genre`
--

INSERT INTO `of_the_genre` (`ID_GAME`, `ID_GENRE`) VALUES
(1, 1),
(5, 1),
(2, 2),
(3, 2),
(4, 3),
(5, 3),
(7, 3),
(8, 3),
(9, 3),
(12, 3),
(4, 4),
(5, 4),
(12, 4),
(8, 5),
(9, 5),
(10, 5),
(13, 5),
(4, 7),
(6, 8),
(11, 9),
(14, 10);

-- --------------------------------------------------------

--
-- Structure de la table `on_the_platform`
--

DROP TABLE IF EXISTS `on_the_platform`;
CREATE TABLE IF NOT EXISTS `on_the_platform` (
  `ID_GAME` int(11) NOT NULL,
  `ID_PLATFORM` int(11) NOT NULL,
  PRIMARY KEY (`ID_GAME`,`ID_PLATFORM`),
  KEY `FK_SUPPORTS` (`ID_PLATFORM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `on_the_platform`
--

INSERT INTO `on_the_platform` (`ID_GAME`, `ID_PLATFORM`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(7, 1),
(10, 1),
(11, 1),
(13, 1),
(14, 1),
(2, 2),
(4, 2),
(6, 2),
(8, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(2, 3),
(4, 3),
(6, 3),
(7, 3),
(8, 3),
(10, 3),
(11, 3),
(13, 3),
(14, 3),
(5, 4),
(9, 4),
(1, 5),
(5, 7),
(5, 9),
(11, 10),
(9, 11);

-- --------------------------------------------------------

--
-- Structure de la table `platform`
--

DROP TABLE IF EXISTS `platform`;
CREATE TABLE IF NOT EXISTS `platform` (
  `ID_PLATFORM` int(11) NOT NULL,
  `NAME_PLATFORM` varchar(35) NOT NULL,
  PRIMARY KEY (`ID_PLATFORM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `platform`
--

INSERT INTO `platform` (`ID_PLATFORM`, `NAME_PLATFORM`) VALUES
(1, 'PC'),
(2, 'PS4'),
(3, 'ONE'),
(4, 'WiiU'),
(5, 'VITA'),
(6, '3DS'),
(7, 'Mac'),
(8, 'iOS'),
(9, 'Android'),
(10, 'Arcade'),
(11, 'Nintendo NX');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `develops`
--
ALTER TABLE `develops`
  ADD CONSTRAINT `FK_DEVELOPED` FOREIGN KEY (`ID_DEV`) REFERENCES `developer` (`ID_DEV`),
  ADD CONSTRAINT `FK_DEVELOPED_BY` FOREIGN KEY (`ID_GAME`) REFERENCES `game` (`ID_GAME`);

--
-- Contraintes pour la table `edits`
--
ALTER TABLE `edits`
  ADD CONSTRAINT `FK_EDITS` FOREIGN KEY (`ID_EDITOR`) REFERENCES `editor` (`ID_EDITOR`),
  ADD CONSTRAINT `FK_WAS_EDITED_BY` FOREIGN KEY (`ID_GAME`) REFERENCES `game` (`ID_GAME`);

--
-- Contraintes pour la table `of_the_genre`
--
ALTER TABLE `of_the_genre`
  ADD CONSTRAINT `FK_ARE_OF_THIS_GENRE` FOREIGN KEY (`ID_GENRE`) REFERENCES `genre` (`ID_GENRE`),
  ADD CONSTRAINT `FK_IS_OF_THE_GENRE` FOREIGN KEY (`ID_GAME`) REFERENCES `game` (`ID_GAME`);

--
-- Contraintes pour la table `on_the_platform`
--
ALTER TABLE `on_the_platform`
  ADD CONSTRAINT `FK_SUPPORTED_BY` FOREIGN KEY (`ID_GAME`) REFERENCES `game` (`ID_GAME`),
  ADD CONSTRAINT `FK_SUPPORTS` FOREIGN KEY (`ID_PLATFORM`) REFERENCES `platform` (`ID_PLATFORM`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
