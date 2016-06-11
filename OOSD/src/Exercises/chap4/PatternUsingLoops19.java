/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class PatternUsingLoops19 {

    public static void main(String[] args) {
        /*
         display pattern using loops:
         use nested loops to display patterns a, b, c, or d
         */

        //scanner for input
        Scanner scan = new Scanner(System.in);

        //prompt user for pattern type
        System.out.println("What pattern (A, B, C, D)");
        String pattern = scan.next();
        switch (pattern.toUpperCase()) {
            case "A":
                patternA();
                break;
            case "B":
                patternB();
                break;
            case "C":
                patternC();
                break;
            case "D":
                patternD();
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void patternA() {
        //columns of 9, 5 times
        for (int i = 0; i < 5; i++) {
            System.out.println("*********");
        }
    }

    public static void patternB() {
        //5 columns, 5 times --> middle one is missing star
        int counter = 1;
        for (int i = 1; i <= 5; i++) {
            if (counter % 3 != 0) {
                System.out.println("*****");
            } else {
                System.out.println("** **");
            }
            counter++;
        }
    }

    public static void patternC() {
        //create a diamond with 5 rows of stars
        for(int i = 0; i < 5; i++){
            if(i == 0 || i == 4){
                System.out.println("  *  ");
            }
            else if(i == 1 || i == 3){
                System.out.println(" *** ");
            }
            else if(i == 2){
                System.out.println("*****");
            }
        }
    }

    public static void patternD() {
        //display diamond but with spaces
        for(int i = 0; i < 5; i++){
            if(i == 0 || i == 4){
                System.out.println("  *  ");
            }
            else if(i == 1 || i == 3){
                System.out.println(" * * ");
            }
            else if(i == 2){
                System.out.println("* * *");
            }
        }
    }
}
