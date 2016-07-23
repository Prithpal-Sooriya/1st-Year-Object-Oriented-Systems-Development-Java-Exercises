/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.part10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Prithpal Sooriya
 */
//entends JFrame so we can create a GUI
public class Server extends JFrame {

    //main method to run code
    public static void main(String[] args) {
        Server server = new Server();
    }

    //variabes to user
    private ServerSocket serverSocket;
    //DONT FORGET TO INITIALISE THE ARRAYLIST OF SOCKETS (this is where the issue was... whooops :P)
    private ArrayList<Socket> sockets = new ArrayList<>(); //will store all the clients created, and be used to display the number of users connected
    private JTextArea log = new JTextArea();

    //constructor
    public Server() {
        //add the scrollpane (which holds the JTextArea) to the panel
        add(new JScrollPane(log));

        //set the JFrame settings
        setTitle("Multi Chat: Server");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //sort out the networking
        networking();

    }

    //method networking()
    //initialises the ServerSocket and creates a socket for each client --> to be added onto the ArrayList and ran on thread
    private void networking() {
        //try and catch exceptions
        //catch IOException since dealing with sockets and streams
        try {
            //create a server socket at port 8000
            serverSocket = new ServerSocket(8000);
            log.append("Server created on port: " + serverSocket.getLocalPort() + ", at date: " + new Date() + "\n");
            //infinite while loop to listen for a client to connect, then run a thread for that client
            while (true) {
                //wait till a client wants to connect
                Socket socket = serverSocket.accept();

//                //add the socket onto the ArrayList
//                if(socket == null){
//                    log.append("Socket is null!!\n");
//                }
                sockets.add(socket);

                //run a thread for this client (for communication)
                Thread thread = new Thread(new HandleAClient(socket));

                //DONT FORGET TO START THE THREAD
                thread.start();

                //sleep for some time so to not use up too much processing power
                //Thread.sleep(100);
            }
        } catch (IOException ex) {
            log.append("Server could not be created\n");
            System.err.println(ex);
        }
    }

    //inner class HandleAClient
    //implements Runnable so can be used in thread
    private class HandleAClient implements Runnable {

        //variables to be using
        Socket socket;
        DataInputStream fromClient;
        DataOutputStream toClient;

        //constructor
        HandleAClient(Socket socket) {
            this.socket = socket; //initialise the socket
        }

        //override method from Runnable to add own code into thread
        @Override
        public void run() {
            try {
                //initialise the Data input and output streams
                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());

                //first send all the clients the number of users
                //--> use sentToAll("") to send the message to all available clients
                sendToAll("");

                //infinite while loop to read this clients input, then will send input to all users
                while (true) {
                    //read the clients message sent
                    //message sent will be in form of <name> : <message>
                    //append the number of users at the start (so Client/other clients can use scanner to retrieve later)
                    //String message = sockets.size() + " " + fromClient.readUTF();
                    String message = fromClient.readUTF();
                    //send the message to all the other clients
                    sendToAll(message);
                }

            } catch (IOException ex) { //thrown when fromClient.readInt fails (due to when client disconnects PROPERLY
                //if the infinite while loop ends, that means client has disconnected (need to remove the client)
                log.append("Client from socket(" + socket.getInetAddress().getHostAddress() + ", " + socket.getPort() + ") disconnected\n");
                System.err.println(ex);
                //remove the socket from the arraylist
                int indexOfSocket = sockets.indexOf(socket);
                try {
                    socket.close();
                } catch (IOException ex1) {
                }
                sockets.remove(indexOfSocket);
                //since the socket is now removed send all the clients the new number of users connected
                sendToAll("");
            }
        }

        //method sendToAll(String clientMessage)
        //sends the message recieved from the client to all the users
        private void sendToAll(String clientMessage) {
            DataOutputStream send;
            for (Socket socketToSend : sockets) {
                try {
                    send = new DataOutputStream(socketToSend.getOutputStream());
                    //send number of users
                    send.writeInt(sockets.size());
                    //send the message
                    send.writeUTF(clientMessage);
                    //send.close();
                } catch (IOException ex) {
                    log.append("Could not send message from: " + socket.getInetAddress().getHostAddress() + ", " + socket.getPort() + "\n");
                    System.err.println(ex);
                }
            }
        }
    }
}
