/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap19.examples.listing19_4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Prithpal Sooriya
 */
public class Copy {
    
    //main method to run code
    public static void main(String[] args){
        
        //check if there was 2 args passed
        if(args.length != 2){
            System.out.println("Need to arguments: source file, destination file");
            System.exit(1);
        }
        
        try{
            File sourceFile = new File(args[0]);
            //if file doesnt exist then end
            if(!sourceFile.exists()){
                System.out.println("The source file doesnt exist");
                System.exit(2);
            }
            
            File targetFile = new File(args[1]);
            //if the file exists then then end
            if(targetFile.exists()){
                System.out.println("The target file exists");
                System.exit(3);
            }
            
            //input and output stream to read and write file
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
            
            //continuously read bytes from source file and output on new file
            int bytesRead = 0;
            int read;
            while((read = input.read()) != -1){ //-1 means end of file
                output.write((byte) read);
                 bytesRead++;
            }
            
            //close the streams
            input.close();
            output.close();
            
            //prompt user
            System.out.println("File copied, " + bytesRead + " copied!");
        }
        catch(IOException e) {
            //there was an IO exception
            System.out.println("IO Exception");
        }
        
    }
    
}
