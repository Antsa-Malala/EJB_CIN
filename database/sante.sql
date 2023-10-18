CREATE TABLE Personne(
    cin varchar(12) primary key,
    nom varchar(100),
    prenom varchar(100),
    sexe int,
    dateNaissance datetime,
    contact varchar(30),
    adresse varchar(50)
);

CREATE TABLE poids(
    cin varchar(12),
    poids double precision,
    dateControl datetime,
    foreign key(cin) references personne(cin)
);

CREATE TABLE Taille(
    cin varchar(12),
    taille double precision,
    dateControl datetime,
    foreign key(cin) references personne(cin)
);

CREATE TABLE Docteur(
    idDocteur varchar(7) primary key,
    nom varchar(100),
    prenom varchar(100),
    titre varchar(100),
    contact varchar(30)
);

CREATE TABLE Hopital(
    idHopital int identity(1,1) primary key,
    nom varchar(50),
    adresse varchar(50)
);

CREATE TABLE Antecedent(
    cin varchar(12),
    descriptions varchar(200),
    organe varchar(100),
    dateOperation datetime,
    idHopital integer,
    idDocteur varchar(7),
    foreign key(cin) references personne(cin),
    foreign key(idDocteur) references Docteur(idDocteur),
    foreign key(idHopital) references Hopital(idHopital)
);

CREATE TABLE Allergie(
    idAllergie int IDENTITY(1,1) PRIMARY KEY,
    allergie varchar(50)
);

CREATE TABLE Allergique(
    cin varchar(12),
    idAllergie integer,
    foreign key(cin) references personne(cin),
    foreign key(idAllergie) references allergie(idAllergie)
);

CREATE TABLE Maladie(
    idMaladie int IDENTITY(1,1) PRIMARY KEY,
    nom varchar(100),
    hereditaire integer 
);

CREATE TABLE MaladiePersonne(
    cin varchar(12),
    idMaladie int,
    dateDecouverte datetime,
    foreign key(cin) references personne(cin),
    foreign key(idMaladie) references Maladie(idMaladie)
);

CREATE TABLE Devise(
    idDevise int IDENTITY(1,1) PRIMARY key,
    nomDevise varchar(30),
);
CREATE TABLE DeviseVente(
    idDevise int IDENTITY(1,1) PRIMARY key,
    nomDevise varchar(30),
);
CREATE TABLE cout(
    idDevise int,
    valeur double precision,
    dateDevise datetime
    foreign key(idDevise) references Devise(idDevise)
);

CREATE TABLE coutVente(
    idDevise int,
    valeur double precision,
    dateDevise datetime
    foreign key(idDevise) references DeviseVente(idDevise)
);

create view CoutDevise as select cout.*,devise.nomDevise from cout join devise on devise.idDevise=cout.iddevise;
create view CoutDeviseVente as select coutVente.*,deviseVente.nomDevise from coutVente join deviseVente on deviseVente.idDevise=coutVente.iddevise;