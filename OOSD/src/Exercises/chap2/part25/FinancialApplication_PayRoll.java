/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part25;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class FinancialApplication_PayRoll {
    public static void main(String[] args) {
        /*(Financial application: payroll)
        enter input for:
        name (bob)
        hours worked in week (10)
        hourly pay rate (6.75)
        federal tax withholding rate (20%)
        state tax rate (9%)
        */
        
        //Scanner for input
        Scanner scan = new Scanner(System.in);
        
        //variables to use
        String name;
        double hourlyPay, federalTax, stateTax, hoursWorked;
        
        //ouputs and inputs
        System.out.println("Enter employee's name:");
        name = scan.nextLine();
        
        System.out.println("Enter number of hours worked in a week:");
        hoursWorked = scan.nextInt();
        
        System.out.println("Enter hourly pay rate:");
        hourlyPay = scan.nextDouble();
        
        System.out.println("Enter federal tax withholding rate:");
        federalTax = scan.nextDouble();
        
        System.out.println("Enter state tax withholding rate:");
        stateTax = scan.nextDouble();
        
        //calculate gross pay
        double grossPay = hourlyPay * hoursWorked;
        
        //calculate deductions
        double federalWithholding = grossPay * federalTax;
        double stateWithholding = grossPay * stateTax;
            //total deduction
        double totalDeduction = federalWithholding + stateWithholding;
        
        double netPay = grossPay - totalDeduction;
        
        //output
        System.out.println(""
                + "Employee name: " + name + "\n"
                + "Hours Worked: " + hoursWorked + "\n"
                + "Pay Rate: $" + hourlyPay + "\n"
                + "Gross Pay: $" + grossPay + "\n"
                + "Deductions:" + "\n"
                + "\tFederal Withholding (" + (federalTax * 100) + "%): $" + federalWithholding + "\n"
                + "\tState Withholding (" + (stateTax * 100) + "%): $" + stateWithholding + "\n"
                + "\tTotal Deduction: $" + totalDeduction + "\n"
                + "Net Pay:\t$" + netPay);
    }
}
