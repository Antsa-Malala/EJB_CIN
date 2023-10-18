CREATE DATABASE foncier;
CREATE user foncier WITH PASSWORD 'foncier';
GRANT ALL PRIVILEGES ON DATABASE "foncier" to foncier;
ALTER DATABASE foncier OWNER TO foncier;  

create table typeTany(
    idTypeTany serial primary key,
    typeTany varchar(50)
);
create table tany(
    numCadastre varchar(14) primary key,
    adresseTany varchar(50),
    superficie double precision not null,
    idTypeTany integer,
    foreign key(idTypeTany) references typeTany(idTypeTany)
);

create table proprietaire(
    numCadastre varchar(14),
    cin varchar(12) not null,
    dateAcquisition  date,
    foreign key(numCadastre) references tany(numCadastre)
);
---View
create view propriete as select proprietaire.cin,proprietaire.dateAcquisition,tany.*,typeTany.typetany from proprietaire join tany on tany.numcadastre=proprietaire.numcadastre join typeTany on typeTany.idTypeTany=tany.idTypeTany;

--Insertion de données dans la table typetany
INSERT INTO typeTany VALUES(default,'Residentiel');
INSERT INTO typeTany VALUES(default,'Commercial');
INSERT INTO typeTany VALUES(default,'Agricole');

-- Insertion de données dans la table tany
INSERT INTO tany VALUES
    ( '123ABCRTCDRY67', '123 Rue de la Rose', 500.25, 1),
    ( '456XYZFGTHY678', '456 Avenue du Soleil', 750.75, 2),
    ( '789DEFGJB893LP', '789 Boulevard de la Lune', 300.50, 3);


    
-- Insertion de données dans la table proprietaire
INSERT INTO proprietaire VALUES
    ('123ABCRTCDRY67', '1234567890', '2020-01-15'),
    ('456XYZFGTHY678', '9876543210', '2019-05-20'),
    ('789DEFGJB893LP', '5678901234', '2022-03-10'),
    ('456XYZFGTHY678', '1234567890', '2020-05-20');

