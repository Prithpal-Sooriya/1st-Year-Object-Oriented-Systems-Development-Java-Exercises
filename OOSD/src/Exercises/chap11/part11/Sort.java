/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class Sort {
    //main method to enter users numbers
    public static void main(String[] args) {
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //ArrayList to store 
        ArrayList<Integer> list = new ArrayList<>();
        
        //prompt user to enter 5 numbers
        System.out.println("Enter 5 numbers (integers): ");
        
        //for simplicity, lets just use for loop for get the 5 numbers
        for (int i = 0; i < 5; i++) {
            list.add(scan.nextInt());
        }
        
        //run the method
        //we are passing a pointer to the arraylist, so we dont need to store new value into the arraylist
        sort(list);
        
        //output the list
        System.out.println(list.toString());
        
    }
    
    public static void sort(ArrayList<Integer> list){
        //want to sort the list in increasing order, smallest first
        //easiest way, use the collections class
        Collections.sort(list);
        
    }
}
