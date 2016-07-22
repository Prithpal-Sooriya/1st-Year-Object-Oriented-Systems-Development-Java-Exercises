/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.part10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JApplet;
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
public class Client extends JApplet {

    private Socket socket; //to create connection to server, null to verify later
    private DataInputStream fromServer = null; //to recieve data from server, null to verify later
    private DataOutputStream toServer = null; //to send data to server, null to verify later
    private JTextField textField_inputFromUser; //GUI: where the user will input message
    private JTextField textField_username; //GUI: where the user can enter their name, blank will send message as anonymous
    private JTextArea textArea_chat; //GUI: where the chat will be displayed
    private JLabel label_numberOfUsersConnected; //GUI: stored the number of users connected to the server
    private String host = "localhost"; //stored the host of server (can be changed if not stand alone application
    private boolean isStandAlone = false; //declares if this application is stand alone or not

    //override method init() to initialise JApplet
    @Override
    public void init() {
        //create GUI
        createGUI();
        //create the action listener (as the user may try to enter input before connection established
        userInput();
        //sort out the networking
        networking();
    }

    //method createGUI()
    //will create a GUI for which the GUI will look like
    private void createGUI() {
        //initialise all the GUI elements
        textField_inputFromUser = new JTextField();
        textField_username = new JTextField("Anonymous");
        textArea_chat = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea_chat); //scroll pane on chat so can scroll through chat
        label_numberOfUsersConnected = new JLabel();

        //create a panel to group the username and input from user
        JPanel panel_groupUserNameAndInput = new JPanel(new GridLayout(2, 2));
        panel_groupUserNameAndInput.add(new JLabel("Name: "));
        panel_groupUserNameAndInput.add(textField_username);
        panel_groupUserNameAndInput.add(new JLabel("Enter Text: "));
        panel_groupUserNameAndInput.add(textField_inputFromUser);

        //create a panel to group number of users (with text beside stating number of users)
        JPanel panel_groupNumberOfUsers = new JPanel();
        panel_groupNumberOfUsers.add(new JLabel("number of users connected to server: "));
        panel_groupNumberOfUsers.add(label_numberOfUsersConnected);

        //create a panel to group panel_groupNumberOfUsers and panel_groupUserNameAndInput
        JPanel panel_upper = new JPanel(new BorderLayout());
        panel_upper.add(panel_groupNumberOfUsers, BorderLayout.NORTH);
        panel_upper.add(panel_groupUserNameAndInput, BorderLayout.CENTER);

        //create a panel which add everything together
        JPanel panel_all = new JPanel(new BorderLayout());
        panel_all.add(panel_upper, BorderLayout.NORTH);
        panel_all.add(scrollPane, BorderLayout.CENTER);

        //add panel_all to the applet
        add(panel_all);
    }

    //method userInput()
    //retrieve the userInput and send to the server (which sends to everyone)
    private void userInput() {
        //add the action listener
        textField_inputFromUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                //try and catch exceptions
                //catch IOException due to Sockets and Streams
                try {
                    //check if the Socket and DataOutputStream has been initialised
                    if (socket == null || toServer == null) {
                        textArea_chat.append("MESSAGE NOT SEND: CONNECTION NOT ESTABLISHED\n");
                    } else { //able to send message

                        //create StringBuilder to build onto the string
                        //prevenets new Strings to be added to heep or StringPool
                        StringBuilder sb = new StringBuilder();

                        //String to store the message, first store the name of user
                        sb.append((!textField_username.getText().equals("")) ? textField_username.getText() : "Anonymous");

                        //now append the message and send the message through the server
                        sb.append(": ");
                        sb.append(textField_inputFromUser.getText());

                        toServer.writeUTF(sb.toString());
                    }
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        });
    }

    //method networking()
    //initialised the sockets, streams, and creates thread for listening to server
    private void networking() {
        //try and catch exceptions
        //catch IOException due to sockets and streams
        try {
            //initialise the socket on host and port 8000
            socket = new Socket(host, 8000);
            //initialise the Data Streams
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            //now create a thread that will listen for all user inputs
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //try and catch exceptions
                    //catch IOException due to streams
                    try {
                        //first thing server sends is the amount of users connected to the server
                        label_numberOfUsersConnected.setText("" + fromServer.readInt());
                        
                        //infinite while loop to wait for user input
                        while (true) {
                            //first server sends the number of users
                            label_numberOfUsersConnected.setText("" + fromServer.readInt());

                            //next the server sends the message
                            textArea_chat.append(fromServer.readUTF() + "\n");
                        }
                    } catch (IOException ex) {
                        textArea_chat.append("COULD NOT READ MESSAGE SENT\n");
                        System.err.println(ex);
                    }
                }
            });

            //DONT FORGET TO START THE THREAD
            thread.start();

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    //main method to run code
    public static void main(String[] args) {
        //create an instance of the applet
        Client applet = new Client();
        applet.isStandAlone = true; //stand alone application so is true
        //get the host
        if (args.length == 1) {
            applet.host = args[0]; //change the host from localhost to host passed through argument
        }

        //invoke initialise and start methods from Applet class
        applet.init();
        applet.start();

        //create a JFrame to hold the applet
        JFrame frame = new JFrame();

        //add the applet instance to the JFrame
        frame.setLayout(new BorderLayout());
        frame.add(applet, BorderLayout.CENTER);

        //set frame settings
        frame.setTitle("Client Applet");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
