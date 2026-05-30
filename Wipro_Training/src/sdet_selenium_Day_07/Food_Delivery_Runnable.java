package sdet_selenium_Day_07;

import java.lang.*;

class Order implements Runnable{
	public void run() {
		try {
			for(int i=1; i<=5; i++) {
				System.out.println("Order is processing on step: " + i);
				Thread.sleep(500);
			}
			System.out.println("Order is prepared.");
		}
		catch(InterruptedException e) {
			System.out.println("Order processing interrupted.");
		}
	}
}

class Payment implements Runnable{
	public void run() {
			System.out.println("Payment done.");
	}
}

class Notification implements Runnable{
	public void run() {
			System.out.println("Notification has sent of order and payment. ");
	}
}

public class Food_Delivery_Runnable {

	public static void main(String[] args) throws InterruptedException {
		Runnable order = new Order();
        Runnable payment = new Payment();
        Runnable notification = new Notification();
        
        Thread thread1 = new Thread(order);
        Thread thread2 = new Thread(payment);
        Thread thread3 = new Thread(notification);
        
        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();

	}

}
