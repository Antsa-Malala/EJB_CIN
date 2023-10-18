-- Insérer des données dans la table Personne
INSERT INTO Personne (cin, nom, prenom, sexe, dateNaissance, contact, adresse)
VALUES
    ('1234567890', 'Doe', 'John', 1, '1990-01-15 00:00:00', 'john.doe@example.com', '123 Main Street'),
    ('9876543210', 'Smith', 'Jane', 2, '1995-03-20 00:00:00', 'jane.smith@example.com', '456 Elm Avenue'),
    ('5678901234', 'Johnson', 'Robert', 1, '1985-07-10 00:00:00', 'robert.johnson@example.com', '789 Oak Lane');

-- Insérer des données dans la table poids
INSERT INTO poids (cin, poids, dateControl)
VALUES
    ('1234567890', 75.5, '2023-01-10 08:00:00'),
    ('9876543210', 65.2, '2023-01-12 09:30:00'),
    ('5678901234', 80.0, '2023-01-15 07:45:00'),
    ('1234567890', 74.8, '2023-01-20 08:30:00'),
    ('9876543210', 66.0, '2023-01-22 09:15:00');

-- Insérer des données dans la table Taille
INSERT INTO Taille (cin, taille, dateControl)
VALUES
    ('1234567890', 175.0, '2023-01-10 08:00:00'),
    ('9876543210', 162.5, '2023-01-12 09:30:00'),
    ('5678901234', 180.2, '2023-01-15 07:45:00'),
    ('1234567890', 175.3, '2023-01-20 08:30:00'),
    ('9876543210', 163.0, '2023-01-22 09:15:00');
-- Insérer des données dans la table Docteur
INSERT INTO Docteur (idDocteur, nom, prenom, titre, contact)
VALUES
    ('DOCT001', 'Smith', 'John', 'Médecin généraliste', 'john.smith@example.com'),
    ('DOCT002', 'Johnson', 'Sarah', 'Cardiologue', 'sarah.johnson@example.com'),
    ('DOCT003', 'Davis', 'Michael', 'Dermatologue', 'michael.davis@example.com');

-- Insérer des données dans la table Hopital
INSERT INTO Hopital (nom, adresse)
VALUES
    ('Hopital Central', '123 Main Street'),
    ('Hopital Saint-Louis', '456 Elm Avenue'),
    ('Hopital Saint-Jean', '789 Oak Lane');
-- Insérer des données dans la table Antecedent
INSERT INTO Antecedent (cin, descriptions, organe, dateOperation, idHopital, idDocteur)
VALUES
    ('1234567890', 'Appendicite aiguë', 'Abdomen', '2022-05-15 10:00:00', 1, 'DOCT001'),
    ('9876543210', 'Hypertension artérielle', 'Cœur', '2021-08-20 14:30:00', 2, 'DOCT002'),
    ('5678901234', 'Fracture de la jambe', 'Jambe', '2020-03-10 11:15:00', 3, 'DOCT003'),
    ('1234567890', 'Chirurgie du genou', 'Genou', '2019-11-05 09:45:00', 2, 'DOCT002'),
    ('9876543210', 'Appendicite aiguë', 'Abdomen', '2018-07-02 16:20:00', 1, 'DOCT001');
-- Insérer des données dans la table Allergie
INSERT INTO Allergie (allergie)
VALUES
    ('Aspirine'),
    ('Pénicilline'),
    ('Pénicilline'),
    ('Paracétamol'),
    ('Morphine');

-- Insérer des données dans la table Allergique
INSERT INTO Allergique (cin, idAllergie)
VALUES
    ('1234567890', 1),
    ('1234567890', 3),
    ('9876543210', 2),
    ('5678901234', 4),
    ('5678901234', 5),
    ('9876543210', 1);
-- Insérer des données dans la table Maladie
INSERT INTO Maladie (nom, hereditaire)
VALUES
    ('Diabète de type 2', 1),
    ('Asthme', 0),
    ('Hypertension artérielle', 1),
    ('Cancer du sein', 1),
    ('Maladie de Crohn', 0);

-- Insérer des données dans la table MaladiePersonne
INSERT INTO MaladiePersonne (cin, idMaladie, dateDecouverte)
VALUES
    ('1234567890', 1, '2022-03-10 09:30:00'),
    ('9876543210', 2, '2021-06-15 14:45:00'),
    ('5678901234', 3, '2020-08-20 11:00:00'),
    ('1234567890', 4, '2023-01-05 08:15:00'),
    ('9876543210', 5, '2019-11-30 16:30:00'),
    ('5678901234', 1, '2022-02-12 10:20:00');

-- Insérer des données de test dans la table Devise
INSERT INTO Devise (nomDevise)
VALUES ('Ariary'),
       ('USD'),
       ('Euro');
       ('Yen japonais'),
       ('Dollar canadien'),
       ('Dollar américain');

INSERT INTO DeviseVente (nomDevise)
VALUES ('Ariary'),
       ('USD'),
       ('Euro');
       ('Yen japonais'),
       ('Dollar canadien'),
       ('Dollar américain');

-- Insérer des données de test dans la table cout avec la clé étrangère correcte

-- Pour le Dollar américain (idDevise = 1)
INSERT INTO cout (idDevise, valeur, dateDevise)
VALUES (1, 1, '1990-10-16 08:00:00');


-- Pour l'Euro (idDevise = 2)
INSERT INTO cout (idDevise, valeur, dateDevise)
VALUES (2, 850.0, '2023-10-16 08:00:00'),
       (2, 875.0, '2023-10-16 12:00:00'),
       (2, 860.0, '2023-10-17 08:00:00');

-- Pour la Livre sterling (idDevise = 3)
INSERT INTO cout (idDevise, valeur, dateDevise)
VALUES (3, 750.0, '2023-10-16 08:00:00'),
       (3, 780.0, '2023-10-16 12:00:00'),
       (3, 760.0, '2023-10-17 08:00:00');

-- Pour le Yen japonais (idDevise = 4)
INSERT INTO cout (idDevise, valeur, dateDevise)
VALUES (4, 110000.0, '2023-10-16 08:00:00'),
       (4, 109500.0, '2023-10-16 12:00:00'),
       (4, 109800.0, '2023-10-17 08:00:00');

-- Pour le Dollar canadien (idDevise = 5)
INSERT INTO cout (idDevise, valeur, dateDevise)
VALUES (5, 1250.0, '2023-10-16 08:00:00'),
       (5, 1260.0, '2023-10-16 12:00:00'),
       (5, 1265.0, '2023-10-17 08:00:00');


INSERT INTO cout (idDevise, valeur, dateDevise)
VALUES (6, 1000.0, '2023-10-16 08:00:00'),
       (6, 1050.0, '2023-10-16 12:00:00'),
       (6, 1025.0, '2023-10-17 08:00:00');


       
INSERT INTO coutVente (idDevise, valeur, dateDevise)
VALUES (1, 1, '1990-10-16 08:00:00');


-- Pour l'Euro (idDevise = 2)
INSERT INTO coutVente (idDevise, valeur, dateDevise)
VALUES (2, 50.0, '2023-10-16 08:00:00'),
       (2, 75.0, '2023-10-16 12:00:00'),
       (2, 60.0, '2023-10-17 08:00:00');

-- Pour la Livre sterling (idDevise = 3)
INSERT INTO coutVente (idDevise, valeur, dateDevise)
VALUES (3, 50.0, '2023-10-16 08:00:00'),
       (3, 80.0, '2023-10-16 12:00:00'),
       (3, 60.0, '2023-10-17 08:00:00');

-- Pour le Yen japonais (idDevise = 4)
INSERT INTO coutVente (idDevise, valeur, dateDevise)
VALUES (5, 10000.0, '2023-10-16 08:00:00'),
       (5, 19500.0, '2023-10-16 12:00:00'),
       (5, 09800.0, '2023-10-17 08:00:00');

-- Pour le Dollar canadien (idDevise = 5)
INSERT INTO coutVente (idDevise, valeur, dateDevise)
VALUES (6, 150.0, '2023-10-16 08:00:00'),
       (6, 160.0, '2023-10-16 12:00:00'),
       (6, 165.0, '2023-10-17 08:00:00');


INSERT INTO coutVente (idDevise, valeur, dateDevise)
VALUES (7, 100.0, '2023-10-16 08:00:00'),
       (7, 150.0, '2023-10-16 12:00:00'),
       (7, 125.0, '2023-10-17 08:00:00');