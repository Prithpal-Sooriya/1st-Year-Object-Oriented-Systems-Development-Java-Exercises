/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap3;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise26_logicalOperators {
    public static void main(String[] args) {
        /*
        use &&, ||, ^
        if input is divisible by 3 and 7, 3 or 7, divisible by 3 or 7 but not both
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //prompt for input
        System.out.println("Enter an integer:");
        int in = scan.nextInt();
        
        //if statements
        System.out.format("Is " + in + " divisible by 3 and 7?");
        if(in % 3 == 0 && in % 7 == 0){
            System.out.println(" True");
        }
        else{
            System.out.println(" False");
        }
        System.out.format("Is " + in + " divisible by 3 or 7?");
        if(in % 3 == 0 || in % 7 == 0){
            System.out.println(" True");
        }
        else{
            System.out.println(" False");
        }
        System.out.format("Is " + in + " divisible by 3 or 7, but not both?");
        if(in % 3 == 0 ^ in % 7 == 0){
            System.out.println(" True");
        }
        else{
            System.out.println(" False");
        }
    }
}
