/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part14;

/**
 *
 * @author Prithpal Sooriya
 */
public class Stopwatch {
    private long startTime = 0;
    private long endTime = 0;

    public Stopwatch() { //no args constructor
    }
    
    //getters
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    
    public void start(){
        startTime = System.currentTimeMillis();
        System.out.println(startTime);
    }
    
    public void stop(){
        endTime = System.currentTimeMillis();
        System.out.println(endTime);
    }
    
    public long getElapsedTime(){
        return endTime - startTime;
    }
    
    
    
}
