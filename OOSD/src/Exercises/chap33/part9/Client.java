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
import java.net.Socket;
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
//extends JFrame so we can create GUI
public class Client extends JFrame {

    //variables to use
    private Socket socket = null;
    private DataInputStream fromServer = null;
    private DataOutputStream toServer = null;
    private JTextArea textArea_output;
    private JTextField textField_input;
    private String host = "localhost";

    //constructor
    public Client() {
        //create a panel to hold to input
        JPanel panelInput = new JPanel(new BorderLayout());
        panelInput.add(new JLabel("Send to Server: "), BorderLayout.WEST);
        panelInput.add(textField_input = new JTextField(), BorderLayout.CENTER);

        //create a panel to hold the output
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new JLabel("Chat:"), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(textArea_output = new JTextArea());
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        //add the panels to the JFrame
        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        //set JFrame settings
        setTitle("Client Chat:");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //action listener to listen for client input
        outputToServer();
        //start networking
        networking();
        //start thread that will deal with getting clients data
        inputFromServer();

    }

    //method networking()
    //will initialise Socket, DataInputStream, DataOuputStream
    private void networking() {
        //try and catch exceptions
        //catch IOException due to sockets and streams
        try {
            //initialise the socket (and try to connect to the server)
            socket = new Socket(host, 8000);

            //initialise DataOutputStream and DataInputStream
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            textArea_output.append("Could not connect to server, restart the application\n");
            System.err.println(ex);
            socket = null; //so if user tries to enter something, error method will still show on screen
        }
    }

    //method inputFromServer()
    //will create a thread which will listen to data sent from server
    //then display to screen
    private void inputFromServer() {
        //create thread to listen to server
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //we need to have an infinite WHILE loop to wait for Server to send data
                //then we write the data onto the screen
                String dataFromServer;
                try {
                    while (true) {
                        dataFromServer = fromServer.readUTF();
                        //output to TextArea
                        textArea_output.append(dataFromServer + "\n");
                    }
                } catch (Exception ex) { //catch any other exceptions, this means that the fromServer failed for some reason
                    textArea_output.append("Server socket has lost connection\n");
                }
            }
        });
        //DONT FORGET TO START THE THREAD
        thread.start();
    }

    //method outputToServer()
    //will take the input from user and send it to server
    //then display to screen
    private void outputToServer() {
        textField_input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //string to hold output
                String dataToSendToServer = "Client: " + textField_input.getText().trim();
                try {
                    //send the data to the client and display on own screen
                    if (socket == null || toServer == null) {
                        textArea_output.append("Cannot send, Client not connected\n");
                    } else {
                        toServer.writeUTF(dataToSendToServer);
                        textArea_output.append(dataToSendToServer + "\n");
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

    //main method to run code
    public static void main(String[] args) {
        Client client = new Client();
    }
}
