/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prithpal Sooriya
 */
public class ReadWriteData {

    //main method to run code
    public static void main(String[] args) {

        String workingDir = System.getProperty("java.class.path");
        System.out.println("Current working directory : " + workingDir);
        File file = new File("src/Exercises/chap14/part15/100RandomIntegers.txt");
        if (!file.exists()) {
            //the file doesnt exist, so lets create this file of 100 random integers
            createFileOfRandomIntegers(file);
        }
        ArrayList<Integer> numbers = readFileOfRandomIntegers(file);
        Collections.sort(numbers);
        //variable to hold the size of the array (if we remove items from the array the size for the for loop will change)
        int size = 0;
        //System.out.println(numbers.toString());
  
        while (!numbers.isEmpty()) {
            size = numbers.size();
            for (int i = 0; i < ((size >= 10) ? 10 : numbers.size()); i++) { //print the row of size 10, or whatevers left
                System.out.print(numbers.get(0).toString() + " ");
                //remove that item
                numbers.remove(0);
            }

            System.out.println(""); //new row
        }
    }

    private static void createFileOfRandomIntegers(File file) {
        try {
            //create the file
            file.createNewFile();
            try {
                //create a print writer to write to the file
                PrintWriter pw = new PrintWriter(file);
                //for loop of 100 to write 100 random numbers
                Random rand = new Random();
                for (int i = 0; i < 100; i++) {
                    pw.print((rand.nextInt(100) + 1));
                    if (i != 99) {
                        pw.print(" "); //need to seperate the numbers by spaces
                    }
                }
                pw.close(); //close the print writer to save the file
            } catch (FileNotFoundException ex) {
                System.out.println("The file was not found");
            }
        } catch (IOException ex) {
            System.out.println("Could not create the file");
        }
    }

    private static ArrayList<Integer> readFileOfRandomIntegers(File file) {

        ArrayList<Integer> numbers = new ArrayList<>();

        //scanner to read the file
        try (Scanner scan = new Scanner(file)) {
            //read all the numbers
            while (scan.hasNext()) {
                numbers.add(scan.nextInt());
            }
            //close the scanner
            scan.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(numbers.toString());
        //return the ArrayList of Integers
        return numbers;

    }

}
