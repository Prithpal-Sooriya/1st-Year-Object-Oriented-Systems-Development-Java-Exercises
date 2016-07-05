/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.part2;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestGenericStackInheritArrayList {
 
    //main method to run code
    public static void main(String[] args){
        
        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        
        //create the GenericStack arrayList
        GenericStackInheritArrayList stack = new GenericStackInheritArrayList();
        
        //prompt user to enter 5 words
        System.out.println("Enter 5 words: ");
        stack.push(scan.next());
        stack.push(scan.next());
        stack.push(scan.next());
        stack.push(scan.next());
        stack.push(scan.next());
        
        //output in reverse order
        System.out.println("Your inputs in reverse order");
        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
        
    }
    
}
