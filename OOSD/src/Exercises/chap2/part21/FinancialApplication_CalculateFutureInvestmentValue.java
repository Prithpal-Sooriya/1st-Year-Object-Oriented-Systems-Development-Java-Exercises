/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part21;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class FinancialApplication_CalculateFutureInvestmentValue {
    public static void main(String[] args){
        /*(financial application)
        read the investment amount, anual rate and number of years
        display the future investment value using formula:
        futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate)^ (number of years * 12)
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //variables to use
        double futureInvestmentAmount, investmentAmount, annualInterestRate, monthlyInterestRate, numberOfYears;
        
        //prompt for input
        System.out.println("Enter investment amount:");
        investmentAmount = scan.nextDouble();
        System.out.println("Enter annual interest rate in percentage:");
        annualInterestRate = scan.nextDouble();
        System.out.println("Enter number of years:");
        numberOfYears = scan.nextDouble();
        
        //calculation
        //calculate monthly interest (from chap2, part 20 AND IN BOOK (2.16))
        monthlyInterestRate = (annualInterestRate / 1200);
        System.out.println(monthlyInterestRate);
        //calculate future investment
        futureInvestmentAmount = investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);
        
        //output
        System.out.println("Accumulated value is $" + futureInvestmentAmount);
    }
}
