/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_7.listing33_10_11_12.code;

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

//extends JFrame = so we can show scroll pane of text of client server communication
//implements TicTacToeConstants, so we can use the constants
public class TicTacToeServer extends JFrame implements TicTacToeConstants{
    //main method to run code (aka create a frame and start the server)
    public static void main(String[] args){
        TicTacToeServer frameServer = new TicTacToeServer();
    }
    
    //constuctor to create frame and server
    public TicTacToeServer() {
        //create a JTextArea (to append text of Client - Server Communication)
        JTextArea textLog = new JTextArea();
        
        //create a scroll pane so we can scroll through JTextArea
        JScrollPane scrollPane = new JScrollPane(textLog);
        
        //add the scroll pane to the JFrame
        add(scrollPane);
        
        //set JFrame settings
        setTitle("Server log");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //try and catch IOException when dealing with streams (networking part)
        try {
            //create a server socket with port number 8000
            ServerSocket serverSocket = new ServerSocket(8000);
            textLog.append("Server created on port 8000\nDate of creation: " + new Date() + "\n");
            
            //Number of a session (so we can distinguish the different sessions)
            int sessionNumber = 1;
            
            //ready to create a session for every 2 players
            //infinite WHILE loop, so that every 2 players joined --> create a session, then start again
            while(true) {
                textLog.append("Wait for 2 players to join session:" + sessionNumber + "\n");
                
                //connect to player1
                Socket player1 = serverSocket.accept();
                textLog.append("Player 1 has joined the server\n");
                textLog.append("Player 1 IP address: " + player1.getInetAddress().getHostAddress() + "\n");
                //notify to this socket, that they are player 1
                new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);
                
                //connect to player2
                Socket player2 = serverSocket.accept();
                textLog.append("Player 2 has joined the server\n");
                textLog.append("Player 2 IP address: " + player2.getInetAddress().getHostAddress() + "\n");
                //notify to this socket that they are player 2
                new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);
                
                //display this session and increment the session number
                textLog.append("Started a new session, session number: " + sessionNumber + "\n");
                sessionNumber++;
                
                //use the HandleASession class (which extends Runnable for a thread)
                HandleASession task = new HandleASession(player1, player2);
                
                //start the new thread
                new Thread(task).start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
    }
}
