/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
//class will be generic (like arraylist) -> thats what <E> means
public class GenericStack<E> {

    //private arraylist
    //cannot use "new E[]" so will work around by using "new Object"
    private E[] stack = (E[]) new Object[5];

    //private head, to show there the head of the items are
    private int head = 0;
//    
//    //no arg constuctor
//    public GenericStack(){
//    }

    //methods
    //get the size of the stack
    public int getSize() {
        return stack.length;
    }

    //push the element/particular object E into the stack
    public void push(E e) {
        //check size of stack
        if (head == stack.length) {
            //need to double the size of the current stack
            E[] tempStorage = (E[]) new Object[head * 2];
            //copy all the contents so far
            System.arraycopy(stack, 0, tempStorage, 0, head);
            //set tempstorage to be stack
            stack = (E[]) tempStorage;
        }
        //(now) sufficient size to add item, so add item then increment head
        stack[head] = e;
        head++;
    }

    //pop the element/particular object E off the stack
    public E pop() {
        //check if the stack is empty or not
        E returningItem = null;
        if (head != 0) {
            //head is not at 0 (empty so we can pop off an item)
            head--;
            returningItem = stack[head];
        }
        return returningItem; //will return null if the stack is empty
    }

    public boolean isEmpty() {
        return (head == 0);
    }

    //override method of toString
    @Override
    public String toString() {
        return "Stack: " + Arrays.toString(stack);
    }

}
