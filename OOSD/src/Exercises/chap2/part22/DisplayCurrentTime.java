/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part22;

/**
 *
 * @author Prithpal
 */
public class DisplayCurrentTime {
    public static void main(String[] args){
        /*(display current time)
        in format hr:min:sec using System.CurrentTimeMillis() method
        */
        
        //save all miliseconds into a long (default time)
        long totalMilliSeconds = System.currentTimeMillis();
        
        //convert milli to second --> 1 sec = 1000 milli (or 1/1000 sec = 1 milli)
        long totalSeconds = totalMilliSeconds / 1000;
        //get current second  --> 60 seconds in a min
        long currentSeconds = totalSeconds % 60;
        //convert all the seconds to minutes
        long totalMinutes = totalSeconds / 60;
        //get current minute --> 60 min = 1 hr
        long currentMinutes = totalMinutes % 60;
        //convert all the mins to hr --> 60 min = 1 hr
        long totalHours = totalMinutes / 60;
        //get current hour --> 24 hrs = 1 day
        long currentHours = totalHours %24;
        
        //output current time
        System.out.println(currentHours + ":" + currentMinutes + ":" + currentSeconds);
    }
}
