/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.examples.part34_6.listing34_4_callable_statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestCallableStatement {

    //main method to run code
    //creates new form in table test editor
    //throw Exception for any Exceptions given
    public static void main(String[] args) throws Exception {
        //load driver
        Class.forName("com.mysql.jdbc.Driver");

        //establish a connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");

        //create callable statement
        //calls function studentFound, which will return an int
        CallableStatement callableStatement = connection.prepareCall("{? = call studentFound(?, ?)}");

        //user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student's first name:");
        String firstName = input.next();
        System.out.println("Enter student's last name:");
        String lastName = input.next();

        //set the question marks in SQL function
        callableStatement.setString(2, firstName); //first name in 2nd param
        callableStatement.setString(3, lastName); //last name in 3rd param
        callableStatement.registerOutParameter(1, Types.INTEGER); //register 1st param as output (expect integer)

        //execute the statement
        callableStatement.execute();

        //process the result
        if (callableStatement.getInt(1) >= 1) {
            System.out.println(firstName + " " + lastName + " is in the database");
        } else {
            System.out.println(firstName + " " + lastName + " is not in the database");
        }
    }
}
