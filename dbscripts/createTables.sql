DROP database Minibank01;
CREATE database Minibank01

USE Minibank01;

--Note the order of the create table statements (referential integrity)

CREATE TABLE PostalCity(
	postalCode	varchar(4)	NOT NULL,
	city		varchar(20)	NOT NULL,
	CONSTRAINT PostalCityPK
		PRIMARY KEY(postalCode)
)

CREATE TABLE Client(
	cpr 		char(10)	NOT NULL,
	name		varchar(20)	NOT NULL,
	street		varchar(20)	NOT NULL,
	postalCode	varchar(4),
	status		varchar(2),
	
	CONSTRAINT ClientPK
		PRIMARY KEY(cpr),
	CONSTRAINT PostalCodeFK
		FOREIGN KEY(postalCode) REFERENCES PostalCity(postalCode)
);

CREATE TABLE Account(
	accNo		int			NOT NULL,
	balance		float		NOT NULL,
	inRate		float		NOT NULL,
	clientNo	char(10)	NOT NULL,
	CONSTRAINT AccountPK
		PRIMARY KEY(accNo),
	CONSTRAINT ClientFK
		FOREIGN KEY(clientNo) REFERENCES Client(cpr)
)
		