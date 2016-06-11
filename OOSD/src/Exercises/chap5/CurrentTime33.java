/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

import java.util.Calendar;

/**
 *
 * @author Prithpal
 */

/*
use the System.currentTimeMillis() since Jan 1, 1970 to calculate:
current date and time
*/
public class CurrentTime33 {
  public static void main(String[] args) {
    /*
    Honestly, the calculations needed are very complex
    so why can't i just reuse code that are already in the java library
    */
    
    //array for month
    String month[] =
    {"January", "February", "March", "April"
            , "May", "June", "July", "August"
            , "September", "October", "November", "December"};
    
    //get save the instant of time into a variable
    long miilis = System.currentTimeMillis();
    //create a calander object with current time
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(miilis);
    
    //create and initialise year, month, ect...
    int year = calendar.get(Calendar.YEAR);
    String thisMonth = month[calendar.get(Calendar.MONTH)]; //starts at 0 ends at 11
    int day = calendar.get(Calendar.DATE);
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    
    //output
    System.out.format("Current date and time is %d:%d:%d on %d of %s %d\n",
            hour, minute, second,
            day, thisMonth, year);
  }
}
