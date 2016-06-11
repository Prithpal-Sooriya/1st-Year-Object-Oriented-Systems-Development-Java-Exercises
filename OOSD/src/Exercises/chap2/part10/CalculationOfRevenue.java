/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part10;

import java.util.Scanner;

/**
 *
 * @author ps2-sooriya
 */
public class CalculationOfRevenue {
    public static void main(String[] args) {
        /*calculation of revenue
        company XYZ is split into diff zones (zone1/2/ect)
        write a program that: prompts user to enter totalSales of the company and the salesPercentage of the certral zone in previous year
        and calculate the total revenue earned by the central zone for the company
        */
        
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //total sales of comp
        System.out.println("Enter the total sales of the company:");
        double totalSales = scan.nextDouble();
        //sales percentage of central zone
        System.out.println("Enter the sales percentage of the central zone:");
        double percentageSales = scan.nextDouble();
        //print out central zone sales
        double centralZoneSales = totalSales * percentageSales;
        System.out.println("Central zone sales: " + centralZoneSales);
    }
}
