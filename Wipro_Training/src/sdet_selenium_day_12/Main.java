package sdet_selenium_day_12;

import java.io.*;

class Student implements Serializable {
    public int a;
    public String b;

    public Student(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    public static void main(String[] args) {
        Student object = new Student(1, "Anish");
        String filename = "file.ser";

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        Student object1 = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            object1 = (Student) in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
