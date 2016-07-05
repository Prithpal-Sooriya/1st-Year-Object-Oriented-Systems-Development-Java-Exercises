/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_10;

import sun.invoke.util.ValueConversions;

/**
 *
 * @author Prithpal Sooriya
 */
//abstract class --> dont want this to be called with "new"
//<E extends Number> to this has to be created with a subclass of number
public abstract class GenericMatrix<E extends Number> {

    //abstract method to add 2 matricies
    protected abstract E add(E matrixItem1, E matrixItem2);

    //abstract method to multiply 2 matricies
    protected abstract E multiply(E matrixItem1, E matrixItem2);

    //abstract method for setting zero for matrix
    protected abstract E zero();

    //method to add 2 matricies
    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        //check bounds of the matricies
        //valid matricies: if the rows and columns length are the same, or if the number of rows are the same
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            //the matricies are not the same size
            throw new RuntimeException("The matricies do not have the same size");
        }

        //create a matrix for the result
        //cannot do new E, one of the restrictions for generics
        //so use the E extends number, so can use "new Number"
        //the resulting matrix will always have same rows and columns as the the original matricies
        E[][] result = (E[][]) new Number[matrix1.length][matrix1[0].length];

        /*
        addition of matricies:
        each element in the result matrix = same position in matrix1, same position in matrix 2
        
        2 FOR loops
        outer FOR loop, loop through columns
        inner FOR loop, loop through rows
         */
        //perform the addition
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }

        return result;
    }

    //method to multiply 2 matricies
    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        //check bounds
        //valid matricies, numbers of rows in matrix1 is the same size as number of columns in matrix2
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("The matricies do not have compatible sizes");
        }

        //create the resulting matrix
        //need to cast the "new Number[][]" as "E[][]"
        E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];

        //perform the multiplication
        //outer loop to choose item in column
        for (int i = 0; i < result.length; i++) {
            //inner loop to choose item in row
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero(); //"zero the item"

                //another FOR loop to perform multiplication
                //will loop through the size of number of rows in matrix1
                for (int k = 0; k < matrix1[0].length; k++) {

                    //multiplication: result + (matrix1 * matrix2 --> multiply all columns(_) of matrix1 to corrisponding rows (|) in matrix2)
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));

                }
            }
        }

        //return result
        return result;
    }

    //method to print matricies, the operator and their operation result
    //cannot use E[][] as this is a static method
    public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op) {
        //outer FOR loop for the columns of matrix1
        for (int i = 0; i < m1.length; i++) {
            
            //print row
            printRow(m1, i);
            
            
            //format if operand should be shown
            if (i == m1.length / 2) {
                System.out.print("" + op + "   ");
            } else {
                System.out.print("    ");
            }

            //For loop for matrix2
            printRow(m2, i);

            //format if '=' should be shown
            if (i == m1.length / 2) {
                System.out.print("=   ");
            } else {
                System.out.print("    ");
            }

            //for loop to show matrix3 (the result)
            printRow(m3, i);
            
            //print new line, for start of new row
            System.out.println();
        }
    }
    
    private static void printRow(Number[][] matrixToPrint, int indexOfRowToPrint){
        for (int i = 0; i < matrixToPrint[indexOfRowToPrint].length; i++) {
            //System.out.print(" " + matrixToPrint[indexOfRowToPrint][i] + " ");
            System.out.format("%-4s", String.valueOf(matrixToPrint[indexOfRowToPrint][i]));
        }
    }
}
