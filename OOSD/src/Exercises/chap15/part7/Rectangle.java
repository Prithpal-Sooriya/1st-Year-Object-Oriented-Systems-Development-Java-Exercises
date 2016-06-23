/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part7;

/**
 *
 * @author Prithpal Sooriya
 */
public class Rectangle extends GeometricObject{
    
    double height, width;

    //constuctors
    public Rectangle(){
        this(1,1);
    }
    
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }
    @Override
    public double getArea() {
        //area = height * width
        return (height * width);
    }

    @Override
    public double getPerimeter() {
        //perimeter = 2height + 2 width
        double twiceHeight = 2 * height;
        double twiceWidth = 2 * width;
        return (twiceHeight + twiceWidth);
    }
    
    //getters
    public double getHeight(){
        return height;
    }
    
    public double getWidth(){
        return width;
    }
    
    //toString method

    @Override
    public String toString() {
        return "Rectangle{" + "height=" + height + ", width=" + width + '}';
    }
    
}
