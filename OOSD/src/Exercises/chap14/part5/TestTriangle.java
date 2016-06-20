/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part5;

import Exercises.chap11.part1.*;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestTriangle {
    
    //main method to test the triangle
    public static void main(String[] args) {
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt user to enter the sides of the triangle
        System.out.println("Enter side1 of the triangle:");
        double side1 = scan.nextDouble();
        System.out.println("Enter side2 of the triangle:");
        double side2 = scan.nextDouble();
        System.out.println("Enter side3 of the triangle:");
        double side3 = scan.nextDouble();
        
        //create the triangle
        /* NEW CODE, ADD TRY CATCH BLOCK TO DEAL WITH IllegalTriangleException */
        try{
        Triangle triangle = new Triangle(side1, side2, side3);
        
        //prompt user to enter colour and filled or not
        System.out.println("Enter the colour of the triangle:");
        triangle.setColour(scan.next());
        System.out.println("Enter if the triangle is filled or not (True/false)");
        triangle.setFilled(scan.nextBoolean());
        
        //output area perimeter colour filled or not
        System.out.println("The triangle has an area of: " + triangle.getArea());
        System.out.println("The triangle has a perimeter of: " + triangle.getPerimeter());
        System.out.println("The triangle has a colour of: " + triangle.getColour());
        System.out.println("The triangle is " + (triangle.isFilled()? "filled" : "not filled"));
        }
        catch(IllegalTriangleException e){
            //output to the user that this is not a triangle
            System.out.println("This is not a triangle");
            System.out.println(side1 + " + " + side2 + " should be > than side 3 (which is " + side3 + ")");
        }
    }
    
}
