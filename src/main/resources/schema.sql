--CREATE TABLE IF NOT EXISTS tb_circuit(id serial primary key,
--circuitId Long,
--circuitRef VARCHAR(200),
--name VARCHAR(200),
--location VARCHAR(200),
--country VARCHAR(200),
--lat Double,
--lng Double,
--alt int,
--url VARCHAR(600),
--    )


--COPY tb_circuit(circuitRef ,
--name ,
--location,
--country,
--lat,
--lng,
--alt ,
--url) from 'src/main/resources/assets/circuit.csv' DELIMITER ',' CSV HEADER;


--DROP TABLE coffee IF EXISTS;
--
--CREATE TABLE coffee  (
--    coffee_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--    brand VARCHAR(20),
--    origin VARCHAR(20),
--    characteristics VARCHAR(30)
--);




--CREATE TABLE IF NOT EXISTS "circuit"  (
--    circuitId bigint,
--    circuitRef varchar(250),
--    name varchar(250),
--    location varchar(250),
--    country varchar(250),
--    lat double  precision,
--    lng double precision,
--    alt int ,
--    url varchar(250)
--);

CREATE TABLE IF NOT EXISTS "circuit"  (
    circuitId bigint,
    circuitRef varchar(250),
    name varchar(250),
    location varchar(250),
    country varchar(250),
    lat double precision,
    lng double precision,
    alt smallserial,
    url varchar(250)
);