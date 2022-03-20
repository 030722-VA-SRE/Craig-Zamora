/*
 * Beer Store
 * Beer name
 * 
 */

select * from beer 


drop table beer;
create table beer(
	id serial primary key,
	price numeric(7,2) not null,
	beername varchar (20) not null unique,
	beertype  varchar(20) not null
);

insert into beer(beerName, price, beerType) values
	('DosXX', 7.99, 'Golden Pilsner'),
	('Truly', 8.99, 'Hard Seltzer'),
	('Guinness', 5.99, 'Irish Stout'), 
	('Samuel Adams', 7.99, 'IPA'), 
	('Blue Moon', 6.99, 'Wheat Ale'),
	('Heineken', 5.99, 'lager'),	
	('White Claw', 6.99, 'Hard Seltzer');


select * from beer where price = 7.99;
select * from beer where price = 5.99;

insert into beer (beerName, price, beerType) values  ('Pink Claw', 1.99, 'fun beer') returning id;

select * from beer where price = 8.99 and beerType = 'Hard Seltzer';

select * from beer where beerType = Hard Seltzer;