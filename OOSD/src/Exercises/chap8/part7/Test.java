/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part7;

/**
 *
 * @author Prithpal Sooriya
 */
public class Test {
    public static void main(String[] args) {
        //create account and set annual interest rate
        Account acc = new Account(1122, 20000);
        acc.setAnnualInterestRate(4.5);
        
        //withdraw and diposit
        acc.withdraw(2500);
        acc.diposit(3000);
        
        //output values
        System.out.println("Account ID: " + acc.getId());
        System.out.println("Account Balance: " + acc.getBalance());
        System.out.println("Account monthly interest: " + acc.getMonthlyInterest());
        System.out.println("Account Account created on: " + acc.getDateCreated().getTime());
    }
}
