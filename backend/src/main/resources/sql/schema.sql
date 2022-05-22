create table if not exists user
(
#     TODO 인덱싱 수정을 위해서 PK는 정수형으로 수정
    email        varchar(50) primary key,
    nickname     varchar(50) not null unique,
    password     varchar(50) not null,
    reg_date     datetime    not null default now(),
    address      varchar(50) not null,
    gender       varchar(10) not null check (gender = 'man' || gender = 'woman'),
    photo_path   varchar(50) not null,
    phone_number varchar(50),
    language     varchar(50) not null default 'korean'
);

create table if not exists course
(
    id int primary key auto_increment
);

create table if not exists interested_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);

create table if not exists visited_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);

create table if not exists registered_course
(
    email         varchar(50) references user (email),
    course_id     int references course (id),
    user_nickname varchar(50) not null,
    course_tile   varchar(50) not null
);