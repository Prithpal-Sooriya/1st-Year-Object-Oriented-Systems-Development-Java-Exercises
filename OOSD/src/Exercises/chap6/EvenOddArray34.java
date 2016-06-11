/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
/*
write a program that prompts the user to enter 10 integers.
place the even numbers into an array called evenArray;
place the odd numbers into an array called oddArray.
display the contents of the array after the numbers have been allocated.
 */
public class EvenOddArray34 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);

    //arrayList which will hold the odd and even numbers
    ArrayList<Integer> evenArray = new ArrayList<>();
    ArrayList<Integer> oddArray = new ArrayList<>();
    //prompt user to enter 10 numbers
    System.out.println("Enter 10 integer numbers:");
    for (int i = 0; i < 10; i++) {
      //temporary store the number and allocate it into the correct array
      int temp = scan.nextInt();
      if (temp % 2 == 0) {
        evenArray.add(temp);
      } else {
        oddArray.add(temp);
      }
    }

    //display the contents of the array
    System.out.println("Contents of even array: " + evenArray.toString());
    System.out.println("Contents of odd array: " + oddArray.toString());
  }
}
