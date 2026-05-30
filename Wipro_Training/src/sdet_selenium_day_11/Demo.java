package sdet_selenium_day_11;

import java.util.*; 

public class Demo
{ 
    public static Character findFirstNonRepeating(String str) { 
        Map<Character, Integer> map = new HashMap<>(); 
 
        for (char ch : str.toCharArray()) { 
            map.put(ch, map.getOrDefault(ch, 0) + 1); 
        } 
 
        for (char ch : str.toCharArray()) { 
            if (map.get(ch) == 1) { 
                return ch; 
            } 
        } 
 
        return null; 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the string: "); 
        String input = sc.next(); 
        System.out.print("The first non repeating character: "); 
        System.out.println(findFirstNonRepeating(input)); 
    } 
}
