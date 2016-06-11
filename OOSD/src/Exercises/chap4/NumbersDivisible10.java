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
public class NumbersDivisible10 {

    public static void main(String[] args) {
        /*
         find numbers divisible by 3 and 4:
         display all numbers divisible by 3 and 4 within a range given by user
         5 numbers per line and each number has 2 spaces
         */

        //scanner for input
        Scanner scan = new Scanner(System.in);

        //prompt user for range
        System.out.println("Enter lower bound:");
        int i = scan.nextInt();
        System.out.println("Enter upper bound");
        int upperBound = scan.nextInt();

        //need int for calculating if a new line needed
        int newline = 0;

        for (/* nothing */; i <= upperBound; i++) {
            //we need if statement to check if a number is found to be divisible
            if (i % 3 == 0 && i % 4 == 0) {
                newline++;
                System.out.format("%-2d  ", i);
                //check if we need a new line
                if (newline % 5 == 0) {
                    newline = 0;
                    System.out.format("\n");
                }
            }
        }
    }
}
