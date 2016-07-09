/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_10;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Prithpal Sooriya
 */
public class ConsumerProducer {

    //inner class for the buffer
    private static class Buffer {

        //buffer variables
        private static final int CAPACITY = 1; //allows to have 2 items in buffer before == capacity
        private LinkedList<Integer> queue = new LinkedList<>();

        //create a Lock
        Lock lock = new ReentrantLock();

        //Create 2 Conditions for this one lock, notFull and notEmpty
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        //method write: write a value to the linked list
        public void write(int value) {
            lock.lock(); //acquire the lock, so no other threads/ methods can access
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println("Wait for notFull condition");
                    notFull.await();
                }
                //WHILE condition met (broken out of while loop) and notFull Condition signal sent
                queue.offer(value); //adds the integer to the tail of the queue/linked list
                notEmpty.signal(); //signal to read method (if called) for Condition notEmpty
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock(); //unlock so other threads can use
            }
        }

        //method read: reads and removed a value from the linked list/queue
        public int read() {
            int value = 0;
            lock.lock(); //acquire the lock
            try {
                while (queue.isEmpty()) {
                    System.out.println("\t\tWait for NotEmpty condition");
                    notEmpty.await();
                }
                //WHILE condition met and notEmpty signal sent, so we can carry on
                value = queue.remove(); //remove the integer from the tail and set it to the value variable
                notFull.signal(); //signal to other threads waiting for this condition (aka signal to other threads that this condidition has been met)
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock(); //unlock so other threads can use
                return value; //need to return the value for this method
            }

        }
    }

    //A local variable to be used
    //this variable is a Buffer, which holds, adds(produce) and removes(consumes) data inside it
    private static Buffer buffer = new Buffer();

    //main method to run code
    public static void main(String[] args) {
        //create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //execute the tasks/threads
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        //shutdown the executor, so no other tasks/threads can be added to the executor
        executor.shutdown();
    }

    //A task for adding an int to the buffer
    private static class ProducerTask implements Runnable {

        //override method from Runnable to make this a thread
        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes: " + i);
                    buffer.write(i++); //write i into buffer, and increment i afterwards
                    Thread.sleep((int) (Math.random() * 10000)); //send the thread to sleep for a random time
                }
            } catch (InterruptedException ex) {
            }
        }
    }
    
    //A  task for removing an integer from the buffer
    private static class ConsumerTask implements Runnable{

        //override method from Runnable to make this a thread
        @Override
        public void run() {
            try{
                while(true){
                    System.out.println("\t\tConsumer reads " + buffer.read());
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex){
            }
            
        }
        
    }
}
