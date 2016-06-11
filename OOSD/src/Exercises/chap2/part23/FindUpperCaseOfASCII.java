/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part23;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class FindUpperCaseOfASCII {

    public static void main(String[] args) {
        /*(uppercase equiv to of an ascii code)
         retrieve lower case ascii code (97 to 122 displays uppercase equiv)
         hint 'a' is 32 difference to 'A'
         */

        //scanner for input
        Scanner scan = new Scanner(System.in);

        //variables to use
        int lowerCase, upperCase;
        while (true) {
            //output
            System.out.println("Enter an ASCII code (within the range of 97 - 122):");
            lowerCase = scan.nextInt();
            if(lowerCase < 97 || lowerCase > 122){
                continue;
            }
            break;
        }
        //calculate uppercase val
        upperCase = lowerCase - 32;
        //convert uppercase and lowercase to char
        char upper = (char) upperCase;
        char lower = (char) lowerCase;
        System.out.println("The lower case character is " + lower + " and its equivelent upper case is " + upper);
    }
}
