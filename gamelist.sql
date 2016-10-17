/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  17/10/2016 11:16:39                      */
/*==============================================================*/

CREATE DATABASE IF NOT EXISTS `gamecatalog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gamecatalog`;


/*==============================================================*/
/* Table : DEVELOPER                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `DEVELOPPEUR`(
   ID_DEV               int not null AUTO_INCREMENT,
   NAME_DEV             varchar(35),
   primary key (ID_DEV)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : DEVELOPS                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `DEVELOPS`(
   ID_DEV               int not null,
   ID_GAME              int not null,
   primary key (ID_DEV, ID_GAME)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : EDITS                                                */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `EDITS`(
   ID_EDITOR            int not null,
   ID_GAME              int not null,
   primary key (ID_EDITOR, ID_GAME)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : EDITOR                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `EDITOR`(
   ID_EDITOR            int not null,
   NAME_EDITOR          varchar(35),
   primary key (ID_EDITOR)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : GENRE                                                */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `GENRE`(
   ID_GENRE             int not null AUTO_INCREMENT,
   GENRE                varchar(35),
   primary key (ID_GENRE)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : GAME                                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `GAME`(
   ID_GAME              int not null AUTO_INCREMENT,
   NAME_GAME            varchar(50),
   SUMMARY_GAME         text,
   primary key (ID_GAME)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : OF_THE_GENRE                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `OF_THE_GENRE`(
   ID_GAME              int not null,
   ID_GENRE             int not null,
   primary key (ID_GAME, ID_GENRE)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : ON_THE_PLATFORM                                      */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `ON_THE_PLATFORME`(
   ID_GAME              int not null,
   ID_PLATFORM          int not null,
   RELEASE_DATE         date,
   primary key (ID_GAME, ID_PLATFORM)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : PLATFORM                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS `PLATFORM`(
   ID_PLATFORM         int not null,
   NAME_PLATFORM       varchar(35),
   primary key (ID_PLATFORM)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : FK                                                   */
/*==============================================================*/

alter table DEVELOPS add constraint FK_DEVELOPED foreign key (ID_DEV)
      references DEVELOPER (ID_DEV) on delete restrict on update restrict;

alter table DEVELOPS add constraint FK_DEVELOPED_BY foreign key (ID_JEU)
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

INSERT INTO `GAME` (`ID_GAME`, `NAME_GAME`, `SUMMARY_GAME`) VALUES
(1, 'Hatsune Miku Project Diva X', 'Hatsune Miku : Project Diva X disponible sur PS4, est un jeu d\'action/rythme mettant en avant la chanteuse numérique de renommée mondiale, Hatsune Miku. Menez le meilleur show jamais connu avec Miku et ses amis. Afin que l\'excitation soit à son comble, il sera possible de débloquer des effets de transformation spéciaux.' ),
()