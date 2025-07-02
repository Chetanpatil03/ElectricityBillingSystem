create database bill_system;
use bill_system;

create table signup(
meter_num varchar(20),
username varchar(20),
name varchar(30),
password varchar(20),
user_type varchar(10));

select * from signup;
truncate signup;

create table new_cust(
meter_no varchar(10),
name varchar(30),
address varchar(40),
city varchar(10),
state varchar(10),
email varchar(10),
phone varchar(10)
);

drop table user;

select * from new_cust;
truncate table new_cust;


create table meter_info(
meter_no varchar(20),
meter_loc varchar(30),
meter_type varchar(30),
phase_code varchar(30),
bill_type varchar(30),
days varchar(10)
);

drop table meter_info;

select * from meter_info;

create table tax(
cost_per_unit varchar(20),
meter_rent varchar(20),
service_charge varchar(20),
service_tax varchar(20),
swachh_bharat varchar(20),
fixed_tax varchar(20)
);

drop table tax;

insert into tax values('10','45','20','58','5','18');

select * from tax;
