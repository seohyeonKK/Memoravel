create or replace table user
(
    email        varchar(50) primary key,
    nickname     varchar(50) unique,
    password     varchar(50)                                            not null,
    reg_date     datetime default now(),
    address      varchar(50)                                            not null,
    gender       varchar(10) check (gender = 'man' or gender = 'woman') not null,
    photo_path   varchar(50)                                            not null,
    phone_number varchar(50)
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