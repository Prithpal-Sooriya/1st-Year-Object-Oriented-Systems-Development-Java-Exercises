/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part7;

import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericBinarySearch {
    
    //main method to run code
    public static void main(String[] args){
        
        //create an Object array, has to be ordered for binary search to work
        Integer[] integerList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
       
        //print out array
        System.out.println(Arrays.toString(integerList));
        
        //output index of 4
        System.out.println("Number 4 is at index: " + binarySearch(integerList, new Integer(4))); //need to box, or will return -1
        //output index of 9
        System.out.println("Number 9 is at index: " + binarySearch(integerList, new Integer(9)));
        //output index 11, will return -1 as doesnt exist
        System.out.println("Number 11 is at index: " + ((binarySearch(integerList, new Integer(11)) == -1)? "-1, this item does not exist" : "apparently this does exist?!?!"));
    }
    
    //method to run binary search, will return the index of the item
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
        
        int upperBound = list.length - 1, lowerBound = 0; //the bounds used to get the midpoint and split at each search
        int index = (upperBound + lowerBound) / 2; //what we will return, set as midpoint
        
        //While loop: if we HAVNT got the key, if lowerbound <= upperbound
        while(list[index] != key && lowerBound <= upperBound){
            
            //check if the key is > or < or equal to key
            if(list[index].compareTo(key) > 0){
                //the upper bound is to high, so set as midpoint - 1 (as index is currently at midpoint)
                upperBound = index - 1;
            }
            else if (list[index].compareTo(key) < 0){
                //the lower bound was to low, so set as midpoint + 1 (as index is currently at midpoint)
                lowerBound = index + 1;
            }
            else{
                return index; //the index is equal to the key
            }
            //change the position to new midpoint
            index = (upperBound + lowerBound) / 2;
        }
        
        //loop ended without finding the index, so return -1
        return -1;
    }
    
}
