/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part13;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Prithpal Sooriya
 */
public class CountFile {

    //main method to run code
    public static void main(String[] args) throws URISyntaxException {

        //lets find the file, spawn JFileChooser in this projects dir
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(".")); //will open file chooser on this current dir
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //if user selects a file
            File file = fileChooser.getSelectedFile();
            //try and catch block to catch FileNotFound
            try {
                //output chars, words and lines
                System.out.println("Total number of characters in file: " + countChars(file));
                System.out.println("Total number of words in file: " + countWords(file));
                System.out.println("Total number of lines in file: " + countLines(file));
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        } else { //user pressed cancel
            System.out.println("No file selected");
        }
    }

    //method to find the amount of chars in the file, throw if file is not found
    public static int countChars(File file) throws FileNotFoundException {

        //counter to count the total number of chars
        int total;
        //create a scanner to read the file
        try (Scanner scan = new Scanner(file)) {
            //counter to count the total number of chars
            total = 0;
            //read the file
            while (scan.hasNextLine()) {
                //read the line
                String currentLine = scan.nextLine();
                //add the chars amount to the total
                total += currentLine.toCharArray().length;
            }
            //close the scanner
            scan.close();
        }

        return total;
    }

    //method to find amount of words in a file
    public static int countWords(File file) throws FileNotFoundException {

        //count to count the total number of words
        int total;
        //create a Scanner to read the file
        try (Scanner scan = new Scanner(file)) {
            //count to count the total number of words
            total = 0;
            //read the file
            while (scan.hasNext()) {
                //scanner default delimeter is whitespace, so will read words
                //read the word and increment total
                scan.next();
                total++;
            }
            //close the scanner
            scan.close();
        }

        return total;
    }

    //method to find the amount of lines in a file
    public static int countLines(File file) throws FileNotFoundException {
        
        //counter to count the total number of lines
        int total;
        //create a Scanner to read the file
        try (Scanner scan = new Scanner(file)) {
            //counter to count the total number of lines
            total = 0;
            //read the file
            while (scan.hasNextLine()) {
                //read the line and increment the total
                scan.nextLine();
                total++;
            }
            //close the scanner
            scan.close();
        }

        return total;
    }
}
