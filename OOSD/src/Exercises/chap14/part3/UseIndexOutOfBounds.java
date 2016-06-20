/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class UseIndexOutOfBounds {
    
    //main method to run code
    public static void main(String[] args) {
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //create array with 100 random integers
        Random rand = new Random();
        int array[] = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        
        //prompt user to enter an index
        System.out.println("Enter index for array size 100 (enter 0 to 100)");
        int index = scan.nextInt();
        
        try{
            System.out.println("The random integer in index " + index + " is: " + array[index]);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Out Of Bounds");
        }
    }
    
}
