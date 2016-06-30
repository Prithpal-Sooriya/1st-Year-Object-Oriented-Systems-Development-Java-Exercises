/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.part9;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//extends JFrame so the constuctor is a JFrame with componenets
public class DrawLinesWithArrowKeys extends JFrame {

    //constuctor
    public DrawLinesWithArrowKeys() {
        //add the JPanel for drawing lines
        DrawLines panelDrawLines = new DrawLines(); //center location
        //add the JPanel
        add(panelDrawLines);
        //set the focus on the panel, so keyboard inputs are focused on the panel
        panelDrawLines.setFocusable(true);
    }

    //inner class to paint dots for lines
    //extends JPanel to draw lines
    private class DrawLines extends JPanel {

        //private variables to use inside this class
        private int prevX = getWidth() / 2;; //coords
        private int prevY = getHeight() / 2;; //coords
        private int x;
        private int y;

        //boolean to check if the object has been created (only need to use this once
        private boolean started = true;

        //constuctor --> will hold the x and y coords so when called, give a starting location
        public DrawLines() {
            
            //add the keylisteners
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent ke) {
                    //switch statement to for the arrow keys
                    switch (ke.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            y = prevY - 5;
                            /* y axis inverted */
                            break;
                        case KeyEvent.VK_DOWN:
                            y = prevY + 5;
                            /* y axis inverted */
                            break;
                        case KeyEvent.VK_LEFT:
                            x = prevX - 5;
                            break;
                        case KeyEvent.VK_RIGHT:
                            x = prevX + 5;
                            break;
                    }
                    repaint();
                }
            });
        }

        //override paint method from JComponent superclass
        @Override
        public void paint(Graphics g) {
            //super.paint(g); //dont need this, as this super call of the method removes previous graphics
            if (started) {
                prevX = x = getWidth() / 2;
                prevY = y = getHeight() / 2;
                
                g.drawLine(prevX, prevY, prevX, prevY);
                started = false;
            } else {
                g.drawLine(prevX, prevY, x, y);
                //set the current x and y values to previous x and y values
                prevX = x;
                prevY = y;
            }
        }

    }

    //main method to run code for JFrame
    public static void main(String[] args) {
        //create frame
        DrawLinesWithArrowKeys frame = new DrawLinesWithArrowKeys();
        frame.setTitle("Draw Lines with arrow Keys");
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null); //spawn frame to middle of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when the frame is closed

        //show the frame
        frame.setVisible(true);
    }
}
