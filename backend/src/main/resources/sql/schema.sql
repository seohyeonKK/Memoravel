drop table if exists requesting;
drop table if exists registering;

drop table if exists interested_req_course;
drop table if exists req_course_spot;
drop table if exists req_course_image;
drop table if exists req_course_tag;
drop table if exists req_course_lang;
drop table if exists interested_reg_course;
drop table if exists visited_reg_course;
drop table if exists reg_course_spot;
drop table if exists reg_course_image;
drop table if exists reg_course_tag;
drop table if exists reg_course_lang;

drop table if exists member;
drop table if exists requested_course;
drop table if exists registered_course;
drop table if exists lang;
drop table if exists tag;

create table member
(
    id           int primary key auto_increment,
    email        varchar(50) not null unique,
    nickname     varchar(50) not null unique,
    password     varchar(60) not null,
    reg_date     datetime    not null default now(),
    location     point       not null,
    gender       varchar(10) not null check (gender = 'man' || gender = 'woman'),
    photo_path   varchar(50) not null,
    phone_number varchar(50),
    language     varchar(50) not null default 'korean',
    salt         varchar(64) not null,
    jwt          varchar(500)
);
create table lang
(
    id        int primary key auto_increment,
    lang_name varchar(50) not null
);

create table tag
(
    id         int primary key auto_increment,
    tag_phrase varchar(50) not null
);
create table requested_course
(
    id             int primary key auto_increment,
    title          varchar(50) not null,
    contents       varchar(50) not null,
    created_at     datetime    not null default now(),
    updated_at     datetime    not null default now(),
    travel_expense int(10)     not null
);

/*
 등록한 코스
 */
create table registered_course
(
    id                  int primary key auto_increment,
    title               varchar(50)  not null,
    represent_region    varchar(50)  not null,
    contents            varchar(500) not null,
    guide_cost          int          not null,
    expected_total_cost int          not null,
    start_date          date         not null,
    end_date            date         not null,
    created_at          datetime     not null default now(),
    updated_at          datetime     not null default now()
);
/*
 요청 코스 관계 테이블
 */
create table requesting
(
    id        int primary key auto_increment,
    member_id int references member (id),
    course_id int references req_course (id)
);

create table interested_req_course
(
    id        int primary key auto_increment,
    member_id int references member (id),
    course_id int references requested_course (id)
);

create table req_course_spot
(
    id        int primary key auto_increment,
    course_id int references requested_course (id),
    ordered   int(10) not null,
    latitude  double  not null,
    longitude double  not null
);

create table req_course_image
(
    id         int primary key auto_increment,
    course_id  int references requested_course (id),
    image_path varchar(100) not null
);

create table req_course_tag
(
    id        int primary key auto_increment,
    tag_id    int references tag (id),
    course_id int references requested_course (id)
);

create table req_course_lang
(
    id        int primary key auto_increment,
    course_id int references requested_course (id),
    lang_id   int references lang (id)
);

/*
 등록 코스 관계 테이블
 */
create table registering
(
    id        int primary key auto_increment,
    member_id int references member (id),
    course_id int references registered_course (id)
);
create table interested_reg_course
(
    id        int primary key auto_increment,
    member_id int references member (id),
    course_id int references registered_course (id)
);
create table visited_reg_course
(
    id        int primary key auto_increment,
    member_id int references member (id),
    course_id int references registered_course (id),
    star      int
);

create table reg_course_spot
(
    id            int primary key auto_increment,
    course_id     int references registered_course (id),
    ordered       varchar(50) not null,
    latitude      double      not null,
    longitude     double      not null,
    expected_cost int
);

create table reg_course_image
(
    id         int primary key auto_increment,
    course_id  int references registered_course (id),
    image_path varchar(100) not null
);
create table reg_course_tag
(
    id        int primary key auto_increment,
    tag_id    int references tag (id),
    course_id int references registered_course (id)
);

create table reg_course_lang
(
    id        int primary key auto_increment,
    course_id int references registered_course (id),
    lang_id   int references lang (id)
);
