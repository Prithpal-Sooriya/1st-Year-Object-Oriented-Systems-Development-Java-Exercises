/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part5;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class Exercise {
    public static void main(String[] args) {
        /*financial application: calculate tips
        reads the subtotal and gratuity rate
        computs the gratuity and total
        e.g. 10 for subtotal; 15% gratuity rate; output would be $1.5 as gratuity and $11.5 as total
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //create the variables
        double subtotal, total;
        double gratuityRate, gratuity;
        //output to enter subtotal and gratuity rate
        System.out.println("Enter the subtotal and gratuity rate:");
        //input them
        subtotal = scan.nextDouble();
        gratuityRate = scan.nextDouble();
        //calculate
        gratuity = (subtotal/100) * gratuityRate; //this is for percent of gratuity rate on subtotal
        total = subtotal + gratuity;
        System.out.println("The gratuity is $" + gratuity + " and the total is $" + total);
    }
}
