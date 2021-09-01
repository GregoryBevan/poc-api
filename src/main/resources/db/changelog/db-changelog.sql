--liquibase formatted sql

--- PERSONS

--changeset audace:1
CREATE TABLE IF NOT EXISTS booking (
  id UUID primary key,
  details varchar(100) not null
);
--rollback drop table booking;