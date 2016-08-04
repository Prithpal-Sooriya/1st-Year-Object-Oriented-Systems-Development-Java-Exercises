-- create table enrolment
CREATE TABLE Enrollment (
    ssn CHAR(9) NOT NULL,
    courseId CHAR(5) NOT NULL,
    dateRegistered DATE,
    grade CHAR(1),
    -- primary key pkenrollment links rows ssn and courseId
    CONSTRAINT pkEnrollment PRIMARY KEY (ssn , courseId),
    -- foreign key ssn references Student(ssn)
    CONSTRAINT fkSsn FOREIGN KEY (ssn) REFERENCES Student(ssn),
    -- foreign key courseID references Course(courseID)
    CONSTRAINT fkCourseId FOREIGN KEY (courseID) REFERENCES Course(courseId)
);
  