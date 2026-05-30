package sdet_selenium_Day_02;

public class Shopping {

	public static void main(String[] args) {
		int purchase_amount = 750;
		
		
		if(purchase_amount < 300) {
			System.out.println("There is no discount for this price!!");
		}
		else if(purchase_amount >= 300 && purchase_amount < 500) {
			System.out.println("Great, You got 10% discount on this product");
		}
		else if(purchase_amount >= 500 && purchase_amount < 800) {
			System.out.println("Great, You got 15% discount on this product");
		}
		else if(purchase_amount >= 800 && purchase_amount < 1000) {
			System.out.println("Great, You got 20% discount on this product");
		}
		else {
			System.out.println("Great, You got 25% discount on this product");
		}
	}

}
