    drop user banque cascade;
    create user banque identified by banque;
    grant dba to banque;
    alter user banque account unlock;
    connect banque/banque;
    
    CREATE sequence seqBanque start with 1;
    CREATE FUNCTION getSeqBanque RETURN number IS sequence number;
    BEGIN
    sequence := seqBanque.NEXTVAL;
    RETURN sequence;
    END;
    /
    CREATE sequence seqCompte start with 1;
    CREATE FUNCTION getSeqCompte RETURN number IS sequence number;
    BEGIN
    sequence := seqCompte.NEXTVAL;
    RETURN sequence;
    END;
    /
    CREATE sequence seqTransaction start with 1;
    CREATE FUNCTION getSeqTransaction RETURN number IS sequence number;
    BEGIN
    sequence := seqTransaction.NEXTVAL;
    RETURN sequence;
    END;
    /

    CREATE sequence seqTransfert start with 1;
    CREATE FUNCTION getSeqTransfert RETURN number IS sequence number;
    BEGIN
    sequence := seqTransfert.NEXTVAL;
    RETURN sequence;
    END;
    /

    CREATE sequence seqTypeTransaction start with 1;
    CREATE sequence seqTypeBanque start with 1;
    CREATE sequence seqTypeCompte start with 1;


    CREATE TABLE typeBanque(
        idTypeBanque number primary key,
        typeBanque varchar(50)
    );

    CREATE TABLE Banque(
        idBanque varchar(7) primary key,
        nomBanque varchar(50),
        adresseBanque varchar(50),
        contactBanque varchar(50),
        idTypeBanque number,
        foreign key(idTypeBanque) references typeBanque(idTypeBanque)
    );

    CREATE TABLE typeCompte(
        idTypeCompte number primary key,
        typeCompte varchar(50)
    );

    CREATE TABLE Compte(
        numCompte VARCHAR(11) primary key,
        cin VARCHAR(12) not null,
        idBanque varchar(7),
        idTypeCompte number,
        dateCreation date,
        foreign key(idBanque) references banque(idBanque),
        foreign key(idTypeCompte) references typeCompte(idTypeCompte)
    );

    CREATE TABLE typeTransaction(
        idTypeTransaction number primary key,
        typeTransaction varchar(50)
    );

    CREATE TABLE Transactions(
        idTransaction varchar(7) primary key,
        numCompte varchar(11),
        idBanque varchar(7),
        idTypeTransaction number,
        montant double precision,
        dateTransaction timestamp,
        foreign key(numCompte) references Compte(numCompte),
        foreign key(idBanque) references Banque(idBanque),
        foreign key(idTypeTransaction) references typeTransaction(idTypeTransaction)
    );

    CREATE TABLE Transfert(
        idTransfert varchar(7) primary key,
        idTransaction1 varchar(7),
        idTransaction2 varchar(7),
        idDevise int
    );

    CREATE OR REPLACE TRIGGER TypeBanqueTrigger
    BEFORE INSERT ON typeBanque
    FOR EACH ROW
    BEGIN
        SELECT seqTypeBanque.NEXTVAL
        INTO :NEW.idTypeBanque
        FROM dual;
    END;
    /

    CREATE OR REPLACE TRIGGER TypeCompteTrigger
    BEFORE INSERT ON typeCompte
    FOR EACH ROW
    BEGIN
        SELECT seqTypeCompte.NEXTVAL
        INTO :NEW.idTypeCompte
        FROM dual;
    END;
    /

    CREATE OR REPLACE TRIGGER TypeTransactionTrigger
    BEFORE INSERT ON typeTransaction
    FOR EACH ROW
    BEGIN
        SELECT seqTypeTransaction.NEXTVAL
        INTO :NEW.idTypeTransaction
        FROM dual;
    END;
    /

-- Insertion de données dans la table typeBanque
INSERT INTO typeBanque(typeBanque) VALUES('Banque de detail');
INSERT INTO typeBanque(typeBanque) VALUES('Banque en ligne');
INSERT INTO typeBanque(typeBanque) VALUES('Banque cooperative');
INSERT INTO typeBanque(typeBanque) VALUES('Banque universelle');
INSERT INTO typeBanque(typeBanque) VALUES('Banque de credit');
INSERT INTO typeBanque(typeBanque) VALUES('Banque regionale');
INSERT INTO typeBanque(typeBanque) VALUES('Banque privee');

-- Insertion de données dans la table Banque
INSERT INTO Banque VALUES('BANQ001', 'BOA', '123 Rue de la Finance', 'contactA@banqueA.com',1);
INSERT INTO Banque VALUES('BANQ002', 'BNI', '456 Avenue des Investissements', 'contactB@banqueB.com',5);
INSERT INTO Banque VALUES('BANQ003', 'BFV', '789 Boulevard de la Bourse', 'contactC@banqueC.com',3);
INSERT INTO Banque VALUES('BANQ004', 'Acces Banque', '789 Boulevard de Tokyo', 'contactC@banqueD.com',3);

--Insertion de données dans la table typeCompte
INSERT INTO typeCompte(typeCompte) VALUES('Compte courant');
INSERT INTO typeCompte(typeCompte) VALUES('Compte epargne');
INSERT INTO typeCompte(typeCompte) VALUES('Compte cheques');
INSERT INTO typeCompte(typeCompte) VALUES('Compte de depot a terme');
INSERT INTO typeCompte(typeCompte) VALUES('Compte entreprise');

-- Insertion de données dans la table Compte
INSERT INTO Compte VALUES( '12345678901','1234567890', 'BANQ001',1, TO_DATE('2022-01-15','yyyy-mm-dd'));
INSERT INTO Compte VALUES( '98765432109','9876543210', 'BANQ002',2, TO_DATE('2021-05-20','yyyy-mm-dd'));
INSERT INTO Compte VALUES( '56789012345','5678901234', 'BANQ003',3, TO_DATE('2023-03-10','yyyy-mm-dd'));
INSERT INTO Compte VALUES( '56789012356','5678901234', 'BANQ002',1, TO_DATE('2023-04-04','yyyy-mm-dd'));
INSERT INTO Compte VALUES( '56459012356','1234567890', 'BANQ002',1, TO_DATE('2023-01-04','yyyy-mm-dd'));
--Insertion de données dans la table typeTransaction
INSERT INTO typeTransaction(typeTransaction) VALUES('Retrait');
INSERT INTO typeTransaction(typeTransaction) VALUES('Depot');
INSERT INTO typeTransaction(typeTransaction) VALUES('Virement');
INSERT INTO typeTransaction(typeTransaction) VALUES('Paiement par carte de credit');
INSERT INTO typeTransaction(typeTransaction) VALUES('Paiement de facture');
INSERT INTO typeTransaction(typeTransaction) VALUES('Envoie');
INSERT INTO typeTransaction(typeTransaction) VALUES('Recu');

-- Insertion de données dans la table Transaction
INSERT INTO Transactions VALUES ('TRNS001', '12345678901', 'BANQ001',2, 1000.50,TO_TIMESTAMP('2023-10-03 14:30:02','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS002', '56789012345', 'BANQ002',2, 500.75,TO_TIMESTAMP('2023-08-02 10:45:00','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS003', '12345678901', 'BANQ001',1, 750.00,TO_TIMESTAMP('2023-01-04 20:31:04','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS004', '98765432109', 'BANQ003',2, 300.25,TO_TIMESTAMP('2022-12-28 20:00:04','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS005', '12345678901', 'BANQ001',2, 70.00,TO_TIMESTAMP('2023-11-01 20:31:04','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS006', '56459012356', 'BANQ002',2, 30.00,TO_TIMESTAMP('2023-10-02 20:31:04','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS007', '56459012356', 'BANQ002',2, 30.00,TO_TIMESTAMP('2023-09-06 20:31:04','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO Transactions VALUES ('TRNS008', '12345678901', 'BANQ001',6, 50,TO_TIMESTAMP('2023-11-03 14:30:02','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS009', '56789012345', 'BANQ002',7, 50,TO_TIMESTAMP('2023-11-03 14:30:02','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO Transactions VALUES ('TRNS010', '12345678901', 'BANQ001',7, 50,TO_TIMESTAMP('2023-01-04 20:31:04','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Transactions VALUES ('TRNS011', '98765432109', 'BANQ003',6, 50,TO_TIMESTAMP('2023-01-04 20:31:04','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO Transfert VALUES ('TRNF001','TRNS008','TRNS009',1);
INSERT INTO Transfert VALUES ('TRNF002','TRNS008','TRNS009',3);
create view banky as  select banque.*,typebanque.typebanque from banque join typeBanque on typebanque.idtypebanque=banque.idtypebanque;
create view kaonty as  select compte.*,typecompte.typecompte from compte join typecompte on typecompte.idtypecompte=compte.idtypecompte;
create view transacts as  select transactions.*,typeTransaction.typeTransaction from transactions join typeTransaction on typeTransaction.idtypeTransaction=transactions.idtypeTransaction;