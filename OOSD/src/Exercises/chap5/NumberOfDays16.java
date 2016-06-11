/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

/**
 *
 * @author ps2-sooriya
 */
public class NumberOfDays16 {
  public static void main(String[] args) {
    /*
    Number of days in a year:
    create a method called: int numberOfDaysInAYear(int year)
    write a program that displays the number of days in a year from 2000 to 2010
    */
    //integer to add the total days
    int totalDays = 0;
    //create a for loop to add all the days in the years
    for (int i = 2000; i < 2010; i++) {
      totalDays += numberOfDaysInAYear(i);
    }
    //print out the total number of days in a year
    System.out.format("Total number of days in a year from 2000 to 2010: %d\n", totalDays);
  }
  
  public static int numberOfDaysInAYear(int year){
    //first lets check if the year is a leap year (happens every 4 years)
    return ((year % 4) == 0) ? 366 : 365;
  }
}
