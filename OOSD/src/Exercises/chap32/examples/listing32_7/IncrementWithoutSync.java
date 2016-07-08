/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Prithpal Sooriya
 */
public class IncrementWithoutSync {

    //variable that all the threads will access
    private static int threadsAccess = 0;

    //main method to run code
    public static void main(String[] args) {

        //create a ExecutorService, which will use Executors.createCachedThreadPool
        ExecutorService executor = Executors.newCachedThreadPool();

        //launch 100 threads
        //calling Task to increment variable 10 times, 100 times... so total should be 1000
        for (int i = 0; i < 100; i++) {
            executor.execute(new IncrementVariable());
        }

        //shut down the executor, so no new tasks can be added to executor
        executor.shutdown();

        //dont run the rest of the code until all threads have finished
        while (!executor.isTerminated());

        //output the threadAccess (that was incremented)
        //should be 1000.... but doesnt (simple process, so can be done quickly), doesnt always give 100
        //next program shows sycronisation and how we can allow threads to wail till another thread has finished using variable
        System.out.println("100 threads incremented variable\nVariable value (should be 100): " + threadsAccess);
    }

    //inner class for incremeting variable
    //implements Runnable, so can be run as a thread
    private static class IncrementVariable implements Runnable {

        @Override
        public void run() {
            //ioncrement variable 10 times
            for (int i = 0; i < 10; i++) {
                threadsAccess = threadsAccess + 1;
                try {
                    //the thread sleeps for 5ms
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                }
            }
        }

    }

}
