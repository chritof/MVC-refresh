CREATE TABLE emne (
                      kode CHAR(6) PRIMARY KEY, -- f.eks. 'DAT100'
                      navn VARCHAR, -- f.eks. 'Grunnleggende programmering'
                      studiepoeng INTEGER, -- f.eks. 10
                      semester CHAR(1), -- 'v'|'h'|'b' for vår, høst eller begge
                      type CHAR(1), -- 'o'|'v' for obligatorisk eller valgfag
                      antall INTEGER -- antall interesserte
);

INSERT INTO emne (kode, navn, studiepoeng, semester, type, antall) VALUES
                                                                       ('DAT100', 'Grunnleggende programmering', 10, 'h', 'o', 120),
                                                                       ('DAT101', 'Videregående programmering', 10, 'v', 'o', 95),
                                                                       ('DAT102', 'Datastrukturer og algoritmer', 10, 'h', 'o', 110),
                                                                       ('DAT103', 'Operativsystemer', 10, 'v', 'o', 85),
                                                                       ('DAT104', 'Webutvikling', 10, 'h', 'v', 40),
                                                                       ('DAT105', 'Databaser', 10, 'v', 'o', 130),
                                                                       ('DAT200', 'Big Data Introduksjon', 10, 'h', 'v', 35),
                                                                       ('DAT201', 'Maskinlæring', 10, 'v', 'v', 50),
                                                                       ('DAT202', 'Datasikkerhet', 10, 'h', 'o', 90),
                                                                       ('DAT203', 'Cloud Computing', 10, 'b', 'v', 25),
                                                                       ('MAT100', 'Diskret matematikk', 10, 'h', 'o', 150),
                                                                       ('MAT110', 'Statistikk', 10, 'v', 'o', 140),
                                                                       ('INF150', 'Introduksjon til AI', 10, 'b', 'v', 60),
                                                                       ('INF200', 'Programvarearkitektur', 10, 'h', 'o', 70),
                                                                       ('INF250', 'Mobilprogrammering', 10, 'v', 'v', 30);