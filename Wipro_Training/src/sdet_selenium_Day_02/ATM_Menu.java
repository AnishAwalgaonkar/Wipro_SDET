package sdet_selenium_Day_02;

import java.util.Scanner;

public class ATM_Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Savings");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Balance is 1000");
            }

        } while (choice != 2);

        System.out.println("Exited");
    }
}
