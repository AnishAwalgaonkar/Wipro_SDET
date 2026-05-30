package sdet_selenium_Day_05;

interface Payment{
	
	void processPayment(double amount);
	
	default void receipt(double amount) {
		System.out.println("This is the recipt of your payment with amount: " + amount);
	}
}

class CreditCardPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Paid using Credit Card");
        receipt(amount);
    }
}

class UPIPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Paid using UPI");
        receipt(amount);
    }
}

public class PaymentSystem {

	public static void main(String[] args) {
		Payment p1 = new CreditCardPayment();
		p1.processPayment(250);
		
		Payment p2 = new UPIPayment();
		p2.processPayment(250);

	}

}
