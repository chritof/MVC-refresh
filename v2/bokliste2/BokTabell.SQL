-- =========================================================
-- Schema og tabeller for Bok ↔ Forfatter (Many-to-Many)
-- PostgreSQL-versjon
-- =========================================================

-- 1) Opprett schema (hopp over hvis det allerede finnes)
CREATE SCHEMA IF NOT EXISTS bok_visning;

-- 2) Rydd opp hvis du vil kjøre skriptet flere ganger
DROP TABLE IF EXISTS bok_visning.bok_forfatter CASCADE;
DROP TABLE IF EXISTS bok_visning.bok CASCADE;
DROP TABLE IF EXISTS bok_visning.forfatter CASCADE;

-- 3) Opprett tabeller
CREATE TABLE bok_visning.forfatter (
                                       id              SERIAL PRIMARY KEY,
                                       author_fname    VARCHAR(100) NOT NULL,
                                       author_lname    VARCHAR(100) NOT NULL
    -- Valgfritt: UNIQUE (author_fname, author_lname)
);

CREATE TABLE bok_visning.bok (
                                 id              SERIAL PRIMARY KEY,
                                 title           VARCHAR(255) NOT NULL,
                                 year_of_release INT NOT NULL
    -- Valgfritt: UNIQUE (title, year_of_release)
);

-- Join-tabell for many-to-many
CREATE TABLE bok_visning.bok_forfatter (
                                           bok_id        INT NOT NULL,
                                           forfatter_id  INT NOT NULL,
                                           PRIMARY KEY (bok_id, forfatter_id),
                                           CONSTRAINT fk_bok
                                               FOREIGN KEY (bok_id) REFERENCES bok_visning.bok (id) ON DELETE CASCADE,
                                           CONSTRAINT fk_forfatter
                                               FOREIGN KEY (forfatter_id) REFERENCES bok_visning.forfatter (id) ON DELETE CASCADE
);

-- Indekser (kan hjelpe på oppslag)
CREATE INDEX idx_bok_forfatter_bok_id ON bok_visning.bok_forfatter (bok_id);
CREATE INDEX idx_bok_forfatter_forfatter_id ON bok_visning.bok_forfatter (forfatter_id);

-- =========================================================
-- Testdata
-- =========================================================

-- Forfattere
INSERT INTO bok_visning.forfatter (author_fname, author_lname) VALUES
                                                                   ('J.R.R.', 'Tolkien'),        -- id = 1
                                                                   ('Neil', 'Gaiman'),           -- id = 2
                                                                   ('Terry', 'Pratchett'),       -- id = 3
                                                                   ('J.K.', 'Rowling');          -- id = 4

-- Bøker
INSERT INTO bok_visning.bok (title, year_of_release) VALUES
                                                         ('The Hobbit', 1937),         -- id = 1 (Tolkien)
                                                         ('Good Omens', 1990),         -- id = 2 (Gaiman + Pratchett)
                                                         ('Raising Steam', 2013),      -- id = 3 (Pratchett)
                                                         ('Fantastic Beasts', 2001);   -- id = 4 (Rowling)

-- Relasjoner (M:N)
-- The Hobbit ↔ Tolkien
INSERT INTO bok_visning.bok_forfatter (bok_id, forfatter_id) VALUES (1, 1);

-- Good Omens ↔ Gaiman + Pratchett
INSERT INTO bok_visning.bok_forfatter (bok_id, forfatter_id) VALUES (2, 2);
INSERT INTO bok_visning.bok_forfatter (bok_id, forfatter_id) VALUES (2, 3);

-- Raising Steam ↔ Pratchett
INSERT INTO bok_visning.bok_forfatter (bok_id, forfatter_id) VALUES (3, 3);

-- Fantastic Beasts ↔ Rowling
INSERT INTO bok_visning.bok_forfatter (bok_id, forfatter_id) VALUES (4, 4);

