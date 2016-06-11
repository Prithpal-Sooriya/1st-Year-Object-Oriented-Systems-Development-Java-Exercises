/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
/*
Bubble sort:
write a method that uses the bubble sort algorithm.
===============================================================
The bubble sort algorithm makes several passes through the array. On each pass, successive
neighboring pairs are compared. If the pair is not in order, its values are swapped; otherwise
the values remain unchanged. Smaller values rise to the top and larger values sink to the bottom.
===============================================================
Write a test program that reads in 10 double numbers, invokes the method, and displays the sorted
numbers
 */
public class BubbleSort18 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //current list to work with
    double currentList[] = new double[10];
    
    //prompt user to enter 10 doubles
    System.out.println("Enter 10 double numbers:");
    for (int i = 0; i < currentList.length; i++) {
      currentList[i] = scan.nextDouble();
    }
    
    System.out.println("Current List is: " + Arrays.toString(currentList));
    //sort list
    bubbleSort(currentList);
    System.out.println("Ordered List is: " + Arrays.toString(currentList));

  }

  //method for bubble sort, passing pointers so array will change anyways (no need to return vals)
  public static void bubbleSort(double[] list) {
    //bubble sort compares in pairs, and each iteration gives us the most highest value
    for (int decrement = 0; decrement < list.length; decrement++) { //loop for decrementing
      for (int i = 1; i < (list.length - decrement); i++) { //loop for each iteration
        //bubble sort works in pairs so we have pointer i (head pointer) and pointer (i-1) end pointer
        int head = i, tail = i - 1;
        //swap if the tail is larger than the head
        if (list[tail] > list[head]) {
          double temp = list[head];
          list[head] = list[tail];
          list[tail] = temp;
        }
      } //once loop is done, the largest number is in the correct place so we can decrement
    }
  }
}
