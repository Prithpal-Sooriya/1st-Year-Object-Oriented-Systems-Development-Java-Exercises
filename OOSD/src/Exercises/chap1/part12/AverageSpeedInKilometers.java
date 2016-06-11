/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercises.chap1.part12;

/**
 *
 * @author Prithpal
 */
public class AverageSpeedInKilometers {
    public static void main(String[] args){
        //average speed in kilometers when distance = 24 miles and time = 1hr, 40min, 35sec --> in km/hr
        double distance = 1.6 * 24; //this is because there is 1.6km for every mile
        double time = (60 + (40/60) + (35/3600))/60; //the time taken in minutes is 60 + 40/60 + 35/3600 --> thus in hours will be ans/60
        
        //average speed = distance/ time
        double averageSpeed = distance / time;
        System.out.println("The average speed is: " + averageSpeed + " Kilometers per hour");
    }
}
