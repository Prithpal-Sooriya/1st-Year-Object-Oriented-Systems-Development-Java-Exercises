/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part9;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class CalculateSimpleInterest {
    public static void main(String[] args) {
        /*calculate simple interest
        simpleInterest = (principalAmount * rate * time)/100
        */
        //vars to use
        double principleAmount, rateOfInterest, timeDuration;
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //output and input for the user
        System.out.println("Enter the Principle Amount:");
        principleAmount = scan.nextDouble();
        System.out.println("Enter the Rate of Interest:");
        rateOfInterest = scan.nextDouble();
        System.out.println("Enter the Time Duration:");
        timeDuration = scan.nextDouble();
        
        //calculate
        double simpleInterest = (principleAmount * rateOfInterest * timeDuration)/ 100;
        System.out.println("For Principle Amount:" + principleAmount + " with Rate of Interest:" + rateOfInterest + " and Time Duration:" + timeDuration);
        System.out.println("The Simple Interest is:" + simpleInterest);
    }
}
