/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_14;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Prithpal Sooriya
 */
public class ParallelMax {

    //main method to run code
    public static void main(String[] args) {
        //create a list
        final int N = 9000000;
        int[] list = new int[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        
        list[123456] = 1000000000;
        
        long startTime = System.currentTimeMillis();
        System.out.println("The largest number is: " + max(list));
        long endTime = System.currentTimeMillis();
        System.out.println("\nThe number of processors is: " + Runtime.getRuntime().availableProcessors());
        System.out.println("\nThe time taken to find largest number: " + (endTime - startTime) + " milliseconds");
    }

    //max method, will be responcible for creating the ForkJoinPool and the ForkJoinTask
    public static int max(int[] list) {
        RecursiveTask<Integer> task = new MaxTest(list, 0, list.length); //Max test extends Recursive task
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    //inner class
    //extends recursive task so we return a value, and use create method to run code
    private static class MaxTest extends RecursiveTask {

        //variables that will be used by class
        private final static int THRESHOLD = 1000;
        private int[] list;
        private int low;
        private int high;

        //constructor
        /**
         * @param int[] list, the input list
         * @param int low, the starting index to search for largest number
         * (inclusive)
         * @param int high, the end index to search for largest item (exclusive)
        *
         */
        public MaxTest(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected Object compute() {
            //the range is within the threshold, thus base case
            if (high - low < THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++) {
                    if(list[i] > max){
                        max = list[i];
                    }
                }
                return new Integer(max); //cannot return a primitive
            }
            else{
                int mid = (low + high) / 2;
                RecursiveTask<Integer> left = new MaxTest(list, low, mid); //recursive call (of new thread) from list, low to mid
                RecursiveTask<Integer> right = new MaxTest(list, mid, high); //recursive call (of new thread) from list, mid to high
                
                //fork the methods
                //fork right first, as it is the last item to be joined (as shown below)
                //this is to help avoid deadlock
                right.fork(); 
                left.fork();
                
                //return the Max integer (found from recursion), how find which branch contains the larger number
                return Math.max(left.join().intValue(), right.join().intValue());
            }
        }

    }
}
