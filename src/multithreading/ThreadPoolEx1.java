package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl100());
        }
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.SECONDS);
        System.out.println("main ended");
    }
}

class RunnableImpl100 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started Work");
        System.out.println("Current Thread name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " ended Work");
    }
}
