package sdet_selenium_day_12;

import java.io.*;
import java.util.*;

class FoodApp {

    static Scanner sc = new Scanner(System.in);

    public static void addMenuItem(String item, double price) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("menu.txt", true));
        bw.write(item + "," + price);
        bw.newLine();
        bw.close();
        System.out.println("Menu item added");
    }

    public static void placeOrder(int orderId, String item, int qty) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("orders.txt", true));
        bw.write(orderId + "," + item + "," + qty);
        bw.newLine();
        bw.close();
        System.out.println("Order placed");
    }

    public static void deliveryLog(int orderId, String status) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("delivery.txt", true));
        bw.write(orderId + "," + status);
        bw.newLine();
        bw.close();
        System.out.println("Delivery status updated");
    }

    public static void readFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        System.out.println("\n" + file);
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\n--- Food Delivery App ---");
            System.out.println("1. Add Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Update Delivery");
            System.out.println("4. View Menu");
            System.out.println("5. View Orders");
            System.out.println("6. View Delivery Logs");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Item: ");
                    String item = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    addMenuItem(item, price);
                    break;

                case 2:
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Item: ");
                    item = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    placeOrder(id, item, qty);
                    break;

                case 3:
                    System.out.print("Enter Order ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    deliveryLog(id, status);
                    break;

                case 4:
                    readFile("menu.txt");
                    break;

                case 5:
                    readFile("orders.txt");
                    break;

                case 6:
                    readFile("delivery.txt");
                    break;

                case 7:
                    return;
            }
        }
    }
}