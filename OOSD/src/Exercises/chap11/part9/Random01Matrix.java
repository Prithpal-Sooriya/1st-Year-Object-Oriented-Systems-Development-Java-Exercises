/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part9;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class Random01Matrix {

    //main method to run the code
    public static void main(String[] args) {

        //Scanner for input
        Scanner scan = new Scanner(System.in);

        //prompt for how large the matrix should be
        System.out.println("Enter the array size n:");
        int input = scan.nextInt();

        //create the n by n matrix
        int[][] matrix = new int[input][input]; //[column][row]

        //populate the array with random 0 and 1
        Random rand = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //pick a random 0 or 1
                matrix[i][j] = rand.nextInt(2); //random int between 0 and 1
            }
        }

        //output array
        for (int[] is : matrix) {
            for (int i : is) {
                System.out.print(i);
            }
            System.out.println("");
        }

        //work out the the largest column and row
        ArrayList<Integer> largestRowIndex = new ArrayList<>();
        ArrayList<Integer> largestColumnIndex = new ArrayList<>();

        //counter to add all the 1's
        int counter = 0;
        //work out largest row
        for (int index = 0; index < matrix.length; index++) {

            //reset the counter at the start of every column
            counter = 0;
            for (int i = 0; i < matrix.length; i++) {
                counter += matrix[index][i]; //add up the row
            }

            //at the end of each row, check if it is < > or equal to
            //if there is no item in the arraylist, then add this new item
            if (largestRowIndex.isEmpty()) {
                largestRowIndex.add(index);
            } else {
                //the we know the index of the largest row, use the index to find its value
                int currentValue = 0;
                for (int i = 0; i < matrix.length; i++) {
                    currentValue += matrix[largestRowIndex.get(0)][i];
                }

                //check this current value
                if (counter > currentValue) { //counter is larger than what is in ArrayList
                    //empty ArrayList and add the new value
                    largestRowIndex.clear();
                    largestRowIndex.add(index);
                } else if (counter == currentValue) { //counter has same value
                    //add this index into the arrayList
                    largestRowIndex.add(index);
                }
            }
        }

        //work out largest column
        for (int index = 0; index < matrix.length; index++) {
            //reset counter
            counter = 0;
            for (int i = 0; i < matrix.length; i++) {
                counter += matrix[i][index]; //add up the column
            }

            //at the end of each row check the counter to the counter of whats in the index
            if (largestColumnIndex.isEmpty()) {
                largestColumnIndex.add(index);
            } else {
                //we know the index of the largest column, so calculate the size
                int currentValue = 0;
                for (int i = 0; i < matrix.length; i++) {
                    currentValue += matrix[i][largestColumnIndex.get(0)];
                }
                
                //check this current value
                if(counter > currentValue){ //counter is larger than what is in the Arraylist
                    //empty ArrayList and add this larger value
                    largestColumnIndex.clear();
                    largestColumnIndex.add(index);
                }
                else if(counter == currentValue){ //counter had the same value
                    //add the counter to the arrayList
                    largestColumnIndex.add(index);
                }
            }
        }

        //we have worked out the largest row and column, so lets display this
        System.out.print("The Largest row index: ");
        //make the output look nice
        if(largestRowIndex.size() == 1){
            System.out.println(largestRowIndex.get(0));
        }
        else{
            System.out.print(largestRowIndex.get(0));
            for (int i = 1; i < largestRowIndex.size(); i++) {
                System.out.print(", " + largestRowIndex.get(i));
            }
        }
        System.out.println("");
        
        System.out.println("The Largest column index: ");
        //make the output look nice
        if(largestColumnIndex.size() == 1){
            System.out.println(largestColumnIndex.get(0));
        }
        else{
            System.out.print(largestColumnIndex.get(0));
            for (int i = 1; i < largestColumnIndex.size(); i++) {
                System.out.print(", " + largestColumnIndex.get(i));
            }
        }
        System.out.println("");
    }

}
