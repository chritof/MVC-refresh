drop schema if exists emne_registrering cascade;
create schema emne_registrering;
set search_path to emne_registrering;

CREATE TABLE emne (
                      kode CHAR(6) PRIMARY KEY, -- f.eks. 'DAT100'
                      navn VARCHAR, -- f.eks. 'Grunnleggende programmering'
                      studiepoeng INTEGER, -- f.eks. 10
                      semester CHAR(1), -- 'v'|'h'|'b' for vår, høst eller begge
                      type CHAR(1), -- 'o'|'v' for obligatorisk eller valgfag
                      antall INTEGER -- antall interesserte
);
