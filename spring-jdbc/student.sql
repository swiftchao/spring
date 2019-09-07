use test;
DROP TABLE IF EXISTS student;
CREATE TABLE student(
   id   INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   age  INT NOT NULL,
   image BLOB,
   description LONGTEXT,
   PRIMARY KEY (id)
);

INSERT INTO student(id, name, age, image, description) VALUES(1,'Maxsu', 23, NULL, NULL);

select * from student;
