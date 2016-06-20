/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part5;

/**
 *
 * @author Prithpal Sooriya
 */
public class IllegalTriangleException extends Exception{
    
    //constructor (of what is show through creating this exception
    public IllegalTriangleException(){
        super("Invalid triangle"); //override the constuctor from the Exception class
        //this will output the incorrect triangle
    }
    
}
