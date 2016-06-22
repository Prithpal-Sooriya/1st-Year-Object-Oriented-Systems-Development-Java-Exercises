/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Prithpal Sooriya
 */
public class ShuffleArrayListNumbers {
    
    //main method to run code
    public static void main(String[] args) {
        
        //ArrayLists to test
        ArrayList<Number> integers = new ArrayList<>(Arrays.asList(new Number[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(new Double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0}));
        //ArrayList<BigInteger> strings = new ArrayList<>(Arrays.asList(new BigInteger[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<BigInteger> bigIntegers = new ArrayList(Arrays.asList(
                new BigInteger("0"),
                new BigInteger("1"),
                new BigInteger("2"),
                new BigInteger("3"),
                new BigInteger("4"),
                new BigInteger("5"),
                new BigInteger("6"),
                new BigInteger("7"),
                new BigInteger("8"),
                new BigInteger("9")
        ));
        
        //shuffle the arrays
        shuffle(integers);
//        shuffle(doubles);
        
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
