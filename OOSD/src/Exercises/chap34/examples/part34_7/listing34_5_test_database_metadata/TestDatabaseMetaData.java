/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.examples.part34_7.listing34_5_test_database_metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestDatabaseMetaData {
 
    //main method to run code
    //throws SQLException due to SQL statements
    //throws ClassNotFoundException due to JDBC driver not found
    public static void main(String[] args) throws
            SQLException, ClassNotFoundException{
        //load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");
        
        //connect to the database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");
        System.out.println("Database Connected");
        
        //get the Database metadata
        DatabaseMetaData dbMetaData = connection.getMetaData();
        
        //print database metadata
        System.out.println("");
        System.out.println("Database Metadata: ");
        System.out.println("");
        System.out.println("Database URL: " + dbMetaData.getURL());
        System.out.println("Database Username: " + dbMetaData.getUserName());
        System.out.println("");
        System.out.println("Database ProductName: " + dbMetaData.getDatabaseProductName());
        System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
        System.out.println("");
        System.out.println("JDBC Driver Name: " + dbMetaData.getDriverName());
        System.out.println("JDBC Driver Version: " + dbMetaData.getDriverVersion());
        System.out.println("");
        System.out.println("JDBC Driver Major Version: " + dbMetaData.getJDBCMajorVersion());
        System.out.println("JDBC Driver Minor Version: " + dbMetaData.getJDBCMinorVersion());
        System.out.println("");
        System.out.println("MaxTableNameLength: " + dbMetaData.getMaxTableNameLength());
        System.out.println("MaxColumnsInTable: " + dbMetaData.getMaxColumnsInTable());
        
        //close the connection
        connection.close();
        
    }
    
}
