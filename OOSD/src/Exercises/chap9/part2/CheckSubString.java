/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part2;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class CheckSubString {
    public static void main(String[] args) {
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt user to enter the 2 strings
        System.out.println("Enter the first string (the substring): ");
        String input1 = scan.next();
        System.out.println("Enter the second string (the sring): ");
        String input2 = scan.next();
        
        //now lets check if the first string is a substring or not
        System.out.println("Is the first String a substring? " + isSubstring(input1, input2));
    }

    private static boolean isSubstring(String input1, String input2) {
        
        //indexOf method returns the index of the specified substring from the String
        //e.g. "hello".indexOf("llo") returns 2 (starts at index 2); indexOf("z") returns -1
        //so if the return is >= 0 then it is a substring
        return (input2.contains(input1));
        
    }
}
