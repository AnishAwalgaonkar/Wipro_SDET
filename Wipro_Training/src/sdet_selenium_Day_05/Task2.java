package sdet_selenium_Day_05;
class Payment1 {

    public final void processPayment(double amount, String type) {

        if (type.equals("credit")) {
            credit(amount);
        } else if (type.equals("debit")) {
            debit(amount);
        } else {
            System.out.println("Invalid transaction type");
            return;
        }

        System.out.println("Transaction Successful");
    }
    
    public void credit(double amount) {
        System.out.println("Crediting amount: " + amount);
    }

    public void debit(double amount) {
        System.out.println("Debiting amount: " + amount);
    }
}

class UpiPayment extends Payment1 {

    public void validate() {
        System.out.println("Validating UPI...");
    }

    public void credit(double amount) {
        System.out.println("UPI Credit: " + amount);
    }

    public void debit(double amount) {
        System.out.println("UPI Debit: " + amount);
    }
}

public class Task2 {
    public static void main(String[] args) {

        Payment1 p = new UpiPayment();

        p.processPayment(2000, "credit");
        p.processPayment(1500, "debit");
    }
}