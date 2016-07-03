/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.part14;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Prithpal Sooriya
 */
public class EncyrptFiles {

    //main method to run code
    //throws IO exception when reading/writing to file
    public static void main(String[] args) throws IOException {

        //get user to select a file
        JFileChooser fileChooser = new JFileChooser(new File("src/Exercises/chap19/part14"));
        int returnVal = fileChooser.showOpenDialog(new JFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //get the file
            File file = fileChooser.getSelectedFile();

            try {

                //read the file as bytes, so will need a file input stream
                FileInputStream input = new FileInputStream(file);
                System.out.println(file.getParent());
                
                //prompt user to choose what the encrypt version should be called
                System.out.println("What should the name of the encrypted file be called: ");
                String encryptedFileName = new Scanner(System.in).next();
                
                //write a new file as bytes, so will need file output stream
                DataOutputStream output = new DataOutputStream(new FileOutputStream(file.getParent() + "/" + encryptedFileName));
                
                //for each byte tranfered, write integer 7 (4 bytes)
                int byteToTransfer;
                while(input.available() > 0){
                    byteToTransfer = input.read();
                    //write the byte to the new file
                    output.write(byteToTransfer);
                    //write the 4 bytes for 7
                    output.writeInt(7);
                }
                //close the streams (as all the bytes have been tranfered
                input.close();
                output.close();
            } catch (FileNotFoundException e) {
                System.out.println("The file was not found");
            }
        } else {
            System.out.println("No file selected");
            //terminate the program
            System.exit(0);
        }
        
        //terminate the program
        System.exit(0);
    }

}
