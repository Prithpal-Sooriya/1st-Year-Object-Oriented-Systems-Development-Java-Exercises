/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class FactorialWithinRange20 {
    public static void main(String[] args) {
        /*
        factorial of all numbers within range
        each line displays numebr and its factorial
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt user for upper and lower bounds
        System.out.println("Enter lower bound:");
        int i = scan.nextInt();
        System.out.println("Enter upper bound");
        int upperBound = scan.nextInt();
        
        //for loop to iterate and find factorials
        System.out.format("%-15s%-15s\n", "Number", "Factorial");
        for (; i <= upperBound; i++) {
            //lets work out factorial using another for loop
            int factorial = 1;
            for (int j = 0; j < i; j++) {
                factorial *= (j+1);
            }
            System.out.format("%-15d%-15d\n", i, factorial);
        }
    }
}
