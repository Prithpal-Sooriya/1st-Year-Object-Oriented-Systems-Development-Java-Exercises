/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_11;

import Exercises.chap21.examples.listing21_10.GenericMatrix;

/**
 *
 * @author Prithpal Sooriya
 */

//extends GenericMatrix with generic E as Integer
public class IntegerMatrix extends GenericMatrix<Integer>{

    //override method from GenericMatrix for add
    @Override
    protected Integer add(Integer matrixItem1, Integer matrixItem2) {
        return matrixItem1 + matrixItem2;
    }

    //override method from GenericMatrix for multiply
    @Override
    protected Integer multiply(Integer matrixItem1, Integer matrixItem2) {
        return matrixItem1 * matrixItem2;
    }

    //override method from GenericMatrix for zero
    @Override
    protected Integer zero() {
        return 0;
    }
}
