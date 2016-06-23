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
public class TestComparableCircle {
    
    //main method to run code
    public static void main(String[] args){
        
        //create 2 comparable circles
        ComparableCircle c1 = new ComparableCircle();
        ComparableCircle c2 = new ComparableCircle(5);
        
        //compare the area of the circles
        System.out.println("Which Circle is bigger (by area)?\n" + 
                "Circle 1: " + c1 + "\n" + 
                "Circle 2: " + c2);
        
        int largest = c1.compareTo(c2);
        if(largest > 0){
            System.out.println("Circle 1 is the largest area");
        }
        else if(largest < 0){
            System.out.println("Circle 2 is the largest area");
        }
        else{
            System.out.println("They both have the same area");
        }
    }
    
}
