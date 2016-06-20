/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part2;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class QuotientValidation {
    
    //main class for code to run
    public static void main(String[] args) {
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        //2 integers to store numerator and denominator
        int numerator = 0;
        int denominator = 0;
        
        //while loop to prompt user to enter integers (if they give incorrect denominator)
        while(true){
            //lets use try and catch, just cause we can
            try{
                //prompt user to enter 2 integers
                System.out.println("Enter first integer (numerator):");
                numerator = scan.nextInt();
                System.out.println("Enter second integer (denominator):");
                denominator = scan.nextInt();
                //check if denominator is == 0
                if(denominator == 0){
                    throw new ArithmeticException();
                } 
                else{
                    break; //break out of the while loop
                }
            }
            catch(ArithmeticException e){
                //prompt user that the second integer is 0
                System.out.println("The denominator (second integer) cannot be 0 (you cannot divide by 0)");
            }
            //rerun loop
        }
        
        //perform the calculation
        int result = numerator / denominator;
        
        System.out.println("The Quotient of " + numerator + " / " + denominator + ": " + result);
        
    }
    
}
