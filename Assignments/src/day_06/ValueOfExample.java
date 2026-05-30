package day_06;
import java.util.Scanner;
public class ValueOfExample {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter number: ");
        int num = sc.nextInt();
        String str = String.valueOf(num);
        System.out.println("String: " + str);
        sc.close();
    }
}
