/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_5.listing33_5And6;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Prithpal Sooriya
 */

//extend applet to be used as an applet
public class AppletClient extends Applet{
    //Variables to be using
    JLabel labelCount = new JLabel(); //JLabel to show the count
    boolean isStandAlone = false; //Indicate if the program runs as an application
    private String host = "localhost"; //HostName or IP address for server
    
    //override method from applet to initailise the applet
    @Override
    public void init() {
        add(labelCount);
        
        //try and catch IOException for dealing with streams
        try {
            //Create the socket to connect to the server
            Socket socket = new Socket(host, 8000); //connect to server with servers hostname and port number
            
            //create a dataInputStream to recieve the count
            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
            
            //recieve the count and display on JLabel
            int count = inputFromServer.readInt();
            labelCount.setText("You are visitor " + count + " to the server");
            
            //close the stream from server (best practice to close streams to prevent memory leakage
            inputFromServer.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    //main method to run the code
    public static void main(String[] args){
        //Create a JFrame to show content
        JFrame frame = new JFrame();
        
        //create an instance of the applet
        AppletClient applet = new AppletClient();
        applet.isStandAlone = true;
        
        //get the host
        if(args.length == 1){
            applet.host = args[0]; //change the host from localhost to host passed through argument
        }
        
        //add the applet instance to the JFrame
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
    }
    
}
