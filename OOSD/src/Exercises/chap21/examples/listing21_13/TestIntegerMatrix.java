/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_13;

import Exercises.chap21.examples.listing21_10.GenericMatrix;
import Exercises.chap21.examples.listing21_11.IntegerMatrix;

/**
 *
 * @author Prithpal Sooriya
 */
public class TestIntegerMatrix {
    
    //main method to run code
    public static void main(String[] args){
     
        //create 2 2D integer arrays
        Integer[][] m1 = {{1,2,3}, {4,5,6}, {1,1,1}};
        Integer[][] m2 = {{1,1,1}, {2,2,2}, {0,0,0}};
        
        //create an IntegerMatrix
        IntegerMatrix integerMatrix = new IntegerMatrix();
        
        //add the 2 matricies
        System.out.println("m1 + m2:");
        //print the result (static method from GenericMatrix)
        GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
        
        //multiply the 2 matricies
        System.out.println("m1 * m2:");
        //print the result (static method from GenericMatrix)
        GenericMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
    }
    
}
