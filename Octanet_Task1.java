// ATM MACHINE USING JAVA !!
import java.util.Scanner;

class Octanet_Task1 {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPIN();
    }
}
// defining a class method for the ATM Machine 
class ATM {
    private float balance = 0;
    // Initialize bank balance as 0
    private String transactionHistory = "";
     // Initialise transcation history as zero
    private int PIN = 7890;
    private Scanner scanner = new Scanner(System.in);
    // Scanner object for user input 

    public void checkPIN() {
        System.out.println("Enter your PIN:");
        int enteredPIN = scanner.nextInt();
        if (enteredPIN == PIN) {
            // Check if entered pin matches the stored pin 
            menu();
        } else {
            System.out.println("Invalid PIN. Exiting...");
            // display error message if the pin is stored incorrectly 
        }
    }

    public void menu() {
        int opt;
        do {
            // Display menu options 
            System.out.println("\nEnter Your Choice:");
            System.out.println("1. Account Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. PIN Change");
            System.out.println("5. View Transaction History");
            System.out.println("0. Exit");

            opt = scanner.nextInt();
            // Read users choice 
            switch (opt) {
                case 1:
                    accountBalanceInquiry();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    pinChange();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 0:
                    System.out.println("Exiting ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        } while (opt != 0);

        scanner.close(); // Close the scanner when done
    }

    public void accountBalanceInquiry() {
        System.out.println("Account Balance: " + balance);
        // Display current bank account details
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to Withdraw:");
        float amount = scanner.nextFloat();
        // Read amount to withdraw 
        if (amount > balance) {
            System.out.println("Insufficient Balance");
            // Display mess if withdrawl amount exceeds balance 
        } else {
            balance -= amount;
            System.out.println("Money Withdrawal Successful");
            // Conform withdrawl done Successfull
            transactionHistory += "Withdrawal: " + amount + "\n"; 
            // Record transcation history 
        }
    }

    public void depositMoney() {
        System.out.println("Enter Amount to Deposit:");
        float amount = scanner.nextFloat();
        // Read amount to deposit 
        balance += amount;
        System.out.println("Money Deposited Successfully");
        // Conform successfull deposit 
        transactionHistory += "Deposit: " + amount + "\n";
        // Record transcation in history 
    }

    public void pinChange() {
        System.out.println("Enter new PIN:");
        PIN = scanner.nextInt();
        // Read new pin from the user 
        System.out.println("PIN Changed Successfully");
        // Conform Successfull pin change 
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);
        // Display transcation history 
    }
}