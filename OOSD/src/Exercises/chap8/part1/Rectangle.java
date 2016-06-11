/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part1;

/**
 *
 * @author Prithpal Sooriya
 */

public class Rectangle {
    
    private double width = 1;
    private double height = 1;

    
    //no args constuctor
    public Rectangle() {
    }
    
    //set width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //returns the area
    public double getArea(){
        return width * height;
    }
    
    //returns the area
    public double getPerimeter(){
        double total;
        total = (2 * width) + (2 * height);
        return total;
    }
    
    //setters and getters for width and height
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    
    
}
