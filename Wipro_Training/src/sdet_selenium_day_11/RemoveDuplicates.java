package sdet_selenium_day_11;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        for (char c : input.toCharArray()) {
            set.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (Character ch : set) {
            result.append(ch);
        }

        System.out.println("Result: " + result.toString());
        scanner.close();
    }
}

