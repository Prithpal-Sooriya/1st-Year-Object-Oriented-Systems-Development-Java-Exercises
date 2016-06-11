/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part14;

import java.util.Random;

/**
 *
 * @author Prithpal Sooriya
 */
public class Test {
    
    public static void main(String[] args) {
        
        //create a list of 1000 random ints
        int array[] = new int[10000];
        Random rand = new Random();
        for (int i : array) {
           i = rand.nextInt(10000);
        }
        
        Stopwatch stopwatch = new Stopwatch();
        //now lets test the stopwatch
        stopwatch.start();
        insertionSort(array);
        stopwatch.stop();
        System.out.println("Time elapsed: " + stopwatch.getElapsedTime());
    }
    
    //insertion sort of an array of numbers
    public static void insertionSort(int[] array){
        int smallest = 0; 
        for (int i = 0; i < array.length - 1; i++) { //i will itereate through 0-(n-2)
            smallest = i; //set the smallest so far to the first item
            for (int j = 1; j < array.length; j++) { //j will iterate throug 1-(n-1)
                if(array[smallest] > array[j]){ //smallest is not the smallest
                    //we found a new smallest number
                    smallest = j;
                }
            }
            //we found the smallest number, so lets place it into the correct location
            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }
    }
    
}
