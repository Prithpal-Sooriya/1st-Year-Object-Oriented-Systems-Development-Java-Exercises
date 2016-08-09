USE javabook;

-- arithmetic operators
SELECT 
    title, numOfCredits * 50 AS 'Lecture Minutes Per Week'
FROM
    Course
WHERE
    subjectId = 'CSCI';