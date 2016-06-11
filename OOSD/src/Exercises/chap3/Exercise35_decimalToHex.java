/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap3;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise35_decimalToHex {
    public static void main(String[] args) {
        /*
        decimal to hex
        only decimal from 0 to 15
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //could use string array, but too much effort
       
        //prompt for input
        System.out.println("Enter a decimal value (0 to 15):");
        int input = scan.nextInt();
        
        if(input > 15 || input < 0){
            System.out.println("Invalid input");
        }
        else{
            System.out.println("The hex value is " + Integer.toHexString(input).toUpperCase());
        }
    }
}
