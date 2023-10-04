create database universityexams;

use universityexams;

create table course(
course_no int primary key,
name varchar(255),
dept_id int,
foreign key(dept_id) references department(dept_id)
);

create table room(
room_no int primary key,
building varchar(255),
capacity int
);

create table exam(
exam_id int primary key,
exam_time time,
room_no int,
course_no int,
exam_date date,
student_id int,
foreign key (room_no) references room(room_no),
foreign key(course_no) references course(course_no),
foreign key(student_id) references student(student_id)
);

create table department(
dept_id int primary key,
name varchar(50)
);

create table student(
student_id int primary key,
name varchar(255),
dept_id int,
foreign key(dept_id) references department(dept_id)
);