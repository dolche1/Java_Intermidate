package multithreading;

public class DaemonExample {

    public static void main(String[] args) {
        UserThread userThread = new UserThread();
        DaemonThread daemonThread = new DaemonThread();


        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();

        System.out.println("main thread ends");
    }
}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + Thread.currentThread().isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + Thread.currentThread().isDaemon());
        for (int i = 1; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

