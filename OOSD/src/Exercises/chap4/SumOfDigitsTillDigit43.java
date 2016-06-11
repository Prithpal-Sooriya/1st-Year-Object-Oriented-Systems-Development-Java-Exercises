/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class SumOfDigitsTillDigit43 {

    public static void main(String[] args) {
        /*
         sum the digits of a number until a single digit remains
         e.g. if the input is 768 --> sum is 21
         --> sum of 21 is 3
         */

        //scanner for input
        Scanner scan = new Scanner(System.in);

        //prompt for an input
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        //we could use a recursive function
        System.out.println("The sum of the digits is " + addDigits(number));
    }

    private static int addDigits(int num) {
        //convert this int into a string and then to a char array
        String temp = String.valueOf(num);
        char digitsChar[] = temp.toCharArray();
        //now convert this input into an integer for each char in char array
        int digitsInt[] = new int[digitsChar.length];
        for (int i = 0; i < digitsInt.length; i++) {
            digitsInt[i] = Integer.parseInt((digitsChar[i] + ""));
        }
        //now lets add the integer
        int total = 0;
        for (int i = 0; i < digitsInt.length; i++) {
            total += digitsInt[i];
        }
        //check total is single digit or not to return back
        if(total < 10){
            return total;
        }
        else{
            return addDigits(total);
        }
    }
}
