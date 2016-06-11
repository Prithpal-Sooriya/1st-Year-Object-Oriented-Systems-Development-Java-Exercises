/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part2;

/**
 *
 * @author Prithpal Sooriya
 */

//test the Stock class
public class Test {
    
    public static void main(String[] args) {
        
        Stock stock = new Stock("ORCL", "Oracle Corperation", 34.5, 34.35);
        
        System.out.print("Symbol: " + stock.getSymbol() + ", ");
        System.out.print("Name: " + stock.getName() + ", ");
        System.out.print("Previous Closing Price: " + stock.getPreviousClosingPrice()+ ", ");
        System.out.print("Current Price: " + stock.getCurrentPrice()+ "\n");
        System.out.println("Price-change percentage: " + stock.getChangePercent());
    }
    
}
