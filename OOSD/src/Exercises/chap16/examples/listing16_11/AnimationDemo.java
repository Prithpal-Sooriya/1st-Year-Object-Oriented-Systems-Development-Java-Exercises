/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.examples.listing16_11;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Prithpal Sooriya
 */
//Extend JFrame so we can call a constuctor that is a JFrame
public class AnimationDemo extends JFrame {

    //constuctor
    public AnimationDemo() {
        //create 2 moving message pannels for display
        this.setLayout(new GridLayout(2, 1));
        add(new MovingMessagePanel("Left Click Slows Animation"));
        add(new MovingMessagePanel("Right Click Speeds Animation"));
        
    }

    //main method to run code
    public static void main(String[] args) {

        //create the Frame
        AnimationDemo frame = new AnimationDemo();
        frame.setTitle("Animation Demo");
        frame.setSize(900, 300);
        frame.setLocationRelativeTo(null); //spawn frame in center of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when frame is closed
        frame.setVisible(true); //show the frame
        
    }

    //inner nested (Static) class, extend JPanel so we can add to JFrame
    private class MovingMessagePanel extends JPanel {
        
        //variables to use
        private String message;
        private int x = 0;
        private int y = 20;
        private Timer timer = new Timer(1000, new TimeListener());
        
        public MovingMessagePanel(String message) {
            this.message = message;

            //start the timer
            timer.start();

            //control animation by mouse buttons
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    //check which button was clicked to determine to increase or decrease delay
                    int delay = timer.getDelay();
                    if(me.getButton() == MouseEvent.BUTTON1){
                        //increase timer
                        timer.setDelay(delay < 2000 ? delay + 10 : 2000);
                    }
                    else if(me.getButton() == MouseEvent.BUTTON3){
                        //decrease timer
                        timer.setDelay(delay > 10 ? delay - 10 : 0);
                    }
                }
            });
        }

        //override method from JComponent to paint contents
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            //set new coordinates
            if(x > getWidth())
                x = -20; //goes beyond bounds, then go back to start
            x += 5;
            
            //draw the string
            g.drawString(message, x, y);
        }
    }

    //inner class to implement action listener
    private class TimeListener implements ActionListener {

        //impement method from ActionListener
        @Override
        public void actionPerformed(ActionEvent ae) {
            //we want to repaint for after each delay (so message is in new location
            repaint();
        }
        
    }
    
}
