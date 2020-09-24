create database SellCar;
use sellcar;
create table cart(
	cart_id int primary key auto_increment,
    car_id int
);
create table car(
car_id int primary key auto_increment,
car_name varchar(120) not null,
car_img varchar(255),
car_price varchar(100),
car_description varchar(255),
cart_id int,
foreign key (cart_id) references cart(cart_id)
);


insert into car (car_name,car_img,car_price,car_description) values ('hatback','img1.jpg','500','Huyndai');
select * from car;

delimiter $$
create procedure delete_car(car_id int)
	begin
    delete from car where car.car_id = car_id;
    end $$
delimiter ;

delimiter $$
create procedure get_car_by_id(car_id int)
begin
	select * from car 
    where car.car_id = car_id;
end $$
delimiter ;