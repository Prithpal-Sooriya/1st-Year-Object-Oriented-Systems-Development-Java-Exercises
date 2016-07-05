/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part2;

import java.util.ArrayList;

/**
 *
 * @author Prithpal Sooriya
 */

//This GenericStack will inherit ArrayList
//since it extends ArrayList, we can call the methods directly without creating an ArrayList class
public class GenericStackInheritArrayList <E> extends ArrayList<E>{
    
    
    //methods
    //get the size of the stack
    public int getSize(){
        return size();
    }
    
    //push the element/particular object E into the stack
    public void push(E e){
        add(e);
    }
    
    //pop the element/particular object E off the stack
    public E pop(){
        E returningItem = get(size() - 1);
        //remove the item and return the ite
        remove(size() - 1);
        return returningItem;
    }
    
}
