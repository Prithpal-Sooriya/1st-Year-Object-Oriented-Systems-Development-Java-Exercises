/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part13;

/**
 *
 * @author Prithpal Sooriya
 */
public class Palindrome {
    
    public static void main(String[] args) {
        
        //we have got a string in the index 0 of the arg[], now test if it is a palindrome
        /*
        word testings:
        bob
        sixaxis
        */
        System.out.println(args[0] + " is " + (isPalindrome(args[0]) ? "a palindrome" : "not a palindrome"));
        
    }
    
    //check if a string is a palindrome
    public static boolean isPalindrome(String s){
        //need to store the index of the first and last char of the string
        int low = 0;
        int high = s.length()-1;
        
        //loop to see each end of the string and compare
        while(low < high){
            //compare ends of string
            if(s.charAt(low) != s.charAt(high)){
                //not a palidrome so end
                return false;
            }
            
            //move inwards to test the other chars
            low++;
            high--;
        }
        
        //it has passed the while loop so is a palindrome
        return true;
    }
    
}
