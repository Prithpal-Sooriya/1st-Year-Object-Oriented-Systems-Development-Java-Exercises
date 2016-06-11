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
Find the index of the largest element:
write a method that returns the index of the largest element in an array or doubles
if there are 2 largest's return the smallest index
header:
int indexOfLargestElement(double[] array)

write a test program that prompts user to enter 10 numbers and ouputs index of largest number
 */
public class IndextOfLargestElement10 {

  public static void main(String[] args) {
    //copy most of exercise 9
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
    int largest = indexOfLargestElement(numbers);
    //ouput largest
    System.out.println("The maximum number is: " + largest);
  }

  //we will use the array and search through the array to find the largest double
  public static int indexOfLargestElement(double[] array) {
    //store the first double into variable
    int largestIndex = 0;

    //for loop to search all elements and determain largest
    for (int i = 1; i < array.length; i++) {
      double d = array[i];
      if (d > array[largestIndex]) {
        largestIndex = i;
      }
    }

    //return the largest
    return largestIndex;
  }
}
