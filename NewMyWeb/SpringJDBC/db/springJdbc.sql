create table goodsinfo(
code varchar(10),
name varchar(30),
price int,
maker varchar(20));

insert into goodsinfo(code,name,price,maker) values('p0001','�ڹ�',25000,'G70');
insert into goodsinfo(code,name,price,maker) values('p0002','JSP',30000,'���ھ�');
insert into goodsinfo(code,name,price,maker) values('p0003','spring',30000,'���������');
insert into goodsinfo(code,name,price,maker) values('p0004','kotlin',50000,'Google');

select * from goodsinfo;
