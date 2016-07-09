/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Prithpal Sooriya
 */
public class ConsumerProducerUsingBlockingQueue {

    //create a buffer to be used for the producer and consumer tasks
    //the queue will have size of 2 (2 elements can only be inside of the queue
    //this is helpful as it blocks all calls of adding items once capacity has reached
    //same thing happens when queue is empty, blocks all calls for removing an item
    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(2);

    //A Task for writing integers to a buffer
    private static class ProducerTask implements Runnable {

        //override method from Runnable to be used as a thread
        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes: " + i);
                    buffer.put(i++); //put i into buffer and then increment i
                    //put the thread to sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
            }
        }
    }

    //A Tash for reading integers to a buffer
    private static class ConsumerTask implements Runnable {

        //override method from Runnable to be used as a thread
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\tConsumer reads: " + buffer.take());
                    //put the thread to sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
            }
        }
    }

    //main method to run code
    public static void main(String[] args) {
        //create an executor service for a pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //execute threads
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        //shutdown executor so no new threads can be added/executed
        executor.shutdown();
    }

}
