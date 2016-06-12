/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part5;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class OccurancesOfDigits {
    
    public static void main(String[] args) {
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt user to input
        System.out.println("Input a String of numbers (can throw in other characters):");
        String input = scan.next();
        
        //create and fill the array from the int array passed back
        int numbers[] = count(input);
        
        //now we can output the occurances
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("The number of occurances of " + i + " is: " + numbers[i]);
        }
    }
    
    //method to calculate and return the occurances of each digit
    public static int[] count(String s){
        
        //create an int array to hold the different types of numbers
        int counts[] = new int[10];
        
        //first, remove all the non digits and convert into a char array
        char numbers[] = s.replaceAll("\\D", "").toCharArray();
        
        //FOR loop to read each number and increment their occurances
        for (char number : numbers) {
            counts[Character.getNumericValue(number)]++;
        }
        
        return counts;
    }
}
