
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part3;

import java.util.Arrays;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestMyInteger {

    //test MyInteger class methods
    public static void main(String[] args) {

        //test non static methods
        MyInteger test = new MyInteger(5);
        System.out.println("Non static My integer object with value = " + test.getValue());
        System.out.println("Is Even: " + test.isEven());
        System.out.println("Is Odd: " + test.isOdd());
        System.out.println("Is Prime: " + test.isPrime());
        System.out.println(5 + " = " + test.getValue() + ": " + test.equals(5));

        //test static methods
        System.out.println("Static method test");
        System.out.println("Is 5 Even: " + MyInteger.isEven(5));
        System.out.println("Is 5 Odd: " + MyInteger.isOdd(5));
        System.out.println("Is 5 Prime: " + MyInteger.isPrime(5));
        System.out.println("5 = 3: " + MyInteger.equals(5, 3));
        
        //String and char array
        String s = "123";
        char[] c = s.toCharArray();
        System.out.println("Character array, " + Arrays.toString(c) + ", as number: " + MyInteger.parseInt(c));
        System.out.println("String, " + s + ", as number: " + MyInteger.parseInt(s));

    }

}
