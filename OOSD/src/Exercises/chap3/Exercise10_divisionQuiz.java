/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap3;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise10_divisionQuiz {
    public static void main(String[] args) {
        /*
        Game: division quiz
        division question with 2 integers less than 1000
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //random number generater
        Random rand = new Random();
        
        //use format of rand.nextInt((MAX - MIN) + 1) + MIN
        int int1 = rand.nextInt((1000 - 1) + 1) + 1;
        int int2 = rand.nextInt((1000 - 1) + 1) + 1;
        
        //what the answer should be (in 2 decimal places)
            //this gets the double, and outputs the format as a String
        DecimalFormat df = new DecimalFormat("00.00");
            //so to get out double ans, we will parse it as a double
        double ans = (double) int1/int2;
        ans = Double.parseDouble(df.format(ans));
        //output to user
        System.out.println("What is " + int1 + " / " + int2 + " (2dp)?");
        //input
        double input = scan.nextDouble();
            //cut off any digits past the input
        input = Double.parseDouble(df.format(input));
        
        //if statement to check if the values of ans and input are the same
        if(input == ans){
            System.out.println("You are correct!!!");
        }
        else{
            System.out.println("Wrong. The correct answer is " + ans);
        }
    }
}
