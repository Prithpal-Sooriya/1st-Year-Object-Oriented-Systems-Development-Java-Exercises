/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part8;

/**
 *
 * @author Prithpal Sooriya
 */
public class Test {
    
    public static void main(String[] args) {
        
        //create 2 fans
        Fan fans[] = new Fan[2];
        fans[0] = new Fan();
        fans[0].setSpeed(Fan.FAST);
        fans[0].setRadius(10);
        fans[0].setColour("Yellow");
        fans[0].setOn(true);
        
        fans[1] = new Fan();
        fans[1].setSpeed(Fan.MEDIUM);
        fans[1].setRadius(5);
        fans[1].setColour("Blue");
        fans[1].setOn(false);
        
        //test the to string methods
        for (Fan fan : fans) {
            System.out.println(fan.toString());
        }
        
    }
    
}
