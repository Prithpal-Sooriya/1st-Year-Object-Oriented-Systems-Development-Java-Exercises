/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class FindLargestNumber5 {
    public static void main(String[] args) {
        /*
        Find largest number:
        find and display the largest of 3 numbers
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //3 numbers to test
        double i[] = new double[3];
        
        for (int j = 0; j < i.length; j++) {
            //prompt user to enter number
            System.out.println("Enter double " + (j + 1) + ":");
            i[j] = scan.nextDouble();
        }
        
        displayLargestNumber(i[0], i[1], i[2]);
    }
    public static void displayLargestNumber(double num1, double num2, double num3){
        double temp = Math.max(num1, num2);
        System.out.println("The largest of these numbers is: " + Math.max(temp, num3));
    }
}
