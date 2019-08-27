DELIMITER $$

DROP PROCEDURE IF EXISTS `test`.`getRecord` $$
CREATE PROCEDURE `test`.`getRecord` (
IN in_id INTEGER,
OUT out_name VARCHAR(20),
OUT out_age  INTEGER)
BEGIN
   SELECT name, age
   INTO out_name, out_age
   FROM student where id = in_id;
END $$

DELIMITER ;

show create procedure test.getRecord;


DELIMITER $$

DROP FUNCTION IF EXISTS `test`.`get_student_name` $$
CREATE FUNCTION `test`.`get_student_name` (in_id INTEGER)
RETURNS varchar(200)
BEGIN
DECLARE out_name VARCHAR(200);
   SELECT name
   INTO out_name
   FROM student where id = in_id;

RETURN out_name;
END $$

DELIMITER ;

show create function test.get_student_name;
