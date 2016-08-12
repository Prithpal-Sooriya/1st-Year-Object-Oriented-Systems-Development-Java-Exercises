/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.examples.part34_5.listing34_3_fixing_security_hole;

import Exercises.chap34.examples.part34_4.listing34_2_applet_access_database.FindGrade;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//extend JApplet so to use in web page or diplay in frame
public class FindGradeUsingPreparedStatement extends JApplet {

    //GUI elements that will be used in other methods
    private JTextField jtfSSN = new JTextField(9);
    private JTextField jtfCourseId = new JTextField(5);
    private JButton jbtShowGrade = new JButton("Show Grade");

    //PreparedStatement for executing queries
    private PreparedStatement preparedStatement;

    //initialise the applet
    @Override
    public void init() {
        //initialise the database
        initialiseDB();

        //action listener for the button
        jbtShowGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbtShowGrade_actionPerformed(e);
            }
        });

        //create the other GUI elements
        JPanel jPanel1 = new JPanel();
        jPanel1.add(new JLabel("SSN"));
        jPanel1.add(jtfSSN);
        jPanel1.add(new JLabel("Course ID"));
        jPanel1.add(jtfCourseId);
        jPanel1.add(jbtShowGrade);

        //add the JPanel to the applet
        add(jPanel1, BorderLayout.NORTH);
    }

    //method initialiseDB
    //initialises the database: loads drver, established a connection and creates a statement
    private void initialiseDB() {
        //try and catch exceptions
        //catch Exception, from any thrown exception
        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL Driver Loaded...");

            //establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");
            System.out.println("Connection to database established...");

            //create the query string (to work on)
            //this string is a placeholder, in which the '?' will be filled in later
            String queryString
                    = "SELECT \n"
                    + "    firstName, mi, lastName, title, grade\n"
                    + "FROM\n"
                    + "    Student,\n"
                    + "    Enrollment,\n"
                    + "    Course\n"
                    + "WHERE\n"
                    + "    Student.ssn = ?\n"
                    + "        AND Enrollment.courseId = ?\n"
                    + "        AND enrollment.courseId = Course.courseId\n"
                    + "        AND enrollment.ssn = student.ssn";

            //create a statement
            preparedStatement = connection.prepareStatement(queryString);
            System.out.println("PrepareStatement Created...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //method jbtShowGrade_actionPerformed
    //action performed when button is pressed
    //will get the inputs from user, and place them into the the question marks above
    private void jbtShowGrade_actionPerformed(ActionEvent e) {
        //get the user inputs
        String ssn = jtfSSN.getText();
        String courseId = jtfCourseId.getText();
        //try and catch exception
        //catch SQLException due to SQL query/statement/string error
        try {
            //set the '?' to the correct value, REMEMBER starts at 1
            preparedStatement.setString(1, ssn);
            preparedStatement.setString(2, courseId);
            
            //execute the query and get the ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("PreparedStatement Executed!");
            
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
