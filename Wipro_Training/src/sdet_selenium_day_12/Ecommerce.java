package sdet_selenium_day_12;

import java.io.*;
import java.util.*;

class Order {
    int orderId;
    String productName;
    int quantity;
    double price;

    public Order(int orderId, String productName, int quantity, double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "ID: " + orderId + "\n" + "productName: " + productName + "\n" + "Quantity: " + quantity + "\n" + "Price: " + price + "\n";
    }
}

public class Ecommerce {

    static Scanner sc = new Scanner(System.in);

    public static void saveOrder(Order order) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("orders.txt", true));
        bw.write(order.toString());
        bw.newLine();
        bw.close();
        System.out.println("Order saved to file");
    }

    public static void generateInvoice(Order order) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("invoices.txt", true));
        bw.write("Order ID: " + order.orderId);
        bw.newLine();
        bw.write("Product: " + order.productName);
        bw.newLine();
        bw.write("Quantity: " + order.quantity);
        bw.newLine();
        bw.write("Total: " + order.getTotal());
        bw.newLine();
        bw.close();
        System.out.println("Invoice generated");
    }

    public static void readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        System.out.println("\n " + fileName + " contents:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\nE-Commerce System");
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. View Invoices");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String product = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    Order order = new Order(id, product, qty, price);

                    saveOrder(order);
                    generateInvoice(order);
                    break;

                case 2:
                    readFile("orders.txt");
                    break;

                case 3:
                    readFile("invoices.txt");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}