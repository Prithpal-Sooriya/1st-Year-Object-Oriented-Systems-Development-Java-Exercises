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
public class NumbersInRange7 {
    public static void main(String[] args) {
        /*
        numbers in a given range:
        user enters lowerbound and upper bound
        and displays all numbers in that range
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt for input
        System.out.println("Enter the lower bound:");
        int lower = scan.nextInt();
        System.out.println("Enter the upper bound:");
        int upper = scan.nextInt();
        
        //for loop and then we display
        for(; lower <= upper; lower++){
            System.out.format("%d ", lower);
        }
    }
}
