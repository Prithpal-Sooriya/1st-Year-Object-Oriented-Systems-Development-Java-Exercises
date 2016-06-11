/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part3;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class ConvertBitsToBytes {
    public static void main(String[] args) {
        /* Convert bits to bytes
        Write a program that reads the number of bits, converts it to bytes and displays result        
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //output for user to enter number of bits
        System.out.println("Enter the number of bits:");
        //save the input into an int
        int bits = scan.nextInt();
        //do calculation on bits to convert to bytes
        int bytes = bits/8;
        int newbits = bits%8;
        //output the number of bytes and bits left
        System.out.println(bits + " bits is " + bytes +" byte/s and " + newbits + " bit/s left over");
    }
}
