/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_7.listing33_10_11_12.code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Prithpal Sooriya
 */

//extend JApplet, so we can show a GUI (and passible implement on a web page
//implement Runnable, so can use as code for thread
//implement TicTacToeConstants to gain the constants
public class TicTacToeClient extends JApplet implements Runnable, TicTacToeConstants{
    //variables to use
    //indicate if the player has a turn
    private boolean myTurn = false;
    //the token for the player to use (not set yet as we dont know if this client is player 1 or 2)
    private char myToken = ' ';
    //other players token (not set yet as we dont know if this client is player 1 or 2)
    private char otherToken = ' ';
    
    private Cell[][] cell = new Cell[3][3]; //uses class called Cell, for GUI implimentation
    
    private JLabel labelTitle = new JLabel(); //JLabel for the title
    private JLabel labelStatus = new JLabel(); //JLabel for the status
    
    //ints for row and column for the selected move
    private int rowSelected;
    private int columnSelected;
    
    //Data Input/Output streams to the server
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    
    //boolean for continue to play default value is true
    private boolean continueToPlay = true;
    
    //boolean for waiting for this clients turn
    private boolean waiting = true;
    
    //boolean to indicate if this is a standalone application
    private boolean isStandAlone = false;
    
    //HostName or IP address of server
    private String host = "localhost";

    //override method from JApplet
    @Override
    public void init() {
        //pannel to hold cells
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 0, 0));
        
        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < cell[i].length; j++){
                panel.add(cell[i][j] = new Cell(i, j));
            }
        }
        
        //set properties for labels and boarders for JLabels and JPanels
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelTitle.setBorder(new LineBorder(Color.BLACK, 1));
        labelStatus.setBorder(new LineBorder(Color.BLACK, 1));
        
        //place the labelTitle and labelStatus onto the applet
        add(labelTitle, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(labelStatus, BorderLayout.SOUTH);
        
        //call the connectToServer method
        
    }
    
    
}
