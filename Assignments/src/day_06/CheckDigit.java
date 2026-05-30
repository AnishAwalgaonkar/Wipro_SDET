package day_06;
import java.util.Scanner;
class CheckDigit {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter character: ");
        char s = sc.next().charAt(0);
        if (Character.isDigit(s))
            System.out.println("Digit");
        else
            System.out.println("Not Digit");
        sc.close();
    }
}
