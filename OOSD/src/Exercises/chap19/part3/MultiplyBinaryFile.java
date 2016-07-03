/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.part3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Prithpal Sooriya
 */
public class MultiplyBinaryFile {
    
    //main method to run code
    //throw IO exception from writing to a file
    public static void main(String[] args) throws IOException{
        
        //create a binary file to write the integers
        DataOutputStream output = new DataOutputStream(new FileOutputStream("src/Exercises/chap19/part3/Exercise19_03.dat"));
        
        //populate binary file with random integers integers
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            //write integer (4 bytes)
            output.writeInt(rand.nextInt(10) + 1); //random integer from 1-10
        }
        
        //close output stream
        output.close();
        
        //read the binary file
        DataInputStream input = new DataInputStream(new FileInputStream("src/Exercises/chap19/part3/Exercise19_03.dat"));
        
        //read the binary file
        int number = 0;
        int total = 1;
        //when the input read is -1, means the end of file is reached
        //could use for loop where i < file.length
        //could use EOFException
        while(input.available() > 0){
            //store the input
            number = input.readInt();
            System.out.println(number);
            total *= number;
        }
        
        //output total
        System.out.println("product of the numbers: " + total);
        
        //close input stream
        input.close();
        
    }
    
}
