/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

/**
 *
 * @author ps2-sooriya
 */

//redo this --> cant seem to understand how to do it
public class ComputeComissions11 {
  public static void main(String[] args) {
    /*
    financial application: compute commissions
    write method that computes commisions of exersice 4.39
    the header of the method: computeCommission(double salesAmount)
    display in a table
    */
    //salery consists of base salery and commission
    double baseSalery = 5000.00;
    
  }
  
  public static double computeCommission(double salesAmount){
    //find minimum amount of sales to generate in order to make $30 000
    if(salesAmount > 0.00 && salesAmount <= 5000.00){
      //8 percent
      return (salesAmount * 0.05);
    }
    else if(salesAmount > 5000.00 && salesAmount <= 10000.00){
      //10 percent
      return (salesAmount * 0.10);
    }
    else if(salesAmount > 10000.00){
      //12 percent
      return (salesAmount * 0.12);
    }
    return 0;
  }
}
