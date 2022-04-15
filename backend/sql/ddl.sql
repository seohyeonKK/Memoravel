create table users(
    id int(10) not null auto_increment primary key,
    userid varchar(100) not null,
    user_name varchar(100) not null,
    user_password varchar(500) not null,
    phone_num varchar(500) not null,
    email varchar(500) not null,
    gender varchar(10),
    city varchar(100),
    reg_date datetime default now()
);