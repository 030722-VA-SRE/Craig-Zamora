/*
 * Beer Store
 * Beer name
 * 
 */
drop table beer;
create table beer(
	id serial primary key, 
	price numeric(7,2) not null,
	name  varchar(20) not null unique	
);

insert into beer(name, price) values
	('DosXX', 7.99),
	('Truly', 8.99),
	('Guinness', 5.99), 
	('Samuel Adams', 7.99), 
	('Blue Moon', 6.99),
	('Heineken', 5.99),	
	('Pink Moon', 6.99);
	
select * from beer 
