DROP TABLE IF EXISTS circuit;

CREATE TABLE IF NOT EXISTS "circuit"  (
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

DROP TABLE IF EXISTS constructorresults;


CREATE TABLE IF NOT EXISTS "constructorresults"  (
    id bigint,
    raceId bigint,
    constructorId bigint,
    status varchar(50),
    points double precision

);