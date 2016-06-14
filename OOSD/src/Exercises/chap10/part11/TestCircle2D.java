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
public class TestCircle2D {
    
    //test the Circle2D class
    public static void main(String[] args) {
        
        Circle2D c = new Circle2D(2, 2, 5.5);
        System.out.println("X: " + c.getX() + "; Y: " + c.getY());
        System.out.println("Radius: " + c.getRadius());
        System.out.println("Area: " + c.getArea());
        System.out.println("Perimeter: " + c.getPerimeter());
        System.out.println("Does this circle contain point (3,3)? " + c.contains(3, 3));
        
        Circle2D d = new Circle2D(4, 5, 10.5);
        System.out.println("Does the circle contain " + d.toString() + "? " + c.contains(d));
        
        d = new Circle2D(3, 5, 2.3);
        System.out.println("Does the circle overlap " + d.toString() + "? " + c.overlaps(d));
        
    }
    
}
