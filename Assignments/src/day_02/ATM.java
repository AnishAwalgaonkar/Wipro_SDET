package day_02;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int balance = 10000;
		System.out.println("1. Balance. ");
		System.out.println("2. Updated Balance after deposit. ");
		System.out.println("3. Remaining Balance after withdraw. ");
		System.out.println("4. Exit. ");
        System.out.print("Enter choice: ");

		int choice = sc.nextInt();

		switch (choice) {
		    case 1:
		        System.out.println("Balance: " + balance);
		        break;
		    case 2:
		    	System.out.println("Enter deposit ammount: ");
		        int deposit = sc.nextInt();
		        balance += deposit;
		        System.out.println("Updated Balance: " + balance);
		        break;
		    case 3:
		    	System.out.println("Enter withdraw ammount: ");
		        int withdraw = sc.nextInt();
		        if (withdraw <= balance) {
		            balance -= withdraw;
		            System.out.println("Remaining Balance: " + balance);
		        } else {
		            System.out.println("Insufficient Balance");
		        }
		        break;
		    case 4:
		        System.out.println("Exit");
		        break;
		    default:
		        System.out.println("Invalid Choice");
		}
	}

}
