/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Prithpal
 */
/*
random number chooser:
write a method that returns a random number between 1 and 54
exclude numbers passed through the arguments
method header should be:
int getRandom(int[] numbers)
 */
public class RandomNumberChooser13 {

  public static void main(String[] args) {
    //test if method works
    int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(getRandom(numbers));
  }

  //returns random number 1-54 excluding the parameters
  public static int getRandom(int[] numbers) {
    //create the random number generator
    Random random = new Random();
    int x = numbers[0];
    boolean run = true;

    //while loop to run till found a number not excluded
    while (run) {
      //random number between 1-54
      //should be: random.nextInt(MAX - MIN + 1) + MIN
      //so in this case: random.nextInt(54 - 1 + 1) + 1
      x = random.nextInt(54) + 1;
      //now.... lets work out if the random number is part of the exclusion
      run = false; //use the boolean run and turn it false
      for (int number : numbers) {
        if (number == x) {
          run = true; //so if the IF statement never execute, run will stay false
        }             //and the loop will end 
      }
    }
    return x;
  }
}
