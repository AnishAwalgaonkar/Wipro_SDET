package day_02;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        
        // Use StringBuilder to reverse the string
        String reverse = new StringBuilder(A).reverse().toString();
        
        // Compare original with reversed
        if (A.equals(reverse)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

