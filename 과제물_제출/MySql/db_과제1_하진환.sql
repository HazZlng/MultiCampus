use sqldb;

drop table book;
create table book
(
bookNo 			char(10)	not null primary key	, 
bookTitle		varchar(30),
bookAuthor		varchar(20),
bookYear		int,
bookPrice		int,
bookPublisher	char(10)
);

insert into book values('B001', '자바프로그래밍', '홍길동', 2021, 30000, '서울출판사');
insert into book values('B002', '데이터베이스', '이몽룡', 2020, 25000, '멀티출판사');
insert into book values('B003', 'HTML/CSS', '성춘향', 2021, 18000, '강남출판사');

select * from book;
