/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.part8;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Prithpal Sooriya
 */
public class UpdateCount {
    
    //main method to run code
    //throws IOException from reading/writing to files
    public static void main(String[] args) throws IOException{
        
        //create a random access file, as we need to read it
        //if the file is already created, then will bring up that file
        RandomAccessFile file = new RandomAccessFile("src/Exercises/chap19/part8/Count.dat", "rw"); //rw = read/write
        
        //integer to hold number of times it has run
        int run = 0;
        
        //if the file isnt empty then get the number of times the program has run
        if(file.length() > 0){
            run = file.readInt();
        }
        
        //increment run, and erase and write the new number
        run++;
        file.setLength(0); //erase the file
        file.writeInt(run);
        
        //close the file
        file.close();
        
        //output the number of times the program has run
        System.out.println("The program has run: " + run + " times");
    }
    
}
