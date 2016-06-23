/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part19;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestComplex {
    
    //main method to run code
    public static void main(String[] args){
        
        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        
        double realPart, imaginaryPart;
        
        //prompt user to enter first complex number
        System.out.println("Enter the first complex number:");
        realPart = scan.nextDouble();
        imaginaryPart = scan.nextDouble();
        Complex c1 = new Complex(realPart, imaginaryPart);
        
        //prompt user to enter second complex number
        System.out.println("Enter the second complex number");
        realPart = scan.nextDouble();
        imaginaryPart = scan.nextDouble();
        Complex c2 = new Complex(realPart, imaginaryPart);
        
        //output Addition, Subtraction, Multiplication, Division, and Absolute
        System.out.println(c1 + " + " + c2 + " = " + Complex.add(c1, c2));
        System.out.println(c1 + " - " + c2 + " = " + Complex.subtract(c1, c2));
        System.out.println(c1 + " * " + c2 + " = " + Complex.multiply(c1, c2));
        System.out.println(c1 + " / " + c2 + " = " + Complex.divide(c1, c2));
        System.out.println("|" + c1 + "| = " + Complex.abs(c1));
        
    }
    
}
