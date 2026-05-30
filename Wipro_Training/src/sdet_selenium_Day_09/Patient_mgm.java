package sdet_selenium_Day_09;

import java.util.*;

class Patient {
    int id;
    String name;
    int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

public class Patient_mgm {
    static ArrayList<Patient> patients = new ArrayList<>();

    // Add patient
    public static void addPatient(int id, String name, int age) {
        patients.add(new Patient(id, name, age));
        System.out.println("Patient added successfully.");
    }

    // View all patients
    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    // Search patient by name
    public static void searchPatient(String name) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    public static void main(String[] args) {
        addPatient(1, "Anish", 22);
        addPatient(2, "Rahul", 30);

        System.out.println("\nAll Patients:");
        viewPatients();

        System.out.println("\nSearch Result:");
        searchPatient("Anish");
    }
}