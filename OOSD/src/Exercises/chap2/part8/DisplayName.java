/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part8;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class DisplayName {
    public static void main(String[] args) {
        /* Display first middle and last names
        String vars: firstName, middleName, lastName
        input and then display
        */
        
        //vars to use
        String firstName;
        String middleName;
        String lastName;
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //output to user to enter names
        System.out.println("Enter your First Name:");
        //input firstname
        firstName = scan.next();
        //output middlename
        System.out.println("Enter your Middle Name:");
        //input middlename
        middleName = scan.next();
        //output lastname
        System.out.println("Enter your Last Name");
        //input last name
        lastName = scan.next();
        
        //output full name
        System.out.format("The name entered is %s %s %s\n", firstName, middleName, lastName);
    }
}
