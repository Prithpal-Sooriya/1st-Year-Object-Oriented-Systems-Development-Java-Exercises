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
Find the largest element:
write a method that finds the largest element in an array:
double max(double[] array)
write a program that prompts users to enter 10 doubles and display the largest double
 */
public class LargestElement9 {

  public static void main(String[] args) {

    //Scanner for input
    Scanner scan = new Scanner(System.in);
    //double array to hold 10 numbers
    double numbers[] = new double[10];

    //prompt user to enter 10 doubles
    System.out.println("Enter ten numbers:");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scan.nextDouble();
    }

    //find and save the largest number
    double largest = max(numbers);
    //ouput largest
    System.out.println("The maximum number is: " + largest);
  }

  //we will use the array and search through the array to find the largest double
  public static double max(double[] array) {
    //store the first double into variable
    double largest = array[0];

    //for loop to search all elements and determain largest
    for (int i = 1; i < array.length; i++) {
      double d = array[i];
      if (d > largest) {
        largest = d;
      }
    }

    //return the largest
    return largest;
  }
}
