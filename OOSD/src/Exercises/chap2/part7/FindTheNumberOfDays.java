/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part7;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class FindTheNumberOfDays {
    public static void main(String[] args) {
        //change seconds to number of days and minutes
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //ouput to user to enter seconds
        System.out.println("Enter the number of seconds");
        int seconds = scan.nextInt();
        //minutes = # of second/ 60
        int minutes = seconds / 60;
        System.out.println(minutes);
        //hours = minutes / 60 --> days = hours /60 
        int days = (minutes/60)/24;
        minutes = minutes%60;
        System.out.println(seconds + " seconds is approximately " + days + " days and " + minutes + "minutes");
    }
}
