/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part16;

import java.math.BigInteger;

/**
 *
 * @author Prithpal Sooriya
 */
public class Divisible50Digits {

    //where the program will output
    public static void main(String[] args) {

        //normal integers will not work as ints can only go up to 2,147,483,647
        //long only goes up to 9,223,372,036,854,775,808 not up to 50 digits
        //need to use BigInteger class
        //FOR loop on it
        String lowestSize
                = "1000000000"
                + "0000000000"
                + "0000000000"
                + "0000000000"
                + "0000000000";

        //counter to find the first 10 numbers
        int counter = 0;
        BigInteger i = new BigInteger(lowestSize);

        while (counter < 10) {

            if (i.mod(new BigInteger(2 + "")).equals(new BigInteger(0 + ""))) {
                if (i.mod(new BigInteger(3 + "")).equals(new BigInteger(0 + ""))) {
                    //divisible by 3 and 3
                    System.out.println(i.toString() +  " is divisible by 2 and 3");
                    counter++;
                } else {
                    //divisible by 2
                    System.out.println(i.toString() + " is divisible by 2");
                    counter++;
                }
            } else if (i.mod(new BigInteger(3 + "")).equals(new BigInteger(0 + ""))) {
                //divisible by 3
                System.out.println(i.toString() + " is divisible by 3");
                counter++;
            }
            //increment bigInteger
            i = i.add(new BigInteger(1 + ""));
        }

    }

}
