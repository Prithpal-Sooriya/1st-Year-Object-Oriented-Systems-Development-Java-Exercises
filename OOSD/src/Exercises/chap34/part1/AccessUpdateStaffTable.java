/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap34.part1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Prithpal Sooriya
 */
//extends JApplet
public class AccessUpdateStaffTable extends JApplet {

    //variables that will be used in other methods
    JTextField jtfId = new JTextField(9);
    JTextField jtfLastName = new JTextField(15);
    JTextField jtfFirstName = new JTextField(15);
    JTextField jtfMi = new JTextField(1);
    JTextField jtfAddress = new JTextField(20);
    JTextField jtfCity = new JTextField(20);
    JTextField jtfState = new JTextField(2);
    JTextField jtfTelephone = new JTextField(10);

    JButton jbtView = new JButton("View");
    JButton jbtInsert = new JButton("Insert");
    JButton jbtUpdate = new JButton("Update");
    JButton jbtClear = new JButton("Clear");

    JLabel jlMessage = new JLabel("Applet Created!");

    //override method from JApplet: init()
    //initialise the JApplet
    @Override
    public void init() {

        //create the gui
        createGUI();

        //try and load the driver (if failed state)
        //catch ClassNotFoundExcption
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

        //set button actions
        buttonActions();
    }

    private void createGUI() {
        //id panel
        JPanel panelId = new JPanel();
        panelId.add(new JLabel("ID "));
        panelId.add(jtfId);

        //name frame
        JPanel panelName = new JPanel();
        //add lastName
        panelName.add(new JLabel("Last Name "));
        panelName.add(jtfLastName);
        //add firstName
        panelName.add(new JLabel("First Name "));
        panelName.add(jtfFirstName);
        //add mi
        panelName.add(new JLabel("mi "));
        panelName.add(jtfMi);

        //address frame
        JPanel panelAddress = new JPanel();
        panelAddress.add(new JLabel("Address "));
        panelAddress.add(jtfAddress);

        //city and state frame
        JPanel panelCityAndState = new JPanel();
        //add city
        panelCityAndState.add(new JLabel("City "));
        panelCityAndState.add(jtfCity);
        //add state
        panelCityAndState.add(new JLabel("State "));
        panelCityAndState.add(jtfState);

        //telephone frame
        JPanel panelTelephone = new JPanel();
        panelTelephone.add(new JLabel("Telephone "));
        panelTelephone.add(jtfTelephone);

        //button frame
        JPanel panelButtons = new JPanel();
        panelButtons.add(jbtView);
        panelButtons.add(jbtInsert);
        panelButtons.add(jbtUpdate);
        panelButtons.add(jbtClear);

        //add all these frames to a master frame (gridview)
        JPanel panelMaster = new JPanel();
        panelMaster.setLayout(new GridLayout(7, 1));
        panelMaster.add(panelId);
        panelMaster.add(panelName);
        panelMaster.add(panelAddress);
        panelMaster.add(panelCityAndState);
        panelMaster.add(panelTelephone);
        panelMaster.add(panelButtons);
        //add final JLabel to display error/messages
        JPanel panelMessage = new JPanel();
        panelMessage.add(jlMessage);
        panelMaster.add(panelMessage);

        //add this master to the applet
        add(panelMaster, BorderLayout.NORTH);

        //set max amount of charcters for each JTextField
        //nevermind, will have to use a DocumentFilter or intercept key presses
        //KISS
    }

    private void buttonActions() {

        //view button, will return "record found" or "record not found"
        jbtView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jlMessage.setText("View Button Clicked!");

                //get the id entered
                String stringId = jtfId.getText().trim();

                //now check if the id is 9 NUMBERS
                if (!stringId.matches("\\d{9}")) {
                    System.out.println("ID not valid (needs to be 9 numbers [0-9]");
                } else {
                    //now time to use the JDBC stuff!!!

                    //try and catch execptions
                    //catch SQLExcpetion due to establishing connection and accessing database
                    try {
                        //Drvier alreadly loaded, so create a connection
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");
                        
                        //create a statement
                        Statement statement = connection.createStatement();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            }
        });

        jbtInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jlMessage.setText("Insert Button Clicked!");
            }
        });

        jbtUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jlMessage.setText("Update Button Clicked!");
            }
        });

        //when clear button is pressed need to clear the text from all the TextFields
        jbtClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jlMessage.setText("Clear Button Clicked!");

                jtfId.setText("");
                jtfLastName.setText("");
                jtfFirstName.setText("");
                jtfMi.setText("");
                jtfAddress.setText("");
                jtfCity.setText("");
                jtfState.setText("");
                jtfTelephone.setText("");
            }
        });
    }

    //main method to run code
    public static void main(String[] args) {
        //create an instance of the applet
        AccessUpdateStaffTable applet = new AccessUpdateStaffTable();

        //create frame to hold applet
        JFrame frame = new JFrame();
        //set frame settings
        frame.setTitle("Staff Table");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add the applet
        frame.add(applet);
        //initialise applet and show frame
        applet.init();

        frame.setVisible(true);
    }
}
