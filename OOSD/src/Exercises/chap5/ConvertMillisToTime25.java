/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */

/*
convert milliseconds to hours:mins:seconds format
use method with header String convertMillis(long millis)
e.g. 5500 millis returns String 0:0:5
     1000000 millis returns String 0:1:40
 */
public class ConvertMillisToTime25 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //tell user to enter a Long, (used to millis)
    System.out.println("Enter milliseconds");
    //number has to be positive
    long x = Math.abs(scan.nextLong());

    //return the time format for the millis
    System.out.println(x + " = " + convertMillis(x));
  }

  //works now;
  public static String convertMillis(long millis) {
    //initialise the value for hours
    //as once all the calc's are done, the leftover will be the largest value (hours)
    int hours = 0;
    
    //conversion of the starting number into seconds
    hours = (int) (millis / 1000);
    int seconds = hours % 60;
    //conversion of the leftovers into minutes
    hours = hours / 60;
    int minutes = hours % 60;
    //conversion of the leftovers into hours
    hours = hours / 60;

    String s = hours + ":" + minutes + ":" + seconds;
    return s;
  }
}
