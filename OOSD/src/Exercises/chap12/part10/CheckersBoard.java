/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part10;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Prithpal Sooriya
 */
public class CheckersBoard {

    //main method to run code
    public static void main(String[] args) {

        //Create a Frame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(8, 8)); //grid of 8x8 for board
        frame.setTitle("Checkers board"); //set the title
        frame.setSize(500, 500); //set size of frame
        frame.setLocationRelativeTo(null); //spawn frame in center of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ends when the frame is closed

        //boolean toggle to change colour
        boolean white = true;

        //for loop for row and column
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //create a button
                JButton button = new JButton();
                //set the colour
                if (white) {
                    button.setBackground(Color.WHITE);
                } else {
                    button.setBackground(Color.BLACK);
                }

                //add the button
                frame.add(button);

                //toggle boolean
                white = !white;
            }
            //toggle boolean at end of each row (to achieve checkered pattern
            white = !white;
        }

        //show the frame by setting visible
        frame.setVisible(true);

    }

}
