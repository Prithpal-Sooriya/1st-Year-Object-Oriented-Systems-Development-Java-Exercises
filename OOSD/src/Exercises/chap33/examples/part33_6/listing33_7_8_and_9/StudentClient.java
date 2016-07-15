/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_6.listing33_7_8_and_9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Prithpal Sooriya
 */
//extends JApplet so can be used to instantiate an applet
public class StudentClient extends JApplet {

    //JTextFields to be using
    private JTextField textFieldName = new JTextField();
    private JTextField textFieldStreet = new JTextField();
    private JTextField textFieldCity = new JTextField();
    private JTextField textFieldPostcode = new JTextField();

    //Button for sending a student's address to the server
    private JButton buttonRegister = new JButton("Register to Server");

    //boolean to indicate if it runs as an application
    boolean isStandAlone = false;

    //String to hold hostname/ip of server
    String host = "localhost";

    //override init() method From JApplet to initiase JApplet
    @Override
    public void init() {
        //Panel for holding all Name, Street and City
        JPanel panelNameStreetCityText = new JPanel(new GridLayout(3, 1)); //3 row, 1 column
        panelNameStreetCityText.add(new JLabel("Name: "));
        panelNameStreetCityText.add(new JLabel("Street: "));
        panelNameStreetCityText.add(new JLabel("City: "));

        //Panel for holding TextFields of Name, Street and City
        JPanel panelNameStreetCity = new JPanel(new GridLayout(3, 1)); //3 rows 1 column
        panelNameStreetCity.add(textFieldName);
        panelNameStreetCity.add(textFieldStreet);
        panelNameStreetCity.add(textFieldCity);

        //Panel for holding PostCode and button
        JPanel panelPostCodeAndButton = new JPanel(new BorderLayout());
        panelPostCodeAndButton.add(new JLabel("Post Code: "), BorderLayout.WEST);
        panelPostCodeAndButton.add(textFieldPostcode, BorderLayout.CENTER);
        panelPostCodeAndButton.add(buttonRegister, BorderLayout.EAST);
        panelPostCodeAndButton.add(buttonRegister, BorderLayout.SOUTH);
        //Panel to group the everything together
        JPanel panelStudent = new JPanel(new BorderLayout());
        panelStudent.setBorder(new BevelBorder(BevelBorder.RAISED));
        panelStudent.add(panelNameStreetCityText, BorderLayout.WEST);
        panelStudent.add(panelNameStreetCity, BorderLayout.CENTER);
        panelStudent.add(panelPostCodeAndButton, BorderLayout.SOUTH);
        
        
        //add the panel of everything to the applet
        add(panelStudent);
        
        //find the IP address of the webserver (this is if it is ran on the web)
        if (!isStandAlone) {
            host = getCodeBase().getHost();
        }

        //action listener for the button
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //try and catch IOException since we are using streams
                try {
                    //establish a connection with server, using host (hostname/IP address) and port number
                    Socket socket = new Socket(host, 8000);

                    //create an ObjectOutputStream to the server
                    ObjectOutputStream outputObjectToServer = new ObjectOutputStream(socket.getOutputStream());

                    //get the text inside the JTextFields
                    String name = textFieldName.getText();
                    String street = textFieldStreet.getText();
                    String city = textFieldCity.getText();
                    String postcode = textFieldPostcode.getText();

                    //create a StudentAddress object and send the object through the server
                    StudentAddress address = new StudentAddress(name, street, city, postcode);
                    outputObjectToServer.writeObject(address);
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        });
    }

    //main method to run code
    public static void main(String[] args){
        //create a frame
        JFrame frame = new JFrame();
        
        
        
        //create the StudentClient applet and add it to the frame
        StudentClient applet = new StudentClient();
        applet.isStandAlone = true; //this is a stand alone Applet, and is not on the web
        if(args.length == 1){
            applet.host = args[0]; //change the host to the argument of different host given
        }
        
        //invoke init and start methods of applet to initialise and start the applet
        applet.init();
        applet.start();
        
        frame.add(applet);
        
        //set frame settings
        frame.setTitle("Register Student Client");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
