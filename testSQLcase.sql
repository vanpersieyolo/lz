create database SellCar;
create table car(
id int primary key auto_increment,
car_name varchar(120) not null,
car_Img varchar(255),
car_Price varchar(100),
car_Description varchar(255)
);

insert into car (car_Name,car_Img,car_Price,car_Description) values ('hatback','img1.jpg','500','Huyndai');
select * from car;