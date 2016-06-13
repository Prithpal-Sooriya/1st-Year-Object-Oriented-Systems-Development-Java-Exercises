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
public final class Time {

    private long hours, minutes, seconds;

    /*create the constructors*/
    //no arg constuctor
    public Time() {
        //sets current time in time format
        //pass to the other time constructor
        this(System.currentTimeMillis());

    }

    //produces current time in millisecond format
    public Time(String millis) {
        if(millis.equalsIgnoreCase("millis"))
        hours = minutes = seconds = System.currentTimeMillis();
    }

    //produces time in time format from millisecond input
    public Time(long millis) {

        //pass to setTime method
        setTime(millis);

    }
    
    //getters only

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }
    
    //method to set time of millisecond given
    public void setTime(long millis){
        //initialise seconds
        seconds = (millis / 1000) % 60; //1000 milliseconds in a second --> and need in format of 1-60 seconds
        //initialise minutes
        minutes = (millis / (1000 * 60)) % 60; //1000 milliseconds in a second, 60 seconds in a minute --> and need in format of 1-60 minutes
        //initialise hours
        hours = (millis / (1000 * 60 * 60)) % 24; //1000 milliseconds in a seconds, 60 seconds in a minute, 60 minutes in an hour --> and need in format of 1-24 hours
    }
    
}
