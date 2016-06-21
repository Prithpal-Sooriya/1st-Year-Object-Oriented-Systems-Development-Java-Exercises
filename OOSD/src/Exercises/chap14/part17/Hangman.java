/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part17;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class Hangman {

    //main method to run code
    public static void main(String[] args) {

        boolean run = true;

        //while loop to check if player wants to play again or not
        while (run) {
            //Scanner to read the file
            Scanner scan = new Scanner(Hangman.class.getResourceAsStream("Hangman.txt"));

            //pick a number from 0-24 (as there are 24 words in the file
            int index = new Random().nextInt(25); //random int from 0-24
            //now read file, keep doing scan.next until we reach our word
            for (int i = 0; i < index - 1; i++) { //use up all the words we dont want
                scan.next();
            }
            String word = scan.next(); //now we have our word
            //close the scanner
            scan.close();

            //need an array to store letters that have/havn't been used
            int userAlphabet[] = new int[26]; //a = index 0, z = index 25
            //initialise the userAlphabet to ensure that they start at 0
            for (int i : userAlphabet) {
                i = 0;
            }

            //a counter to count how many misses they have done
            int misses = 0;

            //store the word what is to be displayed to user
            String displayWord = displayWord(word, userAlphabet);

            //reuse the scanner by using as user input
            scan = new Scanner(System.in);

            //start game
            while (wordIncomplete(displayWord)) {
                //display the word and prompt the user to guess
                System.out.println("(Guess) Enter a letter in word " + displayWord);
                char input = scan.next().toLowerCase().charAt(0);

                //validate the input
                //is it a letter
                if (!Character.isLetter(input)) {
                    System.out.println("This is not a letter");
                    continue; //go back to the start
                }
                //if it has been used
                if (userAlphabet[((int) input) - 'a'] > 0) {
                    //it has been used
                    System.out.println("You have already used " + input);
                    continue; //go back to the start
                }
                //if the letter is in the word
                if (word.contains("" + input)) {
                    //the letter is in the word
                    //increment the letter in the userAlphabet
                    userAlphabet[((int) input) - 'a']++;
                } else {
                    //the letter is not in the word
                    //increment the letter in the userAlphabet and the misses counter
                    userAlphabet[((int) input) - 'a']++;
                    misses++;
                    //prompt user that the letter was not in the word
                    System.out.println(input + " is not in the word");
                }

                //user input is finished, so time to update the word displayed
                displayWord = displayWord(word, userAlphabet);

            }

            //once the player has got the word correct, display the word and show how many misses they have
            System.out.println("The word is " + word + ". You missed " + misses + " times.");
            //ask if they want to play again
            System.out.println("Do you want to guess another word? Enter y or n: ");
            char input = scan.next().charAt(0);
            if (input == 'n') {
                run = false;
            } else if (input == 'y') {
                run = true;
            }
        }
        //end game
    }

    private static boolean wordIncomplete(String word) {
        return word.contains("*"); //return true if still has * (incomplete word)
    }

    private static String displayWord(String word, int[] userAlphabet) {
        //this will be used to create a String to return to the main program
        StringBuilder incompleteWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            //get the character from the word
            char charOfWord = word.charAt(i);
            //find the index of this charOfWord to the array
            int charNumber = (int) charOfWord;
            int index = charNumber - 'a'; //'a' - 'a' = 0, therefore index 0; 'z' - 'a' = 25, therefore index 25

            //check if the letter needs to be hidden or not
            incompleteWord.append((userAlphabet[index] > 0) ? charOfWord : '*');
        }
        //return the incomplete word
        return incompleteWord.toString();
    }

}
