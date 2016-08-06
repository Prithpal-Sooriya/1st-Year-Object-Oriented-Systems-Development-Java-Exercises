USE javabook;

-- search using the BETWEEN-AND operator
SELECT
	ssn,
    grade
FROM
	Enrollment
WHERE grade BETWEEN 'A' AND 'C';
-- WHERE grade BETWEEN 'C' AND 'A';
	-- doesnt work as stating grade >= A; grade <= C (which is not possible)
    -- note to self: always smallest to largest