/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part3;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericBubbleSort {
 
    //main method to run code
    public static void main(String[] args){
        
        //create unsorted arrays
        Integer[] integers = {2, 5, 8, 1, 0, 6, 7, 3, 9, 4};
        Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
        
        //sort the arrays
        bubbleSort(integers);
        bubbleSort(doubles);
        
        //print the arrays sorted
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(doubles));
        
    }
    
    //generic static method bubble sort
    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        
        /*
        Bubble sort:
        this works in pairs(2 indexs)
            index1 = 0 to n-1
            index2 = 1 to n-2
        swaps pairs if index1 > index2
        bubbles the largest value to top of index
            once top value is found, top value is removed from the search space
        if the search space becomes 1 item, end the search
        */
        
        
        int index1, index2; //indexes for swapping
        E holdItemToSwap; //temp storage to hold an item when swap is being performed
        
        //repeat iterations till search space is <= 1
        for (int searchSpace = list.length; searchSpace > 1; searchSpace--) { //search space we will be iterating through
            //this inner loop will be for seaching through the items in search space
            for (index1 = 0; index1 < searchSpace - 1; index1++) {
                //index1 seaches 0 to n-1
                //index2 seaches 1 to n
                index2 = index1 + 1;
                
                //check if the items in the indicies need to be swapped
                if(list[index1].compareTo(list[index2]) > 0){
                    //if index1 is larger, then swap
                    holdItemToSwap = list[index2];
                    list[index2] = list[index1];
                    list[index1] = holdItemToSwap;
                }
            }
        }
        //list is sorted so method will end
    }
    
}
