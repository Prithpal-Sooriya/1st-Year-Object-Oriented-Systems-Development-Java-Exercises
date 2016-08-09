USE javabook;

-- display distinct tuples
-- will display each of the different subjects (from subject id)
SELECT DISTINCT
    subjectId AS 'Subject ID'
FROM
    Course;