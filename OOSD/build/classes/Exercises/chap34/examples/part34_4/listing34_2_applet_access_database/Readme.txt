This listing demonstrates how a Dataabase (can only be Oracle or MySQL) can be accessed by a java applet

    --> the program will prompt user to enter a students SSN and courseID and will return the grade

Applet:
    --> JTextField & JLabel = SSN //enter the ssn for the student
    --> JTextField & JLabel = courseID //enter the CourseID to get the grade
    --> JButton = ActionListener
        --> if grade found = will output grade
        --> if grade not found = will output "not found"


In the server is connected remote to the applet
    --> just find the public ip address and port number of which the server is connected to

If you want to run the applet on a web page/browser:
    --> user may not have MySQL driver, so add this code in applet tag (in HTML)

<applet
    code = "FindGrade"
    archive = "FindGrade.jar, lib/mysqljdbc.jar"
    width = 380
    height = 80
>
</applet>

See Supplement III.Q packaging and deploying java projects