package day_06;
import java.util.Scanner;
class CompareStrings {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter first string: ");
        String s1 = sc.next();
        System.out.print("Enter second string: ");
        String s2 = sc.next();
        if (s1.equals(s2))
            System.out.println("Strings are equal");
        else
            System.out.println("Not equal");
        sc.close();
    }
}