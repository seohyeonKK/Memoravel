drop table interested_course;
drop table visited_course;
drop table registered_course;
drop table user;

create or replace table user
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

create or replace table course
(
    id int primary key auto_increment
);

create or replace table interested_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);

create or replace table visited_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);

create or replace table registered_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);