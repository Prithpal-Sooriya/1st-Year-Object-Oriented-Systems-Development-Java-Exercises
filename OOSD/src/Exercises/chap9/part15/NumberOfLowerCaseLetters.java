/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part15;

/**
 *
 * @author Prithpal Sooriya
 */
public class NumberOfLowerCaseLetters {
    
    public static void main(String[] args) {
        //the input String is passed through the arguments
        for (String arg : args) {
            System.out.println("The number of lowercase letters in the String " + arg + " is: " + lowecaseNumber(arg));
        }
        
    }
    
    private static int lowecaseNumber(String s){
        //remove all the characters that are not lowercase then return the size
        return s.replaceAll("[^a-z]", "").length();
    }
    
}
