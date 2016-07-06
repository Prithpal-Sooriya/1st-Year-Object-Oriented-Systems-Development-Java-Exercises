/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericLargestInArrayList {
    
    //main method to run code
    public static void main(String[] args){
        
        //Create an Integer array, which will be then stored into the ArrayList
        Integer[] ints = {0, 1, 2, 3, 4, 5, 66, 7, 8, 9};
        
        //create an arrayList
        ArrayList<Integer> numbers = new ArrayList();
        numbers.addAll(Arrays.asList(ints));
        
        //output the array
        System.out.println(numbers.toString());
        
        //output the largest element in the array
        System.out.println("The largest item in the array was: " + max(numbers));
    }
    
    //method to find max in generic ArrayList
    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        E largest = list.get(0); //where we will store the largest, default will be the starting index
        
        //for loop to loop through all the element (apart from 1, since it is already in there)
        for (int index = 1; index < list.size(); index++) {
            //check if the largest needs to be replaced
            if(largest.compareTo(list.get(index)) < 0){
                //need to change largest
                largest = list.get(index);
            }
        }
        //found largest, so return largest
        return largest;
    }
    
}
