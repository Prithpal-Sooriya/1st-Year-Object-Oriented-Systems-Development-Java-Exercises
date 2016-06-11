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
Double the contents of each element in the array:
write a program that prompts the user to enter 10 numbers
then call a doubleIt method that double contents of each element in the array
finally output the numbers
 */
public class DoubleArray12 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //array to hold 10 numbers
    int numbers[] = new int[10];
    //prompt for input and invoke method
    System.out.println("Enter 10 numbers:");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scan.nextInt();
    }
    numbers = doubleIt(numbers);
    for (int i = 0; i < numbers.length; i++) {
      int number = numbers[i];
      System.out.print(number + " ");
    }
    System.out.println("");
  }

  public static int[] doubleIt(int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] *= 2;
    }
    return array;
  }
}
