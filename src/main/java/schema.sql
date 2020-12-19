DROP TABLE IF EXISTS STUDENT;
DROP TABLE IF EXISTS CLASS;
DROP TABLE IF EXISTS LECTURER;

CREATE TABLE lecturer
(
    id int(10) auto_increment
        primary key,
    name varchar(100) not null
);

CREATE TABLE class
(
    id int(10) auto_increment
        primary key,
    name varchar(100) not null,
    lecturer_id int(10) not null,
    constraint class_ibfk_1
        foreign key (lecturer_id) references lecturer (id)
);

CREATE INDEX lecturer_id
    ON class (lecturer_id);

CREATE TABLE student
(
    id int(10) auto_increment
        primary key,
    name varchar(100) not null,
    class_id int(10) not null,
    constraint student_ibfk_1
        foreign key (class_id) references class (id)
);

CREATE INDEX class_id
    ON student (class_id);