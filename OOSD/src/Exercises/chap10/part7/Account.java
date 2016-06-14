/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part7;

import Exercises.chap8.part7.*;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Prithpal Sooriya
 */
public class Account {

    private int id;
    private double balance;
    private Calendar dateCreated;

    public Account() { //no args but still have to set current date
        dateCreated = Calendar.getInstance(); //sets the dateCreated to the current time
    }

    public Account(int id, double InitialBalance){
        this.id = id;
        balance = InitialBalance;
        dateCreated = Calendar.getInstance(); //sets the dateCreated to the current time
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

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return (annualInterestRate / 100) / 12; //div 100 as is percentage
    }
    
    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }
    
    public void withdraw(double amount){
        balance = balance - amount;
    }
    
    public void diposit(double amount){
        balance = balance + amount;
    }
    
}
