package sdet_selenium_Day_07;

//import java.util.*;

class MyThread extends Thread {

    public MyThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " started.");

        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is running: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println(getName() + " finished.");
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println("Is t1 alive? " + t1.isAlive());

        System.out.println("Is t1 alive after join? " + t1.isAlive());
    }
}
