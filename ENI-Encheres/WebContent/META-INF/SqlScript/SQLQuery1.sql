-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--

DROP TABLE ENCHERES
DROP TABLE RETRAITS
DROP TABLE ARTICLES_VENDUS
DROP TABLE CATEGORIES
DROP TABLE UTILISATEURS

-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--



CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)

ALTER TABLE CATEGORIES ADD constraint categorie_pk PRIMARY KEY (no_categorie)

CREATE TABLE ENCHERES (
	no_enchere       INTEGER IDENTITY(1,1) NOT NULL,
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
    date_enchere     datetime NOT NULL,
	montant_enchere  INTEGER NOT NULL

)

ALTER TABLE ENCHERES ADD constraint enchere_pk PRIMARY KEY (no_enchere)

CREATE TABLE RETRAITS (
	no_article         INTEGER NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL
)

ALTER TABLE RETRAITS ADD constraint retrait_pk PRIMARY KEY  (no_article)

CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(20) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL
)

ALTER TABLE UTILISATEURS ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)


CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL
)

ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT article_vendus_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE RETRAITS
    ADD CONSTRAINT retraits_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( no_utilisateur )
        REFERENCES utilisateurs ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

INSERT INTO CATEGORIES([libelle]) VALUES('Informatique'),('Ameublement'),('Vêtement'),('Sports & Loisirs');

INSERT INTO UTILISATEURS([pseudo],[nom],[prenom],[email],[telephone],[rue], [code_postal],[ville],[mot_de_passe],[credit],[administrateur]) 
VALUES('admin','Rob','Rollin','rb.rollin@homail.com','0656235964','5 rue dicard','44225','landérion','admin', 1000, 1)
INSERT INTO UTILISATEURS([pseudo],[nom],[prenom],[email],[telephone],[rue], [code_postal],[ville],[mot_de_passe],[credit],[administrateur]) 
VALUES('admin2','Stark','Statin','Stark.St@homail.com','0656888864','5 rue doulur','56100','lorient','admin2', 1000, 1)
INSERT INTO UTILISATEURS([pseudo],[nom],[prenom],[email],[telephone],[rue], [code_postal],[ville],[mot_de_passe],[credit],[administrateur]) 
VALUES('user1','Gnar','Val','Gnar.Val@homail.com','0666884598','5 rue guichard','00000','Ville belle','user1', 1, '0')
INSERT INTO UTILISATEURS([pseudo],[nom],[prenom],[email],[telephone],[rue], [code_postal],[ville],[mot_de_passe],[credit],[administrateur]) 
VALUES('user2','Ab','Saly','Ab.Saly@homail.com','0789568235','5 rue du port','00000','locmiquélic','user2', 1, '0')

INSERT INTO ARTICLES_VENDUS(nom_article, [description], date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie)
values ('pc bureau', ' Pc bureau intel pentium quadcore', '2019-01-01', '2019-02-01', 100, 3, 1)
INSERT INTO ARTICLES_VENDUS(nom_article, [description], date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie)
values ('Balançoire', 'Petite balançoire en bois', '2019-05-22', '2019-06-20', 25, 4, 4)
INSERT INTO ARTICLES_VENDUS(nom_article, [description], date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)
values ('Meuble télé', 'Meuble télé 1300 AC', '2019-04-01', '2019-04-05', 25, 600, 4, 4)

INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere)
values (1, 1, '2019-01-01', 50)
INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere)
values (2, 1, '2019-01-07', 100)   
INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere)
values (1, 1, '2019-01-09', 150)   
INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere)
values (2, 1, '2019-01-14', 300)

INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere)
values (3, 2, '2019-05-22', 50)
INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere)
values (4, 2, '2019-05-28', 100)   


INSERT INTO RETRAITS(no_article, rue, code_postal, ville)
values (1, '5 rue doulur', '56100', 'lorient')
INSERT INTO RETRAITS(no_article, rue, code_postal, ville)
values (2, '5 rue du port', '00000', 'locmiquélic')    
    