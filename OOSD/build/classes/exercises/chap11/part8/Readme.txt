new Account class

use the Account class in 8.7

add a new data field called String name;
add a new data field called interestRate;
add a new constructor that contains params: name, id, balance, interestRate
add new data field ArrayList<Transaction> transactions; //store all transactions

The Transaction class:

Transaction
=============
-java.util.Date date
-char type

-double amount
-double balance
-String description
==============
+Transaction(char type, double amount, double balance, String description)
+set and get methods for all data fields

Modify the withdraw and deposit method to add a transaction to the transactions array
All other properties and methods are the same

Write a program that creates an account with:
annual interest 1.5%
balance 1000
id 1122
name George
deposit 30, 40, 50 to the account
withdraw 5, 4, 2 from the account

Print an account summary that shows account holders name, interest rate, balance, and all transactions