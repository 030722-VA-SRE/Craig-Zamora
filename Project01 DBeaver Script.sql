

drop table beer;
drop table users;
delete from beer;

create table beer(
	id serial primary key,
	price numeric(7,2) not null,
	beername varchar (20) not null unique,
	beertype  varchar(20) not null
);


insert into beer(beer_Name, price, beer_Type, beer_owner_id) values
	('DosXX', 7.99, 'Golden Pilsner', 1),
	('Truly', 8.99, 'Hard Seltzer', 2),
	('Guinness', 5.99, 'Irish Stout', 3), 
	('Samuel Adams', 7.99, 'IPA' , 2), 
	('Blue Moon', 10.99, 'Wheat Ale', 1),
	('Heineken', 5.99, 'lager', 1),	
	('White Claw', 6.99, 'Hard Seltzer', 4);

insert into users (password, role, username) values 
	('quantum data', 'EMPL', 'TARS'),
	('space', 'EMPL', 'Cooper'),
	('joking', 'BASIC', 'Professor Brand'),
	('years', 'EMPL', 'Romilly'),
	('trikery', 'BASIC', 'Mann')	;



select * from beer
select * from users
select * from beer order by id asc; 
select * from users order by id asc;


update users set username = 'Cooper' where id = 2;

select * from beer where price = 7.99;
select * from beer where price = 5.99;
insert into users (username, password) values ('quantum data2', 'TARS2');
insert into beer (beer_Name, price, beer_Type) values  ('Pink Claw', 1.99, 'fun beer') returning id;
insert into beer (beer_Name, price, beer_Type) values  ('Pink Claw', 1.99, 'fun beer');
select * from beer where price = 8.99 and beerType = 'Hard Seltzer';

select * from beer where beerType = Hard Seltzer; -- wrong, forgot '' around name

delete from beer where id = 7; -- code to delete user by id;
delete from users where id = 6; -- code to delete user by id;

update beer set beername = 'TresXXX' where id = 1;
select * from beer order by id asc; -- code to order table after updating; 
select * from users order by id asc;

update beer set beername = 'TresXXX',  price = 19.99, beertype  = 'Expensive' where id = 1; 