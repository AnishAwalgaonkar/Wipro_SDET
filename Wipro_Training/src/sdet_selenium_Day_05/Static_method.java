package sdet_selenium_Day_05;

interface Addition{
	static int add(int a, int b) {
		return a + b;
	}
}

public class Static_method {

	public static void main(String[] args) {
		int result = Addition.add(10, 20);
		System.out.println(result);

	}

}
