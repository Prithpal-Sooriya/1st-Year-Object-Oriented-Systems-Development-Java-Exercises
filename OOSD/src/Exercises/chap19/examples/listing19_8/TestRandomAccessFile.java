/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.examples.listing19_8;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestRandomAccessFile {
    
    //main method to run code, throw IO exception due to reading and writing to file
    public static void main(String[] args) throws IOException{
        
        //create a random access file
        RandomAccessFile file = new RandomAccessFile("src/Exercises/chap19/examples/listing19_8/file.dat", "rw"); //rw = read-write, r = read only
        
        //clear the file to destroy old contents (if there is any)
        file.setLength(0);
        
        //write new integers to the file
        for (int i = 0; i < 200; i++) {
            file.writeInt(i);
        }
        
        //display the length of the file
        System.out.println("file.dat length: " + file.length());
        
        //Retrieve the first number
        file.seek(0); //move the file pointer to the start of the file (like arrays, starts at 0)
        //integer = 4 bytes, to increments 4 times to get to the next item
        System.out.println("First item in file: " + file.readInt()); //returns the item, and increments pointer to next item
        
        //retrieve second number, dont need to seek as pointer is already pointing at second item
        System.out.println("Second item in file: " + file.readInt());
        
        //retrieve 10th item
        file.seek(9*4); //10th item = 9th index, integer is 4 bytes long so 9*4
        System.out.println("Tenth item in file: " + file.readInt());
        
        //modify 11th number
        file.writeInt(555); //rewrites the integer in this location of file pointer
        
        //append a new number
        file.seek(file.length()); //move pointer to end location
        file.writeInt(999);
        
        //display the new length
        System.out.println("The new length of file.dat: " + file.length());
        
        //retrieve new 11th number
        file.seek(10*4); //11 number = 10 index; int = 4 bytes
        System.out.println("Eleventh item in file: " + file.readInt());
        
        //close the file
        file.close();
    }
    
}
