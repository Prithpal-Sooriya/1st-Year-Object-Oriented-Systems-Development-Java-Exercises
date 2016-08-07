use javabook;

-- AS method to give column alias
SELECT 
    CONCAT(firstName, ' ', lastName) AS 'Name'
FROM
    Student;