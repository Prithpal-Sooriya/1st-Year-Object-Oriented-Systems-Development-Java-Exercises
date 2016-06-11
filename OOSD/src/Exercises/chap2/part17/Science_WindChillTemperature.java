/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part17;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Science_WindChillTemperature {

    public static void main(String[] args) {
        /*(science: wind chill temp)
         how cold it is outside? temp, wind speed, humidity, sunshine, ect are factors
         formula for wind chill:
         Twc = 35.74 + 0.6215Ta - 35.75v^0.16 + 0.4275Ta v^0.16
         Ta = temp in fahrenheit; v = speed in mph; Twc = wind chill
        
         this cannot be used for wind speed < 2mph, or -58F< temp < 41F
         */

        //scanner for input
        Scanner scan = new Scanner(System.in);
        //variables to use
        double windSpeed = 0.0, fahrenheit = 0.0, windChill;
        boolean run = true;

        while (run == true) {
            //prompt user to input
            System.out.println("Enter the temperature in Fahrenheit (between -58 and 41):");
            fahrenheit = scan.nextDouble();
            if (fahrenheit < -58 || fahrenheit > 41) {
                System.out.println("Fahrenheit has to be between -58 and 41");
                //go back to start of while loop
                continue;
            }
            //exit loop
            run = false;
        }
        //turn run to true as we need to use it for next while loop
        run = true;
        while (run == true) {
            System.out.println("Enter the wind speed in miles per hour (cannot be lower than 2mph)");
            windSpeed = scan.nextDouble();
            if (windSpeed < 2) {
                System.out.println("wind speed must be greater or equal to 2");
                //go back to start of while loop
                continue;
            }
            //exit loop
            run = false;
        }
        
        //calculate wind chill using formula
        windChill = 35.74 + (0.6215 * fahrenheit) - (35.75 * Math.pow(windSpeed, 0.16)) + (0.4275 * fahrenheit * Math.pow(windSpeed, 0.16));
        //output
        System.out.println("The wind chill index is " + windChill);
    }
}
