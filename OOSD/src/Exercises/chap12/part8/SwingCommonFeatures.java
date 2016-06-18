/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part8;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Prithpal Sooriya
 */
public class SwingCommonFeatures {
    
    //main class to run code
    public static void main(String[] args) {
        
        //create a frame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 3)); //set the layout to grid layout with 2 rows and 3 columns
        frame.setTitle("Swing Common Features"); //set the title
        frame.setSize(600, 300); //set size of frame
        frame.setLocationRelativeTo(null); //spawn frame in the center of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when the frame closes
        
        //create the 6 labels to use
        JLabel labels[] = new JLabel[6];
        
        /*
        initialise the labels
        set the background colour
        set the boarder to line and boarder colour to yellow
        set the font to Times new Roman, bold and 20 pixels
        set the foreground colour (switch statement)
        set text and tooltip to name of foreground colour (inside switch statement)
        add to frame
        */
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(); //initialise the JLabel
            
            //set the boarder
            Border border = BorderFactory.createLineBorder(Color.YELLOW); //creates a line boarder with yellow colour
            labels[i].setBorder(border); //add the boarder
            
            //set font to Times new Roman, bold and 20 pixels
            Font font = new Font("TimesRoman", Font.BOLD, 20);
            labels[i].setFont(font);
            
            //set background colour
            labels[i].setBackground(Color.WHITE);
            
            //set foreground colour with text and tool tip to its name
            switch(i){
                case 0:
                    labels[i].setForeground(Color.BLACK);
                    labels[i].setText("Black");
                    labels[i].setToolTipText("Black");
                    break;
                case 1:
                    labels[i].setForeground(Color.BLUE);
                    labels[i].setText("Blue");
                    labels[i].setToolTipText("Blue");
                    break;
                case 2:
                    labels[i].setForeground(Color.CYAN);
                    labels[i].setText("Cyan");
                    labels[i].setToolTipText("Cyan");
                    break;
                case 3:
                    labels[i].setForeground(Color.GREEN);
                    labels[i].setText("Green");
                    labels[i].setToolTipText("Green");
                    break;
                case 4:
                    labels[i].setForeground(Color.MAGENTA);
                    labels[i].setText("Magenta");
                    labels[i].setToolTipText("Magenta");
                    break;
                case 5:
                    labels[i].setForeground(Color.ORANGE);
                    labels[i].setText("Orange");
                    labels[i].setToolTipText("Orange");
                    break;
            }
            
            //add label to the frame
            frame.add(labels[i]);
        }
        
        //show the frame, by setting it visible
        frame.setVisible(true);
        
    }
    
}
