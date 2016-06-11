/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part14;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class HealthApplication_ComputingBMI {

    public static void main(String[] args) {
        /*(health application: computing BMI)
         BMI is a measure on health on weight
         it is calculated by: taking weight(kg) and dividing by the square of your hieght(m)
         write a program that prompts the user to enter weight in pounds and height in inches and display BMI
         1 pound = 0.45359237 kg; 1 inch = 0.254 m
         */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //variables to use
        double weight, height;
        
        //output to user to promt input
        System.out.println("Enter weight in pounds:");
        weight = scan.nextDouble();
        System.out.println("Enter height in inches:");
        height = scan.nextDouble();
        
        //calculate the weight and height in metric
        weight *= 0.45359237;
        height *= 0.254;
        double bmi = (weight / Math.pow(height, 2)) * 100;
        //ouput BMI
        System.out.println("BMI is " + bmi);
    }
}
