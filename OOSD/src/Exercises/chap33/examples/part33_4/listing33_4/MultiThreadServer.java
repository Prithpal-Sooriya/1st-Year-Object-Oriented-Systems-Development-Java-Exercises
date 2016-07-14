/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_4.listing33_4;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
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
//extend JFrame so to display the contents
public class MultiThreadServer extends JFrame {

    //Text area to display contents of client server communication
    JTextArea displayConents = new JTextArea();

    //constructor
    public MultiThreadServer() {
        //place the text area into the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(displayConents), BorderLayout.CENTER);

        //set JFrame settings
        setTitle("Multi Threaded Server");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //try catch for sockets and reading and writing (IO exception)
        try {
            //create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            displayConents.append("Multi Threaded Server started at: " + new Date() + "\n");

            //number the clients added (this can be helpful when finding a client (this kind of acts like an ID)
            int clientNumber = 1;

            //infinite while loop to add clients
            while (true) {
                //listen and wait till a client wants to connect
                Socket socket = serverSocket.accept();

                //client/socket accepted, lets display client number
                displayConents.append("Starting Thread for new Client at " + new Date() + ":\n");
                InetAddress address = socket.getInetAddress();
                displayConents.append("Client Number: " + clientNumber + "\n");
                displayConents.append("Client Hostname: " + address.getHostName() + "\n");
                displayConents.append("Client IP Address: " + address.getHostAddress() + "\n");
                displayConents.append("==========================================================\n"); //break off from client contents

                //create a new thread for the connection
                HandleAClient task = new HandleAClient(socket);

                //start the thread
                new Thread(task).start();

                //increment client number for next client
                clientNumber++;
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    //inner class
    //define a thread class for handling the new client
    //implements Runnable for thread code to be
    private class HandleAClient implements Runnable {

        //variables to use
        private Socket socket; //will be instantiated from the constructor para

        //constructor
        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        //override method from Runnable to add own code for Thread
        @Override
        public void run() {
            //try and catch IOException since we are using IOstreams
            try {
                //create the streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                //poll/infinite while loop to check for client sending radius to server
                while (true) {
                    //recive the radius
                    double radius = inputFromClient.readDouble();

                    //compute area
                    double area = Math.PI * radius * radius;

                    //send the area back to client
                    outputToClient.writeDouble(area);

                    //display message on server
                    displayConents.append("Radius recieved from client: " + radius + "\n");
                    displayConents.append("Area returned to client: " + area + "\n");
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

    }

    //main method to run code
    public static void main(String[] args) {
        new MultiThreadServer();
    }
}
