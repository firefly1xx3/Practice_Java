#create schema customer; #if u have not create schema at first, do this command.
use customer;
create table user   
(
	id int not null primary key auto_increment,
	name varchar(20) not null,
	password varchar(20) not null,
	birth_date DATE,
    phone_number varchar(20),
    email varchar(255),
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table customer_list
(
	id int not null primary key auto_increment,
	customer_name varchar(20) not null,
    user_id int not null,
	birth_date DATE,
    phone_number varchar(20),
    address varchar(255),
    email varchar(255),
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id)
);