/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part17;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class GuessTheCapital {

    public static void main(String[] args) {

        //Scanner to read the file of states and capitals
        Scanner read = new Scanner(GuessTheCapital.class.getResourceAsStream("StatesAndCapitals.txt"));
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //counter to find total of how many they got right
        int total = 0;
        
        //the text file is set with state <space> capital, so will need to store until we split it
        String stateAndCapital;
        while(read.hasNextLine()){ //while the text file is not empty
            stateAndCapital = read.nextLine(); //read the whole line
            String tokens[] = stateAndCapital.split(" "); //split the capital and the state
            
            //show question and user input
            System.out.println("What is the Capital of " + tokens[0] + "?");
            String input = scan.nextLine();
            
            //see if they are correct
            String answer = tokens[1].replaceAll("-", " "); //in case their answer is not with dashes
            if(input.equalsIgnoreCase(answer) || input.equalsIgnoreCase(tokens[1])){
                total++; //they gained a point for correct answer
                System.out.println("Your answer is correct!");
            }
            else{
                System.out.println("The correct answer should be " + answer);
            }
        }
        
        //show the amount they got correct
        System.out.println("You got " + total + " / 50 correct");
        
    }

}
