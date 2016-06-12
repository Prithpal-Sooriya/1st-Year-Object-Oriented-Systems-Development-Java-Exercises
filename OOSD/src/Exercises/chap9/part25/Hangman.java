/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part25;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class Hangman {

    public static void main(String[] args) {

        //Words array
        String words[] = {
            "orange", "tree", "grape", "river", "steel",
            "awake", "milk", "whisper", "jam", "smart",
            "compete", "delight", "lucky", "handy", "listen",
            "vessel", "detect", "coherent", "crash", "serve",
            "death", "closed", "childlike", "aftermath", "stereotyped",};
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //boolean to run the game, will use to end the game
        boolean run = true;

        while (run) {
            //generate the random word to use, by use of index
            int wordIndex = generateRandomNumber(0, words.length - 1);

            //need an array to store letters that have/havn't been used
            int userAlphabet[] = new int[26]; //a = index 0, z = index 25
            //initialise the userAlphabet to ensure that they start at 0
            for (int i : userAlphabet) {
                i = 0;
            }

            //a counter to count how many misses they have done
            int misses = 0;
            
            //the word to be displayed and checked if is complete
            String displayWord = displayWord(words[wordIndex], userAlphabet);

            //start game
            while (wordIncomplete(displayWord)) {
                //display the word and prompt the user to guess
                System.out.println("(Guess) Enter a letter in word " + displayWord);
                char input = scan.next().toLowerCase().charAt(0);
                
                //validate the input
                //is it a letter
                if(!Character.isLetter(input)){
                    System.out.println("This is not a letter");
                    continue; //go back to the start
                }
                //if it has been used
                if(userAlphabet[((int) input) - 'a'] > 0){
                    //it has been used
                    System.out.println("You have already used " + input);
                    continue; //go back to the start
                }
                //if the letter is in the word
                if(words[wordIndex].contains(""+input)){
                    //the letter is in the word
                    //increment the letter in the userAlphabet
                    userAlphabet[((int) input) - 'a']++;
                }
                else{
                    //the letter is not in the word
                    //increment the letter in the userAlphabet and the misses counter
                    userAlphabet[((int) input) - 'a']++;
                    misses++;
                    //prompt user that the letter was not in the word
                    System.out.println(input + " is not in the word");
                }
                
                //user input is finished, so time to update the word displayed
                displayWord = displayWord(words[wordIndex], userAlphabet);
            }
            
            //once the player has got the word correct, display the word and show how many misses they have
            System.out.println("The word is " + words[wordIndex] + ". You missed " + misses + " times.");
            
            //ask if they want to play again
            System.out.println("Do you want to guess another word? Enter y or n: ");
            char input = scan.next().charAt(0);
            if(input == 'n')
                run = false;
            else if(input == 'y')
                run = true;
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

    private static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        //return the random number
        return randomNum;
    }

}
