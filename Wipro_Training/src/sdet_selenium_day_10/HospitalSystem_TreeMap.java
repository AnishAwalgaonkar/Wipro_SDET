package sdet_selenium_day_10;

import java.util.*;

class Patient {
    int id;
    String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class HospitalSystem_TreeMap{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Patient> map = new TreeMap<>();

        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Get Patient");
            System.out.println("4. Remove Patient");
            System.out.println("5. List All Patients");
            System.out.println("6. Check Patient Exists");
            System.out.println("7. Count Patients");
            System.out.println("8. Clear System");
            System.out.println("9. Exit");	         
	         System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (map.containsKey(id)) {
                        System.out.println("❌ Patient already exists!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    map.put(id, new Patient(id, name));
                    System.out.println("Patient added");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    if (!map.containsKey(id)) {
                        System.out.println("❌ Not found");
                        break;
                    }

                    System.out.print("Enter new name: ");
                    name = sc.nextLine();
 
                    map.put(id, new Patient(id, name));
                    System.out.println("Updated");
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    System.out.println(map.getOrDefault(id, null));
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    map.remove(id);
                    break;

                case 5:
                    map.forEach((k, v) -> System.out.println(v));
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    System.out.println(map.containsKey(id) ? "Exists" : "Not Found");
                    break;

                case 7:
                    System.out.println("Total: " + map.size());
                    break;

                case 8:
                    map.clear();
                    break;

                case 9:
                    sc.close();
                    return;
            }
        }
    }
}