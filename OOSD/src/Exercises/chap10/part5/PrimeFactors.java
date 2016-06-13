/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class PrimeFactors {
    
    
    public static void main(String[] args) {
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt user to enter a number
        System.out.println("Enter a number");
        int input = scan.nextInt(); //store the integer input
        
        //store prime factors into the stack
        IntStack primeFactors = new IntStack(input/2);
        
        //store the users number to be used
        int number = input;
        
        //loop to get the prime factors (the prime factor cant be bigger than the number)
        for(int i = 2; i <= number; i++){
            if(number % i == 0){
                //found a number that is divisible to the input
                primeFactors.push(i);
                number = number / i; //find whats leftover
                i--; //may get more that 1 of that number (e.g. [2, 2, 3] = 12's prime factors
            }
        }
        
        //now we have stored the items in the stack, pop them out to display in reverse order
        System.out.print("Prime factors of " + input + " are: [");
        while(primeFactors.getTail() > 0){
            System.out.print(primeFactors.pop() + (primeFactors.getTail() > 0? ", " : "]\n"));
        }
    }
    
    
    
    
}
