/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap2.part26;

import javax.swing.JOptionPane;

/**
 *
 * @author Prithpal
 */
public class UsingGUIInput {

  public static void main(String[] args) {
    /*(using GUI input)
     rewrite chapter 2 exercise 6 (find the reverse of an integer)
     using GUI input and output
     */

    //to get an input from a GUI, we will be using the 'javax.swing' package
    //the input itself will come from the JOptionPane.showInputDialogue --> x = message, y = title (look at params given)
    //save input to string
    String input = JOptionPane.showInputDialog(
      null,
      "Enter an integer", "Reverse your integer!!!",
      JOptionPane.QUESTION_MESSAGE);

    //now we can evaluate the string
    int startingNumber = Integer.parseInt(input);

    //get the reverse
    int reverseAnsInt = Integer.parseInt(intReverser(startingNumber));

    //output the message to the user
    JOptionPane.showMessageDialog(
      null,
      "The reverse of " + startingNumber + " is " + reverseAnsInt,
      "Your Reversed Integer!!!!",
      JOptionPane.PLAIN_MESSAGE);

    //output + 1 to show it is an integer
    JOptionPane.showMessageDialog(
      null,
      "The reverse of " + startingNumber + " is " + (reverseAnsInt + 1),
      "Your Reversed Integer + 1!!!!",
      JOptionPane.PLAIN_MESSAGE);
  }

  //use the function that we created in chapter 2 exercise 6
  private static String intReverser(int i) {
    int digitPlace = i % 10;
    int rest = i / 10;
    if (rest == 0) {
      return String.valueOf(digitPlace);
    } else {
      return "" + digitPlace + intReverser(rest);
    }
  }
}
