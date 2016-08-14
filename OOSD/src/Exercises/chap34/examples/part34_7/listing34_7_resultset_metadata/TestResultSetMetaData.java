/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.examples.part34_7.listing34_7_resultset_metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestResultSetMetaData {
    
    //main method to run code
    //throws SQLException due to create a connection and use a SQL database
    //throws ClassNotFoundException due to trying to load the driver
    public static void main(String[] args) throws 
            SQLException, ClassNotFoundException{
        
        //load the driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");
        
        //connect to a database
        Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");
        System.out.println("Connection To Database Established");
        
        //create a statement
        Statement statement = connection.createStatement();
        
        //Execute a statement, store result in ResultSet
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Enrollment");
        
        System.out.println("Statement Created And Executed");
        
        //ResultSetMetaData to store meta data from ResultSet
        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        
        //Display column names (done by iterating through all column names
        //rsMetaData to show each of the columns of the table!
        for(int i = 1; i <= rsMetaData.getColumnCount(); i++) {
            System.out.printf("%-20s\t", rsMetaData.getColumnName(i)); //columns start at 1
        }
        System.out.println();
        
        //iteratet through result and print the students names
        //rsMetaData to iterate through the columns you want
        while(resultSet.next()) {
            for(int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                System.out.printf("%-20s\t", resultSet.getObject(i));
            }
            System.out.println();
        }
        
        //close the connection
        connection.close();
    }
    
}
