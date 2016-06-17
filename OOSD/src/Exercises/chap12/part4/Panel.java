/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap12.part4;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Prithpal Sooriya
 */
//need to inherit the JPanel
public class Panel extends JPanel {

    /*
    NOTE: we do not need to create a panel to place the items, as this class whole class is the panel
    */
    
    //constuctor to create the new Panel
    public Panel(int startingNumber) {

        //add 3 buttons (named from startingButton to startingButton + 3
        for (int i = startingNumber; i < startingNumber + 3; i++) {
            //just use add, as this class extends the container/JPanel
            add(new JButton("Button " + (i+1)));
        }
    }
}
