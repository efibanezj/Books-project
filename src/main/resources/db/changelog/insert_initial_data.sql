-- liquibase formatted sql

-- changeset liquibase:2
INSERT INTO PUBLIC.book (id,name,category,isbn,author) values
('368cf97a-2a78-11ed-a261-0242ac120002','Orgullo y prejuicio','drama','978-0-545-01022-1','Jane Austen'),
('288cf97a-2a78-11ed-a261-0242ac120002','La metamorfosis','filosofia','816-0-545-01022-1','Franz Kafka'),
('848cf97a-2a78-11ed-a261-0242ac120002','Dracula','terror','736-0-545-01022-1','Bram Stoker');