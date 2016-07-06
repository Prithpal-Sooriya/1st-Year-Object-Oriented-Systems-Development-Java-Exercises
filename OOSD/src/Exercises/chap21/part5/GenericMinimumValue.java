/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part5;

import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericMinimumValue {
    
    //main method to run code
    public static void main(String[] args){
        
        //create lists
        Integer[] integerList = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Double[] doubleList = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
        
        //print out minimum
        System.out.println("Smallest value in: " + Arrays.toString(integerList) + "\nis: " + min(integerList));
        System.out.println("Smallest value in: " + Arrays.toString(doubleList) + "\nis: " + min(doubleList));
    }
    
    //generic method to find the smallest value
    public static <E extends Comparable<E>> E min(E[] list){
        //store the minimum, starting value will always be the first index of list (0)
        E minimum = list[0];
        //FOR loop to loop through all elements from index 1 to n-1
        //find if there are any smaller values, then store that smaller value
        for (int index = 1; index < list.length; index++) 
            if(minimum.compareTo(list[index]) > 0)
                minimum = list[index];
        
        //return minimum
        return minimum;
    }
    
}
