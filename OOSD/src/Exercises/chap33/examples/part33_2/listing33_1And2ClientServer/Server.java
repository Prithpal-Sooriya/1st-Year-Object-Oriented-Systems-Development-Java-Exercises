/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_2.listing33_1And2ClientServer;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Prithpal Sooriya
 */

//extend JFrame so we can use this as a frame
public class Server extends JFrame{
    private JTextArea textArea = new JTextArea();
    
    public Server(){
        //place text area on the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER); //scroll pane so that user can scroll through JTextArea
        //set the JFrame settings
        setTitle("Server");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //show the frame
        setVisible(true);
        
        
        //Server Networking
        try{
            //Create a ServerSocket with a port number
            ServerSocket serverSocket = new ServerSocket(8000);
            textArea.append("Server started at: " + new Date() + "\n");
            
            //listens for a connection request
            //as we are listening, the code below is blocked and wont run until a connection is made
            Socket socket = serverSocket.accept();
            
            //create the input and output streams to be using
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
            
            //infinite while loop, so we can listen for client to send data
            while(true){
                //recieve the radius from the client
                double radius = inputFromClient.readDouble();
                
                //compute area
                double area = Math.PI * radius * radius;
                
                //send area back to the client
                outputToClient.writeDouble(area);
                
                //output to server screen
                textArea.append("Radius recieved from client: " + radius + "\n");
                textArea.append("Area sent to client: " + area + "\n");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    //main method to run code
    public static void main(String[] args){
        new Server(); //create a server, using the server constructor
    }
}
