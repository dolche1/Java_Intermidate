package multithreading;

public class Ex10 {
    public static void main(String[] args) {
        MyRunnableImpl runnable1 = new MyRunnableImpl();
        MyRunnableImpl runnable2 = new MyRunnableImpl();
        MyRunnableImpl runnable3 = new MyRunnableImpl();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
class Counter{
    static int count = 0;
}

class MyRunnableImpl implements Runnable {
    public synchronized void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            increment();
        }
    }
}