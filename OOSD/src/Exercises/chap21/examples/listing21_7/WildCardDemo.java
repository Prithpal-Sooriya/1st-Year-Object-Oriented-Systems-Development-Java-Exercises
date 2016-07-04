/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_7;

import Exercises.chap21.examples.listing21_1.GenericStack;

/**
 *
 * @author Prithpal Sooriya
 */
public class WildCardDemo {

    //main method to run code
    public static void main(String args[]) {

        //create the generic stack, from listing21_1
        GenericStack<Integer> integerStack = new GenericStack<>();
        //push numbers
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(-2);

        //print out the max number in the stack, using max method
        System.out.println("The max number in the stack is: " + max(integerStack));
    }

    public static double max(GenericStack<? extends Number> stack) {
        //store the "max" value (will change if it is not the max value
        double max = stack.pop().doubleValue();

        //loop through all the items in the stack to find values larger than max
        while (!stack.isEmpty()) {
            double value = stack.pop().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        
        //return the max value
        return max;
    }

}
