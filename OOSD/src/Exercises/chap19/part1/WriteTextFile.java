/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.part1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Prithpal Sooriya
 */
public class WriteTextFile {
    
    //main method to run code
    //throw I/O exception when writing/reading a file
    public static void main(String[] args) throws IOException{
        
        //create a file(if the file doesnt exist)
        File binaryFile = new File("src/Exercises/chap19/part1/Exercise19_01.dat");
        File textFile = new File("src/Exercises/chap19/part1/Exercise19_01.txt");
        
        //wrap binary file in a dataOutputStream to write primitives in binary (this is binary I/O afterall)
        DataOutputStream binaryOutput = new DataOutputStream(new FileOutputStream(binaryFile));

        //wrap text file in print writer to write the text to
        PrintWriter textOutput = new PrintWriter(textFile);
        
        //for loop to add the 200 random integers seperated by a comma
        Random rand = new Random();
        int temp = 0;
        for (int i = 0; i < 200; i++) {
            //strore the random integer (lets say 0-999)
            temp = rand.nextInt(1000);
            
            //write the integer to the binary file
            binaryOutput.writeInt(temp);
            //write the integer to the text file
            textOutput.print(temp);
            
            //write the comma to the binary file
            binaryOutput.writeUTF(",");
            //write the comma to the text file
            textOutput.print(',');
            
        }
        
        //close streams
        binaryOutput.close();
        textOutput.close();
    }
    
}
