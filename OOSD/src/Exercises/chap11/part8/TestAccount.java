/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap11.part8;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestAccount {
    
    //main method to test the transaction
    public static void main(String[] args) {
        
        //create the account
        Account acc = new Account("George", 1122, 1000, 1.5);
        
        //deposit
        acc.diposit(30);
        acc.diposit(40);
        acc.diposit(50);
        //withdraw
        acc.withdraw(5);
        acc.withdraw(4);
        acc.withdraw(2);
        
        //print account report
        System.out.println(acc.printTransations());
        
    }
    
}
