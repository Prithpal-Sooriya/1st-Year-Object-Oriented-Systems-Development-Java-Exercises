/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_6.listing33_7_8_and_9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Prithpal Sooriya
 */
public class StudentServer {
    //variable to use
    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;
    
    //constructor
    public StudentServer(){
        //try and catch for IOException as we are dealing with streams
        //also catch ClassNotFoundException due to reading an object
        try {
            //create a server socket on port 8000
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server Started");
            
            //create an object output stream to output object to a file
            outputToFile = new ObjectOutputStream(new FileOutputStream("src/Exercises/chap33/examples/part33_6/listing33_7_8_and_9/StudentAddress.dat", true)); //param2 true = append not overwrite
            
            //infinite while so as to add multiple clients/sockets that want to establish a connection
            while(true){
                //listen and wait for a new connection request
                Socket socket = serverSocket.accept();
                
                //create an input stream for recieving object from client
                inputFromClient = new ObjectInputStream(socket.getInputStream());
                
                //read the object from the client
                Object object = inputFromClient.readObject();
                
                //write to file
                outputToFile.writeObject(object);
                System.out.println("A new Student Address object sucessfully stored in file!");
            }
        } catch (IOException ex){
            System.err.println(ex);
        } catch (ClassNotFoundException ex2){
            System.err.println(ex2);
        } finally {
            //try and catch any Exceptions when closing the Object Input/OuputStreams
            try {
                outputToFile.close();
                inputFromClient.close();
            } catch (Exception ex){
                System.err.println(ex);
            }
        }
    }
    
    //main method to run code
    public static void main(String[] args){
        //call constructor to create the server
        new StudentServer();
    }
}
