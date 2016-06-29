/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.part3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//extend JFrame so constructor is a JFrame with components
//implement action listener for the buttons
public class MoveABall extends JFrame implements ActionListener {

    //variables to show size of frame
    static int width = 400;
    static int height = 300;
    //buttons in outer scope to be accessed by ActionListener
    JButton buttons[] = new JButton[4];

    //create a panel for the Circle
    //circlePanel in outer scope to be accessed by ActionListener
    CirclePanel circlePanel = new CirclePanel();

    //constuctor
    public MoveABall() {
        //set layout to boarder
        setLayout(new BorderLayout());
        //create a panel for the 4 buttons (up down left right)
        JPanel buttonsPanel = new JPanel();

        for (int i = 0; i < buttons.length; i++) {
            String message = "";
            switch (i) {
                case 0:
                    message = "up";
                    break;
                case 1:
                    message = "down";
                    break;
                case 2:
                    message = "left";
                    break;
                case 3:
                    message = "right";
                    break;
            }
            buttons[i] = new JButton(message);
            //set the action listener
            buttons[i].addActionListener(MoveABall.this);
            //add the buttons to panel
            buttonsPanel.add(buttons[i]);
        }

        //add the panels to the frame
        add(buttonsPanel, BorderLayout.SOUTH); //buttons will be at bottom
        add(circlePanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //buttons commands
        for (int i = 0; i < buttons.length; i++) {
            if (ae.getSource() == buttons[i]) {
                if (i == 0) {
                    circlePanel.up();
                }
                if (i == 1) {
                    circlePanel.down();
                }
                if (i == 2) {
                    circlePanel.left();
                }
                if (i == 3) {
                    circlePanel.right();
                }
            }
        }
    }

    //inner class for Circle
    private class CirclePanel extends JPanel {

        //variables we will use
        //radius of circle
        int radius = 5;
        //coordinates --> starts at middle of the screen
        int x;
        int y;

        //boolean to shown that the circle has been created
        //because we only need to set the circle in the center when first shown then move the circle
        //if we dont do this then the circle will always remain in center of screen
        boolean created = true;

        //no arg constuctor
        public CirclePanel() {
            //nothing to do in here
        }

        //methods
        public void up() {
            //check if the y coord is within bounds
            if (y >= 10) {
                y -= 10; //coords for y are inverted
                repaint(); //redraw circle
            }
        }

        public void down() {
            //check if the y coord is within bounds
            if (((y + (2 * radius)) <= getHeight() - 10)) {
                y += 10; //coords for y are inverted
                repaint(); //redraw circle
            }
        }

        public void left() {
            //check if the x coord is within bounds
            if (x >= 10) {
                x -= 10;
                repaint(); //redraw circle
            }
        }

        public void right() {
            //check if the x coord is within bounds
            if (((x + (2 * radius)) <= getWidth() - 10)) {
                x += 10;
                repaint(); //redraw circle
            }
        }

        //override method from JComponent to paint circle
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            /*
            param1 = center circle in x axis
            param2 = center circle in y axis
            param3 = short diameter, same diameter so enter radius
            param4 = long diameter, same diameter so enter radius
             */
            if (created) {
                x = getWidth() / 2 - radius;
                y = getHeight() / 2 - radius;
                created = false;
            }
            System.out.println(x);
            System.out.println(y);
            g.drawOval(x, y, radius * 2, radius * 2);
        }

    }

    //main method to run GUI Swing
    public static void main(String[] args) {
        //create the frame and set important methods
        MoveABall frame = new MoveABall();
        frame.setTitle("Press the buttons to move the ball");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null); //spawn the frame in the middle of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when JFrame is closed
        frame.setResizable(false); //user cant resize the Frame
        //show the frame
        frame.setVisible(true);
    }

}
