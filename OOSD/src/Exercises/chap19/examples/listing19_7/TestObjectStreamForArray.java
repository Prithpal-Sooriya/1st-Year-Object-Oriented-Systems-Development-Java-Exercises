/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.examples.listing19_7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestObjectStreamForArray {
    
    //main method to run code
    //throws IOException due to stream
    //throws ClassNotFound exception when reading objects from file
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
        //array of ints and strings
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"Bob", "John", "Bill"};
        
        //create an output stream
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/Exercises/chap19/examples/listing19_7/Arrays.dat"));
        
        //write the arrays to the file
        output.writeObject(numbers); //arrays can be read as objects
        output.writeObject(strings);
        
        //close the stream
        output.close();
        
        //create and input stream
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/Exercises/chap19/examples/listing19_7/Arrays.dat"));
        
        //read the numbers and strings from the file
        int[] newNumbers = (int[])(input.readObject());
        String[] newStrings = (String[])(input.readObject());
        
        //display the new arrays
        for(int number : newNumbers){
            System.out.print(number + " ");
        }
        System.out.println("");
        for (String newString : newStrings) {
            System.out.print(newString + " ");
        }
        
        //close input stream
        input.close();
    }
    
}
