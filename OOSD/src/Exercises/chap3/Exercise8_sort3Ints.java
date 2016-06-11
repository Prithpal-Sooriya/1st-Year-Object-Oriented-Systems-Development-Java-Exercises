/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise8_sort3Ints {
    public static void main(String[] args) {
        /*
        Sort three integers
        input 3 integers in num1, 2, 3
        then sort the numbers
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //store numbers in an array
        int num[] = new int[3];
        
        //prompt the input of numbers
        for(int i = 0; i < 3; i++){
            System.out.println("enter integer " + (i+1) + ":");
            num[i] = scan.nextInt();
        }
        
        //sort the array using its function
        Arrays.sort(num);
        
        //output the numbers in order
        for(int i = 0; i < 3; i++){
            System.out.format("%d ", num[i]);
        }
        
        
    }
}
