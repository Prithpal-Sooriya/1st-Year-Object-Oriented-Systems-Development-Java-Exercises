/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part5;

/**
 *
 * @author Prithpal Sooriya
 */
public class IntStack {
    
    int[] elements;
    private int size;
    private int tail = 0;
    
    public IntStack(int size){
        this.size = size;
        elements = new int[size];
//        for (int element : elements) {
//            element = 10;
//        }
    }
    
    public void push(int i){
        //check if the stack has reached its max size
        if(tail >= size){
            System.out.println("The stack has reached its size of " + size);
        }
        else{
            //we can add an item onto the stack
            //LIFO --> the item will be placed on top of the stack (buttom up stack)
            elements[tail] = i;
            //increment tail
            tail++;
        }
    }
    
    public int pop(){
        //check if the stack is empty or not
        int i = -1;
        if(tail <= 0){
            System.out.println("There are no Items on the stack to pop");
        }
        else{
            //decrement tail
            tail--;  
            //retrive this integer from the stack
            i = elements[tail];
        }
        return i;
    }

    public int getTail() {
        return tail;
    }
    
    
    
}
