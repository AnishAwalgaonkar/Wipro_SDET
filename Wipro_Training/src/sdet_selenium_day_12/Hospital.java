package sdet_selenium_day_12;

import java.io.*;
import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String illness;

    public Patient(int id, String name, int age, String illness) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.illness = illness;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + illness;
    }
}

public class Hospital{

    static Scanner sc = new Scanner(System.in);

    public static void savePatient(Patient p) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("patients.txt", true));
        bw.write(p.toString());
        bw.newLine();
        bw.close();
        System.out.println("Patient record saved");
    }

    public static void viewPatients() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
        String line;

        System.out.println("\nPatient Records:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void generateReport(Patient p, String diagnosis, String treatment) throws IOException {
        String fileName = "report_" + p.id + ".txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write("---- Medical Report ----");
        bw.newLine();
        bw.write("Patient ID: " + p.id);
        bw.newLine();
        bw.write("Name: " + p.name);
        bw.newLine();
        bw.write("Age: " + p.age);
        bw.newLine();
        bw.write("Illness: " + p.illness);
        bw.newLine();
        bw.write("Diagnosis: " + diagnosis);
        bw.newLine();
        bw.write("Treatment: " + treatment);
        bw.newLine();

        bw.close();
        System.out.println("Report generated: " + fileName);
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\n--- Hospital IO System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Illness: ");
                    String illness = sc.nextLine();

                    Patient p = new Patient(id, name, age, illness);
                    savePatient(p);
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Illness: ");
                    illness = sc.nextLine();

                    Patient patient = new Patient(id, name, age, illness);

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = sc.nextLine();

                    System.out.print("Enter Treatment: ");
                    String treatment = sc.nextLine();

                    generateReport(patient, diagnosis, treatment);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
