/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.examples.listing16_8;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//class extends jframe
public class MoveMessageDemo extends JFrame {

    public MoveMessageDemo() {
        //create a movable message panel
        MovableMessagePanel mp = new MovableMessagePanel("Try Moving me!");
        
        //place this panel into the frame
        add(mp);
    }

    //main method to run code
    public static void main(String[] args) {

        //create frame
        MoveMessageDemo frame = new MoveMessageDemo();
        frame.setTitle("Moveable String Demo");
        frame.setSize(200, 100); //set size
        frame.setLocationRelativeTo(null); //spawn frame to middle of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end program when frame is closed
        frame.setVisible(true); //show the frame

    }

    //inner class create a moveable string
    private static class MovableMessagePanel extends JPanel {

        //private variables to use
        private String message;
        private int x = 20;
        private int y = 20;

        //constructor
        public MovableMessagePanel(String message) {
            this.message = message;

            //add a mouse listener --> usually JPanel x; x.addMouse... but this extends JPanel
            //mouseMotionListener, listener for when mouse is dragged or moved
            //adapter --> dont need to add all the methods from listener version
            addMouseMotionListener(new MouseMotionAdapter() {
                
                //when mouse is dragged
                @Override
                public void mouseDragged(MouseEvent mouse) {
                    //get coordinates for the mouse new position
                    x = mouse.getX();
                    y = mouse.getY();
                    
                    //need to re display the panel --> use repaint method (part of all awt/Swing components
                    repaint();
                    
                }
            });
        }
        
        //user JPanel/components override method to paint the component

        @Override
        protected void paintComponent(Graphics g) {
            //call the superclass method paint component
            super.paintComponent(g);
            //draw something on the panel
            g.drawString(message, x, y); //draws a String inside the panel at given coordinates
        }
        

    }

}
