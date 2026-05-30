package day_02;
import java.util.Scanner;
public class Armstrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		int temp = num, sum = 0;
		while (num != 0) {
		    int digit = num % 10;
		    sum += digit * digit * digit;
		    num /= 10;
		}
		if (sum == temp)
		    System.out.println("Armstrong");
		else
		    System.out.println("Not Armstrong");
	}
}
