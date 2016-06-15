/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part8;

import Exercises.chap8.part7.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Prithpal Sooriya
 */
public class Account {

    private int id;
    private double balance;
    private java.util.Date dateCreated;
    private String name;
    private double interestRate;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    
    public Account() { //no args but still have to set current date
        dateCreated = new java.util.Date();
    }

    public Account(int id, double InitialBalance){
        this.id = id;
        balance = InitialBalance;
        dateCreated = new java.util.Date();
    }
    
    public Account(String name, int id, double balance, double interestRate){
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double annualInterestRate;

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return (annualInterestRate / 100) / 12; //div 100 as is percentage
    }
    
    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }
    
    public void withdraw(double amount){
        //add this transaction
        transactions.add(new Transaction('-', amount, balance, "Withdrawing"));
        balance = balance - amount;
    }
    
    public void diposit(double amount){
        //add this transaction
        transactions.add(new Transaction('+', amount, balance, "Depositing"));
        balance = balance + amount;
    }
    
    public String printTransations(){
        String report = name + "\t" + interestRate + "\t" + balance + "\n";
        //add the transactions
        for (Transaction transaction : transactions) {
            report = report + transaction.toString() + "\n"; //append the transaction
        }
        //return the report
        return report;
    }
    
}
