CREATE FUNCTION `studentFound` (first varchar(20), last varchar(20))
	RETURNS int
BEGIN
	declare result int;
    
SELECT 
    COUNT(*)
INTO result FROM
    Student
WHERE
    Student.firstName = first
        AND Student.lastName = last;
RETURN result;
END

