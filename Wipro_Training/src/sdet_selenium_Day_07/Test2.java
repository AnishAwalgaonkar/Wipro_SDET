package sdet_selenium_Day_07;

class DatabaseSystem {

    public synchronized void updateStatus(String taskName) {
        System.out.println(taskName + " is updating system...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        System.out.println(taskName + " finished updating.");
    }
}

class FoodDelivery extends Thread {
	
	public DatabaseSystem ds;
	
	public FoodDelivery(String name, DatabaseSystem ds){
		setName(name);
		this.ds = ds;
	}

	public void run(){
		try
		{
			System.out.println(getName() + " started");
			 ds.updateStatus(getName());
			Thread.sleep(2000);
			System.out.println(getName() + " completed");
		}
		catch (InterruptedException e)
		{
			System.out.println(getName() + " interrupted");
		}
	}
}

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		
		DatabaseSystem ds = new DatabaseSystem();
		
		FoodDelivery order = new FoodDelivery("Order Processing", ds);
		FoodDelivery kitchen = new FoodDelivery("Kitchen Processing", ds);
		FoodDelivery delivery = new FoodDelivery("Delivery Processing", ds);

		order.setPriority(Thread.MAX_PRIORITY);
		kitchen.setPriority(Thread.NORM_PRIORITY);
		delivery.setPriority(Thread.MIN_PRIORITY);

		order.start();
		kitchen.start();

		System.out.println("Is order Alive? " + order.isAlive());

		order.join();
		kitchen.join();
		
		delivery.start();
		delivery.join();

		System.out.println("All tasks completed.");
	}
}
