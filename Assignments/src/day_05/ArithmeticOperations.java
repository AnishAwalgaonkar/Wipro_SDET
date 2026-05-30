package day_05;
public class ArithmeticOperations {
	public static int add(int a, int b) {
		return a+b;
	}
	public static int sub(int a, int b) {
		if(a > b) {
			return a-b;
		}
		else {
			return b-a;
		}
	}
	public static void main(String[] args) {
		int x = 15;
		int y = 20;
		
		System.out.println("Addition of two numbers is: " + add(x,y));
		System.out.println("Subtraction of two numbers is: " + sub(x,y));
	}
}
