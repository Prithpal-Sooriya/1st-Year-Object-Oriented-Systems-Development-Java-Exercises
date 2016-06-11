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
public class Add2NumbersLoop5 {
    public static void main(String[] args) {
        /*
        sum of 2 numbers:
        user enters 2 numbers and the sum shown
        user then chooses to repeat the method or exit
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //boolean to control loop
        boolean run = true;
        //run loop
        while(run){
            //prompt for input
            System.out.println("Enter a number:");
            double i = scan.nextInt();
            System.out.println("Enter a number:");
            double j = scan.nextInt();
            System.out.println("Their sum is " + (i + j));
            //check if they want to do this function again
            System.out.println("Do you want to do this again? (Y/N):");
            String ans = scan.next();
            //check if they said y/n
            if(ans.equalsIgnoreCase("N")){
                run = false;
            }
        }
    }
}
