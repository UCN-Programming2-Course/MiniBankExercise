USE master;

if exists (select * from sysdatabases where name = 'Minibank01')
begin
	DROP database Minibank01;
end


CREATE database Minibank01;
GO

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
);
GO
		
USE master;


CREATE LOGIN minibankuser WITH PASSWORD=N'password', CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO

USE Minibank01;
GO

CREATE USER minibankuser FOR LOGIN minibankuser WITH DEFAULT_SCHEMA=[dbo]
GO

ALTER AUTHORIZATION ON SCHEMA::[db_datareader] TO [minibankuser]
GO

ALTER AUTHORIZATION ON SCHEMA::[db_datawriter] TO [minibankuser]
GO

ALTER ROLE [db_datareader] ADD MEMBER [minibankuser]
GO

ALTER ROLE [db_datawriter] ADD MEMBER [minibankuser]
GO