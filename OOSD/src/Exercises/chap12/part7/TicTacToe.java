/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part7;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Random;
import javafx.scene.shape.Circle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
public class TicTacToe {

    private static final int CROSS = 1;
    private static final int CIRCLE = 0;

    //main class to run code
    public static void main(String[] args) {

        /*
        logic to go through problem
        
        create frame --> 3x3 grid layout
        create label array
        
        X will have 5 goes, and O will have 4 goes
        each time x turn, it is them o turn
        
            --> don't even need to do this, just assign 5 X positions and 4 O positions

        dont need arrayList, just set a loop to add x or o, and when their limit is reached, stop using them
        
        //once positions set, then show them
         */
        //frame to hold board
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 3)); //set the layout to grid (3x3 grid)
        frame.setTitle("Tic-Tac-Toe"); //set the title
        frame.setSize(400, 400); //set size of the frame
        frame.setLocationRelativeTo(null); //spawn frame in center of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end program when frame closes

        //count how many times x and o have been used
        int x = 0; //x will represent 1
        int o = 0; //o will represent 0

        //Random rand to select random 0 or 1
        Random rand = new Random();

        for (int i = 0; i < 9; i++) {
            //conditions to check if x or o is filled
            if (x < 5 && o < 4) {
                //Math.Random to pick a random integer
                int j = rand.nextInt(2);
                //add that image (as 0 and 1 match the constants
                addImage(frame, j);
                //check if o or x should be incremented
                if (j == 0) {
                    o++;
                } else if (j == 1) {
                    x++;
                }
            } else if (x < 5) {
                //just add x image to panel
                addImage(frame, CROSS);
                x++;
            } else if (o < 4) {
                //just add o image to panel
                addImage(frame, CIRCLE);
                o++;
            }
        }
        
        //finally show the frame by setting the visibility
        frame.setVisible(true);

    }

    public static void addImage(JFrame frame, int item) {

        //create a circle or cross and add the item to the frame (hopefully it is passing the reference (it is an object)
        switch (item) {
            case CROSS:
                ImageIcon cross = new ImageIcon(
                        /* .getScaledInstance(Width of label, Height of label, scaling type)  */
                        new ImageIcon(TicTacToe.class.getResource("images/cross.jpg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)
                );
                frame.add(new JLabel(cross));
                break;
            case CIRCLE:
                ImageIcon circle = new ImageIcon(
                        /* .getScaledInstance(Width of label, Height of label, scaling type)  */
                        new ImageIcon(TicTacToe.class.getResource("images/circle.jpg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)
                );
                frame.add(new JLabel(circle));
                break;
            default:
                System.out.println("This is not a valid shape, use the CIRCLE or CROSS constant ints");
                break;
        }

    }

}
