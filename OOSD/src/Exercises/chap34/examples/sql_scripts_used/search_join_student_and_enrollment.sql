USE javabook;

-- joining
-- both tables (student and enrollment) will use ssn for join
SELECT DISTINCT
    lastName,
    firstName,
    courseID
FROM
    Student,
    Enrollment
WHERE
    Student.ssn = Enrollment.ssn
    AND
    lastName = 'Smith' AND firstName = 'Jacob';