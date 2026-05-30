package sdet_selenium_day_11;

import java.util.*;

public class MaxFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("String is empty.");
            return;
        }

        HashMap<Character, Integer> counts = new HashMap<>();
        
        for (char c : input.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        char maxChar = ' ';
        int maxCount = -1;
        
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println("The element with maximum frequency is '" + maxChar + "' appearing " + maxCount + " times.");
        scanner.close();
    }
}

