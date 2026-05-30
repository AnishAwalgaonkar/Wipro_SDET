package sdet_selenium_day_12;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class EmployeeApp {

    static String FILE = "employees.ser";

    public static void saveEmployee(Employee emp) throws IOException {
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE));
        o.writeObject(emp);
        o.close();
        System.out.println("Employee saved");
    }

    public static void readEmployee() throws IOException, ClassNotFoundException {
        ObjectInputStream i = new ObjectInputStream(new FileInputStream(FILE));
        Employee emp = (Employee) i.readObject();
        i.close();
        System.out.println("Employee Data: " + emp);
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee System ---");
            System.out.println("1. Save Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    saveEmployee(new Employee(id, name, salary));
                    break;

                case 2:
                    readEmployee();
                    break;

                case 3:
                    return;
            }
        }
    }
}