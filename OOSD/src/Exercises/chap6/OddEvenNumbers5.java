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
print odd and even index numbers serparately:
write a program that reads in 10 numbers and displays the odd index first and then even indexed numbers
 */
public class OddEvenNumbers5 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //array to hold the 10 numbers
    int numbers[] = new int[10];
    //prompt to input 10 numbers
    System.out.println("Enter ten numbers:");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scan.nextInt();
    }
    //print odd numbers
    System.out.print("Odd index elements are:");
    for (int i = 0; i < numbers.length; i++) {
      if (i % 2 == 1) {
        System.out.format(" %d", numbers[i]);
      }
    }
    System.out.println("");
    //print even numbers
    System.out.print("Even index elements are:");
    for (int i = 0; i < numbers.length; i++) {
      if (i % 2 == 0) {
        System.out.format(" %d", numbers[i]);
      }
    }
    System.out.println("");
  }
}
