/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.part2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Prithpal Sooriya
 */

//extend JFrame so we can create constuctor that puts contents on frame
//implement action listener for pressing the buttons
public class WhichButtonPressed extends JFrame implements ActionListener{
    
    JButton[] buttons = new JButton[6];
    
    //constructor to create JFrame
    public WhichButtonPressed(){
        //set the layout to flow layout
        setLayout(new FlowLayout());
        
        //initialise all the buttons and add the buttons to the JFrame
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton("Button " + (i+1));
            add(buttons[i]);
            //set the action listeners for the button
            buttons[i].addActionListener(WhichButtonPressed.this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //for all the buttons set the action performed to be on console
        for(int i = 0; i < buttons.length; i++){
            if(ae.getSource() == buttons[i]){
                //print what button pressed in console
                System.out.println("Button " + (i+1) + " was pressed");
            }
        }
    }
    
    //main method to run code for GUI Swing
    public static void main(String[] args){
        //create the frame using the constructor
        WhichButtonPressed frame = new WhichButtonPressed();
        frame.setTitle("Press Button and text appears in console");
        frame.setSize(600, 100);
        frame.setLocationRelativeTo(null); //spawn frame in middle of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end program when frame is closed
        frame.setVisible(true); //show the frame
    }
    
}
