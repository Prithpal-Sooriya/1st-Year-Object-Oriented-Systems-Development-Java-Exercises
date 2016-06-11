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
public class Stock {
    
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    //constuctor

    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    //return the percentage
    public double getChangePercent(){
        //percentage calc = (current - prev)/prev * 100
        double percentage = ((currentPrice - previousClosingPrice)/ previousClosingPrice) * 100;
        return percentage;
    }
    
    //getters and setters for the previousClosingPrice and currentPrice
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    
    
}
