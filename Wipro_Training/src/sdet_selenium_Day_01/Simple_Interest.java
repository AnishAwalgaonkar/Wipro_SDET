package sdet_selenium_Day_01;

import java.util.Scanner;

public class Simple_Interest {

	public static void main(String[] args) {

		int principal = 10000;

		float rate = 8.5f;

		int time = 5;
		
		float SI = (principal * rate * time) / 100;
		
		System.out.println("Your simple interest is: " + SI);
	}

}
