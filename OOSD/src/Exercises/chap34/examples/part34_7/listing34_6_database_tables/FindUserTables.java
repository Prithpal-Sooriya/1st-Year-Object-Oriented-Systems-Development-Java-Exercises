/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.examples.part34_7.listing34_6_database_tables;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Prithpal Sooriya
 */
public class FindUserTables {

    //main method to run code
    //throws SQLException due to connecting and using database
    //throws ClassNotFoundExcption due to trying to load driver
    public static void main(String[] args) throws
            SQLException, ClassNotFoundException {

        //load the JDBC diver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("JDBC Driver Loaded!");

        //Establish a connection to the database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");
        System.out.println("Connection To Database Established!");

        //DatabaseMetaData to access databases metadata
        DatabaseMetaData dbMetaData = connection.getMetaData();
        System.out.println("Database Meta Data retrieved!");

        //ResultSet to obtain and store the tables from the database
        ResultSet resultSetTables = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
        System.out.println("Obtained Tables From Database!");
        //display contents
        System.out.println("");
        System.out.println("User Tables: ");
        while (resultSetTables.next()) {
            System.out.print(resultSetTables.getString("TABLE_NAME") + " ");
            //each tables in the ResultSet created can have multiple constructors
            //this is due to the dbMetaData.getTables() method
            //others are listed in the api: 
            /*
TABLE_CAT String => table catalog (may be null)
TABLE_SCHEM String => table schema (may be null)
TABLE_NAME String => table name
TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
REMARKS String => explanatory comment on the table
TYPE_CAT String => the types catalog (may be null)
TYPE_SCHEM String => the types schema (may be null)
TYPE_NAME String => type name (may be null)
SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null)
REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null)
             */

        }

        //close the connection
        connection.close();
    }

}
