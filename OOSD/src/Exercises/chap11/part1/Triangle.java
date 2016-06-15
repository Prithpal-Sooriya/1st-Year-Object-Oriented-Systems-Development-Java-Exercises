/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part1;

/**
 *
 * @author Prithpal Sooriya
 */
public class Triangle extends GeometricObject{
    
    private double side1;
    private double side2;
    private double side3;
    
    //no arg constuctor
    public Triangle(){
        this(1,1,1);
    }
    
    //constructor for the 3 sides
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    //getters for the sides
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
    
    //getArea
    public double getArea(){
        /*
        get the area of an irregular triangle
        -->we know the triangles 3 sides
            --> use heron's formula
        --> s = (a + b + c)/ 2 where a, b, c are the sides
        --> Area = sqrt(s*(s-a)*(s-b)*(s-c))
        */
        
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        return area;
    }
    
    //get perimeter
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    
    //toString method

    @Override
    public String toString() {
        return "Triangle:" + " side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }
    
    
}
