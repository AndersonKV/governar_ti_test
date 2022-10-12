drop TABLE IF EXISTS circuit;

create table if not exists "circuit"  (
    id bigint,
    circuitRef varchar(250),
    name varchar(250),
    location varchar(250),
    country varchar(250),
    lat double precision,
    lng double precision,
    alt  varchar(250),
    url varchar(250)
);

drop TABLE IF EXISTS constructorresults;

create table if not exists "constructorresults"  (
    id bigint,
    raceId bigint,
    constructorId bigint,
    status varchar(50),
    points double precision
);
--
--drop TABLE IF EXISTS constructor_standings;
--
--create table if not exists "constructor_standings"  (
--    id bigint,
--    raceId bigint,
--    constructorId bigint,
--    points double precision,
--    position  INTEGER,
--    positionText  varchar(50),
--    wins  INTEGER
--);
