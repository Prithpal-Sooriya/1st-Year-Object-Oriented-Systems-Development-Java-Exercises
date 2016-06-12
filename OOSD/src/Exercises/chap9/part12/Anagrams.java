/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part12;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class Anagrams {
    
    public static void main(String[] args) {
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt user for inputs
        System.out.println("Enter the first String:");
        String input1 = scan.next();
        System.out.println("Entre the second String:");
        String input2 = scan.next();
        
        //output
        System.out.println("The two Strings are " + (isAnagram(input1, input2) ? "anagrams" : "not anagrams"));
        
    }
    
    //method that checks if the 2 strings are anagrams
    public static boolean isAnagram(String s1, String s2){
        //just in case, remove all non letters and convert them to same case
        String s1Chars = s1.replaceAll("[^A-Za-z]", "").toLowerCase();
        String s2Chars = s2.replaceAll("[^A-Za-z]", "").toLowerCase();
        
        //count occurance of each letter in the strings
        int alphabets1[] = new int[26]; //[0] = a, [25] = z
        for (int i = 0; i < s1Chars.length(); i++) {
            char c = s1Chars.charAt(i);
            int valueOfChar = (int) c;
            alphabets1[valueOfChar - 'a']++; //'a' - 'a' = 0 thus index 0; 'z' - 'a' = 25 thus index 25
        }
        int alphabets2[] = new int[26]; //[0] = a, [25] = z
        for (int i = 0; i < s2Chars.length(); i++) {
            char c = s2Chars.charAt(i);
            int valueOfChar = (int) c;
            alphabets2[valueOfChar - 'a']++; //'a' - 'a' = 0 thus index 0; 'z' - 'a' = 25 thus index 25
        }
        
        //now lets see if they match and return true/false
        return Arrays.equals(alphabets1, alphabets2);
        
    }
}
