/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part27;

import javax.swing.JOptionPane;

/**
 *
 * @author ps2-sooriya
 */
public class FinancialApplication_SimpleInterest {
  public static void main(String[] args) {
    /*(financial application: simple interest)
    rewrite chap 2 exercise 9 using gui input and output
    */
    
    //get input from joption pane and asve it into string
    //input for principle amount
    String principleAmountString = JOptionPane.showInputDialog(
      null,
      "Enter the Principle Amount:",
      "Calculate Simple Interest",
      JOptionPane.QUESTION_MESSAGE);
    //input for rate of interest
    String rateOfInterestString = JOptionPane.showInputDialog(
      null,
      "Enter the Rate of Interest:",
      "Calculate Simple Interest",
      JOptionPane.QUESTION_MESSAGE);
    //input the time of duration
    String timeDurationString = JOptionPane.showInputDialog(null,
      "Enter the Time Duration:",
      "Calculate Simple Interest",
      JOptionPane.QUESTION_MESSAGE);
    
    //convert inputs into doubles
    double principleAmount, rateOfInterest, timeDuration;
    principleAmount = Double.valueOf(principleAmountString);
    rateOfInterest = Double.valueOf(rateOfInterestString);
    timeDuration = Double.valueOf(timeDurationString);
    
    //calculate
    double simpleInterest = (principleAmount * rateOfInterest * timeDuration)/ 100;
    
    //output
    JOptionPane.showMessageDialog(
      null,
      "For Principle Amount:" + principleAmount + " with Rate of Interest:" + rateOfInterest + " and Time Duration:" + timeDuration + "\n"
      + "The Simple Interest is:" + simpleInterest,
      "Calculate Simple Interest",
      JOptionPane.PLAIN_MESSAGE);
  }
}
