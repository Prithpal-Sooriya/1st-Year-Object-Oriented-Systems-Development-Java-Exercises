/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */

/*
write a program that reads a decimal number and displays its binary equivalent
e.g. 24 input; 11000 ouput
*/
public class DecimalToBinary2 {
  
  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    
    //prompt for input
    System.out.println("Enter a number");
    int x = Math.abs(scan.nextInt()); //easier to make sure number is positive
    System.out.println(Integer.toBinaryString(x));
  }
}
