/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_2.listing33_1And2ClientServer;

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
//extends JFrame so we can use a JFrame and see client server talking
public class Client extends JFrame {

    //text area to print client server communication
    private JTextArea textArea = new JTextArea();

    //text field for recieving the radius from user (user input)
    private JTextField textField = new JTextField();

    //IO Streams
    private DataInputStream inputFromServer;
    private DataOutputStream outputToServer;

    //constructor to create the JFrame and client sockets
    public Client() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); //set layout

        //add the contents to the panel
        panel.add(new JLabel("Enter the Radius: "), BorderLayout.WEST); //label to prompt user
        panel.add(textField, BorderLayout.CENTER); //add the text field for input
        textField.setHorizontalAlignment(JTextField.RIGHT); //text will be aligned to the right

        //set layout of JFrame
        setLayout(new BorderLayout());
        //add panel and text area
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER); //scroll pane to let user scroll

        //action listener to the TextField (for user input)
        textField.addActionListener(new ServerCommunication());

        //set JFrame settings
        setTitle("Client");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Socket connections
        //need try catch, to catch IOException (when setting the I/O stream)
        try {
            //create a socket to connect to server
            //socket requests connection
            Socket socket = new Socket("localhost", 8000); //connect to local host (your own computer)

            //create input/output stream to retrieve data
            inputFromServer = new DataInputStream(socket.getInputStream());
            outputToServer = new DataOutputStream(socket.getOutputStream());

        } catch (IOException ex) {
            textArea.append(ex.toString() + "\n");
        }
    }

    //inner class for reading user input from textfield
    //imoplements action listener so we can use the users input to textfield
    private class ServerCommunication implements ActionListener {

        //override method from ActionListener
        @Override
        public void actionPerformed(ActionEvent ae) {
            //try and catch for catching IOException (when reading and writing using the streams
            try {
                //get the radius from the user input
                double radius = Double.parseDouble(textField.getText().trim());
                
                //send the radius to the server
                outputToServer.writeDouble(radius);
                outputToServer.flush(); //forces any buffered bytes/data not used out to the stream
                
                //get the area from the server
                double area = inputFromServer.readDouble();
                
                //display to text area
                textArea.append("Radius given to server: " + radius + "\n");
                textArea.append("Area retrieved from server: " + area + "\n");
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (NumberFormatException ex2) {
                textArea.append("NAN, you have to enter a number!\n");
            }

        }

    }

    //main method to run code
    public static void main(String[] args) {
        new Client(); //create a client Jframe to show on screen
    }
}
