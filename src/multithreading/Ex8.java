package multithreading;

public class Ex8 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myThread1 = new Thread(new MyThread());
        Ex8 ex8 = new Ex8();

        myThread1.start();
        ex8.start();

        myThread1.join();
        ex8.join();
        System.out.println("Konec");


    }
}
class MyThread implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}