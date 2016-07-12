/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.part12;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Prithpal Sooriya
 */
public class ParallelArrayInitialiser {
    //main method to run code
    public static void main(String[] args){
        //2 longs to store the current time (to calculate how long process takes)
        long startTime;
        long endTime;
        
        //create a list of 9000000 elements
        double[] list1 = new double[9000000];
        double[] list2 = new double[9000000];
        //get the start time, run parallel method, get end time, display time taken
        startTime = System.currentTimeMillis();
        parallelAssignValues(list1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken in parallel assign values: " + (endTime - startTime));
        System.out.println("With " + Runtime.getRuntime().availableProcessors() + " number of processors");
        
        //get the start time, run sequential method, get end time, display time taken
        startTime = System.currentTimeMillis();
        sequentialAssignValues(list2);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken in sequential assign values: " + (endTime - startTime));
    }
    
    //sequential method to assign values to list
    public static void sequentialAssignValues(double[] list){
        //randomly assign values to list
        for(int i = 0; i < list.length; i++){
            list[i] = (double) (Math.random()*10000000);
        }
    }
    
    //parallel method to assign values to list
    public static void parallelAssignValues(double[] list){
        //get the list starting index and ending index (exclusive)
        int startingIndex = 0;
        int endingIndex = list.length;
        //create a recursive action (which is a subclass of ForkJoinClass to use in ForkJoinPool)
        //call class that extends RecursiveAction so can use its compute method
        RecursiveAction task = new SplitAssignList(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }
    
    //inner class to split the list and assign values to list
    //extends RecursiveAction, so we can utilise compute method
    private static class SplitAssignList extends RecursiveAction{
        
        //variables to be using
        double[] list;
        //int startingIndex;
        //int endingIndex;
        
        //constructor
        //param1 = the list, param2 = the starting index, param3 = the ending index for the FOR loop
        public SplitAssignList(double[] list){
            this.list = list;
        }

        //override method from RecursiveAction
        @Override
        protected void compute() {
            //set a base case
            if(list.length <= 50){
                //populate the list
                Random rand = new Random();
                for(int i = 0; i < list.length; i++){
                    list[i] = rand.nextDouble() * 10000000;
                }
            }
            else{
                //need to split the list into 2 parts
                int firstHalfLength = list.length / 2;
                int secondHalfLength = list.length - (list.length / 2); //this is becuase rounded down if odd number
                
                double[] firstHalfList = new double[firstHalfLength];
                double[] secondHalfList = new double[secondHalfLength];
                
                //recursion on the list
                /*invokeAll method from ForkJoinTask, calls a new thread for the RecursiveAction param given*/
                invokeAll(new SplitAssignList(firstHalfList), new SplitAssignList(secondHalfList));
                
                //combine the lists together
                /*params
                param1 = list with items
                param2 = starting index the popluated list
                param3 = new list to populate
                param4 = starting index of new list
                param5 = how much you want to copy
                */
                //copy the first half
                System.arraycopy(firstHalfList, 0, list, 0, firstHalfLength);
                //copy the second half
                System.arraycopy(secondHalfList, 0, list, firstHalfLength, secondHalfLength);
                
            }
        }
    }
}
