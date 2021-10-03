package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionEx1 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            source.add(i);
        }

//        ArrayList<Integer> target = new ArrayList<>();

        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
        Runnable r = ()-> {
            synchronized (synchList) {
                for (Integer i : source)
                    synchList.add(i);
            }
        };


        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);

        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();
        System.out.println(synchList);
    }
}
