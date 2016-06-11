/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part11;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class PercentageOfMarks {
    public static void main(String[] args) {
        /*percentage of marks
        total marks, studen marks and % got
        */
        
        //variables to use
        double totalMarks, studentMarks;
        double percentage;
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //output and input
        System.out.println("Enter the Full Marks:");
        totalMarks = scan.nextInt();
        System.out.println("Enter the Marks Obtained:");
        studentMarks = scan.nextInt();
        //calculate percent
        percentage = (studentMarks / totalMarks) * 100;
        System.out.println(studentMarks + " out of " + totalMarks + " means " + percentage + "%");
    }
}
