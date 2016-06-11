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
public class Exercise21_dayOfTheWeek {
    public static void main(String[] args) {
        /*
        Science: day of the week
        h = (q + (26 * (m+1) / 10) + k +(k/4) + (j/4) + 5j) % 7
        h = day of week (0 = sunday .... 7 = saturday)
        q = day of month
        m = month (3 = march .... 12 = dec, jan = 13, feb = 14)
        j = century (year / 100)
        k = year of century (year % 100)
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //String array for days of month
        String day[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        //prompt for correct input
        System.out.println("Enter year: (e.g. 2015):");
        int year = scan.nextInt();
        System.out.println("Enter month: 1-12:");
        int month = scan.nextInt();
        System.out.println("Enter the day of the month: 1-31:");
        int dayOfMonth = scan.nextInt();
        
        //if statement to convert the jan and feb month
        if(month == 1){
            month = 13;
            year--;
        }
        else if(month == 2){
            month = 14;
            year--;
        }
        
        //calculate century and year of century
        int century = year / 100;
        int yearOfCentury = year % 100;
        
        //calculate using formula
        int numberForDay = (dayOfMonth + ((26 * (month + 1))/10) + yearOfCentury + (yearOfCentury / 4) + (century / 4) + (century * 5)) % 7;
        
        //print out day of week
        System.out.println("Day of the week is " + day[numberForDay]);
    }
}
