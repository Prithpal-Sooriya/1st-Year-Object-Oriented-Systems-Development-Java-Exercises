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
write a program that reads a set of numbers and a key element to search for in the entered array
run should be
ENTER NUMBERS IN ASSENDING ORDER: 10 20 30 40 50 60
ENTER A NUMBER TO SEARCH: 40
ELEMENT FOUND AT $ POSITION
*/
public class KeyElementSearch3 {
  
  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //size of array
    System.out.println("Size of number array:");
    int size = scan.nextInt();
    int array[] = new int[size];
    //fill array
    System.out.println("Enter " + size + " numbers in ASCENDING order:");
    for (int i = 0; i < array.length; i++) {
      array[i] = scan.nextInt();
    }
    //search element
    System.out.println("Enter a number to search:");
    int search = scan.nextInt();
    boolean found = false;
    for (int i = 0; i < array.length; i++) {
      if(array[i] == search){
        System.out.println("Element is found at " + i + " position");
        found = true;
        break;
      }
    }
    if(found == false) System.out.println("Element not found");
  }
}
