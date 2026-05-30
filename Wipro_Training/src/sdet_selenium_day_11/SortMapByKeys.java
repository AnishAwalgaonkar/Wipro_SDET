package sdet_selenium_day_11;
import java.util.*;
public class SortMapByKeys {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Zebra", 10);
        unsortedMap.put("Apple", 50);
        unsortedMap.put("Mango", 30);
        unsortedMap.put("Banana", 20);

        TreeMap<String, Integer> sortedMap = new TreeMap<>(unsortedMap);

        System.out.println("Sorted Map by Keys:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

