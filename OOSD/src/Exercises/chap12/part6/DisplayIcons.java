/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part6;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Prithpal Sooriya
 */
public class DisplayIcons {
    
    //main class to run code
    public static void main(String[] args) {
        //JFrame to put everything into
        JFrame frame  = new JFrame();
        frame.setLayout(new GridLayout(2, 2)); //set layout to grid layout (2x2 grid)
        frame.setTitle("Display Icons Using JLabel"); //set Title
        frame.setSize(400, 400); //set size of frame
        frame.setLocationRelativeTo(null); //set spawn location to be center of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end program when frame closes
        
        //Create a the JLabels
        JLabel label[] = new JLabel[4];
        
        //the 4 images to use
        ImageIcon a = new ImageIcon(
                /* .getScaledInstance(Width of label, Height of label, scaling type)  */
                new ImageIcon(DisplayIcons.class.getResource("images/a.jpg")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT)
        );
        ImageIcon b = new ImageIcon(
                new ImageIcon(DisplayIcons.class.getResource("images/b.jpg")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT)
        );
        ImageIcon c = new ImageIcon(
                new ImageIcon(DisplayIcons.class.getResource("images/c.jpeg")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT)
        );
        ImageIcon d = new ImageIcon(
                new ImageIcon(DisplayIcons.class.getResource("images/d.jpeg")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT)
        );
        //initialise all the items in the array
        for (int i = 0; i < label.length; i++) {
            switch(i){
                case 0:
                    label[i] = new JLabel(a);
                    break;
                case 1:
                    label[i] = new JLabel(b);
                    break;
                case 2:
                    label[i] = new JLabel(c);
                    break;
                case 3:
                    label[i] = new JLabel(d);
                    break;
            }
            
            //add the label
            frame.add(label[i]);
        }
        
        //show frame by setting it visible
        frame.setVisible(true);
        
    }
    
}
