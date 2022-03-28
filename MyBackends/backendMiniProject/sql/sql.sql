CREATE TABLE boardtest(
idx int AUTO_INCREMENT PRIMARY KEY,
writer VARCHAR(20) NOT NULL,
title VARCHAR(30) NOT NULL,
content TEXT NOT NULL,
reg_date DATE NOT NULL,
cnt int default 0
) DEFAULT CHARSET=utf8 ;

insert into boardtest (writer, title, content, cnt)
values("testWriter", "testTitle", "testContent");

create table member(
user_id varchar(10) primary key,
passwd varchar(20) not null
);

insert into member(user_id,passwd) values('test','test');

select * from member;