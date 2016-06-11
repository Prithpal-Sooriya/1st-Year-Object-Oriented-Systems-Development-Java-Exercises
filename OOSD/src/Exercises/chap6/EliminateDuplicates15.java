/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Prithpal
 */
/*
Eliminate duplicates:
write a method that returns anew array by eliminating the duplicate values
header of method should be called:
int[] eliminateDuplicates(int[] list)

write a test program that reads 10 integers, invokes method and ouputs new integer array
 */
public class EliminateDuplicates15 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //integer array
    int numbers[] = new int[10];
    System.out.println("Enter 10 numbers:");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scan.nextInt();
    }
    //invoke method
    System.out.println("The distinct numbers are: " + Arrays.toString(eliminateDuplicates(numbers)));
    //output
  }

  //remove all the duplicates in the list
  public static int[] eliminateDuplicates(int[] list) {

    //use arraylists as then when we output we wont get a line of 0's
    ArrayList<Integer> currentList = new ArrayList<>(list.length);
    //populate the arraylist with all the values given
    for (int i = 0; i < list.length; i++) {
      currentList.add(list[i]);
    }
    //now we can use a linked hashset to remove all duplicates and retain order
    Set<Integer> hs = new LinkedHashSet<>();
    hs.addAll(currentList);
    //clear the arraylist and repopulate (all duplicates gone)
    currentList.clear();
    currentList.addAll(hs);

    //convert the arraylist back into array to return
    int newList[] = new int[currentList.size()];
    for (int i = 0; i < newList.length; i++) {
      if (currentList.get(i) != null) //ensure that the current list is populated
      {
        newList[i] = currentList.get(i);
      }
    }
    
    //return the new list
    return newList;
    
    
    //where we will store the new array
//    int outcome[] = new int[list.length]; //USE AN ARRAY LIST TO REMOVE ACCESS 0'S
//    int pointer = 0;
//    for (int i : outcome) {
//      //check if item DOESNT exist in the current array
//      if(!isExists(list, i)){
//        //if it doesnt exist then we can add the item
//        outcome[pointer] = i;
//        //increment pointer to point at next available free space
//        pointer++;
//      }
//    }
  }

//  //return true/ false if an item exists in an array or not
//  private static boolean isExists(int[] array, int value) {
//    for (int i : array) {
//      if (i == value) {
//        return true;
//      }
//    }
//    return false;
//  }
}
