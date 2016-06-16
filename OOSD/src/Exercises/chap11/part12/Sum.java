/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class Sum {
    
    //main method to allow the user to input
    public static void main(String[] args) {
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //ArrayList to store the numbers
        ArrayList<Double> list = new ArrayList<>();
        
        //Prompt the user to enter 5 numbers
        System.out.println("Enter 5 numbers (doubles): ");
        
        //for simplicity, use FOR loop to enter all the numbers
        for (int i = 0; i < 5; i++) {
            list.add(scan.nextDouble());
        }
        
        //output the sum
        System.out.println("The sum of all the numbers is: " + sum(list));
        
    }

    private static double sum(ArrayList<Double> list) {
        double total = 0;
        for (Double double1 : list) {
            total += double1;
        }
        return total;
    }
    
}
