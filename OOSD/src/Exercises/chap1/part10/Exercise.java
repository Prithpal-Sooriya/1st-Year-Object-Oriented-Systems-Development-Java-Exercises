/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exercises.chap1.part10;

/**
 *
 * @author Prithpal
 */
public class Exercise {
    public static void main(String[] args){
        //average speed in miles per hour with distance = 14km and time = 45min and 30sec
        double miles = 14/1.6; //this is because every mile is 1.6km
        double hours = 45.5/60; //this is because it was 45min and 30sec
        double averageSpeed = miles/ hours; //average speed = distance/ time
        System.out.println("The average speed is " + averageSpeed + " miles per hour");
    }
}
