/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part4;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class OccurancesOfCharacters {
    
    public static void main(String[] args) {
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt user to enter a String and a character
        System.out.println("Enter a String: ");
        String str = scan.next();
        System.out.println("Enter a Character to find occurance of: ");
        char a = scan.next().charAt(0);
        
        //output the occurances of the char in the string
        System.out.println("The number of occurances of " + a + " in the String " + str + " is: " + count(str, a));
    }
    
    //method to calculate the number of occurances of a character in a string
    public static int count(String str, char a){
        //find length of string without the character
        //then subtract that from the original lenght to find the occurance of the character
        int otherChars = str.replaceAll(Character.toString(a), "").length();
        int occuranceOfGivenCharacter = str.length() - otherChars;
        return occuranceOfGivenCharacter;
    }
}
