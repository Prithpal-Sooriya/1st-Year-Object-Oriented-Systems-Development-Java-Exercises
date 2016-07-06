/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part4;

import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericInsertionSort {

    //main method to run code
    public static void main(String[] args) {

        //lists to use
        //int[] intList = {2, 5, 8, 1, 0, 6, 7, 3, 9, 4}; //primitives dont work
        Integer[] integerList = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Double[] doubleList = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
        
        //sort the lists
        insertionSort(integerList);
        insertionSort(doubleList);
        
        //print the lists
        System.out.println(Arrays.toString(integerList));
        System.out.println(Arrays.toString(doubleList));
        
    }

    //method for a generic insertion sort
    public static <E extends Comparable<E>> void insertionSort(E[] list) {

        /*
        Insertion sort:
        loops through the list once
            checks each item to the previous item
            if the item is smaller than the previous
                backtrack to "insert" in the right position
                (done by using a WHILE loop till correct position is found
         */
        E holdItem; //temp E to hold the one of the items for swapping
        int sortingIndex; //will store the index to sort (for backtracking to correct location
        for (int index = 1; index < list.length; index++) { //starts at 1 as we need always check to previous
            holdItem = list[index]; //hold the item in the index, if we need to swap
            sortingIndex = index;
            /*While loop conditions:
            sortingIndex > 0, to keep the index within bounds
            previous index > holdItem --> means we still need to run loop for swaps
            */
            while (sortingIndex > 0 && list[sortingIndex - 1].compareTo(holdItem) > 0) {
                //initiate move
                /* rundown of how this works
                list[index] = list[index-1] (1st while iteration)
                list[index-1] = list[index-2] (2nd while iteration)
                list[index-2] = list[index-3] (3rd while iteration)
                ...
                basically move all items forward in index till location for insert should be
                */
                list[sortingIndex] = list[sortingIndex - 1];
                sortingIndex--;
            }
            //"insert" the holded item into the correct position
            list[sortingIndex] = holdItem;
        }
        //list sorted
    }

}
