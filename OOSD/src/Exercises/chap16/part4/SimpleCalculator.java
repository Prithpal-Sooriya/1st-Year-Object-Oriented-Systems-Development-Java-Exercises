/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap16.part4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.text.Format;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Prithpal Sooriya
 */
//extend JFrame to use constuctor to create JFrame and components
public class SimpleCalculator extends JFrame {

    //contstuctor
    public SimpleCalculator() {

        //set the layout for the JFrame to boarder layout
        setLayout(new BorderLayout());

        //create 4 buttons for the calculator --> + - / *
        JButton buttonAdd = new JButton("Add");
        JButton buttonSubtract = new JButton("Subtract");
        JButton buttonMultiply = new JButton("Multiply");
        JButton buttonDivide = new JButton("Divide");

        //create a JPanel to hold to buttons, and add buttons
        JPanel panelButtons = new JPanel(new GridLayout(1, 4));
        panelButtons.add(buttonAdd);
        panelButtons.add(buttonSubtract);
        panelButtons.add(buttonMultiply);
        panelButtons.add(buttonDivide);
        //add the panel to the JFrame (at the bottom)
        add(panelButtons, BorderLayout.SOUTH);

        //panel to hold the numbers and output --> will be grid layout
        JPanel panelNumbers = new JPanel(new GridLayout(1, 3));
        //create the 2 numbers panel that we will use
        final PanelNumber panelNumber1 = new PanelNumber("Number 1");
        final PanelNumber panelNumber2 = new PanelNumber("Number 2");

        JPanel panelResult = new JPanel();
        JLabel labelResult = new JLabel("Result: ");
        final JLabel labelOutput = new JLabel();
        labelOutput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelOutput.setPreferredSize(new Dimension(100, 25));

        //add the labels to the panelResult
        panelResult.add(labelResult);
        panelResult.add(labelOutput);
        //add the other panels into panel numbers, then add to JFrame
        panelNumbers.add(panelNumber1);
        panelNumbers.add(panelNumber2);
        panelNumbers.add(panelResult);
        add(panelNumbers, BorderLayout.NORTH);

        //set the Action Listeners for the buttons
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                double input1 = Double.parseDouble(panelNumber1.getInput());
                double input2 = Double.parseDouble(panelNumber2.getInput());
                labelOutput.setText("" + (input1 + input2));
                } catch(NumberFormatException e){
                    labelOutput.setText("NAN");
                }
            }
        });
        buttonSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                double input1 = Double.parseDouble(panelNumber1.getInput());
                double input2 = Double.parseDouble(panelNumber2.getInput());
                labelOutput.setText("" + (input1 - input2));
                } catch (NumberFormatException e){
                    labelOutput.setText("NAN");
                }
            }
        });
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                double input1 = Double.parseDouble(panelNumber1.getInput());
                double input2 = Double.parseDouble(panelNumber2.getInput());
                labelOutput.setText("" + (input1 * input2));
                } catch (NumberFormatException e){
                    labelOutput.setText("NAN");
                }
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                double input1 = Double.parseDouble(panelNumber1.getInput());
                double input2 = Double.parseDouble(panelNumber2.getInput());
                if(input2 == 0) throw new ArithmeticException();
                labelOutput.setText(String.format("%.2f", (input1 / input2)));
                
                } catch (NumberFormatException e){
                    labelOutput.setText("NAN");
                } catch (ArithmeticException e2) {
                    labelOutput.setText("Cannot divide by 0");
                }
            }
        });
    }

    //inner class to number input, extend JPanel so we can use in JFrame
    private class PanelNumber extends JPanel {

        private String input;
        private final JTextField tfNumber;

        //constuctor
        public PanelNumber(String number) {
            //create the JLabel and JTextField and add them to the JPanel
            JLabel labelNumber = new JLabel(number);
            tfNumber = new JTextField();
            tfNumber.setPreferredSize(new Dimension(100, 25));
            add(labelNumber);
            add(tfNumber);
        }

        //need to get the user input
        public String getInput() {
            return tfNumber.getText();
        }
    }

    //main method to run the code
    public static void main(String[] args) {
        //create the frame and set importand features
        SimpleCalculator frame = new SimpleCalculator();
        frame.setTitle("Simple Calculator");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); //spawn the frame in the middle of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when the frame is closed
        frame.setVisible(true); //show the frame
    }
}
