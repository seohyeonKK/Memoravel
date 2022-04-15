create or replace table user(
    id int(10) not null auto_increment primary key,
    userId varchar(100) not null,
    userName varchar(100) not null,
    userPassword varchar(500) not null,
    phoneNum varchar(500) not null,
    email varchar(500) not null,
    gender varchar(10),
    city varchar(100),
    regDate datetime default now()
);