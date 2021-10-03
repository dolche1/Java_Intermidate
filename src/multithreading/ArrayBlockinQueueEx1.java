package multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockinQueueEx1 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(15);

        Runnable runnable1 = () ->{
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(1000);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("offered queue: " + queue);
            }
        };

        Runnable runnable2 = () ->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(3000);
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("polled queue: " + queue);
            }
        };


        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(queue);
    }
}
