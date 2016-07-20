/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.part9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Prithpal Sooriya
 */
//extends JFrame so to create GUI with constructor
public class Server extends JFrame {

    //variables to be used
    private ServerSocket serverSocket = null; //set to null so we can validate later
    private Socket socket = null; //set to null so we can validate later
    private DataInputStream fromClient = null; //set to null so we can validate later
    private DataOutputStream toClient = null; //set to null so we can validate later
    private JTextArea textArea_output;
    private JTextField textField_input;

    //constructor
    public Server() {
        //Create a panel to hold input
        JPanel panelInput = new JPanel(new BorderLayout());
        panelInput.add(new JLabel("Send To Client: "), BorderLayout.WEST);
        panelInput.add(textField_input = new JTextField(), BorderLayout.CENTER);

        //create a panel to hold output
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new JLabel("Chat:"), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(textArea_output = new JTextArea());
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        //set the layout of the JFrame
        setLayout(new BorderLayout());
        //add the input panel at top, and output panel at center
        add(panelInput, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        //set JFrame settings
        setTitle("Server Chat:");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //action listener for output to client
        //action listener above networking, because if we dont...
        //... action listener will be blocked due to waiting for connection
        outputToClient();
        //start networking sockets and stuff
        networking();
        //thread to deal with input from client
        inputFromClient();

    }

    //method networking()
    //used to initialise ServerSocket, Socket, DataInputStream, DataOutputStream
    private void networking() {
        //try and catch errors
        //catch IOException for sockets and streams
        try {
            //initialise the server socket on port 8000
            serverSocket = new ServerSocket(8000);
            //wait till client connects
            socket = serverSocket.accept();

            //set the Data input and output streams
            fromClient = new DataInputStream(socket.getInputStream());
            toClient = new DataOutputStream(socket.getOutputStream());

        } catch (IOException ex1) {
            textArea_output.append("Failed to create a connection, restart application\n");
        }

    }

    //method inputFromClient()
    //used to create a thread to keep listening for the client to send data, then display on screen
    private void inputFromClient() {
        //Thread to output to screen chat from client
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //we need to have an infinite WHILE loop to wait for client to send data
                //then we write the data onto screen
                String dataFromClient;
                try {
                    while (true) {
                        dataFromClient = fromClient.readUTF(); //read the data from the client
                        textArea_output.append(dataFromClient + "\n");
                    }
                } catch (Exception ex) { //catch any other exceptions, this means that the fromClient failed for some reason
                    textArea_output.append("Client socket has lost connection\n");
                }
            }
        });
        //DONT FORGET TO START THE THREAD
        thread.start();
    }

    //method
    private void outputToClient() {
        textField_input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //get the text, append Server: at start
                String dataToSendToClient = "Server: " + textField_input.getText().trim();
                try {
                    //send the data to the client and display on own screen
                    if (socket == null || toClient == null) {
                        textArea_output.append("Cannot send, Client not connected\n");
                    } else {
                        toClient.writeUTF(dataToSendToClient);
                        textArea_output.append(dataToSendToClient + "\n");
                    }
                } catch (IOException ex) {
                    textArea_output.append("An error occured when sending data\n");
                    System.err.println(ex);
                }
                
                //at the end clear the user input
                textField_input.setText("");
            }
        });
    }

    //main method to create JPanel
    public static void main(String[] args) {
        Server panel = new Server();
    }
}
