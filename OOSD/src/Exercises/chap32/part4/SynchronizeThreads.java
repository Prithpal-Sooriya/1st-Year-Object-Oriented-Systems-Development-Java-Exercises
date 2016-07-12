/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.part4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Prithpal Sooriya
 */
public class SynchronizeThreads {
    //main method to run code
    public static void main(String[] args) {
        int sum = 0;
        final IntWrapper wrappedSum = new IntWrapper(sum);
        //create a thread pool for the threads
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        //for loop to create and run 1000 threads
        for (int i = 0; i < 1000; i++) {
            Thread runIncrementThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized(wrappedSum) {
                            increment(wrappedSum);
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            });
            executor.execute(runIncrementThread); //execute the run() method of thread
        }

        //shutdown executor, so no other threads can be executed with it
        executor.shutdown();
        //wait till all the threads has completed
        while (!executor.isTerminated());
        //print sum
        sum = wrappedSum.getHoldingNumber();
        System.out.println("Sum of 1000 threads incrementing sum (should be 1000): " + sum);
    }

    //synchronized method what gets the sum and increments it
    //(method doesnt need to be synchronised, as it is already called in a synchronised block of code)
    //...but its best to stay safe
    //to pass as reference, we will want to accept Integer (so sum is wrapped)
    private static synchronized void increment(IntWrapper wrappedSum) {
        //sum = wrappedSum + 1; //unbox and add 1
        wrappedSum.setHoldingNumber(wrappedSum.getHoldingNumber() + 1);
    }

    //create inner mutable wrapper class for int
    private static class IntWrapper{
        private int holdingNumber;
        private IntWrapper(int holdingNumber){
            this.holdingNumber = holdingNumber;
        }
        
        //setter, so this class is immutable
        public void setHoldingNumber(int holdingNumber){
            this.holdingNumber = holdingNumber;
        }
        
        //getter to get the integer
        public int getHoldingNumber(){
            return holdingNumber;
        }
    }
}
