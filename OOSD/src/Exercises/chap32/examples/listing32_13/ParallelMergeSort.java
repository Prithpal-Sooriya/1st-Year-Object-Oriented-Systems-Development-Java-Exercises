/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_13;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Prithpal Sooriya
 */

/*
Parallel merge sort:
-->split the array into 2 halves
-->apply merge sort on each half recursivly
-->after the 2 halves are sorted, the algorithm merges them
*/

/*This Java class will compare parallel merge sort with the execution time of sequential sort*/
public class ParallelMergeSort {
    //main method to run code
    public static void main(String[] args){
        final int SIZE = 7000000;
        //2 arrays to be using
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];
        //populate the arrays (lists will be same)
        for (int i = 0; i < list1.length; i++) {
            list1[i] = list2[i] = (int)(Math.random() * 10000000);
        }
        
        /*PARALLEL MERGE SORT TIME TAKEN*/
        //get the starting time (we can use this to get how long the sorts take)
        long startTime = System.currentTimeMillis();
        //start the merge sort, by the parallelMergeSort class
        parallelMergeSort(list1); //invoke parallel merge sort
        //get the end time
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel Runtime with " + Runtime.getRuntime().availableProcessors() + " processors is: " + (endTime - startTime) + " milliseconds");
        
        /*NORMAL MERGE SORT TIME TAKEN*/
        startTime = System.currentTimeMillis();
        MergeSort.mergeSort(list2); //invoke Merge sort
        endTime = System.currentTimeMillis();
        System.out.println("\nNormal Mergesort Runtime/ Sequential time is: " + (endTime - startTime) + " milliseconds");
    }
    
    //parallel merge sort method
    public static void parallelMergeSort(int[] list){
        //create a RecursiveAction (it is a subtask of ForkJoinTask, so can be used); it does not return anything
        RecursiveAction miniTask = new SortTask(list);
        //create a thread pool. Specific thread pool for invoking a ForkJoinTask (aka the subTasks of it, RecursiveAction and RecursiveTask)
        ForkJoinPool pool = new ForkJoinPool();
        //invoke method with param of ForkJoinTask, or its subclasses (RecursiveAction, RecursiveTask)
        pool.invoke(miniTask);
    }
    
    //inner class of SortTask(int[] list)
    //extends RecursiveAction, so it can be used as a RecursiveAction
    //also used to override the compute method, so we can run our own code into it
    private static class SortTask extends RecursiveAction{

        //variables to use
        private final int THRESHOLD = 50; //the threshhold in which splits the original list into smaller lists
        private int[] list; //list to hold input praram from constructor
        
        //constructor
        public SortTask(int[] list){
            this.list = list;
        }
        
        //override method compute, to run own code
        @Override
        protected void compute() {
            if(list.length < THRESHOLD){
                Arrays.sort(list);
            }
            else{ //list is too largs, so lets split the list
                //half of list in first half
                int[] firstHalf = new int[list.length / 2];
                //copy the contnent of list to firstHalf
                /*arraycopy params:
                param1 = original list
                param2 = starting index of original list
                param3 = list to copy to
                param4 = starting index of new list
                param5 = amount of elements to copy over, in this case half of the list
                */
                System.arraycopy(list, 0, firstHalf, 0, list.length/2);
                //half of list in second list
                int secondHalfLength = list.length - (list.length/2);
                int[] secondHalf = new int[secondHalfLength];
                System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
                
                //recursivly sort the 2 halfs
                /*invokeAll method from ForkJoinTask, calls a new thread for the RecursiveAction param given*/
                invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));
                
                //merge the first half and the second half into list
                MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
        
    }
}
