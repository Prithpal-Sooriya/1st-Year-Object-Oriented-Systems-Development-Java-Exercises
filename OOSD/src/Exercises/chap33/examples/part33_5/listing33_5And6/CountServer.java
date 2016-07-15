/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_5.listing33_5And6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Prithpal Sooriya
 */
public class CountServer {

    //variables that will be used
    private RandomAccessFile randomFile; //the file to store the number of visitors
    private int count; //Count the access to the server

    //constructor to create a server
    public CountServer() {
        //try and catch IOException since we will deal with streams
        try {
            //Create a server socket, with port number of 8000
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server Started");

            //create or open the count file
            randomFile = new RandomAccessFile("src/Exercises/chap33/examples/part33_5/listing33_5And6/CountFile.dat", "rw"); //want to make file read and write

            //get the count if it exists
            if (randomFile.length() != 0) {
                count = randomFile.readInt();
            } else {
                count = 0;
            }

            //infinite while loop to add clients
            while (true) {
                //listen and wait for a connection request
                Socket socket = serverSocket.accept();
                
                //Create a DataOutputStream for the socket
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                
                //increase the count, as we have a new visitor, and output to client their visitor number
                count++;
                outputToClient.writeInt(count);
                
                //write new count back to the file
                randomFile.seek(0); //set file pointer to 0, to overwrite the index for count
                randomFile.writeInt(count);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    //main method to run code
    public static void main(String[] args) {
        //call the constructor (to create the server)
        new CountServer();
    }

}
