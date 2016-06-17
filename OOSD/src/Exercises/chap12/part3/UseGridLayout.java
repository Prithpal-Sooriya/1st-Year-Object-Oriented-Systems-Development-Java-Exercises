/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part3;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Prithpal Sooriya
 */

//need to inherit the JFrame class
public class UseGridLayout extends JFrame{
    
    //main method to run the code
    public static void main(String[] args) {
        
        //Create a JFrame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 3)); //param1 = rows, param2 = columns
        frame.setTitle("Use GridLayout"); //set the title
        frame.setSize(400, 200); //set size
        frame.setLocationRelativeTo(null); //spawn frame in center of screen
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); //end the program when frame is closed
        
        //create 6 buttons
        JButton buttons[] = new JButton[6];
        
        //initialise all the buttons and set their names
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button " + (i+1));            
        }
        
        //add all the buttons to the frame --> GridLayout will add container until need to go to next column
        for (int i = 0; i < buttons.length; i++) {
            frame.add(buttons[i]);
        }
        
        //show the frame
        frame.setVisible(true); //set the frame to visible
    }
    
}
