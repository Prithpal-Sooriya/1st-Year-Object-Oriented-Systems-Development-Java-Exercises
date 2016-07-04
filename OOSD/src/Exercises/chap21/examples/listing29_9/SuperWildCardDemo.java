/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing29_9;

import Exercises.chap21.examples.listing21_1.GenericStack;
import static Exercises.chap21.examples.listing29_8.AnyWildCardDemo.print;

/**
 *
 * @author Prithpal Sooriya
 */
public class SuperWildCardDemo {

    //main method to run code
    public static void main(String[] args) {
        //create 2 stacks
        GenericStack<String> stringStack = new GenericStack<>();
        GenericStack<Object> objectStack = new GenericStack<>();

        //push items onto stacks
        objectStack.push("Java");
        objectStack.push(2);
        stringStack.push("Sun");

        //call add method--> add the contents of stringStack to ObjectStack; string stack is cleared
        add(stringStack, objectStack);
        
        //print stack
        print(objectStack);
    }

    //add method, contains <T> to indicate generic used
    /*
    logical process:
    1) program finds out what T is, so when param1 given, progam finds out T = String
    2) param2 --> GenericStack<? super String>
        --> valid input param is a class which is a super class to String
        --> valid input param is Object
    */
    public static <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2) {

        //add contents from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

    }

    //the add method can be replaced by:
    /*
    logical process:
    1) program finds out what T is, so when param1 given
        --> String --> ? extends T
        --> therefore String is ?/ wildcard
        --> T --> what does String extend?, String extends object
        --> T = Object
    */
    public static <T> void addVersion2(GenericStack<? extends T> stack1, GenericStack<T> stack2) {
        //add contents from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

}
