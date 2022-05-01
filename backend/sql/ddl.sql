create or replace table user
(
    id            int(10)      not null auto_increment primary key,
    user_id       varchar(100) not null,
    user_name     varchar(100) not null,
    user_password varchar(500) not null,
    phone_num     varchar(500) not null,
    email         varchar(500) not null,
    gender        varchar(10),
    city          varchar(100),
    profile_photo varchar(100),
    reg_date      datetime default now()
);

create or replace table language
(
    id   int(10)      not null auto_increment primary key,
    name varchar(100) not null
);

create or replace table hope_language
(
    user_id int(10) not null,
    lang_id int(10) not null
);

create or replace table can_language
(
    user_id int(10) not null,
    lang_id int(10) not null
);

insert into user(user_id, user_name, user_password, phone_num, email, gender, city)
values ('koc0819', 'khc', '1234', '01025302359', 'koc0819@gmail.com', 'man', 'seoul');

# TODO 가능 언어, 희망 언어 등록
# TODO 소개, 프로필 사진