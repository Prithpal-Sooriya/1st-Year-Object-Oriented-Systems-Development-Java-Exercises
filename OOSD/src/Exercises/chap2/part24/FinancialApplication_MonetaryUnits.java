/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part24;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class FinancialApplication_MonetaryUnits {

    public static void main(String[] args) {
        /*(financial application: monetary units)
         rewrite chapter 2 code example 10 to fix loss of accuracy
         make the output into currency (pounds, 50p, 20p, 10p, 5p, 2p, 1p)
         */

        //Scanner for input
        Scanner scan = new Scanner(System.in);

        //code from chapter 2 part 
        //input double
        System.out.println("Input price (double in format with end .pp)");
        double remainingAmount = scan.nextDouble();
        //check if the double is correct
        //calculate
        int remainingInt = (int) (remainingAmount * 100);
        int pounds = remainingInt / 100;
        int pence = (int) remainingInt % 100;
        //check temp 2 < 100 (should be)

        System.out.println("£" + remainingAmount + " is £" + pounds + " (pounds) and " + pence + "p (pence)");
    }
}
