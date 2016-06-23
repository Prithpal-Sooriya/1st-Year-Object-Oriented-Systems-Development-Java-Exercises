/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Prithpal Sooriya
 */
public class ShuffleArrayListNumbers {
    
    //main method to run code
    public static void main(String[] args) {
        
        //Create an arrayList which stores numbers (so will store Integers, Doubles bigInts, ect
        ArrayList<Number> numbers = new ArrayList<>(Arrays.asList(new Number[]{
            1.0d, 2.0f, new Long(3), 4, new Short("5"), new Byte("6"), new BigInteger("7"), new BigDecimal("8")
        }));
        
        //output the array
        System.out.println(numbers);
        
        //shuffle the array
        shuffle(numbers);
        
        //output the array
        System.out.println(numbers);
    }
    
    //method to shuffle ArrayList of numbers
    public static void shuffle(ArrayList<Number> list){
        
        /*
        Use Collections.shuffle as we do not use the compareto method
        , thus there is no point in doing this manually
        */
        
        Collections.shuffle(list);
        
    }
    
}
