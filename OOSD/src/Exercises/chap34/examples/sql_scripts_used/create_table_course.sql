USE javabook;
# comment
-- comment
/* comment */

-- create table for course
CREATE TABLE Course (
    courseId CHAR(5),
    subjectId CHAR(4) NOT NULL,
    courseNumber INTEGER,
    title VARCHAR(50) NOT NULL,
    numOfCredits INTEGER,
    /*
    could use PRIMARY KEY (courseID)
	but using CONSTRAINT <name of primary key> PRIMARY KEY (columns to add)
    dont worry though, this will still cause courseID to be primary key in MySQL (pkCourse will not exist yet)
    */
    CONSTRAINT pkCourse PRIMARY KEY (courseId)
    -- cannot add foreign key yet, need to create the Subject table first
    -- CONSTRAINT fkSubjectId FOREIGN KEY (subjectId) REFERENCES Subject (subjectId)
);