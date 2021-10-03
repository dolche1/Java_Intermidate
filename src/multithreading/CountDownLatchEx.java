package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class CountDownLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        Friend f1 = new Friend("Zaur", countDownLatch);
        Friend f2 = new Friend("Oleg", countDownLatch);
        Friend f3 = new Friend("Viktor", countDownLatch);
        Friend f4 = new Friend("Marina", countDownLatch);
        Friend f5 = new Friend("Sergey", countDownLatch);
        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();


    }

    private static void marketStaffIsOnPlace() {
        try {
            Thread.sleep(1000);
            System.out.println("Market Staff is on place");
            countDownLatch.countDown();
            System.out.println("countDownLatch: " + countDownLatch);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void everythingIsReady() {
        try {
            Thread.sleep(3000);
            System.out.println("EveryThing is ready so lets open");
            countDownLatch.countDown();
            System.out.println("countDownLatch: " + countDownLatch);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void openMarket() {
        try {
            Thread.sleep(4000);
            System.out.println("Market is opened");
            countDownLatch.countDown();
            System.out.println("countDownLatch: " + countDownLatch);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name  = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " started buying");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}