insert into course(id,fullname,created_date,last_updated_date) values(10001,'JPA in 50 steps',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10002,'Harry Potter',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10003,'Transformers',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10004,'Katy Perry',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10005,'JPA in 50 Steps',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10006,'Spring in 50 Steps',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10007,'Spring Boot in 100 Steps',sysdate(),sysdate());

insert into passport(id,number) values(40001,'E123456');
insert into passport(id,number) values(40002,'S333456');
insert into passport(id,number) values(40003,'K545616');

insert into student(id,name,passport_id) values(20001,'Rangga',40001);
insert into student(id,name,passport_id) values(20002,'Adam',40002);
insert into student(id,name,passport_id) values(20003,'Jane',40003);

insert into review(id,rating,description,course_id) values(50001,'5','Great Course',10001);
insert into review(id,rating,description,course_id) values(50002,'3','Wonderful Course',10001);
insert into review(id,rating,description,course_id) values(50003,'1','Terrible Course',10003);

insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20002,10001);
insert into student_course(student_id,course_id) values(20003,10001);
insert into student_course(student_id,course_id) values(20001,10003);