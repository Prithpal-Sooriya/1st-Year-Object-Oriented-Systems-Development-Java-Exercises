/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.examples.part34_4.listing34_1_simple_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Prithpal Sooriya
 */
public class SimpleJDBC {

    //main method to run code
    public static void main(String[] args) throws
            SQLException, ClassNotFoundException {
        //LOAD THE JDBC DRIVER

        //remember (for Oracle and MySQL, find the driver online and add to libraries/classpath
        //will add the MySQL Driver
        //IF PLATFORM DEPENDANT, MySQL will get you to download connector J, dont need to worry about driver
        //IF sending to someone else/platform independant, then will need to add to libraries
        //for MySQL
        Class.forName("com.mysql.jdbc.Driver");

        //for Access
        //Class.forName("sun.jdbc.odbc.Jdbc0dbcDriver");
        //for Oracle
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver Loaded!");
        //=====================================================================
        //CONNECT TO THE DATABASE

        //connect using MySQL
        //"jdbc:mysql://localhost/database name", "username", "password"
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "Prithpal", "psooriya");
        //use "jdbc:mysql://localhost/javabook?autoReconnect=true&useSSL=false" to remove the useSSL warning
        
        //connect using Access
        //Connection connection = DriverManager.getConnection("jdbc:odbc:dataSource");
        //connect using Oracle
        //Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port#:oracleDBSID");
        System.out.println("Database Connected!");
        //=====================================================================
        //CREATE A STATEMENT

        Statement statement = connection.createStatement();

        System.out.println("Statement Created!");
        //=====================================================================
        //EXECUTE A STATEMENT

        //ResultSet required since we are querying the database
        ResultSet resultSet = statement.executeQuery(
                "SELECT firstName, mi, lastName "
                + "FROM Student "
                + "WHERE lastName = 'Smith'"
        );

        System.out.println("Statement Executed!");
        //=====================================================================
        //PROCESS ResultSet

        //iterate through the result and print the students names
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
            //returns each column as a strign (so all results can be converted into a string output
        }
        
        System.out.println("Result Set Processed!");
        //=====================================================================
        //CLOSE THE CONNECTION TO THE DATABASE
        
        connection.close();
        
        System.out.println("Connection to the database is closed!");
    }

}
