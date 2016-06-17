/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.Part1;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//need to inherit the Jframe class
public class UseFlowLayout extends JFrame {

    //where the code will start from
    public static void main(String[] args) {

        //create the JFrame
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout()); //set the layout
        frame.setTitle("Use FlowLayout"); //set the title
        frame.setSize(600, 100); //param1 = width, param2 = height
        frame.setLocationRelativeTo(null); //center the frame
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); //set so that the program will terminate when closed

        //create the panels
        JPanel panel1 = new JPanel(new FlowLayout()); //new panal with Flow Layout
        JPanel panel2 = new JPanel(new FlowLayout());

        //create the buttons
        JButton buttons[] = new JButton[6];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("button " + (i + 1)); //initialise the buttons and give them a name
        }

        //add first 3 buttons to the first panel
        for (int i = 0; i < 3; i++) {
            panel1.add(buttons[i]);
        }

        //add last 3 buttons to the second panel
        for (int i = 3; i < buttons.length; i++) {
            panel2.add(buttons[i]);
        }

        //add panels to the frame
        frame.add(panel1);
        frame.add(panel2);

        //show the frame
        frame.setVisible(true);

    }

}
