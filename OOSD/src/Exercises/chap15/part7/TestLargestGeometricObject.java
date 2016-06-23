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
public class TestLargestGeometricObject {
    
    //main method to run code
    public static void main(String[] args){
        
        //create 2 circles
        GeometricObject circle1 = new Circle(); //rad 1
        GeometricObject circle2 = new Circle(5); //rad 5
        
        //create 2 rectangles
        GeometricObject rect1 = new Rectangle(); //height = 1, width = 1
        GeometricObject rect2 = new Rectangle(5, 5); //height = 5, width = 5
        
        //the 2 contestants
        GeometricObject finallyCircle;
        GeometricObject finallyRectangle;
        
        //compare the 2 circles
        System.out.println("Which circles are bigger, circle 1 or circle 2");
        int largest = GeometricObject.max(circle1, circle2);
        if(largest > 0){
            System.out.println("Circle 1 has larger area");
            finallyCircle = circle1;
        }
        else if(largest < 0){
            System.out.println("Circle 2 has larger area");
            finallyCircle = circle2;
        }
        else{
            System.out.println("Both Circles have same area size");
            finallyCircle = circle1;
        }
        
        System.out.println("Which rectangles are bigger, rect 1 or rect 2");
        largest = GeometricObject.max(rect1, rect2);
        if(largest > 0){
            System.out.println("Rect 1 has larger area");
            finallyRectangle = rect1;
        }
        else if(largest < 0){
            System.out.println("Rect 2 has larger area");
            finallyRectangle = rect2;
        }
        else{
            System.out.println("They both have the same area size");
            finallyRectangle = rect1;
        }
        
        //now which is larger the circle or the square
        System.out.println("Which is larger, the circle: " + finallyCircle + 
                ", or the rectangle: " + finallyRectangle);
        largest = GeometricObject.max(finallyCircle, finallyRectangle);
        if(largest > 0){
            System.out.println("Circle has the largest area");
        }
        else if(largest < 0){
            System.out.println("Rectangle has the largest area");
        }
        else{
            System.out.println("Both the Circle and Rectangle have the same area size");
        }
    }
    
}
