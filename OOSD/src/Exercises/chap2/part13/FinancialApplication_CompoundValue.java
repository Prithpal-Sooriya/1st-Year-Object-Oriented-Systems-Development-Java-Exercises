/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part13;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class FinancialApplication_CompoundValue {
    public static void main(String[] args) {
        /*(financial application: compound value)
        e.g. if you save $100 each month into a savings account with the annual interest rate 5%.
        thus, the monthly interest rate is 0.05/12 = 0.00417
        after first month val becomes --> 100 * (1 + 0.00417) = 100.417
        second month --> (100 + 100.417) * (1 + 0.00417) = 201.252
        third month -->(100 + 201.252) * (1 + 0.00417)
        ...
        calc 6 months
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        //output and input for monthly savings
        System.out.println("Enter the monthly saving amounnt:");
        double savingAmount = scan.nextDouble();
        //need variable to hold whats in bank
        double inBank = 0.0;
        //calculation after 6 months of annual interest rate of 5%--> for loop
        for(int i = 0; i < 6; i++){
            //whats in bank = (what you put in + whats already in there) * interest
            inBank = (savingAmount + inBank) * (1 + 0.00417);
        }
        System.out.format("After the sixth month, the account value is $%.2f\n", inBank);
    }
}
