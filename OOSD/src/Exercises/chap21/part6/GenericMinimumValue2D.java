/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part6;

import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericMinimumValue2D {

    //main method to run code
    public static void main(String[] args) {

        //Create a 2D integer array
        Integer[][] integerList2D = {
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,0,5},
            {1,2,3,4,5},
        };
        
        //print out the smallest value in the 2D list
        //Arrays.deepToString --> prints as string for 2D or more Dimension arrays
        System.out.println("The smallest value in:\n" + Arrays.deepToString(integerList2D) + "\nis: " + min(integerList2D));
    }

    //generic method to find smallest value in 2D list
    public static <E extends Comparable<E>> E min(E[][] list){
        E minimum = list[0][0]; //store the minimum, the starting value will be 0,0
        
        //outer FOR loop to run through columns
        for (int i = 0; i < list.length; i++) {
            //inner FOR loop to run through rows
            for (int j = 0; j < list[i].length; j++) {
                //check if the minimum needs to be swapped
                if(minimum.compareTo(list[i][j]) > 0){
                    //minimum needs to be swapped
                    minimum = list[i][j];
                }
            }
        }
        
        //found the smallest, so return it
        return minimum;
    }
    
}
