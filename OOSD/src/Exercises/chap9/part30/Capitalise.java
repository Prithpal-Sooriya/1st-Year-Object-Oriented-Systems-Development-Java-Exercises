/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part30;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class Capitalise {
    
    //test class
    public static void main(String[] args) {
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt for input String
        System.out.println("Enter a String:");
        String input = scan.nextLine(); //want to read the whole input as 1 String
        
        //output the capitalised String
        System.out.println(title(input));
        
    }
    
    public static String title(String s){
        
        //we dont know if sentence, so will need to split into tokens
        String tokens[] = s.split(" ");
        
        //String builder to build the new String
        StringBuilder newString = new StringBuilder();
        
        //FOR loop to iterate through each token to capitalise
        for (String token : tokens) {
            //check if the first character of each token is a letter
            if(Character.isLetter(token.charAt(0))){
                //we want to capitalise the token
                char firstLetter = Character.toUpperCase(token.charAt(0));
                String restOfWord = token.substring(1); //want the substring to start at 1
                
                //add the token together and add to String builder
                newString.append((firstLetter + restOfWord));
            }
            else{
                //it does not start with a letter, so just add to string builder
                newString.append(token);
            }
            //add a space after each word added
            newString.append(" ");
        }
        
        //return the new string
        return newString.toString();
    }
    
}
