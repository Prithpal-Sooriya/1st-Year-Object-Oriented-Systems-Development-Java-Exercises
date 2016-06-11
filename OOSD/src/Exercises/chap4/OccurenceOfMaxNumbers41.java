/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class OccurenceOfMaxNumbers41 {

  public static void main(String[] args) {
    /*
     occurence of max numbers:
     write program that:
     --> reads integers
     --> counts its occurence
     --> assumes that end input is 0
     e.g 3 5 2 5 5 5 0, max = 5, occurence = 4
     */

    //scanner for input
    Scanner scan = new Scanner(System.in);

    //prompt to enter number
    System.out.println("Enter numbers:");
    //save as a large string with spaces
    String input = scan.nextLine();

    //convert this 1 input into a string array splitting each number (because of the space)
    String[] numsString = input.split(" ");

    //now we can create a int array from the numbers
    int[] numsInt = new int[numsString.length + 1];

    //convert each String num into an int num
    int i;
    for (i = 0; i < numsInt.length - 1; i++) {
      numsInt[i] = Integer.parseInt(numsString[i]);
    }
    //now we can add the o at the end
    numsInt[numsInt.length - 1] = 0;
    
    //now lets do the functions!!!!!!
    int max = numsInt[0];
    int count = 1;
    for (int j = 1; j < numsInt.length; j++) {
      if(numsInt[j] > max){
        max = numsInt[j];
        count = 1;
      }else{
        if(max == numsInt[j]){
          count++;
        }
      }
    }
    System.out.println("The highest number: " + max);
    System.out.println("The amount of times it turned up: " + count);
  }
}
