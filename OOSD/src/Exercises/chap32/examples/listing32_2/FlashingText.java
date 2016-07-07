/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_2;

import javax.swing.JApplet;
import javax.swing.JLabel;

/**
 *
 * @author Prithpal Sooriya
 */

//extend JApplet to show text on screen
//implement runnable, so to add code to run() method for thread
public class FlashingText extends JApplet implements Runnable{
    
    //create the JLabel to show text
    private JLabel labelText = new JLabel("Hello", JLabel.CENTER); //2nd param to center the text
    
    //create a constructor
    public FlashingText(){
        //add the JLabel to the JApplet, and create the thread
        add(labelText);
        new Thread(this).start();
    }
    
    //override method from Runnable to execute code in thread
    @Override
    public void run() {
        //infinite while loop to show and hide text (will keep going till the Applet is closed
        //need to catch InterruptedException if the code is called when the thread is sleeping
        try{
            while(true){
                if(labelText.getText() == null){
                    labelText.setText("Hello");
                }
                else{
                    labelText.setText(null);
                }
                //the thread sleeps for 2 seconds (2000ms)
                Thread.sleep(2000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Cannot call the thread, the thread is sleeping");
        }
    }
    
    
    
}
