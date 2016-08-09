USE javabook;

-- display sorted tuples
-- primary order is lastname 
-- secondary order is firsrtname
SELECT
    lastName,
    FirstName,
    deptId
FROM
    Student
WHERE
    deptId = 'CS'
ORDER BY
    lastName DESC,
    firstName ASC;