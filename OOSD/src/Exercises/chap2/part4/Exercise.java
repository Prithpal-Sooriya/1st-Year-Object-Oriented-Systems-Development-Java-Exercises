/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part4;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class Exercise {
    public static void main(String[] args) {
        /*compute product of 2 numbers
        input 2 numbers
        output the 2 numbers times together
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //output to enter number 1
        System.out.println("Enter the First number:");
        //input number
        int number1 = scan.nextInt();
        //output to enter number 2
        System.out.println("Enter the Second number:");
        //input number
        int number2 = scan.nextInt();
        //output product
        System.out.println(number1 + " * " + number2 + " is " + (number1 * number2));
    }
}
