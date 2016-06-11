/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part5;

import java.util.GregorianCalendar;

/**
 *
 * @author Prithpal Sooriya
 */
public class GregorianCalendarTest {
    public static void main(String[] args) {
        GregorianCalendar gregCalendar = new GregorianCalendar();
        System.out.println("Current Day");
        System.out.println(
                "Year: " + gregCalendar.get(GregorianCalendar.YEAR) + " "
                + "Month: " + gregCalendar.get(GregorianCalendar.MONTH) + " "
                + "Day: " + gregCalendar.get(GregorianCalendar.DAY_OF_MONTH) + " "
        );
        gregCalendar.setTimeInMillis(1234567898765L);
        System.out.println("Old Date");
        System.out.println(
                "Year: " + gregCalendar.get(GregorianCalendar.YEAR) + " "
                + "Month: " + gregCalendar.get(GregorianCalendar.MONTH) + " "
                + "Day: " + gregCalendar.get(GregorianCalendar.DAY_OF_MONTH) + " "
        );
        
    }
}
