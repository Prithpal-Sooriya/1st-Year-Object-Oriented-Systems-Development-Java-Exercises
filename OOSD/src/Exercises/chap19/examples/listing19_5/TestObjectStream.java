/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.examples.listing19_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestObjectStream {
    
    //main method to run code
    //throw IO exception from stream
    //throw class not found exception when trying to read an object
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
        //create output stream for Object.dat
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/Exercises/chap19/examples/listing19_5/Object.dat"));
        
        //write a String double and Object
        output.writeUTF("Bob");
        output.writeDouble(85.5);
        output.writeObject(new Date());
        
        //close stream
        output.close();
        
        //create an input stream for Object.dat
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/Exercises/chap19/examples/listing19_5/Object.dat"));
        
        //read the file line by line and print the contents
        System.out.println("Name: " + input.readUTF());
        System.out.println("Score: " + input.readDouble());
        System.out.println("Date of Entry: " + (Date)(input.readObject())); //cast Date to explicitly show this class is a date
        
        //close stream
        input.close();
    }
    
}
