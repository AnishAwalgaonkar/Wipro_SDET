package day_02;

import java.util.Scanner;

public class User_Role_Access {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Admin ");
		System.out.println("2. User ");
		System.out.println("3. Guest ");
		System.out.print("Who are you? ");
		String role = sc.next();

		switch (role) {
		    case "Admin": System.out.println("Full Access"); break;
		    case "User": System.out.println("Limited Access"); break;
		    case "Guest": System.out.println("View Only"); break;
		    default: System.out.println("Invalid Role");
		}

	}

}
