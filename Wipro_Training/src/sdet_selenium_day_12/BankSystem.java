package sdet_selenium_day_12;

import java.io.*;
import java.util.Scanner;

public class BankSystem {
    static String accFile = "acc.txt";
    static String logFile = "logs.txt";

    public static void saveAccount(String name, double bal) throws IOException {
        FileWriter out = new FileWriter(accFile);
        out.write(name + "\n" + bal);
        out.close();
    }

    public static void addLog(String type, double amt) throws IOException {
        FileWriter out = new FileWriter(logFile, true); 
        out.write(type + ": ₹" + amt + "\n");
        out.close();
    }

    public static void showData() throws IOException {
        Scanner s1 = new Scanner(new File(accFile));
        System.out.println("User: " + s1.nextLine() + " | Bal: " + s1.nextLine());
        
        System.out.println("-- History");
        Scanner s2 = new Scanner(new File(logFile));
        while(s2.hasNextLine()) System.out.println(s2.nextLine());
    }

    public static void main(String[] args) throws IOException {
        saveAccount("Rahul", 1200.0);
        addLog("Deposit", 500.0);
        addLog("Withdraw", 100.0);
        showData();
    }
}
