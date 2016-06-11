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
public class Exercise6_healthApplicationBMI {
    public static void main(String[] args) {
        /*
        health applcation: BMI
        enter weight in pounds and height in feet and inches
        calc BMI an if normal
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //conversions
        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;
        //enter weight in pounds
        System.out.println("Enter weight in pounds:");
        double weight = scan.nextDouble();
        
        //enter height in feet
        System.out.println("Enter height in feet");
        double feet = scan.nextDouble();
        
        //enter height in inches
        System.out.println("Enter height in inches");
        double inches = scan.nextDouble();
        
        //calculate all height in inches
        inches += (feet * 12);
        
        //compute BMI
        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = inches * METERS_PER_INCH;
        double bmi = weightInKilograms / (heightInMeters * heightInMeters);
        
        //display result
        System.out.println("BMI is " + bmi);
        if(bmi < 18.5){
            System.out.println("Underweight");
        }
        else if(bmi < 25){
            System.out.println("Normal");
        }
        else if(bmi < 30){
            System.out.println("Overweight");
        }
        else{
            System.out.println("Obese");
        }
    }
}
