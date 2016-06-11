/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part15;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Geometry_AreaOfTriangle {
    public static void main(String[] args) {
        /*Geometry: area of a triangle
        prompt the user to enter 3 points (x1, y1), (x2, y2), (x3, y3)
        formula:
        s = (side1 + side 2 + side3)/2
        area = sqrt(s(s-side1)(s-side2)(s-side3))
        THIS IS KNOWN AS HERON'S FORMULA, READ UP IF YOU FORGET
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //variables we will use
            //x values
        double x1, x2, x3;
            //y values
        double y1, y2, y3;
            //sides
        double side1, side2, side3;
            //sides of the triangle
        System.out.println("Enter three points for a triangle (in format: x y x y x y)");
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();
        x3 = scan.nextDouble();
        y3 = scan.nextDouble();
        
        //calculate the 3 sides
        side1 = calculateSides(x1, y1, x2, y2);
        side2 = calculateSides(x1, y1, x3, y3);
        side3 = calculateSides(x2, y2, x3, y3);
        
        //use Heron's formula
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        
        //output area
        System.out.println("The area of the triangle is " + area);
    }
    //subrouting to calculate sides
    private static double calculateSides(double x1, double y1, double x2, double y2){
        //to calculate the sides we need to use pythagorian theorem --> a^2 = b^2 + c^2
        double b = (x1 - x2);
        double c = (y1 - y2);
        //pythag
        double a = Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2));
        return a;
    }
}
