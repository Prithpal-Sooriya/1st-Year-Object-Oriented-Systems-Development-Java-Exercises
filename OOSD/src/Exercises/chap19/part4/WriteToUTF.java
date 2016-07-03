/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.part4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class WriteToUTF {
 
    //main method to run code
    //throws IO exception
    public static void main(String[] args) throws IOException{
        
        //need printReader/BufferedReader/Scanner to read the file
        Scanner scan = new Scanner(WriteToUTF.class.getResourceAsStream("text.txt"));
        
        //create a dataOutputStream to output the string into the binary file
        DataOutputStream output = new DataOutputStream(new FileOutputStream("src/Exercises/chap19/part4/text.dat"));
        
        //while loop to read lines
        while(scan.hasNextLine()){
            output.writeUTF(scan.nextLine());
        }
        
        //close the scanner and output stream
        scan.close();
        output.close();
        
    }
    
}
