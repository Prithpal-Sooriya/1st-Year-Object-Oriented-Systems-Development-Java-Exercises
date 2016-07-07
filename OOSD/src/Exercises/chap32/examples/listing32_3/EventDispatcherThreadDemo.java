/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_3;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Prithpal Sooriya
 */

//extend JApplet to show text in window
public class EventDispatcherThreadDemo extends JApplet{
    
    //constructor
    public EventDispatcherThreadDemo(){
        //create and add a a JLabel with some text
        add(new JLabel("This has been run through the Event Dispatch Thread"));
    }
    
    //main method to run code
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //code ran in here will be executed first, withouth the need to wait for Event Dispatch Thread
                //create a Frame
                JFrame frame = new JFrame("Event Dispatcher Thread Demo"); //param is title of frame
                frame.add(new EventDispatcherThreadDemo());
                frame.setSize(600, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the frame/program when the frame is closed
                frame.setLocationRelativeTo(null); //spawn in the middle of the screen
                frame.setVisible(true);
            }
        });
    }
}
