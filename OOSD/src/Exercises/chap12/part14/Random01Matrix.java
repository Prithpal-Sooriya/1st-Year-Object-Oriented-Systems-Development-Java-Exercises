/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part14;

import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Prithpal Sooriya
 */
public class Random01Matrix {

    //main method to run code
    public static void main(String[] args) {

        //create a frame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(10, 10)); //set layout to GridLayout with 10x10
        frame.setTitle("Random 01 sqaure matrix"); //set title of frame
        frame.setSize(200, 200); //set size of frame
        frame.setLocationRelativeTo(null); //spawn frame in center of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when the frame is closed

        //Random to create random 0 and 1
        Random rand = new Random();

        //use a FOR loop to loop through 100
        for (int i = 0; i < 100; i++) {
            //JLabel to avoid waste of memory, we will change and keep adding this label
            JLabel label = new JLabel();
            //set the text of the label
            label.setText("" + rand.nextInt(2));
            //center the text in the string
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            //add the label to the frame
            frame.add(label);
        }

        //show frame by setVisible
        frame.setVisible(true);
    }

}
