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
public class BinaryToDecimal37 {
    public static void main(String[] args) {
        /*
        binary to decimal:
        user enters binary number and output denary equiv
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt for binary input
        System.out.println("Enter a binary number");
        //save input as string (easier to work with and use function
        String binary = scan.next();
        
        int decimal = Integer.parseInt(binary, 2);
        
        //ouput denary equiv
        System.out.println("binary = " + binary);
        System.out.println("decimal = " + decimal);
    }
}
