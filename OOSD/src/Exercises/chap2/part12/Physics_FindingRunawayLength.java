/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part12;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class Physics_FindingRunawayLength {
    public static void main(String[] args) {
        /*(physics) find runway length
        aeroplane acceleration 'a' and take-off speed 'v', you can calculate minimum runway needed
        length = (v^2)/2a
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //output to user for the input
        System.out.println("Enter speed(m/s) and acceleration(m/s^2):");
        //inputs
        double speed = scan.nextDouble();
        double acceleration = scan.nextDouble();
        //calculate
        double length = (Math.pow(speed, 2))/(2 * acceleration);
        
        //output
        System.out.println("The minimum runway length for this aeroplane is " + length);
    }
}
