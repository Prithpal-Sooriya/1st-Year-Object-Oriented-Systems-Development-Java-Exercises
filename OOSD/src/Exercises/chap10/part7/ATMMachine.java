/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part7;

import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class ATMMachine {

    //where the main program will start
    public static void main(String[] args) {

        //scanner for input
        Scanner scan = new Scanner(System.in);

        //create the array of accounts
        Account accs[] = new Account[10];
        //populate the accounts
        for (int i = 0; i < accs.length; i++) {
            accs[i] = new Account((i + 1), 100); //id of accounts 1-10
        }

        //boolean to control the main program
        boolean run = true;
        //while loop to control user incorrect input
        while (run) {
            //prompt user to enter ID
            System.out.println("Enter an id (id = 1 to 10)");
            String input = scan.next();

            try {
                //validate that a number has been input
                int intInput = Integer.parseInt(input);
                if (intInput < 1 || intInput > 10) {
                    //not a valid ID
                    System.out.println("This is not a valid id, try again");
                } else {
                    //valid id, so move onto the account transaction
                    accountTransaction(accs, (intInput - 1));
                }
                //now if there is no error, then we can validate it the number is within bounds
            } catch (Exception e) {
                System.out.println("You have not entered a number");
            }
        }

    }

    //where the user with the id can make their transactions
    private static void accountTransaction(Account[] accs, int index) {

        //scanner for input
        Scanner scan = new Scanner(System.in);

        //boolean to run transaction loop
        boolean run = true;
        while (run) {

            //output the options
            System.out.println("Main menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.println("Enter a choice");
            
            String input = scan.next();
            
            //validate that this is a number
            try{
                int intInput = Integer.parseInt(input);
                
                //validate number entered is 1-4
                if(intInput < 1 || intInput > 4){
                    //invalid input
                    System.out.println("This is not a valid number, try again.");
                }
                else{
                    //valid input, so switch case for the different options
                    switch(intInput){
                        case 1:
                            //check balance of the account
                            System.out.println("Your balance is " + accs[index].getBalance());
                            break;
                        case 2:
                            //withdraw
                            System.out.println("Enter an amount to withdraw: ");
                            int withdraw = scan.nextInt();
                            accs[index].withdraw(withdraw);
                            break;
                        case 3:
                            //diposit
                            System.out.println("Enter an amount to diposit: ");
                            int diposit = scan.nextInt();
                            accs[index].diposit(diposit);
                            break;
                        case 4:
                            //exit
                            run = false; //break out of the while loop and the program ends
                            break;
                    }
                }
            }
            catch(Exception e){
                System.out.println("This is not a numbe");
            }

        }

    }

}
