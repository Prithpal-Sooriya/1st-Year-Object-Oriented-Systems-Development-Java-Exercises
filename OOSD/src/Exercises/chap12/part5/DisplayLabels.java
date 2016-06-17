/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Prithpal Sooriya
 */
public class DisplayLabels {
    
    
    //main class to run program
    public static void main(String[] args) {
        
        //create JFrame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(4, 1)); //set the layout (simple flow layout)
        frame.setTitle("Display Labels with borders");
        frame.setSize(400,500); //set size of frame
        frame.setLocationRelativeTo(null); //set spawn location of frame on screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end program if frame is closed
        
        //add labels
        JLabel labels[] = new JLabel[4];
        //initialise and populate labels
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel("This is Label " + (i + 1));
            //add a boarder to the labels
            Border blackline = BorderFactory.createLineBorder(Color.black);
            labels[i].setBorder(blackline);
            //add the label to the frame
            frame.add(labels[i]);
        }
        
        //show frame by setting visible
        frame.setVisible(true);
       
    }
    
}
