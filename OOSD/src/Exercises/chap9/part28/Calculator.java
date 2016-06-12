/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap9.part28;

/**
 *
 * @author Prithpal Sooriya
 */
public class Calculator {
    
    public static void main(String[] args) {
        //we will be using the command line for the ==calculator
        
        //check if the args input is valid (only 1 args)
        if(args.length != 1){
            System.out.println("Enter 1 argument in form:"
                    + "\n<Operand> <Operator> <Operand>");
            System.exit(1);
        }
        
        //variable to store the operation
        double result = 0;
        
        //split the input, remember we want to split on as many spaces in between
        String tokens[] = args[0].replaceAll("\"", "").split("\\s");
        
        //determain the operator and perform the calculation
        switch(tokens[1]){ //operator is in between the 2 operants
            case "+":
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[3]);
                break;
            case "-":
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[3]);
                break;
            case "*":
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[3]);
                break;
            case "/":
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[3]);
                break;
        }
        
        //display the result
        System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " = " + result);
        
    }
    
}
