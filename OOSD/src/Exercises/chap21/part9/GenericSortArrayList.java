/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part9;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericSortArrayList {
    
    //main method to run code
    public static void main(String[] args){
        
        Integer[] ints = {3, 7, 4, 2, 6, 0, 8, 9, 1, 5};
        
        //create an unsorted ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(ints));
        
        //output unsorted array
        System.out.println(numbers.toString());
        
        //sort the array
        sort(numbers);
        
        //output sorted array
        System.out.println(numbers.toString());
        
    }
    
    //method to sort generic arraylist
    public static <E extends Comparable<E>> void sort(ArrayList<E> list){
        
        //variable to hold to smallest index(which will be placed into correct position at the end
        int smallestIndex;
        E itemToSwap; //temporary hold for when swapping 2 items
        //Outer FOR loop for the iterations of sort
        for (int i = 0; i < list.size() - 1; i++) { //size() - 1, because the final item will already be sorted
            //set smallest to i
            smallestIndex = i;
            //inner FOR loop to find the smallest
            for (int j = i + 1; j < list.size(); j++) { //index j is 1 ahead of i
                //check if smallest needs to be swapped
                if(list.get(smallestIndex).compareTo(list.get(j)) > 0){
                    smallestIndex = j;
                }
            }
            //we got the smallest, so put the smallest in the correct position (swap) (if it isnt i)
            if(smallestIndex != i){
                itemToSwap = list.get(smallestIndex);
                list.set(smallestIndex, list.get(i));
                list.set(i, itemToSwap);
            }
        }
        
    }
    
}
