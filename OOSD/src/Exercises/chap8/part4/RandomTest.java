/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part4;

import java.util.Random;

/**
 *
 * @author Prithpal Sooriya
 */
public class RandomTest {
    public static void main(String[] args) {
        //create random object
        Random randObject = new Random(1000);
        
        for (int i = 0; i < 50; i++) {
            /*
            ooooh thats cool, no repititions of numbers
            as long as the FOR loop isnt larger than param
            */
            System.out.println(randObject.nextInt(100));
        }
        
    }
}
