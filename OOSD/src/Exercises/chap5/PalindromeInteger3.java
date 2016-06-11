/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class PalindromeInteger3 {
    public static void main(String[] args) {
        /*
        input int
        reverse int and check if int is palandrome
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //prompt for input
        System.out.println("Enter an integer:");
        int startingNumber = scan.nextInt();
        
        System.out.println("The reverse of your number " + startingNumber + " is: " + reverse(startingNumber));
        if(isPalindrome(startingNumber) == true)
            System.out.println("Your number is a palindrome");
    }
    
    public static int reverse(int number){
        int input = number;
        int reversedNumber = 0;
        while(input != 0){
            //add last digit to number while also shifting rest of digits by 1 (*10)
            reversedNumber = (reversedNumber * 10) + (input % 10);
            //remove the last digit from input
            input /= 10;
        }
        return reversedNumber;
    }
    
    public static boolean isPalindrome(int number){
       return (number == reverse(number));
    }
}
