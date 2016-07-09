/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Prithpal Sooriya
 */
public class ThreadCooperationWithSemaphores {

    //inner class Account, that will be used by threads
    private static class Account {

        //Create a semaphore with only 1 permit
        private static Semaphore semaphore = new Semaphore(1);
        private int balance = 0; //what the threads will be trying to access

        //method to return balance
        public int getBalance() {
            return balance;
        }

        //method to diposit a certian amount
        public void diposit(int amount) {
            try {
                semaphore.acquire(); //acquire the permit to use resource
                int newBalance = balance + amount;

                //put the thread to sleep, Deliberate so we can see data corruption more easily
                //UPDATE, data corruption will not happen anymore due to the semaphore
                Thread.sleep(5);

                balance = newBalance;
                
                System.out.println("Diposit " + amount + "\t\t\t\t\t " + balance);
                
            } catch (InterruptedException ex) {
            } finally {
                //release the permit back to the semaphore
                semaphore.release();
            }
        }
    }
}
