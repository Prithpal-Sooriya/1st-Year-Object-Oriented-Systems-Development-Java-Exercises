/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.part15;

import java.io.DataInputStream;
import java.io.EOFException;
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
public class DecryptFiles {

    //main method to run code
    //throws IOException when reading/writing to a file
    //throw File not found exception when file is not found
    public static void main(String[] args) throws IOException, FileNotFoundException {

        //JFileChooser to select a decrypted file
        JFileChooser fileChooser = new JFileChooser("src/Exercises/chap19/part15");
        int returnVal = fileChooser.showOpenDialog(new JFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //get the file selected
            File encryptedFile = fileChooser.getSelectedFile();

            //output to user what the new decrypted file should be called
            System.out.println("What should the decrypted file be called");
            String decryptedFileName = new Scanner(System.in).next();

            //create a new file to be writing to
            File decryptedFile = new File(encryptedFile.getParent() + "/" + decryptedFileName);

            //data input stream = encrypted file
            //output file stream =decryptedFile
            DataInputStream input = new DataInputStream(new FileInputStream(encryptedFile));
            FileOutputStream output = new FileOutputStream(decryptedFile);

            //loop till all of the input file is ended
            try {
                while (input.available() > 0) { //not reached the end of file
                    //read the input data
                    int byteToStoreInDecryptFile = input.read();
                    //discard the 4 bytes (the number 7)
                    input.readInt();
                    //store byte into decrypt file
                    output.write(byteToStoreInDecryptFile);
                }
                //close the streams (as all the bytes have been tranfered)
                input.close();
                output.close();
            } catch (EOFException e) {
                //end of the file is reached
            }

        } else {
            System.out.println("No file selected");
            System.exit(0);
        }

        //exit out of the program
        System.exit(0);
    }

}
