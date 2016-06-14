/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part11;

/**
 *
 * @author Prithpal Sooriya
 */
public class Circle2D {
    
    //data fields
    double x, y;
    double radius;
    
    //constuctor
    public Circle2D(){ //no arg constuctor
        this(0, 0, 1); //create default circle at origin point and radius 1
    }
    
    //constuctor that contains x, y and radius params
    public Circle2D(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    //get methods
    public double getX() {
        return x;
    }
    
    public double getY() {    
        return y;
    }

    public double getRadius() {
        return radius;
    }
    
    //other methods
    
    //method getArea()
    public double getArea(){
        return radius*radius*Math.PI;
    }
    
    //method getPerimeter
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    
    //method contains(x, y)
    public boolean contains(double x, double y){
        /*
        to check if the point is inside the circle it must satisfy:
        (x - x1)^2 + (y - y1)^2 < radius^2
        where x and y is the coord for the point given
        and x2 and y2 are the center point for the circle
        */
        
        double diffX = Math.pow((x - this.x), 2);
        double diffY = Math.pow((y - this.y), 2);
        
        return ((diffX + diffY) < Math.pow(radius, 2));
    }
    
    public boolean contains(Circle2D c){
        /*
        A circle can only be inside another circle if:
        -->radius if the circle is smaller than the main circle
        -->the difference between the radii > distance between the 2 centerpoints
        
        diffRadi > distance --> circle inside
        diffRadi < distance --> intersection
        */
        
        //difference between the radii
        double diffRadi = Math.abs(radius - c.getRadius());
        //distance between the centers --> pythagorus
        double x2 = Math.pow((x - c.getX()), 2);
        double y2 = Math.pow((y - c.getY()), 2);
        double distance = Math.sqrt((x2 + y2));
        
        //check if the circle is inside the main circle or not
        return (diffRadi >= distance);
    }
    
    //method overlaps(Circle2D)
    public boolean overlaps(Circle2D c){
        
        /*for the circle to overlap:
            diffRadi < distance
        */
        
        //difference between the radii
        double diffRadi = Math.abs(radius - c.getRadius());
        //distance between the centers --> pythagorus
        double x2 = Math.pow((x - c.getX()), 2);
        double y2 = Math.pow((y - c.getY()), 2);
        double distance = Math.sqrt((x2 + y2));
        
        //check if the circle is inside the main circle or not
        return (diffRadi < distance);
    }
    
    
    //toString method to display contents

    @Override
    public String toString() {
        return "Circle2D{" + "x=" + x + ", y=" + y + ", radius=" + radius + '}';
    }
    
    
}
