package day_02;
import java.util.Scanner;
public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = sc.nextInt();
		int a = 0, b = 1, i = 1;
		while (i <= n) {
		    System.out.print(a + " ");
		    int next = a + b;
		    a = b;
		    b = next;
		    i++;
		}
	}
}
