/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Prithpal Sooriya
 */
public class ExecuterDemo {

    //main method to run code
    public static void main(String[] args) {

        //create a fixed thread pool, with max of 3 threads
        /*
        3 threads in threadpool, so those 3 threads are executed concurrently
        if there was 1 thread in thread pool, and trying to execute 3 threads.... They will run one after the other!!!
        -->the other threads have to wait till using threads are executed (simmilar to mutex lock())*/
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        /*If you use catchedThreadPool, then the 3 threads will be added to thread pool and executed concurrently*/
        //ExecutorService executor = Executors.newCachedThreadPool();
        
        //submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));

        //shut down the executor (as we dont need it anymore)
        executor.shutdown();

    }

}

//the Task for printing a character a specified number of times
//implement runnable to run code as thread
class PrintChar implements Runnable {

    //variables to be using
    private char charToPrint; //the character to print
    private int times; //the amound of times to repeat

    //constructors
    //construct a task with specified character and the number of times to print the character
    public PrintChar(char charToPrint, int times) {
        this.charToPrint = charToPrint;
        this.times = times;
    }

    //override method from runnable
    //this will be called when you call "thread.start"
    @Override
    public void run() {
        //implement the code we want to run
        //print the character the amount of times specified
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

//the Task for printing numbers from 1 to n (inclusive) for a given n
//implements runnable to run code as thread
class PrintNum implements Runnable {

    //variables to be using
    private int lastNum;

    //constuctor to specify last num
    public PrintNum(int lastNum) {
        this.lastNum = lastNum;
    }

    //override method to run code through thread
    //this will be called then you call "thread.start"
    @Override
    public void run() {
        //for loop to run integers from 1 to lastNum
        for (int i = 1; i <= lastNum; i++) {
            //print out the number
            System.out.print(" " + i);
        }
    }

}
