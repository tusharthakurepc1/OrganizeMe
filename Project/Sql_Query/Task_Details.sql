 use tdl_db;

-- select *from client_details;
/*
create table task_details(
task_id int NOT NULL PRIMARY KEY auto_increment,
c_id int,
title varchar(300),
t_desc varchar(2000),
flag varchar(10),			-- Which type of task Important,Normal,Planned,Groceries
FOREIGN KEY (c_id)	references Client_Details(c_id)
);

alter table Client_Details auto_increment=50000;
*/
-- drop table task_details;

select *from task_details;

-- In insert query the c_id must present in the client_details
-- insert into task_details(c_id,title,t_desc,flag) values(10000,"Task 1","Wake Up","Imp");


 