/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  17/10/2016 11:16:39                      */
/*==============================================================*/

/*CREATE DATABASE IF NOT EXISTS `draidia2_gamecatalog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;*/
USE `draidia2_gamecatalog`;


/*==============================================================*/
/* Table : DEVELOPER                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `DEVELOPER`(
   ID_DEV               int(11) not null AUTO_INCREMENT,
   NAME_DEV             varchar(35) not null,
   primary key (ID_DEV)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : DEVELOPS                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `DEVELOPS`(
   ID_GAME               int(11) not null,
   ID_DEV              int(11) not null,
   primary key (ID_GAME, ID_DEV)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : EDITS                                                */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `EDITS`(
   ID_GAME            int(11) not null,
   ID_EDITOR              int(11) not null,
   primary key (ID_GAME, ID_EDITOR)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : EDITOR                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `EDITOR`(
   ID_EDITOR            int(11) not null AUTO_INCREMENT,
   NAME_EDITOR          varchar(35) not null,
   primary key (ID_EDITOR)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : GENRE                                                */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `GENRE`(
   ID_GENRE             int(11) not null AUTO_INCREMENT,
   NAME_GENRE           varchar(35) not null,
   primary key (ID_GENRE)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : GAME                                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `GAME`(
   ID_GAME              int(11) not null AUTO_INCREMENT,
   NAME_GAME            varchar(50) not null,
   RELEASE_DATE         date not null,
   PIC_GAME             text,
   SUMMARY_GAME         text,
   primary key (ID_GAME)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : OF_THE_GENRE                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `OF_THE_GENRE`(
   ID_GAME              int(11) not null,
   ID_GENRE             int(11) not null,
   primary key (ID_GAME, ID_GENRE)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : ON_THE_PLATFORM                                      */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `ON_THE_PLATFORM`(
   ID_GAME              int(11) not null,
   ID_PLATFORM          int(11) not null,
   primary key (ID_GAME, ID_PLATFORM)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : PLATFORM                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `PLATFORM`(
   ID_PLATFORM         int(11) not null AUTO_INCREMENT,
   NAME_PLATFORM       varchar(35) not null,
   primary key (ID_PLATFORM)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : FK                                                   */
/*==============================================================*/

alter table DEVELOPS add constraint FK_DEVELOPED foreign key (ID_DEV)
      references DEVELOPER (ID_DEV) on delete restrict on update restrict;

alter table DEVELOPS add constraint FK_DEVELOPED_BY foreign key (ID_GAME)
      references GAME (ID_GAME) on delete restrict on update restrict;

alter table EDITS add constraint FK_EDITS foreign key (ID_EDITOR)
      references EDITOR (ID_EDITOR) on delete restrict on update restrict;

alter table EDITS add constraint FK_WAS_EDITED_BY foreign key (ID_GAME)
      references GAME (ID_GAME) on delete restrict on update restrict;

alter table OF_THE_GENRE add constraint FK_ARE_OF_THIS_GENRE foreign key (ID_GENRE)
      references GENRE (ID_GENRE) on delete restrict on update restrict;

alter table OF_THE_GENRE add constraint FK_IS_OF_THE_GENRE foreign key (ID_GAME)
      references GAME (ID_GAME) on delete restrict on update restrict;

alter table ON_THE_PLATFORM add constraint FK_SUPPORTED_BY foreign key (ID_GAME)
      references GAME (ID_GAME) on delete restrict on update restrict;

alter table ON_THE_PLATFORM add constraint FK_SUPPORTS foreign key (ID_PLATFORM)
      references PLATFORM (ID_PLATFORM) on delete restrict on update restrict;

/*==============================================================*/
/* Table : INSERTS                                              */
/*==============================================================*/

INSERT INTO `DEVELOPER` (`ID_DEV`, `NAME_DEV`) VALUES
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

INSERT INTO `EDITOR` (`ID_EDITOR`, `NAME_EDITOR`) VALUES
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

INSERT INTO `PLATFORM` (`ID_PLATFORM`, `NAME_PLATFORM`) VALUES
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

INSERT INTO `GENRE` (`ID_GENRE`, `NAME_GENRE`) VALUES
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

INSERT INTO `GAME` (`ID_GAME`, `NAME_GAME`, `RELEASE_DATE`, 'PIC_GAME' `SUMMARY_GAME`) VALUES
(1, 'Hatsune Miku Project Diva X', '2016-08-30', null, 'Hatsune Miku : Project Diva X disponible sur PS4, est un jeu d\'action/rythme mettant en avant la chanteuse numérique de renommée mondiale, Hatsune Miku. Menez le meilleur show jamais connu avec Miku et ses amis. Afin que l\'excitation soit à son comble, il sera possible de débloquer des effets de transformation spéciaux.' ),
(2, 'Battlefield 1', '2016-10-21', null, 'Nouvel opus pour la célèbre franchise de FPS, et après plusieurs années de conflits contemporains, Battlefield 1 plonge les joueurs dans la première Guerre Mondiale. Fidèle à ses racines, cet épisode proposera une campagne solo et un mode multijoueur sur des cartes variées et destructibles.'),
(3, 'Shadow Warrior 2', '2016-10-13', null, 'Shadow Warrior 2 met en vedette le guerrier impétueux Lo Wang, qui doit de nouveau exercer une combinaison dévastatrice d\'armes à feu, de lames et de magie pour détruires les légions démoniaques qui écrasent le monde.'),
(4, 'Mafia III', '2016-10-07', null, 'Dans la ville de New Bordeaux en 1968, le joueur incarne Lincoln Clay, un vétéran de la guerre du Vietnam, qui voit sa famille \'adoptive\' se faire massacrer par la mafia Italienne. Dans ce troisième opus de la série Mafia, Lincoln souhaite prendre sa revanche et s\'engage dans une guerre brutale contre les Italiens. Le joueur finira par perturber le pouvoir des mafias dans la ville mais à quel prix? De nombreux choix seront à sa portée pour construire son propre empire du crime afin de prendre le dessus contre les autres criminels et assouvir sa vengeance.'),
(5, 'Beatbuddy : Tale of the Guardians', '2013-08-06', null, 'Beatbuddy : Tale of the Guardians est un jeu d\'aventure musical. Le joueur y incarne Beatbuddy, une entité immortelle partie sauver ses amis du prince Maestro à travers six niveaux peints à la main et aux ambiances musicales réalisées par des musiciens tels qu\'Austin Wintory ou La Rochelle Band.'),
(6, 'Mario Party : Star Rush', '2016-10-07', null, 'Mario Party : Star Rush est un party-game, spin-off de la série des Mario Party, sur 3DS. Vous pourrez jouer avec de nombreux personnages de la license, plus ou moins connus comme Toadette, Harmonie, Wario, Waluigi ... De nombreux amiibos seront également disponible, issus de ce jeu.'),
(7, 'Gears of War 4', '2016-10-11', null, 'Gears of War 4 est un jeu d\'action sur Xbox One. Gears of War 4, qui reprend les acquis de la franchise. L\'histoire se déroulera vingt-cinq ans après les événements du troisième épisode. Suite à l\'utilisation du Rayon de l\'Aube, tous les carburants fossiles de la planète ont été détruits et l\'humanité court un grave danger. Les quatre types de météo auront un impact important sur le déroulement des combats. Pendant la forte bise voleront arbres, feuilles, poussière et de nombreuses autres choses.'),
(8, 'Final Fantasy XV', '2016-11-29', null 'Anciennement nommé Final Fantasy XIII Versus, Final Fantasy XV est un J-RPG de la célèbre série Final Fantasy. Le joueur y incarne Noctis, héritier du roi, accompagné de ses amis, dans un monde moderne, sombre, et fantastique.'),
(9, 'The Legend of Zelda : Breath of the Wild', '2017-03-01', null, 'Annoncé pour 2015, The Legend of Zelda Wii U est un jeu d\'aventure qui promet d\'être différent de ses prédécesseurs et de se rapprocher de l\'organisation du premier opus de la série. Celui-ci se déroulera dans un monde vaste et ouvert avec des donjons sans ordre imposé.'),
(10, 'Mass Effect Andromeda', '2017-03-21', null, 'Quatrième opus de la saga du même nom, Mass Effect 4 est un jeu de rôle intergalactique reposant sur l\'exploration et la gestion des relations entre les peuples. Le joueur pourra en effet découvrir un vaste ensemble de planètes, et choisir la façon dont il traite les gens qu\'il rencontre et ses coéquipiers.'),
(11, 'Tekken 7', '2017-01-01', null, 'Tekken 7 est le septième épisode de la série de jeux de combat éponyme. Cet épisode comprend d\'anciens personnages de la série, mais également de nouvelles têtes telles que Katarina, Claudio et d\'autres encore...'),
(12, 'The Last Guardian', '2016-12-07', null, 'The Last Guardian est un jeu d\'aventure sur PlayStation 4. Vous incarnez un jeune garçon qui, dans des ruines anciennes, découvre un animal fabuleux. Le titre se concentre sur les relations entre la créature et le garçon, qui évolueront en fonction des actions et attentions de ce dernier pour se transformer en véritable amitié.'),
(13, 'Kingdom Come : Deliverance', '2017-01-01', null, 'Jeu en vue à la première personne, Kingdom Come : Deliverance prend place dans un univers médiéval très réaliste et aux détails soignés. Il propose de nombreux éléments qui sont à la base de tout RPG qui se respecte, à savoir : systèmes de craft et de réputation, combats en PvP, etc.'),
(14, 'Resident Evil VII', '2017-01-24', null, 'Resident Evil VII est un survival-horror en vue à la première personne. Dans un style sombre et glauque qui semble revenir aux racines de la série, ce nouvel épisode a également été pensé pour la réalité virtuelle.');

INSERT INTO `EDITS` (`ID_GAME`, `ID_EDITOR`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 6),
(10, 2),
(11, 9),
(12, 10),
(13, 11),
(14, 13);

INSERT INTO `DEVELOPS` (`ID_GAME`, `ID_DEV`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(4, 5),
(5, 6),
(6, 7),
(7, 8),
(8, 9),
(9, 7),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14);

INSERT INTO `OF_THE_GENRE` (`ID_GAME`, `ID_GENRE`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 3),
(4, 4),
(4, 7),
(5, 1),
(5, 3),
(5, 4),
(6, 8),
(7, 3),
(7, 3),
(8, 3),
(8, 5),
(9, 3),
(9, 5),
(10, 5),
(11, 9),
(12, 3),
(12, 4),
(13, 5),
(14, 10);

INSERT INTO `ON_THE_PLATFORM` (`ID_GAME`, `ID_PLATFORM`) VALUES
(1, 1),
(1, 5),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(4, 1),
(4, 2),
(4, 3),
(5, 1),
(5, 4),
(5, 7),
(5, 9),
(6, 2),
(6, 3),
(7, 1),
(7, 3),
(8, 2),
(8, 3),
(9, 4),
(9, 11),
(10, 1),
(10, 2),
(10, 3),
(11, 1),
(11, 2),
(11, 3),
(11, 10),
(12, 2),
(13, 1),
(13, 2),
(13, 3),
(14, 1),
(14, 2),
(14, 3);

