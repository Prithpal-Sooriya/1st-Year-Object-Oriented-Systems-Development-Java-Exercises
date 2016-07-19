/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.part4;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Prithpal Sooriya
 */
//extends applet so we can use this on web if we want to
public class ClientDisplayNumberOfUsers extends JApplet {
    
    private String host = "localhost"; //string for local host
    private int numberOfUsers; //int to store number of users
    private JLabel labelShowNumberOfUsers = new JLabel();
    private Socket socket;
    private DataInputStream fromServer;
    private boolean isStandAlone = false; //if this is run in browser or as application
    //override method to run own code for applet
    @Override
    public void init() {
        //add the JLabel into the applet
        add(labelShowNumberOfUsers);

        //try and catch IOException for creating sockets and streams
        try {
            //connect to host on port 8000
            socket = new Socket(host, 8000); //socket for creating a connection

            //initialise the DataInputStream
            fromServer = new DataInputStream(socket.getInputStream());

            //thread to get numberOfUsers
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //try and catch IOException du to streams
                    while (true) {
                        try {
                            numberOfUsers = fromServer.readInt(); //readInt will pause/block code underneath till read
                            //write the number of users onto the JLabel
                            labelShowNumberOfUsers.setText("\tNumber of users who are currently on server: " + numberOfUsers);
                        } catch (IOException ex) {
                            System.err.println(ex);
                        }
                    }
                }
            });
            //start the thread
            thread.start();
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    //main method to run code
    public static void main(String[] args) {
        //Create a JFrame to show content
        JFrame frame = new JFrame();

        //create an instance of the applet
        final ClientDisplayNumberOfUsers applet = new ClientDisplayNumberOfUsers();
        applet.isStandAlone = true;

        //get the host
        if (args.length == 1) {
            applet.host = args[0]; //change the host from localhost to host passed through argument
        }

        //add the applet instance to the JFramSe
        frame.setLayout(new BorderLayout());
        frame.add(applet, BorderLayout.CENTER);

        //invoke initialise and start methods from Applet class
        applet.init();
        applet.start();

        //set frame settings
        frame.setTitle("Client Applet");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //add code to when window is closing
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                try {
                    //create a DataOutputStream to tell server that this client has exited
                    DataOutputStream toServer = new DataOutputStream(applet.socket.getOutputStream());
                    //send boolean to server FALSE --> meaning we are not on server anymore
                    toServer.writeInt(0);
                    System.out.println("Closed");
                } catch (IOException ex) {
                }
            }
        });
    }
    
}
