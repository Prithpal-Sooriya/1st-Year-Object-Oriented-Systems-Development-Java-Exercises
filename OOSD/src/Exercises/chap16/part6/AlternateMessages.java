/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.part6;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//extends JPanel so constuctor will be JPanel and hold the message
public class AlternateMessages extends JPanel {
    
    //private constructors to use
    private boolean switchMessages = true;
    private final String message1 = "Java is Fun";
    private final String message2 = "Java is Powerful";
    
    
    //constuctor
    public AlternateMessages() {
        //panel created
        //boolean to switch between messages
        

        //get mouse click --> add listener on class
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //when mouse is clicked, change message --> change boolean
                switchMessages = !switchMessages;
                repaint(); //rerun paint component
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //change the message
        String message = switchMessages ? message1 : message2;
        //the minus stuff is just to try to center the message in the center of the JFrame
        g.drawString(message, (getWidth()/2) - ((message.length()/2) * 5), getHeight()/2 - 4);
    }
    
    
    //main method to run code
    public static void main(String[] args){
        
        //create a JFrame
        JFrame frame = new JFrame();
        frame.setTitle("Click to show a different messages");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); //spawn frame in the middle of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when the frame is closed
        
        //add the JPanel constuctor --> to add the message and add the click listener
        frame.add(new AlternateMessages());
        
        //show the frame
        frame.setVisible(true);
        
    }
}
