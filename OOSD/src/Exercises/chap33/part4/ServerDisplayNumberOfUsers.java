/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.part4;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
//extend JFrame, so we can create a frame for this
public class ServerDisplayNumberOfUsers extends JFrame {

    private static int numberOfUsers = 0; //hold number of users

    JTextArea log = new JTextArea(); //log to hold text

    //constructor
    public ServerDisplayNumberOfUsers() {
        //add a JTextArea with JScrollView to scroll
        add(new JScrollPane(log), BorderLayout.CENTER);

        //set frame settings
        setTitle("Server For Displaying Number Of users");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //networking part
        networking();
    }

    private void networking() {
        //try and catch IOException since dealing with sockets and streams
        try {
            //create a server socket with port 8000
            ServerSocket serverSocket = new ServerSocket(8000);
            //prompt on log server started
            log.append("Server started at: " + new Date() + "\n");
            //infinite while loop to add clients
            while (true) {
                //create a socket to connect to client
                Socket socket = serverSocket.accept();
                //pronmpt on server console
                log.append("Number of users increased, number of users connected to server: " + (numberOfUsers + 1) + "\n");
                //thread to show user their visitor number
                Thread thread = new Thread(new RunNumberOfUsers(socket, numberOfUsers++)); //send previous numberOfUsers, then increment numberOfUsers
                thread.start(); //start the thread
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerDisplayNumberOfUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //inner class
    //extends runnable so can add own code
    private class RunNumberOfUsers implements Runnable {

        private Socket socket;
        private int previousNumberOfUsers;

        Boolean notFinished = true; //to run while loop to show client has not finished
        //constructor

        public RunNumberOfUsers(Socket socket, int previousNumberOfUsers) {
            this.socket = socket;
            this.previousNumberOfUsers = previousNumberOfUsers;
        }

        //override run method to show number of users
        @Override
        public void run() {
            //try and catch
            //catch IOException since we are dealing with streams
            //catch InterruptedException since we use Thread.sleep(); and using threads
            DataOutputStream outputToClient = null;

            //thread to wait till user says they are finished
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                        notFinished = fromClient.readBoolean();
                        System.out.println("Closed");
                    } catch (IOException ex) {
                    }
                }
            });
            //start the thread
            thread.start();

            try {
                outputToClient = new DataOutputStream(socket.getOutputStream());

                //save the previous value of numberOfUsers
                previousNumberOfUsers = numberOfUsers;

                //output the number of users, this is just to be used when client is first created
                outputToClient.writeInt(numberOfUsers);

                //infinite while loop to poll till change
                while (notFinished) {
                    //check if number of users have changed
                    //if so, then set previousNumberOfUsers to new value and output to user
                    if (previousNumberOfUsers != numberOfUsers) {
                        previousNumberOfUsers = numberOfUsers;
                        outputToClient.writeInt(previousNumberOfUsers);
                    }
                    //make this thread sleep for a second (dont want to use too much power on thread
                    Thread.sleep(1000);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (InterruptedException ex2) {
                System.out.println(ex2);
            } finally {
                //player has exited, so decrement number of users
                numberOfUsers--; //the client has ended, so decrement number of users
                try {
                    outputToClient.writeInt(numberOfUsers);
                } catch (IOException ex) {
                }
                log.append("Number of users decreased, number of users connected to server: " + numberOfUsers + "\n");
            }
        }
    }

    //main method to run code
    public static void main(String[] args) {
        //create the server and frame
        new ServerDisplayNumberOfUsers();
    }

}
