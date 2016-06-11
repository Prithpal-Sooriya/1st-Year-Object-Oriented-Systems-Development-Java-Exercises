/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

/**
 *
 * @author Prithpal
 */
/*
count single digits:
write a program that generates 100 random integers between 0 and 9
display the count of each number
*/
public class CountSingleDigits7 {

  public static void main(String[] args) {
    //int array store 100 numbers
    int numbers[] = new int[100];
    //initialise array with random numbers between 0 and 9
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = (int) (Math.random() * 10);
    }
    //now we can count how many 0's to 9's there are in the array
    int counter;
    for (int i = 0; i < 9; i++) {
      counter = 0;
      System.out.print("Numbers of " + i + "'s: ");
      for (int j = 0; j < numbers.length; j++) {
        int number = numbers[j];
        if(number == i)
          counter++;
      }
      System.out.format("%d \n", counter);
    }
  }
}
