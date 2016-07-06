/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericShuffleArrayList {
    
    //main method to run code
    public static void main(String[] args){
        
        Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        //create an arrayList
        ArrayList<Integer> numbers = new ArrayList();
        numbers.addAll(Arrays.asList(ints));
        
        //output numbers, not shuffled
        System.out.println(numbers.toString());
        
        //shuffle numbers
        shuffle(numbers);
        
        //output numbers, shuffled
        System.out.println(numbers.toString());
    }
    
    public static <E> void shuffle(ArrayList<E> list){
        Random rand = new Random();
        E itemToSwap;
        //for loop for each of the indexes
        for (int index = 0; index < list.size(); index++) {
            int newIndexForItem = rand.nextInt(list.size());
            //time to swap!!
            itemToSwap = list.get(index);
            list.set(index, list.get(newIndexForItem));
            list.set(newIndexForItem, itemToSwap);
        }
        //swapped positions with all items, I guess this is a pseudo shuffle
    }
    
}
