package sdet_selenium_Day_02;

public class Validation {

	public static void main(String[] args) {
		
        String inputUsername = "admin";
        String inputPassword = "anish@1234";

        String Username = "admin";
        String Password = "anish@123";

        if (inputUsername == Username && inputPassword == Password){
            System.out.println("Login Successful!");
            System.out.println("Welcome, " + inputUsername + ".");
        } else {

            System.out.println("Login Failed!");
            System.out.println("Invalid username or password.");
        }
    }

}
