/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part3;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class ValidPassword {

    public static void main(String[] args) {
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //show user what a valid password is
        System.out.println("A valid password must:");
        System.out.println("-have at least 6 characters");
        System.out.println("-only uppercase letters and numbers (nothing else)");
        System.out.println("-have at least 3 numbers");
        
        //prompt user to enter a password
        System.out.println("Enter a password: ");
        String input = scan.next();
        
        System.out.println((isValidPassword(input)? "V" : "Inv") + "alid password");
        

    }

    public static boolean isValidPassword(String s) {
        /*
        valid password must:
        -have at least 6 characters
        -only uppercase letters and numbers (nothing else)
        -have at least 3 numbers
        */
        
        //test to see if there is at least 6 characters
        if(s.length() < 6){
            return false;
        }
        
        //convert the string input into a char array
        char[] chars = s.toCharArray();
        
        //test to see if the password consists of only lowercase and numbers
        for (char c : chars) {
            //check each character to see if they are not a digit or lowercase
            if(!(Character.isDigit(c) || Character.isUpperCase(c))){
                return false;
            }
        }
        
        //test to see if there is 3 numbers
        //replace all non digits to blank, so we just have numbers
        if(s.replaceAll("\\D", "").length() < 3){
            return false;
        }
        
        //passed all requirements so is true
        return true;
    }

}
