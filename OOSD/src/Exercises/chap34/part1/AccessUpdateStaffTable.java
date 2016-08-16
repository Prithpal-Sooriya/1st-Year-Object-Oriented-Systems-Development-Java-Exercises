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
        //...
    }

    private void buttonActions() {
        jbtView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jlMessage.setText("View Button Clicked!");
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
        
        jbtClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jlMessage.setText("Clear Button Clicked!");
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
