/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part16;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Profit {
    public static void main(String[] args) {
        /*calculate profit
        pen company has 30% profit
        profit = retail price * 0.3
        ask user retail price of pen and calc profit
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //output to user the retail price
        System.out.println("Enter the retail price of a pen:");
        double retailPrice = scan.nextDouble();
        double profit = retailPrice * 0.3;
        System.out.format("Amount of profit: $%.2f\n", profit);
    }
}
