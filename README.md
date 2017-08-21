# TelephoneBookSpringBoot
Spring Boot, Spring Data, Ajax, JUnit, Mockito
create databese telephonebook.

CREATE TABLE users
(
userid bigint auto_increment NOT NULL,
fio character varying(255) NOT NULL,

login_name character varying(255) NOT NULL,

password character varying(255) NOT NULL,

PRIMARY KEY (userid)
);

CREATE TABLE contacts
(
contactid bigint auto_increment NOT NULL,

firstname character varying(255) NOT NULL,

lastname character varying(255) NOT NULL,

middlename character varying(255) NOT NULL,

mob_phone_number character varying(255) NOT NULL,

home_phone_number character varying(255),

address character varying(255),

email character varying(255),

userid bigint,

PRIMARY KEY (contactid),
FOREIGN KEY (userid)
 REFERENCES users (userid));
