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
public class Exercise14_headsOrTails {
    public static void main(String[] args) {
        /*
        Game: heads or tails
        random int of 1 or 0
        guess
        output if correct or not
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //random number generater
        Random rand = new Random();
        //random int of 1 or 0
            //use format of rand.nextInt((MAX - MIN) + 1) + MIN
        int coin = rand.nextInt((1-0) + 1);
        
        //prompt for input
        System.out.println("Heads or tails (1 or 0)");
        int input = scan.nextInt();
        
        //check if correct or incorrect
        if(input == coin){
            System.out.println("Correct!!!");
        }
        else{
            System.out.println("Incorrect");
        }
    }
}
