drop schema if exists butikk_vare cascade;
create schema butikk_vare;
set search_path to butikk_vare;

    create table vare(
        id serial primary key,
        navn varchar(30) not null,
        pris integer not null,
        beskrivelse varchar(100) not null
    )