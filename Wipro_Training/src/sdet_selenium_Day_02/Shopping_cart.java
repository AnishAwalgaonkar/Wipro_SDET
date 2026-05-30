package sdet_selenium_Day_02;

import java.util.Scanner;

public class Shopping_cart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0;
        double price;

        while (true) {
            System.out.print("Enter item price: ");
            price = sc.nextDouble();

            if (price == 0) {
                break;
            }

            total += price;
        }

        System.out.println("Total amount: " + total);

        sc.close();
    }
}
