Access and update staff table:
    --> write a java applet that views inserts and updates staff information stored in a database

    --> View button displays a record with specified ID.

    --> Staff table created as follows:
        CREATE TABLE Staff (
            id CHAR(9) NOT NULL,
            firstName varchar(15),
            lastName varchar(15),
            mi char(1),
            address varchar(20),
            city varchar(20),
            state char(2),
            telephone char(10),
            email varchar(40),
            primary key(id)
        );

        --> table created before hand (so as to access/insert later)

        --> NOTE
            --> I had this error in the code for trying to check if there is data in the ResultSet or not
            --> the problem was that NULL record is at the END not START
                --> so: CHECK NULL RECORD at END, not START
==========================
GUI:
//id Panel
JPanel ID = JLabel jlId ="ID"; JTextField tfId = ...; (9)

//will group lastname, firstname, mi
JPanel LastName = JLabel AND JTextField for last name (max 15)
JPanel FirstName = JLabel AND JTextField for first name (max 15)
JPanel mi = JLabel AND JTextField for mi (1)
JPanel name = GROUP ALL THE NAME FRAMES TOGETHER

//Address Panel
JPanel Address = JLabel and JTextField for address (max 20)

//city and state Panel
JPanel city = JLabel and JTextField for city (max 20)
JPanel state = JLabel and JTextField for state (2)
JPanel cityAndState = GROUP JLABELS FOR CITY AND STATE

//telephone panel
JPAnel telephone = JLabel and JTextField for address (10)

//panel for buttons
JButton view; //view by ID entered
JButton insert; //insert new record (if ID is different)
JButton update; //update record, if exists
JButton clear; //clear textfields

//put everything in master panel
JPanel masterframe = GridLayout (7 rows, 1 columns)

//final column is for output message
===========================
Methods/backend:

what need to be done:
    --> load MySQL driver (only needs to be done once!)
    --> establish connection, create statement, execute query (method will hold param for string query)
        --> all contained in one method (I think best practice)

    --> VIEW BUTTON
        --> check if the id exists in database, if not then forget (prob just catch an error if not found)

    --> INSERT BUTTON
        --> does not insert if id exists
    
    --> UPDATE BUTTON
        --> does not update if ID does not exist

    --> CLEAR BUTTON
        --> clears text fields.
