/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.part5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Prithpal Sooriya
 */
public class StoreObjectsAndArrays {
    
    //main method to run code
    //throws IO exception for reading/writing to a file
    //throws ClassNotFound exception for unidentified classes
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
        //create an ObjectOutputStream for binary file
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/Exercises/chap19/part5/Exercise19_05.dat"));
        
        //write 4 integer array, date object and double
        int[] ints = {14, 22, 53, 75};
        Date date = new Date();
        double d = 15.35;
        
        output.writeObject(ints);
        output.writeObject(date);
        output.writeDouble(d);
        
        //close the output stream
        output.close();
        
        //read the arrays and objects
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/Exercises/chap19/part5/Exercise19_05.dat"));
        
        ints = (int[]) input.readObject();
        date = (Date) input.readObject();
        d = input.readDouble();
        
        //output to check if they are correct
        System.out.println(Arrays.toString(ints));
        System.out.println(date);
        System.out.println(d);
    }
    
}
