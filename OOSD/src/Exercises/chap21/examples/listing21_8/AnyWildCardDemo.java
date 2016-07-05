/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_8;

import Exercises.chap21.examples.listing21_1.GenericStack;

/**
 *
 * @author Prithpal Sooriya
 */
public class AnyWildCardDemo {
    
    //main method to run code
    public static void main(String[] args){
        
        //create a generic stack of integers and push numbers
        GenericStack<Integer> integerStack = new GenericStack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        
        //call the print method
    }
    
    //print method
    //will take in any GenericStack parameter: Integer, Double, Boolean, Object ect
    public static void print(GenericStack<?> stack){
        while(!stack.isEmpty()){
            System.out.println("" + stack.pop());
        }
    }
    
    //print method
    //this method will NOT take in any GenericStack parameter
    //it can only take in GenericStack<Object>
    /*
    Calling this method in main would work like this
    
    GenericStack<Object> stack = new GenericStack<Object>();
    stack.add(new Integer(...));
    stack.add(new String(...));
    stack.add(new Double(...));
    stack.add(new Object(...));
    System.out.println(printInvalid(stack));
    */
    public static void printInvalid(GenericStack<Object> stack){
        
    }
    
}
