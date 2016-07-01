/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.examples.listing19_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Prithpal Sooriya
 */
public class CatchEndOfFile {

    //main method to run code
    //throw IO exception from the streams we will use
    public static void main(String[] args) throws IOException {
        //create a data output stream to write data to a file
        //requires an output stream
        //use Buffered stream to store data in buffer before writing to file to speed up process
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/Exercises/chap19/examples/listing19_3/temp.dat")));

        //write doubles
        output.writeDouble(85.5);
        output.writeDouble(60.2);
        output.writeDouble(90.2);

        //close the stream to prevent leakage and corruption
        output.close();

        //create a data input steam to read data from a file
        //requires an input stream
        //use Buffered stream to store data from file to buffer to speed up process
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("src/Exercises/chap19/examples/listing19_3/temp.dat")));

        //try and catch EOFException
        try {
            //infinite while loop to keep reading doubles in file
            while (true) {
                System.out.println(input.readDouble());
            }
        } catch (EOFException e) {
            System.out.println("All data was read");
        }

        //close the stream to prevent leakage and corruption
        input.close();
    }

}
