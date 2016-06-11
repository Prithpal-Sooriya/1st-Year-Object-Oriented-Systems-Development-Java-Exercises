/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

/**
 *
 * @author Prithpal
 */
public class SumOfSeries24 {
    public static void main(String[] args) {
        /*
        Sum of a series:
        calculate some of series of
        1/25 + 2/24 + 3/23 ..... + 25/1
        */
        
        //2 ints needed
        int i = 1;
        int j = 25;
        //double for total
        double total = 0;
        while(i != 26 && j != 0){
            total += (double) (i/j);
            //print out to check if works
            System.out.print(i + "/" + j + " + ");
            //increment i and decrement j
            i++;
            j--;
        }
        //print total
        System.out.println("Total:" + total);
    }
}
