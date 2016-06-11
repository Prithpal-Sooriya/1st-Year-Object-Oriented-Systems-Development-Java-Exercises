/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

/**
 *
 * @author ps2-sooriya
 */
public class SquareNumbers18 {

  /*
    using the Math class print a table of the numbers and its squares
    table:
    number    square root
    ----------------------
    1             ..
    2             ..
   */
  
  public static void main(String[] args) {
    //crate header for table
    System.out.format("%-15s%-15s\n", "Number", "Square root");
    //for loop to iterate through 1 to 10
    for(int i = 1; i < 11; i++){
      System.out.format("%-15d%-15f\n", i, Math.pow(i, 0.5));
    }
  }
}
