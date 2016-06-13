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
        //String tokens[] = args[0].replaceAll("[ ]*\\s*", " ").split(" ");
        //System.out.println(args[0].replaceAll("\\s", "").replaceAll("", " ").trim().replaceAll("\\s", "x"));
        /*
        First, if there is spaces inbetween operands, remove all spaces
        Second since there are no spaces in argument, add some spaces in between each character
        and remove the end spaces with .trim, then split with the \\s (whitespace)
        */
        String tokens[] = args[0].replaceAll("\\s", "").replaceAll("", " ").trim().split("\\s");
//        for (int i = 0; i < tokens.length; i++) {
//            String token = tokens[i];
//            System.out.println(token);
//        }
        
        //determain the operator and perform the calculation
        switch(tokens[1]){ //operator is in between the 2 operants
            case "+":
                result = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
                break;
            case "-":
                result = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
                break;
            case "*":
                result = Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
                break;
            case "/":
                result = Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
                break;
        }
        
        //display the result
        System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " = " + result);
        
    }
    
}
