/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.examples.listing16_10;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//class extends JFrame --> so constructor called will be JFrame
public class ControlCircleWithMouseAndKey extends JFrame {

    //variables to be used
    private JButton btnEnlarge = new JButton("Enlarge");
    private JButton btnShrink = new JButton("Shrink");
    private CirclePanel panelCircle = new CirclePanel();

    //constructor to create JPanel and add components to it
    public ControlCircleWithMouseAndKey() {
        //group the buttons together by creating a panel
        JPanel panelButtons = new JPanel();
        panelButtons.add(btnEnlarge);
        panelButtons.add(btnShrink);

        //add the 2 panels
        add(panelCircle, BorderLayout.CENTER); //add the circlePanel to center of the screen
        add(panelButtons, BorderLayout.SOUTH); //add button panel to the bottom of the screen

        //action listeners for the buttons
        btnEnlarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //call the enlarge method of the circle
                panelCircle.enlarge();
                btnEnlarge.setFocusable(false); //set focus to false, so not to stop keyboard
            }
        });
        btnShrink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //call the shrink method of the circle
                panelCircle.shrink();
                btnShrink.setFocusable(false); //set focus to false, so not to stop keyboard
            }
        });

        //mouse listener for click enlarg/shrink --> listener needs to be placed onto the panel/circle
        panelCircle.addMouseListener(new MouseAdapter() {
            //override method for mouse clicked
            @Override
            public void mouseClicked(MouseEvent me) {
                //check which button was pressed to enlarge or shrink
                if (me.getButton() == MouseEvent.BUTTON1) {
                    //enlarge circle
                    panelCircle.enlarge();
                } else if (me.getButton() == MouseEvent.BUTTON3) {
                    //shrink circle
                    panelCircle.shrink();
                }
            }
        });

        //set the focus onto the circle, so we can use the arrow keys
        panelCircle.setFocusable(true);
        //arrowKeys for enlarge and shrink --> listener needs to be placed onto the panel/circle
        panelCircle.addKeyListener(new KeyAdapter() {
            //override method for key pressed
            @Override
            public void keyPressed(KeyEvent ke) {
                //check if up arrow or down arrow
                if(ke.getKeyCode() == KeyEvent.VK_UP){
                    //enlarge circle
                    panelCircle.enlarge();
                } else if (ke.getKeyCode() == KeyEvent.VK_DOWN){
                    //shrink the circle
                    panelCircle.shrink();
                }
            }
        });

    }

    //main method to run code
    public static void main(String[] args) {

        //create the JFrame
        ControlCircleWithMouseAndKey frame = new ControlCircleWithMouseAndKey();
        frame.setTitle("Control the size of the Circle");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); //spawn the frame in the middle of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when frame is closed
        frame.setVisible(true); //show the frame
        
    }

    //nested class that extends JPanel
    //this is so that we can use this inner CirclePanel class with other classes (by creating instance of the outer class)
    private static class CirclePanel extends JPanel {

        private int radius;

        //constructor to create the CirclePanel
        public CirclePanel() {
            radius = 5;
        }

        //methods for the circle
        public void enlarge() {
            radius++; //increase the size of the circle
            repaint(); //show the new circle/ panel to the JFrame
        }

        public void shrink() {
            radius--; //decrease the size of the circle
            repaint(); //show the new circle/ panel to the JFrame
        }

        //override paintComponent from the JComponent class
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //call the method from the super class
            //draw a circle --> oval
            //PARAMS: param1 = x location; param2 = y location; param3 = start angle (shortest diameter); param4 = arc angle (largest diameter)
            g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
            /*
            param1 = center circle in x axis
            param2 = center circle in y axis
            param3 = shortest diameter of oval (circle diameter)
            param3 = longest diameter of oval (circle diameter)
             */
        }

    }

}
