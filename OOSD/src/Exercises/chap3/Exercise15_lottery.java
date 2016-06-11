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
public class Exercise15_lottery {

    public static void main(String[] args) {
        /*
         Game: lottery
         generate a lottery of a 3 digit number
         user wins by the following rules
         --> if user matches lottery number in exact order they win $10 000
         --> if the digits match all the lottery digits they win $3000
         --> if 1 digit matches the lottery input they win $1000
         */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //random number generator
        Random rand = new Random();
        //generate random 3 digit number
        //use format of rand.nextInt((MAX - MIN) + 1) + MIN
        //--> all 3 digit numbers are between 100 and 999
        int lottery = rand.nextInt((999 - 100) + 1) + 100;

        System.out.println(lottery);
        //prompt user to guess
        System.out.println("Enter a 3 digit number:");
        int input = scan.nextInt();

        //run subroutine
        int prize = correctness(input, lottery);

        //if statement to see how much they won!!!
        if (prize == 3) {
            System.out.println("YOU WON $10 000");
        } else if (prize == 2) {
            System.out.println("YOU WON $3000");
        } else if (prize == 1) {
            System.out.println("YOU WON $1000");
        } else {
            System.out.println("Sorry you won nothing, try again next time");
        }

    }

    private static int correctness(int userInput, int answer) {
        //int to record score/ how correct they are
        int score = 0;
        if (userInput == answer) {
            //set score to 3 and return it
            score = 3;
            return score;
        }
        //since its not exact we have to check the other options
        //lets convert the user input and input to a string so we can check them
        String userString = String.valueOf(userInput);
        String answerString = String.valueOf(answer);

        //place them into char array so we can check the values of all the digits to the other digits
        char user[] = userString.toCharArray();
        char ans[] = answerString.toCharArray();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //check all positions of j (user[]) to i(ans)
                if (user[j] == ans[i]) {
                    //increment score
                    score++;
                    //break out of this inner loop so we can test the other digits for the answer
                    break;
                }
            }
        }
        //now lets check the score
        if (score == 3) {
            //if all the digits were the same.... but they were not in the correct order they get the second best price
            return 2;
        } else if (score < 3 && score > 0) {
            //if only 1 or 2 digits match, they will only get the lowest price
            return 1;
        } else {
            return 0;
        }
    }
}
