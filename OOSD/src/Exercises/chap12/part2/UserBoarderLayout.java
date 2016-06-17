/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */

//need to inherit JFrame/JContainer/Container
public class UserBoarderLayout extends JFrame{
    
    //main class to to run the code
    public static void main(String[] args) {
        
        //create a JFrame
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout()); //set the layout to BorderLayout
        frame.setName("Use BorderLayout");
        frame.setSize(400, 120);
        frame.setLocationRelativeTo(null); //center the frame in the window
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); //set the close operation n
        
        //create the 2 panels
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        
        //create the 6 buttons
        JButton buttons[] = new JButton[6];
        
        //initialise the buttons and set the names
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button " + (i+1));
        }
        
        //add the first 3 buttons to the panel1
        for (int i = 0; i < 3; i++) {
            panel1.add(buttons[i]);
        }
        //add the last 3 butons to the panel2
        for (int i = 3; i < buttons.length; i++) {
            panel2.add(buttons[i]);
        }
        
        //add the panels to the frames
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        
        //show the frame --> set the visibility
        frame.setVisible(true); //set frame to visible
    }
    
}
