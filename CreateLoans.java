import java.util.Scanner;

// fields
abstract class Loan implements LoanConstants {
    private int loanNumber;
    private String customerLastName;
    private double loanAmount;
    protected double interestRate;
    private int term;
	
    // constructor
    public Loan(int loanNumber, String customerLastName, double loanAmount, int term) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        this.loanAmount = loanAmount;
        this.term = term;

        // Check if loan amount exceeds the maximum allowed
        if (loanAmount > MAX_LOAN_AMOUNT) {
        	// Set loan amount to the maximum allowed
            this.loanAmount = MAX_LOAN_AMOUNT;
        } else {
        	// Use the provided loan amount
            this.loanAmount = loanAmount;
        }

        // Check if term is valid and set to short-term if not
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
        	// Use the provided term
        	this.term = term;
        } else {
        	// Set term to the default short-term
            this.term = SHORT_TERM;
        }

        this.interestRate = 0; // Default value, will be set by subclasses
    }

    // Abstract method to set interest rate
    public abstract void setInterestRate(double primeInterestRate);

    // Calculate total amount owed
    public double calculateTotalAmountOwed() {
    	double totalAmountOwed = loanAmount + (loanAmount * (interestRate / 100) * term);
        return totalAmountOwed;
    }

    @Override
    public String toString() {
        return "Loan Number: " + loanNumber +
                "\nCustomer Last Name: " + customerLastName +
                "\nLoan Amount: $" + loanAmount +
                "\nInterest Rate: " + (interestRate) + "%" +
                "\nTerm: " + term + " years";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Loan)) {
            return false;
        }
        Loan otherLoan = (Loan) obj;
        return loanNumber == otherLoan.loanNumber;
    }
}

//Interface defining loan constants
interface LoanConstants {
    int SHORT_TERM = 3;
    int MEDIUM_TERM = 7;
    int LONG_TERM = 15;
    String COMPANY_NAME = "JPL Loan Company";
    double MAX_LOAN_AMOUNT = 50000;
}

//BusinessLoan class, extends Loan
class BusinessLoan extends Loan {
    public BusinessLoan(int loanNumber, String customerLastName, double loanAmount, int term) {
        super(loanNumber, customerLastName, loanAmount, term);
    }

    // Set interest rate for business loan
    @Override
    public void setInterestRate(double primeInterestRate) {
        super.interestRate = primeInterestRate + 3.2;
    }
}

//PersonalLoan class, extends Loan
class PersonalLoan extends Loan {
    public PersonalLoan(int loanNumber, String customerLastName, double loanAmount, int term) {
        super(loanNumber, customerLastName, loanAmount, term);
    }

    // Set interest rate for personal loan
    @Override
    public void setInterestRate(double primeInterestRate) {
        super.interestRate = primeInterestRate + 2.7;
    }
}

//Main class to create loans
public class CreateLoans {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        	// Prime interest rate variable
        	double primeInterestRate = 0;

        	// Read prime interest rate from user
			System.out.print("Enter the current prime interest rate: ");
			primeInterestRate = scanner.nextDouble();

			// Array to hold loans
			Loan[] loans = new Loan[5];

			for (int i = 0; i < 5; i++) {
			    System.out.println("\nLoan #" + (i + 1));
			    // Read loan type from user
			    System.out.print("Enter the loan type (B for Business, P for Personal): ");
			    String loanType = scanner.next();

			    // Read customer's last name from user
			    System.out.print("Enter the customer's last name: ");
			    String customerLastName = scanner.next();

			    // Read loan amount from user
			    System.out.print("Enter the loan amount: ");
			    double loanAmount = scanner.nextDouble();

			    // Read loan term from user
			    System.out.print("Enter the loan term (3 for short-term, 7 for medium-term, 15 for long-term): ");
			    int term = scanner.nextInt();

			    if (loanType.equalsIgnoreCase("B")) {
			    	// Set interest rate for business loan
			        BusinessLoan businessLoan = new BusinessLoan(i + 1, customerLastName, loanAmount, term);
			        businessLoan.setInterestRate(primeInterestRate);
			     
			        // Store business loan in the array
			        loans[i] = businessLoan;
			    } else if (loanType.equalsIgnoreCase("P")) {
			    	// Set interest rate for personal loan
			        PersonalLoan personalLoan = new PersonalLoan(i + 1, customerLastName, loanAmount, term);
			        personalLoan.setInterestRate(primeInterestRate);
			        // Store personal loan in the array
			        loans[i] = personalLoan;
			    }
			}
			
			// Print loan details
			System.out.println("\nLOAN DETAILS:\n");
			for (Loan loan : loans) {
			    System.out.println(loan);
			    System.out.printf("Total Amount Owed: $%.2f%n", loan.calculateTotalAmountOwed()); // Format to 2 decimal places
			    System.out.println("----------------------------------------");
			}
		}
   }
}
