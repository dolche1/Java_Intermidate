package multithreading;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerr {
     static AtomicInteger  atomicInteger = new AtomicInteger(0);


     public static void increment() {
         atomicInteger.addAndGet(5);
     }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl3());
        Thread thread2 = new Thread(new MyRunnableImpl3());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(atomicInteger);
    }
}

class MyRunnableImpl3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            AtomicIntegerr.increment();
        }
    }
}
