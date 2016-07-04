/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_1;

import java.util.ArrayList;

/**
 *
 * @author Prithpal Sooriya
 */

//class will be generic (like arraylist) -> thats what <E> means
public class GenericStack <E>{
    
    //private arraylist
    private ArrayList<E> stack = new ArrayList<>();
    
    //methods
    //get the size of the stack
    public int getSize(){
        return stack.size();
    }
    
    //push the element/particular object E into the stack
    public void push(E e){
        stack.add(e);
    }
    
    //pop the element/particular object E off the stack
    public E pop(){
        E returningItem = stack.get(stack.size() - 1);
        //remove the item and return the ite
        stack.remove(stack.size() - 1);
        return returningItem;
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    //override method of toString
    @Override
    public String toString() {
        return "Stack: " + stack.toString();
    }
    
    
}
