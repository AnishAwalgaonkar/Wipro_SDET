package day_02;

import java.util.Scanner;

public class Menu_Driven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter item number (1-4): ");
		int item = sc.nextInt();

		switch (item) {
		    case 1: System.out.println("Burger - 100"); break;
		    case 2: System.out.println("Pizza - 200"); break;
		    case 3: System.out.println("Pasta - 150"); break;
		    case 4: System.out.println("Sandwich - 80"); break;
		    default: System.out.println("Invalid Item");
		}

	}

}
