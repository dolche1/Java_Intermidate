package multithreading;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        InterruptedThread interruptedThread = new InterruptedThread();
        interruptedThread.start();
        Thread.sleep(2000);
        interruptedThread.interrupt();
        interruptedThread.join();
        System.out.println("main ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000_000; i++) {
            if (isInterrupted()) {
                System.out.println("Trying to interrupt the Thread");
                System.out.println("Stoping the Thread");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread wanted to be interrupt while it's sleeping");
                System.out.println(sqrtSum);
                return ;
            }
        }
        System.out.println(sqrtSum);
    }
}
