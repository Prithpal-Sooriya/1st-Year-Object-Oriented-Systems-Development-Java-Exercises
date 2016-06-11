/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class AverageScores15 {
    public static void main(String[] args) {
        /*
        average a set of scores:
        enter 4 tests for a student and get average
        after average ask user if they want to average another set of scores
        do while loop executes at least once
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //boolean to run
        boolean run = true;
        //int to hold scores
        int[] scores = new int[4];
        //double for average
        double average = 0;
        //do while
        do {            
            //prompt user to enter scores
            for (int i = 0; i < scores.length; i++) {
                System.out.println("Enter the score for test " + (i+1) + ":");
                scores[i] = scan.nextInt();
                average += scores[i];
            }
            //divide to find average
            average /= (double) scores.length;
            
            //display average and ask if the user wants to run again
            System.out.println("Average: " + average);
            System.out.println("Do you want to run average on different scores? (Y/N)");
            String input = scan.next();
            if(input.equalsIgnoreCase("N")){
                run = false;
            }
        } while (run);
    }
}
