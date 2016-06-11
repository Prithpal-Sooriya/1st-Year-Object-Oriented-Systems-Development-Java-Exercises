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
one array double anoher:
The array list2 is double list1 if each element of list2 is double corrisponding element in list1.

Write a method that returns true if list2 is double list1
header should be:
boolean checkDouble(int[] list1, int[] list2)

Write a test program that prompts the user to enter 2 lists of integers and displays whether the 
elements of the second array are double of the elements of the first array.
ASSUME that the lists are equal sizes
 */
public class DoubleAnotherArray26 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //2 int arrays
    int list1[] = new int[4];
    int list2[] = new int[4];

    //prompt user to fill both lists
    System.out.println("Enter 4 integers for list1:");
    for (int i = 0; i < list1.length; i++) {
      list1[i] = scan.nextInt();
    }
    System.out.println("Enter 4 integers for list2:");
    for (int i = 0; i < list2.length; i++) {
      list2[i] = scan.nextInt();
    }
    //invoke and output if list2 is double list1
    System.out.println(checkDouble(list1, list2)?
            "Second list is double of first list" :
            "Second list is not double first list");
  }

  public static boolean checkDouble(int[] list1, int[] list2) {
    //check size of both lists --> if not the same size, return false
    if (list1.length != list2.length) {
      return false;
    }
    
    //check each element of each array
    for (int i = 0; i < list2.length; i++) {
      if(list2[i] != list1[i] * 2){
        return false;
      }
    }
    //passed for loop, so must be true
    return true;
  }

}
