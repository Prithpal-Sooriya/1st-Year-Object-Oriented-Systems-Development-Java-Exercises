/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.part15;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Prithpal Sooriya
 */
public class ParallelSum {

    //main method t0 run code
    public static void main(String args[]) {
        //create a list with 9000000 items
        double[] list = new double[9000000];
        //populate list (lets use small values, as number returned cannot be larger than Double.maxValue()
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 10) + 1;
            //list[i] = 1;
        }

        //output the total when sequentail
        long startTime = System.currentTimeMillis();
        double total = sequentialSum(list);
        long endTime = System.currentTimeMillis();
        System.out.println("The total value of the list is: " + total);
        System.out.println("Time taken for sequential sum: " + (endTime - startTime) + " milliseconds");

        total = 0;
        //output the total when parallel
        startTime = System.currentTimeMillis();
        total = parallelSum(list);
        endTime = System.currentTimeMillis();
        System.out.println("The total value of the list is: " + total);
        System.out.println("Time taken for parallel sum: " + (endTime - startTime) + " milliseconds");
        System.out.println("With " + Runtime.getRuntime().availableProcessors() + " number of processors");
    }

    //method to find and return sequential sum
    private static double sequentialSum(double[] list) {
        double total = 0;
        for (int i = 0; i < list.length; i++) {
            total += list[i];
        }
        return total;
    }

    //method to find and return parallel sum
    private static double parallelSum(double[] list) {
        int startingIndex = 0;
        int endingIndex = list.length;
        //create a recursive task for which the ForkJoinPool will invoke
        //use the class we created that extends RecursiveTask, so we can use our own code
        RecursiveTask<Double> task = new RecursiveTaskParallelSum(list, startingIndex, endingIndex);
        ForkJoinPool pool = new ForkJoinPool();
        //invoke the method to get total
        double total = pool.invoke(task);
        //return the total
        return total;
    }
}

//class to implement parallel method to find sum of double list and return answer
//extends RecursiveTask so we can add our own code into compute method
class RecursiveTaskParallelSum extends RecursiveTask {

    //variables to use
    private static final int THRESHOLD = 50;
    private double[] list;
    private int startingIndex;
    private int endingIndex;

    //constructor
    public RecursiveTaskParallelSum(double[] list, int startingIndex, int endingIndex) {
        this.list = list;
        this.startingIndex = startingIndex;
        this.endingIndex = endingIndex;
    }

    //override method to add our own code into compute
    @Override
    protected Object compute() {
        double total = 0;
        //base case, if the amount of items in the sublist is less than 50
        if (endingIndex - startingIndex < THRESHOLD) {
            for (int i = startingIndex; i < endingIndex; i++) {
                total += list[i];
            }
            return new Double(total);
        } else {
            //split the list into 2 lists
            //first find the middle
            int startingIndexForFirstHalf = startingIndex;
            int endingIndexForFirstHalf = (startingIndex + endingIndex) / 2;
            int startingIndexForSecondHalf = (startingIndex + endingIndex) / 2;
            int endingIndexForSecondHalf = endingIndex;

            //invoke 2 recursive calls to get the total from each half
            RecursiveTask<Double> firstHalfTask = new RecursiveTaskParallelSum(list, startingIndexForFirstHalf, endingIndexForFirstHalf);
            RecursiveTask<Double> secondHalfTask = new RecursiveTaskParallelSum(list, startingIndexForSecondHalf, endingIndexForSecondHalf);

            secondHalfTask.fork();
            firstHalfTask.fork();

            total = total + firstHalfTask.join().doubleValue();
            total = total + secondHalfTask.join().doubleValue();

            //return total
            return new Double(total);
        }
    }
}
