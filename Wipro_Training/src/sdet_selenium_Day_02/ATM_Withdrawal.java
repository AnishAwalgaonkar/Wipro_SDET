package sdet_selenium_Day_02;

public class ATM_Withdrawal {

	public static void main(String[] args) {
		int balance = 1500;
		int withdraw_amount = 760;
		
		int remaining_balance = balance - withdraw_amount;

		if(withdraw_amount <= balance) {
			System.out.println("Amount " + withdraw_amount + " is debited. Remaining balace is: " + remaining_balance);
		}
		else {
			System.out.println("Insufficient balance");
		}
	}

}
