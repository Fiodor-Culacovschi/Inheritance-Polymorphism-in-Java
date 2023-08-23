# Inheritance-Polymorphism-in-Java
Loan tracker
#################

This Java application represents a simple Loan Management System that allows users to create and manage different types of loans, including Business Loans and Personal Loans. The system calculates the total amount owed for each loan based on the provided loan amount, interest rate, and loan term. The program uses inheritance and interfaces to achieve the functionality.
###################
Features

1.Allows users to input the current prime interest rate.
2.Enables users to create Business Loans and Personal Loans.
3.Calculates and displays loan details, including loan type, customer's last name, loan amount, interest rate, term, and total amount owed.
4.Utilizes abstract classes and interfaces for structured code organization.
####################

Code Components
Loan (Abstract Class):
Represents a loan and contains fields such as loan number, customer's last name, loan amount, interest rate, and term.
Contains methods to set interest rates and calculate the total amount owed.

LoanConstants (Interface):
.Defines constants related to loan terms, company name, and maximum loan amount.

BusinessLoan (Class):
Extends Loan and represents a Business Loan.
Overrides the setInterestRate method to set interest rates for business loans.

PersonalLoan (Class):
Extends Loan and represents a Personal Loan.
Overrides the setInterestRate method to set interest rates for personal loans.

CreateLoans (Class):
Contains the main method to execute the loan creation and management process.
Reads the prime interest rate from the user and creates an array to hold loans.
Allows users to input loan details and chooses between Business Loans and Personal Loans.
Displays loan details and the total amount owed for each loan.
How to Use
Compile and run the CreateLoans class.
Enter the current prime interest rate.
For each of the five loans, provide the following information:
Loan type (B for Business, P for Personal)
Customer's last name
Loan amount
Loan term (3 for short-term, 7 for medium-term, 15 for long-term)
The program will display the loan details, including the total amount owed for each loan.
Note
###############
This program is a simplified representation and does not include advanced features like error handling, data persistence, or a graphical user interface.
################
Contributors
This code was developed by Fiodor Culacovschi.

