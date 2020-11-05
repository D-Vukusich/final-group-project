CREATE database ticketapp_db;

use ticketapp_db;

CREATE TABLE events (
date DATE NOT NULL,
venue VARCHAR (30) NOT NULL,
artistORteam VARCHAR (30) NOT NULL,
primary key (venue)
);
CREATE TABLE owners (
barcode int NOT NULL auto_increment,
first_name VARCHAR (20) NOT NULL,
last_name VARCHAR (20) NOT NULL,
primary key (barcode)
);
CREATE TABLE tickets (
date DATE NOT NULL,
venue VARCHAR (30),
seat VARCHAR (10) NOT NULL,
barcode int NOT NULL auto_increment,
primary key (barcode)
);

