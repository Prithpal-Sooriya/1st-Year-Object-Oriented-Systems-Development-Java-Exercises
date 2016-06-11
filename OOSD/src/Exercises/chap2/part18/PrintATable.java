/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part18;

import java.util.Arrays;

/**
 *
 * @author Prithpal
 */
public class PrintATable {

    public static void main(String[] args) {
        /*(print a table)
         a   b   a+b    a+b
         */

        //components of table
        int a[] = {
            1, 2, 3, 4, 5
        };
        int b[] = {
            2, 3, 4, 5, 6
        };

        int plus[] = new int[5];
        for (int i = 0; i < 5; i++) {
            plus[i] = a[i] + b[i];
        }
        int times[] = new int[5];
        for (int i = 0; i < 5; i++) {
            times[i] = a[i] * b[i];
        }
        
        //create a heading/ for columns
        System.out.format("%-15s%-15s%-15s%-15s\n", "a", "b", "a + b", "a * b");
        //for loop to set the table
        for(int i = 0; i < a.length; i++){
            System.out.format("%-15s%-15s%-15s%-15s\n", a[i], b[i], plus[i], times[i]);
        }
    }
}
