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
public class GramsToKilograms3 {
    public static void main(String[] args) {
        /*
        convert kg to grams and show table
        */
        //strings for titles
        System.out.format("%-15s%-15s\n", "Kilograms", "Grams");
        //for loop to display numbers
        for(int i = 0; i < 25; i++){
            System.out.format("%-15d%-15d\n", (i + 1), ((i + 1)*1000));
        }
    }
}
