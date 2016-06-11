/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise4_learnMultiplication {
    public static void main(String[] args) {
        /*
        Game: learn multiplication
        generate 2 ints under 100
        input product of integers
        true if correct, false if not
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //create random number generator
        Random rand = new Random();
        
        //use rand to create random ints
            //use format of rand.nextInt((MAX - MIN) + 1) + MIN if there are bounds
            //bounds are 1 - 9
        int number1 = rand.nextInt((99) + 1) + 1;
        int number2 = rand.nextInt((99) + 1) + 1;
        
        //find out what the answer is
        int ans = number1 * number2;
        
        //output to user to input
        System.out.format("What is the product of %d and %d?\n", number1, number2);
        //input
        int input = scan.nextInt();
        
        //check with if statement if correct
        if(input == ans){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
