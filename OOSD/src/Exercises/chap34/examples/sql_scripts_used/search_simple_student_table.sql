USE javabook;
-- simple search through Student table
SELECT
    firstName, mi, lastName
FROM
    Student
WHERE deptId = 'CS';