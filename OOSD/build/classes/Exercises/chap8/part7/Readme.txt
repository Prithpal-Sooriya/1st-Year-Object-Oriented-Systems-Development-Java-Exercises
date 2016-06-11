Create UML and Java class of Account
Account contains:
-int id (default 0)
-double balance (default 0)
-double annualInterestRate stores the current interest rate (default 0)
    this is a percentage (4.5%) so will need to /100
    assume all accounts have the same interest rate
-Date dateCreated stores the date when account was created

-no arg constructor that creates a default account
-constructor that creates an account with specified id and initial balance

-accessor and mutator for id, balance, annualInterestRate
-accessor for dateCreated

-method getMonthlyInterestRate() that returns the monthly interest rate
    monthlyInterestRate = AnnualInterestRate / 12
-method getMonthlyInterest() that returns the monthly interest
    return monthly interest, not interest rate
    monthly interest = balance * monthlyInterestRate.
-method withdraw() that withdraws a specified amount from the account
-method diposit() that diposits a specified amount to the account

Write a test program that creates an Account object with:
-Account ID of 1122
-balance of $20 000
-annual interest rate of 4.5%
-withdraw $2 500
-diposit $3 000
-print balance, monthly interest, and the date when this account was created

