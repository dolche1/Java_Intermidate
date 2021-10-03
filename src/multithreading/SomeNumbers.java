package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SomeNumbers {
    private static long value = 1_000_000_000;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResults = new ArrayList<>();

        long valueDividedBy10 = value / 10;

        for (int i = 0; i < 10; i++) {
            futureResults.add(executorService.submit(new PartialSum(valueDividedBy10 * i + 1, valueDividedBy10 * (i + 1))));
            sum += futureResults.get(i).get();
        }
        executorService.shutdown();
        System.out.println(sum);
    }
}

class PartialSum implements Callable<Long> {
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("sum from: " + from + " to: " + to + " is: " + localSum);
        return localSum;
    }
}