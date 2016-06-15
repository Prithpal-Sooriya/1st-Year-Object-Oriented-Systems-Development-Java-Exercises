/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part8;

import java.util.Date;

/**
 *
 * @author Prithpal Sooriya
 */
public class Transaction {
    
    private java.util.Date date;
    private char type;
    
    private double amount;
    private double balance;
    private String description;
    
    //constructor
    public Transaction(char type, double amount, double balance, String description){
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }
    
    //setters and getter methods

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    //to string method to pass back the data fields=
    @Override
    public String toString() {
        return "Transaction{" + "type=" + type + ", amount=" + amount + ", balance=" + balance + ", description=" + description + '}';
    }
    
}
