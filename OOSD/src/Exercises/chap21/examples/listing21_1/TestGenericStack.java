/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_1;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestGenericStack {
    
    //main method to run code
    public static void main(String[] args){
        
        //create a stack for strings and a stack for numbers
        GenericStack<String> words = new GenericStack<>();
        GenericStack<Integer> numbers = new GenericStack<>();
        
        //push words and numbers
        words.push("Hello");
        words.push("World");
        words.push("Java");
        words.push("is");
        words.push("Awesome");
        for (int i = 0; i < 10; i++) {
            numbers.push(i);
        }
        
        //print out the size
        System.out.println("Size of words stack: " + words.getSize());
        System.out.println("Size of numbers stack: " + numbers.getSize());
        
        //print and pop some of the stack numbers/words
        System.out.println("Words pop: " + words.pop());
        System.out.println("Words pop: " + words.pop());
        for (int i = 0; i < 10; i++) {
            System.out.println("Numbers pop: " + numbers.pop());
        }
        
        //print out new sizes
        System.out.println("Size of words stack: " + words.getSize());
        System.out.println("Size of numbers stack: " + numbers.getSize());
        
        //print out is empty
        System.out.println("Words stack empty: " + words.isEmpty());
        System.out.println("Numbers stack empty: " + numbers.isEmpty());
        
    }
    
}
