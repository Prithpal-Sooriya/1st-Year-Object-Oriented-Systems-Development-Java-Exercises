/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercises.chap1.part4;

/**
 *
 * @author Prithpal
 */
public class PrintATable {
    public static void main(String[] args){
        //print out a times table
        
        //create a table for the strings
        Object table[][] = new String[5][];
        //set the table contents
        table[0] = new String[] {"a", "a*2", "a*3"};
        table[1] = new String[] {"1", "2", "3"};
        table[2] = new String[] {"2", "4", "6"};
        table[3] = new String[] {"3", "6", "9"};
        table[4] = new String[] {"4", "8", "12"};
        //display contents
        for(Object[] row: table){
            //add hypen ("-" will make it align to the left
            System.out.format("%-15s%-15s%-15s\n", row);
        }
    }
}
