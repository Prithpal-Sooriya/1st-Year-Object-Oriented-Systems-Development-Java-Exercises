/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part31;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class SwapCase {
    
    //test the method swapCase()
    public static void main(String[] args) {
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt for user input
        System.out.println("Enter a String:");
        String input = scan.nextLine(); //want to read spaces as part of 1 String
        
        //output the new String
        System.out.println(swapCase(input));
        
    }
    
    //swaps the cases of all letters in a string
    public static String swapCase(String s){
        
        //String builder to append each character of the String
        StringBuilder newString = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            //read each character from the String
            char c = s.charAt(i);
            
            //check if the character is a letter
            if(Character.isLetter(c)){
                //we want to swap the case
                if(Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                }
                else{
                    c = Character.toUpperCase(c);
                }
                
                //append the character
                newString.append(c);
            }
            else{
                //it is not a letter, so just append it
                newString.append(c);
            }
        }
        
        //return the newString
        return newString.toString();
    }
    
}
