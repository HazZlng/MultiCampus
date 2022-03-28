create table tb_customer(
id varchar(10) ,
password varchar(10) not null,
name varchar(16));

insert into tb_customer values('111','111','111');
insert into tb_customer values('222','222','222');
insert into tb_customer values('333','333','333');

select * from tb_customer;
