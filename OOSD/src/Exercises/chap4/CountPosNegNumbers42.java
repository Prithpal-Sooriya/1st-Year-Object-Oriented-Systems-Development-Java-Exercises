/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class CountPosNegNumbers42 {

    public static void main(String[] args) {
        /*
         user can enter set of numbers
         should count number of positive numbers and negative numbers seperately along with sum
         program should terminate when 0 entered
         */

        //scanner for input
        Scanner scan = new Scanner(System.in);

        //boolean to run loop
        boolean run = true;
        while (run) {
            //prompt user to enter a set of numbers
            System.out.println("Enter a set of integers (0 will terminate the program):");
            String input = scan.nextLine();
            //convert this 1 input into a string array splitting each number (because of the space)
            String[] numsString = input.split(" ");
            //now we can create a int array from the numbers
            int[] numsInt = new int[numsString.length];
            //convert each String num into an int num
            for (int i = 0; i < numsInt.length; i++) {
                numsInt[i] = Integer.parseInt(numsString[i]);
            }

            //now we can calculate the number number of +ve and -ve and count sum
            int sumPos = 0;
            int sumNeg = 0;
            int countPos = 0;
            int countNeg = 0;
            //for loop to count pos and neg till 0 (or if 0) is found
            for (int i = 0; i < numsInt.length; i++) {
                if (numsInt[i] > 0) {
                    //increment counter
                    countPos++;
                    //add to positive sum
                    sumPos += numsInt[i];
                } else if (numsInt[i] < 0) {
                    //increment counter
                    countNeg++;
                    //add to negaive sum
                    sumNeg += numsInt[i];
                } else {
                    //ZERO IS FOUND
                    //set run to alse and break out of this code
                    run = false;
                    break;
                }
            }
            //print out positive
            System.out.println("The number of positive numbers was: " + countPos);
            System.out.println("The sum of the positive numbers was: " + sumPos);
            //print out negative
            System.out.println("The number of negative numbers was: " + countNeg);
            System.out.println("The sum of the negative numbers was: " + sumNeg);

            //check run to see if we should break out of loop
            if (run == false) {
                break;
            } else {
                //prompt user if they want to break out of loop
                System.out.println("Do you want to close this program? (Y/N)");
                String exit = scan.next();
                //clear input by using nextLine to eat it
                scan.nextLine();
                if (exit.equalsIgnoreCase("Y")) {
                    run = false;
                }
            }
        }
    }
}
