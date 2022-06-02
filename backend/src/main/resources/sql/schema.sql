drop table if exists requested_course;
drop table if exists interested_req_course;
drop table if exists req_course_place;
drop table if exists req_course_tag;
drop table if exists req_course_lang;
drop table if exists registered_course;
drop table if exists interested_reg_course;
drop table if exists visited_reg_course;
drop table if exists reg_course_place;
drop table if exists reg_course_image;
drop table if exists reg_course_tag;
drop table if exists reg_course_lang;

drop table if exists user;
drop table if exists req_course;
drop table if exists reg_course;
drop table if exists lang;
drop table if exists tag;

create table user
(
    id           int primary key auto_increment,
    email        varchar(50)  not null unique,
    nickname     varchar(50)  not null unique,
    password     varchar(60)  not null,
    reg_date     datetime     not null default now(),
    address      varchar(50)  not null,
    gender       varchar(10)  not null check (gender = 'man' || gender = 'woman'),
    photo_path   varchar(50)  not null,
    phone_number varchar(50),
    language     varchar(50)  not null default 'korean',
    salt         varchar(64)  not null,
    jwt          varchar(500) not null
);
create table lang
(
    id          int primary key auto_increment,
    choice_lang varchar(50) not null
);

create table tag
(
    id         int primary key auto_increment,
    tag_phrase varchar(50) not null
);
create table req_course
(
    id             int primary key auto_increment,
    title          varchar(50) not null,
    contents       varchar(50) not null,
    created_at     datetime    not null default now(),
    updated_at     datetime    not null default now(),
    travel_expense int(10)     not null
);


create table reg_course
(
    id             int primary key auto_increment,
    title          varchar(50)  not null,
    contents       varchar(500) not null,
    created_at     DATETIME     not null default now(),
    updated_at     DATETIME     not null default now(),
    start_time     varchar(50)  not null,
    end_time       varchar(50)  not null,
    guide_pay      int(10)      not null,
    travel_expense int(10)      not null
);
/*
 요청 코스 관계 테이블
 */
create table requested_course
(
    user_id   int references user (id),
    course_id int references req_course (id)
);

create table interested_req_course
(
    user_id   int references user (id),
    course_id int references req_course (id)
);


create table req_course_place
(
    course_id  int references req_course (id),
    ordered    varchar(50) not null,
    latitude   int(10)     not null,
    longitude  int(10)     not null,
    created_at DATETIME    not null default now(),
    updated_at DATETIME    not null default now()
);

create table req_course_tag
(
    tag_id    int references tag (id),
    course_id int references req_course (id)
);


create table req_course_lang
(
    course_id int references req_course (id),
    lang_id   int references lang (id)
);

/*
 등록 코스 관계 테이블
 */
create table registered_course
(
    user_id   int references user (id),
    course_id int references reg_course (id)
);
create table interested_reg_course
(
    user_id   int references user (id),
    course_id int references reg_course (id)
);
create table visited_reg_course
(
    user_id   int references user (id),
    course_id int references reg_course (id),
    star      int
);

create table reg_course_place
(
    course_id  int references reg_course (id),
    ordered    varchar(50) not null,
    latitude   int(10)     not null,
    longitude  int(10)     not null,
    created_at DATETIME    not null default now(),
    updated_at DATETIME    not null default now()
);

create table reg_course_image
(
    course_id  int references reg_course (id),
    image_path varchar(100) not null,
    created_at DATETIME     not null default now(),
    updated_at DATETIME     not null default now()
);
create table reg_course_tag
(
    tag_id    int references tag (id),
    course_id int references reg_course (id)
);

create table reg_course_lang
(
    course_id int references reg_course (id),
    lang_id   int references lang (id)
);
