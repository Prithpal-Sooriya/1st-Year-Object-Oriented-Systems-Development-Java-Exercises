/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_4;

import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericSort {
    
    //main method to run the code
    public static void main(String[] args){
        
        //create an object array
        Integer[] integerArray = {5, 3, 7, 2, 7, 2, 4, 3};
        Double[] doubleArray = {1.1, 3.67, 2.57, 3.1, 9.9};
        Character[] characterArray = {'b', 'd', 'a', 'c'};
        String[] stringArray = {"hello", "bye", "apple", "cat", "world"};
        
        //sort the arrays
        sort(integerArray);
        sort(doubleArray);
        sort(characterArray);
        sort(stringArray);
        
        //display the sorted arrays
        System.out.println(Arrays.toString(integerArray));
        System.out.println(Arrays.toString(doubleArray));
        System.out.println(Arrays.toString(characterArray));
        System.out.println(Arrays.toString(stringArray));
    }
    
    //method to sort
    //E extends Comparable to be able to sort
    public static <E extends Comparable<E>> void sort(E[] list){
        //need an int to hold the smallest index of the loop
        //need a temp E to hold E before swap
        int smallestIndex = 0;
        E itemToSwap;
        
        //outer loop to set the new smallest index
        //need to loop till list.length - 1 --> as last index will already be sorted
        for (int i = 0; i < list.length - 1; i++) {
            smallestIndex = i;
            
            //inner loop to find swaps
            //need to loop till list.length as we need to check all items
            //j = i + 1, as this loop will always start 1 after outer loop
            for (int j = i + 1; j < list.length; j++) {
                //check if we need to swap
                if(list[smallestIndex].compareTo(list[j]) > 0){
                    //smallest index is not the smallest, change the smallest
                    smallestIndex = j;
                }
            }
            
            //after end of inner FOR loop ended, check if i is different --> then swap items
            if(smallestIndex != i){
                //need to swap items
                itemToSwap = list[smallestIndex];
                list[smallestIndex] = list[i];
                list[i] = itemToSwap;
            }
            
        }
        //end of loop, lists are sorted
    }
    
    
    
}
