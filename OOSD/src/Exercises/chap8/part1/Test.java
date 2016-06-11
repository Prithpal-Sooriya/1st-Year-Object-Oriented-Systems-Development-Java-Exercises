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
public class Test {
    
    //give some test data to test the Rectangle class
    public static void main(String[] args) {
        
        //create the 2 rectangles
        Rectangle rects[] = new Rectangle[2];
        rects[0] = new Rectangle(4, 40);
        rects[1] = new Rectangle(3.5, 35.9);
        
        //display the rectangle values
        for (Rectangle rect : rects) {
            System.out.println(
                    "Width: " + rect.getWidth() + ", "
                    + "Height: " + rect.getHeight() + ", "
                    + "Area: " + rect.getArea() + ", "
                    + "Perimeter: " + rect.getPerimeter()
            );
        }
        
    }
}
