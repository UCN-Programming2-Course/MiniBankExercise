use Minibank01;

insert into PostalCity values
('9000','Aalborg');
insert into PostalCity values
('9800','Hjørring');
insert into PostalCity values
('9700','Brønderslev');
insert into PostalCity values
('8000','Aarhus');

insert into Client values
('1234567890', 'Finn', 'Xgade', '9000', 'A');
insert into Client values
('0123456789', 'Ib', 'Agade', '9700', 'C');
insert into Client values
('9012345678', 'Bodil', 'Ygade', '9800', 'A');
insert into Client values
('8901234567', 'Lars', 'Xstræde', '9000', 'B');
insert into Client values
('7890123456', 'Jakob', 'Xgade', '9700', 'A');


insert into Account values
(1,1000,1,'1234567890');
insert into Account values
(2,110,2,'1234567890');
insert into Account values
(3,2000,2,'0123456789');
insert into Account values
(4,111,-1,'9012345678');
insert into Account values
(5,2222,3,'9012345678');
insert into Account values
(6,3333,1,'8901234567');
insert into Account values
(7,6666,1,'7890123456');