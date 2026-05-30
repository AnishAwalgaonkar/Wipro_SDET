package day_02;
import java.util.Scanner;
public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		int i = 2;
		boolean isPrime = true;
		while (i <= num / 2) {
		    if (num % i == 0) {
		        isPrime = false;
		        break;
		    }
		    i++;
		}
		if (isPrime && num > 1)
		    System.out.println("Prime");
		else
		    System.out.println("Not Prime");
	}
}
