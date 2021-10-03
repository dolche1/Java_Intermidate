package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        Person p1 = new Person("Zaur", callBox);
        Person p2 = new Person("Oleg", callBox);
        Person p3 = new Person("Marina", callBox);
        Person p4 = new Person("Igor", callBox);
        Person p5 = new Person("Nadya", callBox);
    }
}

class Person extends Thread {
    String name;
    Semaphore callBox;

    public Person(String name,Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " is waiting...");
        try {
            callBox.acquire();
            System.out.println(name + " is using a phone.");
            Thread.sleep(2000);
            System.out.println(name + " ended using a phone");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            callBox.release();
        }
    }
}

