/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part20;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class FinancialApplication_CalculateInterest {
    public static void main(String[] args) {
        /*(financial application: calculate interest)
        interest = balance * (annual interest rate/1200)
        write a program that reads balance and annual intrest rate and displays interest rate for the next month
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //variables to use
        double balance, interestRate, interest;
        //output to user to prompt input
        System.out.println("enter balance and interest rate (e.g., 3 for 3%):");
        balance = scan.nextDouble();
        interestRate = scan.nextDouble();
        
        //calculate interest (use formula)
        interest = balance * (interestRate/1200);
        
        //output
        System.out.println("The interest is " + interest);
    }
}
