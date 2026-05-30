package day_02;
import java.util.Scanner;
public class Grades {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter grade: ");
		char grade = sc.next().charAt(0);

		switch (grade) {
		    case 'A': System.out.println("Excellent"); break;
		    case 'B': System.out.println("Good"); break;
		    case 'C': System.out.println("Average"); break;
		    case 'D': System.out.println("Below Average"); break;
		    case 'F': System.out.println("Fail"); break;
		    default: System.out.println("Invalid Grade");
		}

	}

}
