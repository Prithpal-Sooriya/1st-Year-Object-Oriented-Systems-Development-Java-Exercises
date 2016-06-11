/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part2;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class Exercise {
    public static void main(String[] args) {
        /*(compute the area and perimeter of a rectangle) read input of length and breadth
        and output the area and perimeter
        */
        //use scanner for input
        Scanner scan = new Scanner(System.in);
        //output message for input length
        System.out.println("Enter length of the rectangle");
        //input length
        int length = scan.nextInt();
        //output message for input length
        System.out.println("Enter the breadth of the rectangle");
        //input breadth
        int breadth = scan.nextInt();
        //output area
        System.out.println("The area of the rectangle is " + ((double)length * breadth));
        //output perimeter
        System.out.println("The perimeter of the rectangle is " + ((2*length) + (2*breadth)));
        
    }    
}
