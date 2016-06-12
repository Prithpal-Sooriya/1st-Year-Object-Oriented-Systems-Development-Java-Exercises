/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part1;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class ConfirmValidRollNumber {

    public static void main(String[] args) {
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a Roll number in the format DD-DDD-DDDDD (where D is a Digit): ");
        String input = scan.next();

        //confirm that the String is of the correct format
        if (input.matches("^\\d\\d-\\d\\d\\d-\\d\\d\\d\\d\\d$")) {//regex of dd-ddd-ddddd (^ start; $ end)
            System.out.println("Valid Roll Number");
        }
        else{
            System.out.println("Invalid Roll Number");
        }
    }
}
