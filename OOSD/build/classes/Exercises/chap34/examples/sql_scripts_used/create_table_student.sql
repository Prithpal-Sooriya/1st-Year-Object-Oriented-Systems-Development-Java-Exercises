-- create table student
use javabook;

CREATE TABLE Student (
    ssn CHAR(9) NOT NULL,
    firstName VARCHAR(25),
    mi CHAR(1),
    lastName VARCHAR(25),
    phone CHAR(11),
    birthDate DATE,
    street VARCHAR(100),
    zipCode CHAR(5),
    deptId CHAR(4),
    CONSTRAINT pkStudent PRIMARY KEY (ssn)
    -- cannot add foreign key to deptID yet
	-- constraint fkDeptId foreign key (deptId) references Department(deptId)
);
