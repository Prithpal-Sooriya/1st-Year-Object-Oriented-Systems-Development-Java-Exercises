USE javabook;

SET SQL_SAFE_UPDATES=0; -- need to uncheck safe updates for now (since it is 'unsafe' to delete all records
delete from Course; -- will delete all rows/records from table Course

INSERT INTO Course VALUES (
  '11111', 'CSCI', '1301', 'Intro to Java I', 4);
INSERT INTO Course VALUES (
  '11112', 'CSCI', '1302', 'Intro to Java II', 3);
INSERT INTO Course VALUES (
  '11113', 'CSCI', '4720', 'Database Systems', 3);
INSERT INTO Course VALUES (
  '11114', 'CSCI', '4750', 'Rapid Java Application', 3);
INSERT INTO Course VALUES (
  '11115', 'MATH', '2750', 'Calculus I', 5);
INSERT INTO Course VALUES (
  '11116', 'MATH', '3750', 'Calculus II', 5);
INSERT INTO Course VALUES (
  '11117', 'EDUC', '1111', 'Reading', 3);
INSERT INTO Course VALUES (
  '11118', 'ITEC', '1344', 'Database Administration', 3);

-- show contents of table onto screen
SELECT *
FROM Course;
