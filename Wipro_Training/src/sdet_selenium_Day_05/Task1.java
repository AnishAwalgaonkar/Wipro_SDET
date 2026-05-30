package sdet_selenium_Day_05;

class BankAccount {
	
    private final int accountNumber;
    private String name;
    private double balance;
    BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class Task1 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(12345, "Anish", 5000);
        acc.display();
    }
}
