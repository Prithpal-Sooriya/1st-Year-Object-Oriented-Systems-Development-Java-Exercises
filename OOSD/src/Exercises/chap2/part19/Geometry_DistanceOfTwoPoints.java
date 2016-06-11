/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part19;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Geometry_DistanceOfTwoPoints {
    public static void main(String[] args) {
        /*(geometry: distance of 2 points)
        user enters 2 points (x1, y1), (x2, y2)
        and calculate distance using pythagorus theorem
        */
        
        //scanner for input
        Scanner scan =  new Scanner(System.in);
        //variables to use
        double x1, y1, x2, y2;
        //prompt for input
        System.out.println("Enter x1 and y1:");
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();
        System.out.println("Enter x2 and y2:");
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();
        
        //calculate
        double distance = Math.sqrt((Math.pow((x1 - x2), 2) + (Math.pow(y1 - y2, 2))));
        //output
        System.out.println("The distance between the two points is " + distance);
    }
}
