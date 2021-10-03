package multithreading;

import javax.management.monitor.Monitor;

public class Ex12 {
   static final Object object = new Object();

    void mobileCall()  {
        synchronized (object) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }
    void skypeCall()  {
        synchronized (object) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }
    void whatsappCall()  {
        synchronized (object) {
            System.out.println("Whatsapp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Whatsapp call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplWhatsapp());

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class RunnableImplMobile implements Runnable {
    @Override
    public void run() {
        new Ex12().mobileCall();
    }
}

class RunnableImplSkype implements Runnable {
    @Override
    public void run() {
        new Ex12().skypeCall();
    }
}

class RunnableImplWhatsapp implements Runnable {
    @Override
    public void run() {
        new Ex12().whatsappCall();
    }
}
class Car{

}