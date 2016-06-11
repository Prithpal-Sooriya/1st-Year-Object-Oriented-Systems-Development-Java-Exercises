/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part1;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class Exercise {

    public static void main(String[] args) {
        /*convert km to miles
         input km and convert to miles and display the result
         */
        //create a scanner for input
        Scanner scan = new Scanner(System.in);
        //create int to store input
        int kilometer;
        //output an output for a responce
        System.out.println("Enter the value of kilometer: ");
        //get input
        kilometer = scan.nextInt();
        //calculate the miles
        double miles = (double) kilometer / 1.609;
        //output result
        System.out.println(kilometer + " kilometer/s is: " + miles + " miles");
    }
}
