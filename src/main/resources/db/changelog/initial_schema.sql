-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE PUBLIC.book
(
    id       VARCHAR(36),
    name     VARCHAR(100),
    category VARCHAR(100),
    isbn     VARCHAR(100),
    author   VARCHAR(100),
    PRIMARY KEY (id)
)