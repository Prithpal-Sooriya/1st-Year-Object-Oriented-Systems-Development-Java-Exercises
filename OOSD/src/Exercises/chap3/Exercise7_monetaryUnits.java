/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap3;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class Exercise7_monetaryUnits {
    //vars we will use
    public static int remainingAmount, numberOfPounds, numberOf50
            , numberOf20, numberOf10, numberOf5, numberOf2, numberOf1;
    
    public static void main(String[] args) {
        /*
        Fincancial application: monitary units
        change computeChange.java to display nonzero demonations only
        single words for single units (1 penny, or 34 pennies)
        */
        //scanner for input
        Scanner scan = new Scanner(System.in);
        
        //recieve amount
        System.out.println("Enter an amount, e.g. 11.56");
        double amount = scan.nextDouble();
        
        //calc money
        calculateMoney(amount);
        
        //output
        System.out.println("Your amount " + amount + " consists of:");
        System.out.format("\t%d pound%s\n", numberOfPounds, singularWords(numberOfPounds));
        System.out.format("\t%d 50p%s\n", numberOf50, singularWords(numberOf50));
        System.out.format("\t%d 20p%s\n", numberOf20, singularWords(numberOf20));
        System.out.format("\t%d 10p%s\n", numberOf10, singularWords(numberOf10));
        System.out.format("\t%d 5p%s\n", numberOf5, singularWords(numberOf5));
        System.out.format("\t%d 2p%s\n", numberOf2, singularWords(numberOf2));
        System.out.format("\t%d 1p%s\n", numberOf1, singularWords(numberOf1));
        
    }
    //calculate change
    private static void calculateMoney(double a){
        remainingAmount = (int) (a * 100);
        
        //find number of pounds
         numberOfPounds = remainingAmount / 100;
        remainingAmount %= 100;
        
        //find number of 50 pence
         numberOf50 = remainingAmount / 50;
        remainingAmount %= 50;
        
        //find number of 20 pence
         numberOf20 = remainingAmount / 20;
        remainingAmount %= 20;
        
        //find number of 10 pence
         numberOf10 = remainingAmount / 10;
        remainingAmount %= 10;
        
        //find number of 5 pence
        numberOf5 = remainingAmount / 5;
        remainingAmount %= 5;
        
        //find number of 2 pence
         numberOf2 = remainingAmount / 2;
        remainingAmount %= 2;
        
        //find number of pence
         numberOf1 = remainingAmount;
    }
    private static String singularWords(int i){
        if(i > 1){
            return "s";
        }
        else{
            return "";
        }
    }
}
