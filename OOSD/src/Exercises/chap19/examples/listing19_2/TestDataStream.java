/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.examples.listing19_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestDataStream {
    
    //main method to run code
    //throw the IO exception when using streams
    public static void main(String[] args) throws IOException{
        
        //create a data output stream to write data to a file
        //requires an output stream
        DataOutputStream output = new DataOutputStream(new FileOutputStream("src/Exercises/chap19/examples/listing19_2/temp.dat"));
        
        //write student test scores into the file
        output.writeUTF("John");
        output.writeDouble(85.5);
        output.writeUTF("Susan");
        output.writeDouble(60.2);
        output.writeUTF("Bill");
        output.writeDouble(90.2);
        
        //close the stream to prevent leakage and corruption
        output.close();
        
        //create a data input steam to read data from a file
        //requires an input stream
        DataInputStream input = new DataInputStream(new FileInputStream("src/Exercises/chap19/examples/listing19_2/temp.dat"));
        
        //read the name and test scores
        for (int i = 0; i < 3; i++) {
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
        
        //close the stream to prevent leakage and corruption
        input.close();
    }
    
}
