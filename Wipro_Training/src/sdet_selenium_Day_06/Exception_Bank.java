package sdet_selenium_Day_06;

import java.util.Scanner;

class ATM{
	private final int original_pin = 8830;

	public void enterPin(int pin) throws Exception{
		if(original_pin != pin) {
			throw new Exception("Invalid Pin");
		}
		System.out.println("The pin is correct.");
	}
	
	public void transaction() {
		System.out.println("Transaction is completed.");
	}
}


public class Exception_Bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ATM atm = new ATM();
		
		try {
			System.out.println("Card is inserted.");
			System.out.print("Enter your pin: ");
			int user_pin = sc.nextInt();
			atm.enterPin(user_pin);
			atm.transaction();
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		finally {
			System.out.println("Transaction logged. Thank you!!");
			sc.close();
		}
	}

}
