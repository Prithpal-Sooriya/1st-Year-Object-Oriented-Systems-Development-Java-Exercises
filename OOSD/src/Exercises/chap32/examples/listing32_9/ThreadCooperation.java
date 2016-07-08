/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Prithpal Sooriya
 */
public class ThreadCooperation {

    //integer to be used for addition thread and minus thread
    private static int number = 0;
    //lock to be used
    private static Lock lock = new ReentrantLock();
    //condition on lock
    private static Condition condition = lock.newCondition();
    
    //main method to run code
    public static void main(String[] args) {

        //create a thread pool to hold 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Thread add\t\tThread Minus\t\tNumber");
        
        //execute the threads
        executor.execute(new AdditionThread());
        executor.execute(new SubtractionThread());
        //shutdown the executor, so no other threads can be executed on it
        executor.shutdown();
        
        
    }

    //methods to use
    private static void add(int amount){
        //acquire the lock
        lock.lock();
        try{
            number += amount;
            System.out.println("Add amount " + amount + "\t\t\t\t\t" + number);
            
            //signal thread waiting on the condition
            condition.signalAll();
        } finally {
            //unlock the thread
            lock.unlock();
        }
    }
    
    private static void subtract(int amount){
        //acquire the lock
        lock.lock();
        try{
            //if the number is less than the amount (go to minus number), wait for addition (like listener)
            while(number < amount){
                System.out.println("\t\tSubtract amount: cannot subtract");
                condition.await(); //wait for another thread (addition thread) to use number
            }
            
            //loop has ended (aka, the await signal has ended) so lets subtract
            number -= amount;
            System.out.println("\t\tSubtract amount " + amount + "\t\t" + number);
        } catch(InterruptedException ex){
        } finally {
            //unlock the lock, so can be used by another awaiting thread
            lock.unlock();
        }
    }
    
    //inner class
    //class to implement Runnable to create addition thread
    private static class AdditionThread implements Runnable {

        @Override
        public void run() {
            try{ //purposely delay this thread so withdraw thread will proceed first (to indicate the wait command
                while(true){
                    add((int)(Math.random() * 10) + 1); //add a random number from 1 to 10 to the number
                    Thread.sleep(1000); //make the thread sleep for 1 second
                }
            }
            catch(InterruptedException ex){
            }
        }
    }
    
    //inner class
    //class to implement Runnable to create a subtraction thread
    private static class SubtractionThread implements Runnable{

        @Override
        public void run() {
            while(true){
                subtract((int) (Math.random() * 10) + 1);
            }
        }
        
    }
}
