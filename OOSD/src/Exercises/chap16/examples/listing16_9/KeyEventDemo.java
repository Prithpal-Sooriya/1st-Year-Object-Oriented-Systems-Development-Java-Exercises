/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.examples.listing16_9;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//class extends JFrame
public class KeyEventDemo extends JFrame {

    //constuctor for class
    public KeyEventDemo() {

        //create the keyboard panel to use
        KeyboardPanel kp = new KeyboardPanel();
        
        //add the keyboard panel (a JPanel) to the frame
        add(kp);
        
        //set the focus on the keyboard panel (JPanel)
        //--> this allows us to keep locked onto the panel/ wont move off the screen
        kp.setFocusable(true);
    }

    //main method to run code
    public static void main(String[] args) {

        KeyEventDemo frame = new KeyEventDemo();
        frame.setTitle("Keyboard Event Demo");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null); //spawn frame in the center of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when the frame is closed
        frame.setVisible(true); //show the frame
    }

    //private inner class JPanel that deals with keyboard action
    //static so there can only be 1 instance of the class (and no non static method to use)
    private static class KeyboardPanel extends JPanel {

        private char message;
        private int x = 100;
        private int y = 100;

        //constuctor
        public KeyboardPanel() {

            //keyboard listener
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent ke) {
                    //what happens when a key is pressed

                    //use a switch statement to go through the options
                    //use the keyevent keycode to find out what key was pressed
                    switch (ke.getKeyCode()) {
                        case KeyEvent.VK_UP: //up key pressed
                            y -= 10; //need to decrement as y = 0 is top bar
                            break;
                        case KeyEvent.VK_DOWN: //down key pressed
                            y += 10; //need to increment as y = 0 is top bar
                            break;
                        case KeyEvent.VK_LEFT: //left key pressed
                            x -= 10;
                            break;
                        case KeyEvent.VK_RIGHT: //right key pressed
                            x += 10;
                            break;
                        default:
                            message = ke.getKeyChar();
                    }

                    //show the message in new coords --> repaint method in Component class
                    repaint();
                }

            });
        }

        //draw the character, use
            //method to paint the component of the message
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //use superclass to paint the panel
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 50));
            g.drawString(String.valueOf(message), x, y); //draw this char message on screen
        }
    }
}
