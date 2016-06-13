/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part1;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestTime {
    
    //test the time class
    public static void main(String[] args) {
        //1st time object
        Time time1 = new Time();
        
        //2nd time
        Time time2 = new Time(555550000);
        
        //check the data fields given, time1 = current time, time2 = 10:19:10
        System.out.println("Time 1 (current time)");
        System.out.println("Hours: " + time1.getHours());
        System.out.println("Minutes: " + time1.getMinutes());
        System.out.println("Seconds: " + time1.getSeconds());
        System.out.println("Time 2 (10:19:10)");
        System.out.println("Hours: " + time2.getHours());
        System.out.println("Minutes: " + time2.getMinutes());
        System.out.println("Seconds: " + time2.getSeconds());
    }
    
}
