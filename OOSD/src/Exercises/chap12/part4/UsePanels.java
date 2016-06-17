/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part4;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
public class UsePanels {
    
    //main method to run code
    public static void main(String[] args) {
        
        //create a frame
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout()); //ALL FRAMES WILL NEED A LAYOUT
        frame.setTitle("Use JPanel to group buttons"); //set the title
        frame.setSize(400, 130); //set the size
        frame.setLocationRelativeTo(null); //set the spawn location to center of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when user closes frame
        
        //create the 2 panels and add them to the frame
        JPanel panel1 = new Panel(0);
        JPanel panel2 = new Panel(3);
        frame.add(panel1);
        frame.add(panel2);
        
        //show the frame, by setting visibility
        frame.setVisible(true);
    }
    
}
