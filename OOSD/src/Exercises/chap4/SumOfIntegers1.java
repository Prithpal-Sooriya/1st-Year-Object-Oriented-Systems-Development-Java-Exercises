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
public class SumOfIntegers1 {
    public static void main(String[] args) {
        /*
        sum of integers from 1 to a number given
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt for input
        System.out.println("Enter a positive non-zero integer:");
        int number = scan.nextInt();
        
        //for loop for sum
        int total = 0;
        for (int i = 0; i <= number; i++) {
            total = total + i;            
        }
        //print out sum
        System.out.println("The sum of all integers from 1 to " + number + " is " + total);
    }
}
