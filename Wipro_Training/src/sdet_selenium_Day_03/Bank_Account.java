package sdet_selenium_Day_03;

class Account {
    // 1. Private Fields: Hides the data from direct access (encapsulation)
    private String accountNumber;
    private double balance;

    // Constructor to initialize
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        // Basic security: Don't allow negative opening balance
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // 2. Controlled Access: Public Getter (Read-only)
    public double getBalance() {
        return balance;
    }

    // 3. Secure Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount! Amount must be positive.");
        }
    }

    // 4. Secure Withdrawal Method
    public void withdraw(double amount) {
        // Validation: Positive amount and sufficient funds
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: ₹" + amount);
        } else if (amount > balance) {
            System.out.println("Transaction Failed: Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}

public class Bank_Account {
    public static void main(String[] args) {
        Account myAccount = new Account("123456789", 1000.0);

        // This would fail to compile because balance is private
        // myAccount.balance = 100000; 

        // Controlled interactions
        myAccount.deposit(500.0);       // Success
        myAccount.withdraw(200.0);      // Success
        myAccount.withdraw(2000.0);     // Fails (Insufficient funds)
        myAccount.deposit(-100.0);      // Fails (Invalid amount)

        System.out.println("Final Balance: ₹" + myAccount.getBalance());
    }
}

