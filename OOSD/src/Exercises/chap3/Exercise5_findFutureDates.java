/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap3;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise5_findFutureDates {

    public static void main(String[] args) {
        /*
         find future dates:
         input int for todays day (0 = sunday, 1 = monday.....)
         input number of days after today
         display day of the future day
         */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //String array to hold the days
        String[] strDays = new String[] {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };

        //enter current day and days till future day
        System.out.println("Enter today's day:");
        int currentDay = scan.nextInt();
        System.out.println("Enter the number of days elapsed since today:");
        int daysElapsed = scan.nextInt();

        //calculate that day
        int futureDay = (currentDay + daysElapsed) % 7;

        //display day
        System.out.println("Today is " + strDays[currentDay] + "and the furure day is " + strDays[futureDay]);
    }
}
