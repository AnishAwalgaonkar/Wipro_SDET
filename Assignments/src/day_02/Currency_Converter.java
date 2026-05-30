package day_02;

import java.util.Scanner;

public class Currency_Converter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. USD. ");
		System.out.println("2. EUR. ");
		System.out.println("3. GBP. ");
        System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		System.out.print("Enter amount: ");
		double amount = sc.nextDouble();

		switch (choice) {
		    case 1: System.out.println("USD: " + (amount / 83)); break;
		    case 2: System.out.println("EUR: " + (amount / 90)); break;
		    case 3: System.out.println("GBP: " + (amount / 100)); break;
		    default: System.out.println("Invalid Choice");
		}

	}

}



