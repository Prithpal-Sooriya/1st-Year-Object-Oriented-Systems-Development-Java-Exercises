/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_1;

/**
 *
 * @author Prithpal Sooriya
 */
public class TaskThreadDemo {
    
    //main method to run code
    public static void main(String[] args){
        //create 3 Runnables (will be used for threads)
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);
        
        //create threads
        Thread thread1 = new Thread(printA); //new Thread(Runnable class)
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        
        //start thread
        //thread will start and will continue till the run() method is finished
        thread1.start();
        thread2.start();
        thread3.start();
        
    }
    
}

//the Task for printing a character a specified number of times
//implement runnable to run code as thread
class PrintChar implements Runnable{
    
    //variables to be using
    private char charToPrint; //the character to print
    private int times; //the amound of times to repeat
    
    //constructors
    
    //construct a task with specified character and the number of times to print the character
    public PrintChar(char charToPrint, int times){
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
class PrintNum implements Runnable{

    //variables to be using
    private int lastNum;
    
    //constuctor to specify last num
    public PrintNum(int lastNum){
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