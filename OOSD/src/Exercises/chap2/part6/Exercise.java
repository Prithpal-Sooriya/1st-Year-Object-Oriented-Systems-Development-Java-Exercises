/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap2.part6;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise {
    public static void main(String[] args) {
        //reverse an integer e.g. 123 --> 321
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //tell user to enter a number
        System.out.println("Enter an integer between 100 and 999:");
        int startingNumber = scan.nextInt();
        
//        //now we can use % and / to extract each part of numbers
//        //int rest to store remaining digits
//        int rest;
//        //get the last digit of number 123 % 10 = 3
//        int lastDigit = startingNumber % 10;
//        //save the remaining to rest --> 123/10 = 12
//        rest = startingNumber / 10;
//        //repeat for second digit --> 12%10 = 2, 12/10 = 1
//        int secondDigit = rest % 10;
//        rest = rest / 10;
//        //repeat for first digit --> 1%10 = 1
//        int firstDigit = rest % 10;
//        
//        //now we reorder them
//        String reverseAnsString = "" + lastDigit + secondDigit + firstDigit;
//        System.out.println("The reverse of " + startingNumber + " is " +reverseAnsString);
        
        String reverseAnsString = intReverser(startingNumber);
        System.out.println("The reverse of " + startingNumber + " is " +reverseAnsString);
    }
    
    private static String intReverser(int i){
        int digitPlace = i % 10;
        int rest = i / 10;
        if(rest == 0){
            return String.valueOf(digitPlace);
        }
        else{
            return "" + digitPlace +intReverser(rest);
        }
    }
}
