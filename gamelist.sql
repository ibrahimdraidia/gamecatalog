/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  17/10/2016 11:16:39                      */
/*==============================================================*/

CREATE DATABASE IF NOT EXISTS `draidia2_gamecatalog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
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
   ID_DEV               int(11) not null,
   ID_GAME              int(11) not null,
   primary key (ID_DEV, ID_GAME)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : EDITS                                                */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `EDITS`(
   ID_EDITOR            int(11) not null,
   ID_GAME              int(11) not null,
   primary key (ID_EDITOR, ID_GAME)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : EDITOR                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `EDITOR`(
   ID_EDITOR            int(11) not null,
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
   RELEASE_DATE         date not null,
   primary key (ID_GAME, ID_PLATFORM)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : PLATFORM                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `PLATFORM`(
   ID_PLATFORM         int(11) not null,
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

INSERT INTO `GAME` (`ID_GAME`, `NAME_GAME`, `SUMMARY_GAME`) VALUES
(1, 'Hatsune Miku Project Diva X', 'Hatsune Miku : Project Diva X disponible sur PS4, est un jeu d\'action/rythme mettant en avant la chanteuse num�rique de renomm�e mondiale, Hatsune Miku. Menez le meilleur show jamais connu avec Miku et ses amis. Afin que l\'excitation soit � son comble, il sera possible de d�bloquer des effets de transformation sp�ciaux.' ),
(2, 'Battlefield 1', 'Nouvel opus pour la c�l�bre franchise de FPS, et apr�s plusieurs ann�es de conflits contemporains, Battlefield 1 plonge les joueurs dans la premi�re Guerre Mondiale. Fid�le � ses racines, cet �pisode proposera une campagne solo et un mode multijoueur sur des cartes vari�es et destructibles.'),
(3, 'Shadow Warrior 2', 'Shadow Warrior 2 met en vedette le guerrier imp�tueux Lo Wang, qui doit de nouveau exercer une combinaison d�vastatrice d\'armes � feu, de lames et de magie pour d�truires les l�gions d�moniaques qui �crasent le monde.'),
(4, 'Mafia III', 'Dans la ville de New Bordeaux en 1968, le joueur incarne Lincoln Clay, un v�t�ran de la guerre du Vietnam, qui voit sa famille \'adoptive\' se faire massacrer par la mafia Italienne. Dans ce troisi�me opus de la s�rie Mafia, Lincoln souhaite prendre sa revanche et s\'engage dans une guerre brutale contre les Italiens. Le joueur finira par perturber le pouvoir des mafias dans la ville mais � quel prix? De nombreux choix seront � sa port�e pour construire son propre empire du crime afin de prendre le dessus contre les autres criminels et assouvir sa vengeance.'),
(5, 'Beatbuddy : Tale of the Guardians', 'Beatbuddy : Tale of the Guardians est un jeu d\'aventure musical. Le joueur y incarne Beatbuddy, une entit� immortelle partie sauver ses amis du prince Maestro � travers six niveaux peints � la main et aux ambiances musicales r�alis�es par des musiciens tels qu\'Austin Wintory ou La Rochelle Band.'),
(6, 'Mario Party : Star Rush', 'Mario Party : Star Rush est un party-game, spin-off de la s�rie des Mario Party, sur 3DS. Vous pourrez jouer avec de nombreux personnages de la license, plus ou moins connus comme Toadette, Harmonie, Wario, Waluigi ... De nombreux amiibos seront �galement disponible, issus de ce jeu.'),
(7, 'Gears of War 4', 'Gears of War 4 est un jeu d\'action sur Xbox One. Gears of War 4, qui reprend les acquis de la franchise. L\'histoire se d�roulera vingt-cinq ans apr�s les �v�nements du troisi�me �pisode. Suite � l\'utilisation du Rayon de l\'Aube, tous les carburants fossiles de la plan�te ont �t� d�truits et l\'humanit� court un grave danger. Les quatre types de m�t�o auront un impact important sur le d�roulement des combats. Pendant la forte bise voleront arbres, feuilles, poussi�re et de nombreuses autres choses.'),
(8, 'Final Fantasy XV', 'Anciennement nomm� Final Fantasy XIII Versus, Final Fantasy XV est un J-RPG de la c�l�bre s�rie Final Fantasy. Le joueur y incarne Noctis, h�ritier du roi, accompagn� de ses amis, dans un monde moderne, sombre, et fantastique.'),
(9, 'The Legend of Zelda : Breath of the Wild', 'Annonc� pour 2015, The Legend of Zelda Wii U est un jeu d\'aventure qui promet d\'�tre diff�rent de ses pr�d�cesseurs et de se rapprocher de l\'organisation du premier opus de la s�rie. Celui-ci se d�roulera dans un monde vaste et ouvert avec des donjons sans ordre impos�.'),
(10, 'Mass Effect Andromeda', 'Quatri�me opus de la saga du m�me nom, Mass Effect 4 est un jeu de r�le intergalactique reposant sur l\'exploration et la gestion des relations entre les peuples. Le joueur pourra en effet d�couvrir un vaste ensemble de plan�tes, et choisir la fa�on dont il traite les gens qu\'il rencontre et ses co�quipiers.'),
(11, 'Tekken 7', 'Tekken 7 est le septi�me �pisode de la s�rie de jeux de combat �ponyme. Cet �pisode comprend d\'anciens personnages de la s�rie, mais �galement de nouvelles t�tes telles que Katarina, Claudio et d\'autres encore...'),
(12, 'The Last Guardian', 'The Last Guardian est un jeu d\'aventure sur PlayStation 4. Vous incarnez un jeune gar�on qui, dans des ruines anciennes, d�couvre un animal fabuleux. Le titre se concentre sur les relations entre la cr�ature et le gar�on, qui �volueront en fonction des actions et attentions de ce dernier pour se transformer en v�ritable amiti�.'),
(13, 'Kingdom Come : Deliverance', 'Jeu en vue � la premi�re personne, Kingdom Come : Deliverance prend place dans un univers m�di�val tr�s r�aliste et aux d�tails soign�s. Il propose de nombreux �l�ments qui sont � la base de tout RPG qui se respecte, � savoir : syst�mes de craft et de r�putation, combats en PvP, etc.'),
(14, 'Resident Evil VII', 'Resident Evil VII est un survival-horror en vue � la premi�re personne. Dans un style sombre et glauque qui semble revenir aux racines de la s�rie, ce nouvel �pisode a �galement �t� pens� pour la r�alit� virtuelle.');

