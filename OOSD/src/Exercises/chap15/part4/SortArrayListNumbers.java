/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Prithpal Sooriya
 */
public class SortArrayListNumbers {

    //main method to run code
    public static void main(String[] args) {

        //Create an arrayList which stores numbers (so will store Integers, Doubles bigInts, ect
        ArrayList<Number> numbers = new ArrayList<>(Arrays.asList(new Number[]{
            1.0d, 2.0f, new Long(3), 4, new Short("5"), new Byte("6"), new BigInteger("7"), new BigDecimal("8")
        }));

        //make the ArrayList in random order
        Collections.shuffle(numbers);

        //output the array
        System.out.println(numbers);
        
        //sort the array
        sort(numbers);
        
        //output the array
        System.out.println(numbers);

    }

    //method to sort the array 
    public static void sort(ArrayList<Number> list) {

        //lets do this sort manually, do an bubble swap
        //create temp store to store the smallest number index
        int smallest;

        for (int i = 0; i < list.size(); i++) {
            //set the smallest to the index
            smallest = i;
            for (int j = i + 1; j < list.size() - 1; j++) {
                //check smallest should be replaced
                if (list.get(smallest).doubleValue() > list.get(j).doubleValue()) {
                    swap(list, smallest, j);
                }
            }
        }

    }

    //create a swap method which swaps the previous smallest with the new smallest
    public static void swap(ArrayList<Number> list, int indexOfPrevSmallest, int indexOfNewSmallest) {

        //temp store to store number to swap
        Number temp = list.get(indexOfNewSmallest);
        Number largest = list.get(indexOfPrevSmallest);
        list.set(indexOfNewSmallest, largest);
        list.set(indexOfPrevSmallest, temp);

    }
}
