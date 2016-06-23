/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part19;

/**
 *
 * @author Prithpal Sooriya
 */
public class Complex {
    
    //variables
    private double a, b;
    
    //constructor
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    public Complex(double a){
        this.a = a;
        b = 0;
    }
    
    public Complex(){
        this(0,0);
    }
    
    //getters
    public double getRealPart(){
        return a;
    }
    
    public double getImaginaryPart(){
        return b;
    }
    
    /*
    complex-number opterations
    make them static, so then we can specify the 2 Complex objects
    they will all return a Complex object back
    */
    
    //a + bi + c + di = (a + c) + (b + d)i
    public static Complex add(Complex c1, Complex c2){
        double realPart = c1.getRealPart() + c2.getRealPart();
        double imaginaryPart = c1.getImaginaryPart() + c2.getImaginaryPart();
        return new Complex(realPart, imaginaryPart);
    }
    
    //a + bi - (c + di) = (a - c) + (b - d)
    public static Complex subtract(Complex c1, Complex c2){
        double realPart = c1.getRealPart() - c2.getRealPart();
        double imaginaryPart = c1.getImaginaryPart() - c2.getImaginaryPart();
        return new Complex(realPart, imaginaryPart);
    }
    
    //(a + bi) * (c + di) = (ac - bd) + (bc + ad)i
    public static Complex multiply(Complex c1, Complex c2){
        double a = c1.getRealPart();
        double b = c1.getImaginaryPart();
        double c = c2.getRealPart();
        double d = c2.getImaginaryPart();
        
        double realPart = (a*c) - (b*d);
        double imaginaryPart = (b*c) + (a*d);
        return new Complex(realPart, imaginaryPart);
    }
    
    //(a + bi) / (c + di) = (ac + bd)/(c^2 + d^2) + (bc - ad)i/(c^2 + d^2)
    public static Complex divide(Complex c1, Complex c2){
        double a = c1.getRealPart();
        double b = c1.getImaginaryPart();
        double c = c2.getRealPart();
        double d = c2.getImaginaryPart();
        
        double realPartNumerator = (a*c) + (b*d);
        double imaginaryPartNumerator = (b*c) - (a*d);
        double denominator = (c*c) + (d*d);
        
        double realPart = realPartNumerator / denominator;
        double imaginaryPart = imaginaryPartNumerator / denominator;
        return new Complex(realPart, imaginaryPart);
    }
    
    //|a + bi| = sqrt(a^2 + b^2)
    public static double abs(Complex c1){
        double a = c1.getRealPart();
        double b = c1.getImaginaryPart();
        return Math.sqrt((a*a) + (b*b));
    }
    
    //toString method
    @Override
    public String toString(){
        return "(" + a + " + " + b + "i)";
    }
    
}
