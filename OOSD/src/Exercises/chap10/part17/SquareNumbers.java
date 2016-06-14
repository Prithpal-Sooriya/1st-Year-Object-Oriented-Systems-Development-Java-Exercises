/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part17;

import java.math.BigInteger;

/**
 *
 * @author Prithpal Sooriya
 */
public class SquareNumbers {

    //where the code will run
    public static void main(String[] args) {

        //create a String of the lowest a long can go
        String lowest = "" + Long.MAX_VALUE;

        //create a counter to count the 10 squared numbers
        int counter = 0;

        //create the bigInteger we will be using
        BigInteger i = new BigInteger(lowest);

        //while loop to find the integers
        while (counter < 10) {

            //find out if the number can be square rooted
            if(isSquare(i)){
                System.out.println(i.toString() + " is a square number");
                //increment counter
                counter++;
            }
            //increment bigInteger
            i = i.add(new BigInteger(1 + ""));

        }

    }

    /*
    code obtained from stack overflow (could not visit the link to where it was sourced:
    http://stackoverflow.com/questions/2685524/check-if-biginteger-is-not-a-perfect-square
     */
    private static final BigInteger b100 = new BigInteger("100");
    private static final boolean[] isSquareResidue;

    static {
        isSquareResidue = new boolean[100];
        for (int i = 0; i < 100; i++) {
            isSquareResidue[(i * i) % 100] = true;
        }
    }

    public static boolean isSquare(final BigInteger r) {
        final int y = (int) r.mod(b100).longValue();
        boolean check = false;
        if (isSquareResidue[y]) {
            final BigInteger temp = sqrt(r);
            if (r.compareTo(temp.pow(2)) == 0) {
                check = true;
            }
        }
        return check;
    }

    public static BigInteger sqrt(final BigInteger val) {
        final BigInteger two = BigInteger.valueOf(2);
        BigInteger a = BigInteger.ONE.shiftLeft(val.bitLength() / 2);
        BigInteger b;
        do {
            b = val.divide(a);
            a = (a.add(b)).divide(two);
        } while (a.subtract(b).abs().compareTo(two) >= 0);
        return a;
    }

}
