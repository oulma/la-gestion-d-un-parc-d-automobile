/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     3/17/2021 8:54:07 PM                         */
/*==============================================================*/


drop table if exists FraisParking;

drop table if exists ListeNoire;

drop table if exists Parking;

drop table if exists Reservation;

drop table if exists Utilisateur;

drop table if exists Voiture;

/*==============================================================*/
/* Table: FraisParking                                          */
/*==============================================================*/
create table FraisParking
(
   idFrais              int not null,
   prix                 numeric(8,0),
   primary key (idFrais)
);

/*==============================================================*/
/* Table: ListeNoire                                            */
/*==============================================================*/
create table ListeNoire
(
   type                 int not null,
   description          varchar(254),
   primary key (type)
);

/*==============================================================*/
/* Table: Parking                                               */
/*==============================================================*/
create table Parking
(
   idPark               int not null,
   idUtilisateur        int,
   seriePark            varchar(254),
   placePark            int,
   primary key (idPark)
);

/*==============================================================*/
/* Table: Reservation                                           */
/*==============================================================*/
create table Reservation
(
   idR                  int not null,
   idUtilisateur        int,
   nomR                 varchar(254),
   matricule_r          varchar(254),
   dateEntre            datetime,
   dateSortie           datetime,
   primary key (idR)
);

/*==============================================================*/
/* Table: Utilisateur                                           */
/*==============================================================*/
create table Utilisateur
(
   idUtilisateur        int not null,
   serieU               varchar(254),
   nomU                 varchar(254),
   motPasse             varchar(254),
   email                varchar(254),
   primary key (idUtilisateur)
);

/*==============================================================*/
/* Table: Voiture                                               */
/*==============================================================*/
create table Voiture
(
   type                 int not null,
   idV                  int not null,
   idPark               int,
   idUtilisateur        int,
   idFrais              int,
   matricule            int not null,
   dateEntrer           datetime,
   dateSortie2          datetime,
   primary key (type, idV)
);

alter table Parking add constraint FK_association6 foreign key (idUtilisateur)
      references Utilisateur (idUtilisateur) on delete restrict on update restrict;

alter table Reservation add constraint FK_association3 foreign key (idUtilisateur)
      references Utilisateur (idUtilisateur) on delete restrict on update restrict;

alter table Voiture add constraint FK_association1 foreign key (idPark)
      references Parking (idPark) on delete restrict on update restrict;

alter table Voiture add constraint FK_association2 foreign key (idUtilisateur)
      references Utilisateur (idUtilisateur) on delete restrict on update restrict;

alter table Voiture add constraint FK_association5 foreign key (type)
      references ListeNoire (type) on delete restrict on update restrict;

alter table Voiture add constraint FK_association7 foreign key (idFrais)
      references FraisParking (idFrais) on delete restrict on update restrict;

