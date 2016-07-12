/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.part1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prithpal Sooriya
 */
public class ReviseTaskThreadDemo {

    //main method to run code
    public static void main(String[] args) {
        //print 1ab first
        System.out.print("1ab");
        
        //create the threads
        Thread thread1 = new Thread(new PrintChar('a', 99));
        Thread thread2 = new Thread(new PrintChar('b', 99));
        Thread thread3 = new Thread(new PrintNum(2, 100));
        
        //run thread3, ints 2 to 100
        thread3.start();
        try{
        thread3.join(); //wait till this thread is done
        } catch (InterruptedException ex){
            System.out.println("Thread3 failed to join, Interrupted Exception");
        }
        //run thread2
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread2 failed to join, Interrupted Exception");
        }
        //run thread1
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread1 failed to join, Interrupted Exception");
        }
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
    private int startingValue;
    //constuctor to specify last num
    public PrintNum(int lastNum) {
        this(1, lastNum);
    }

    //constructor to specify starting value and last number
    public PrintNum(int startingValue, int lastNum){
        this.startingValue = startingValue;
        this.lastNum = lastNum;
    }
    //override method to run code through thread
    //this will be called then you call "thread.start"
    @Override
    public void run() {
        //for loop to run integers from 1 to lastNum
        for (int i = startingValue; i <= lastNum + startingValue; i++) {
            //print out the number
            System.out.print(" " + i);
        }
    }
}
