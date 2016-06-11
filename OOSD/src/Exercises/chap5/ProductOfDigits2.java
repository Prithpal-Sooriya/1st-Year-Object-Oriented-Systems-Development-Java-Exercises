/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class ProductOfDigits2 {

  public static void main(String[] args) {
    /*program returns product of digits
     e.g. 234 --> 24 (2*3*4)
     */
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //prompt for input
    System.out.println("Enter an integer:");
    int startingNumber = scan.nextInt();
    System.out.println("The product of all its digits are: " + productDigits(startingNumber));
  }

  public static int productDigits(long n) {

    long temp = n;
    int counter = 1;
    
    while (temp > 1) { //loop to iterate till all digits left <10
            //extract the smallest digit (e.g 234 --> smallest digit = 4)
      //place the smallest digit into counter
      counter *= temp % 10;
      //remove the smallest digit to to have the rest of integer
      temp /= 10;
    }
    return counter;
  }
}
