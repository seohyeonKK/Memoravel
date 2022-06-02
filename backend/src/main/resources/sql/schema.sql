drop table if exists interested_course;
drop table if exists visited_course;
drop table if exists registered_course;
drop table if exists user;

create table user
(
    email        varchar(50) primary key,
    nickname     varchar(50) not null unique,
    password     varchar(60) not null,
    reg_date     datetime    not null default now(),
    address      varchar(50) not null,
    gender       varchar(10) not null check (gender = 'man' || gender = 'woman'),
    photo_path   varchar(50) not null,
    phone_number varchar(50),
    language     varchar(50) not null default 'korean'
);

create table course
(
    id int primary key auto_increment
);

create table interested_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);

create  table visited_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);

create table registered_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);