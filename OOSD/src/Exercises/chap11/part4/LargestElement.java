/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class LargestElement {
    
    //main method to run the program
    public static void main(String[] args) {
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //ArrayList to hold the list of Integers
        ArrayList<Integer> numbers = new ArrayList<>();
        
        //prompt user to enter list of numbers and end with 0
        System.out.println("Enter integers (input ends with 0): ");
        int input; //to hold the input
        do{
            //save the input
            input = scan.nextInt();
            //add the input to the arraylist
            numbers.add(input);
        }
        while(input != 0);
        //now the list is populated, output the largest number
        System.out.println("The largest number in the list given is: " + max(numbers));
    }
    
    //method to find the largest integer in the ArrayList
    public static Integer max(ArrayList<Integer> list){
        //return null  if the list is null of size = 0
        if(list == null || list.isEmpty()){
            return null;
        }
        
        //integer to hold the largest number
        Integer max = 0;
        //FOR loop to loop through all elements to find the largest integer
        for (Integer integer : list) {
            //find the largest integer between max or the element
            //then replace max with that element (if larger)
            max = Math.max(max, integer);
        }
        //return the largest number
        return max;
    }
    
}
