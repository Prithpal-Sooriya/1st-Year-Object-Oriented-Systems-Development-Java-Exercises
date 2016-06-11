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
sorted?:
write a method that returns true if the list is already sorted in increasing order
header should be:
boolean isSorted(int[] list)

write a test program that prompts users to enter a list and display whether it is sorted or not
 */
public class Sorted19 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);

    //prompt user to enter how many numbers in the list
    System.out.println("How many integers do you want in your list:");
    int size = scan.nextInt();
    int numbers[] = new int[size];

    //enter the set of numbers
    System.out.println("Enter " + size + " integers:");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scan.nextInt();
    }

    System.out.println(
            (isSorted(numbers) == true)
            ? "The list is already sorted"
            : "The list is not sorted");
  }

  public static boolean isSorted(int[] list) {
    //to check if the list is sorted we will need to compare each of the pairs and see if they're in
    //order

    for (int i = 1; i < list.length; i++) { // i-1 will be tail, i will be head
      int tail = (i - 1), head = i;
      if (list[tail] > list[head]) {
        return false;
      }
    }

    //if loop completes then it is sorted
    return true;
  }
}
