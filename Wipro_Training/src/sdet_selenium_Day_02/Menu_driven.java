package sdet_selenium_Day_02;

public class Menu_driven {

	public static void main(String[] args) {
		
		System.out.println("1. Dosa");
        System.out.println("2. Vadapav");
        System.out.println("3. Coffee");
        System.out.println("4. Exit");
        
		int choice = 2;
		
		System.out.println("Your order is Coffee.");
		
		 switch (choice) {
         case 1:
             System.out.println("You ordered Dosa");
             break;
         case 2:
             System.out.println("You ordered a Vadapav");
             break;
         case 3:
             System.out.println("You ordered Coffee");
             break;
         case 4:
             System.out.println("Exiting the menu. Thank you!");
             break;
         default:
             System.out.println("Invalid choice. Please try again.");
             break;
     }

	}

}
