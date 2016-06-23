/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part8;


/**
 *
 * @author Prithpal Sooriya
 */
public class Circle extends GeometricObject{

    double radius;
    
    //constructors
    public Circle(){
        this(1);
    }
    
    public Circle(int radius){
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        //area = PI * rad * rad
        return (Math.PI * radius * radius);
    }

    @Override
    public double getPerimeter() {
        //perimeter = 2 * PI * rad
        return (2 * Math.PI * radius);
    }
    
    //getters

    public double getRadius() {
        return radius;
    }
    
    //toString method

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }
    
    
}
