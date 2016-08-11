/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.examples.part34_4.listing34_2_applet_access_database;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Prithpal Sooriya
 */
//extends JApplet to be used on the web if we want to
public class FindGrade extends JApplet {

    //some of the GUI elements
    //these can be created since they will not change later on
    private JTextField jtfSSN = new JTextField(9); //max input is 9 chars
    private JTextField jtfCourseId = new JTextField(5); //max input 5 chars
    private JButton jbtShowGrade = new JButton("Show Grade");

    //statement for executing queries
    private Statement statement;

    //initialise the applet
    @Override
    public void init() {
        //initialise the database connection and create a Statement object
        initialiseDB();

        //action listener for when the button is pressed, execute query
        jbtShowGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbtShowGrade_actionPerformed(e);
            }
        });

        //create the rest of the GUI elements
        JPanel jPanel1 = new JPanel();
        jPanel1.add(new JLabel("SSN"));
        jPanel1.add(jtfSSN);
        jPanel1.add(new JLabel("Course ID"));
        jPanel1.add(jtfCourseId);
        jPanel1.add(jbtShowGrade);

        //add the panel to the applet
        add(jPanel1, BorderLayout.NORTH);
    }

    //method initialiseDB()
    //will load drivers, create a connection, and create a statement
    private void initialiseDB() {
        //try catch exceptions
        //catch Exception ex = catch any exception thrown (including SQL exception and ClassNotFound exception)
        try {
            //load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded!");

            //exstablish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");
            //Connect to a database on web host
            //Connection connection = DriverManager.getConnection("jdbc:myslq://liang.armstrong.edu:1521/javabook", ...);
            //connection with mysql is with string "jdbc:mysql://[host]:[port]/database name
            //host can be anything (IP address, 
            System.out.println("Connection to database made!");

            //create a statement
            statement = connection.createStatement();
            System.out.println("Statment created!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //method jbtShowGrade_actionPerformed(ActionEvent e)
    //will execute the statement, return a result (ResultSet) and process the ResultSet
    private void jbtShowGrade_actionPerformed(ActionEvent e) {
        //get the text from the inputs
        String ssn = jtfSSN.getText();
        String courseId = jtfCourseId.getText();

        //try and catch exceptions
        //catch SQL exception due to query
        try {
//            String queryString
//                    = "SELECT firstName, mi, lastName, title, grade " //columns to use
//                    + "FROM Student, Enrollment, Course " //tables to use
//                    + "WHERE "
//                    + "Student.ssn = '" + ssn + "' " //return must have correct ssn
//                    + "AND Enrollement.courseId = '" + courseId + "' " //return must have correct courseID
//                    + "AND Enrollment.courseId = Course.courseId " //creates the join to enrollment and course
//                    + "AND Enrollment.ssn = Student.ssn "; //creates the join to enrollment and student
            String queryString
                    = "SELECT \n"
                    + "    firstName, mi, lastName, title, grade\n"
                    + "FROM\n"
                    + "    Student,\n"
                    + "    Enrollment,\n"
                    + "    Course\n"
                    + "WHERE\n"
                    + "    Student.ssn = '444111110'\n"
                    + "        AND Enrollment.courseId = '11111'\n"
                    + "        AND enrollment.courseId = Course.courseId\n"
                    + "        AND enrollment.ssn = student.ssn";
            ResultSet resultSet = statement.executeQuery(queryString);

            //process the result set
            if (resultSet.next()) {
                String firstName = resultSet.getString(1);
                String mi = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String title = resultSet.getString(4);
                String grade = resultSet.getString(5);

                //display result in a dialogue box
                JOptionPane.showMessageDialog(null, firstName + " " + mi + " " + lastName
                        + "'s grade on course " + title + " is " + grade);
            } else {
                JOptionPane.showMessageDialog(null, "Not Found");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //main method to run code
    public static void main(String[] args) {
        //create the applet
        FindGrade applet = new FindGrade();

        //create a frame and set settings
        JFrame frame = new JFrame("Database Applet Connection");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initialise and add the applet
        applet.init();
        frame.add(applet);

        //show the frame
        frame.setVisible(true);

    }

}
