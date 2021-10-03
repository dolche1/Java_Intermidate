package multithreading;

import java.util.concurrent.*;

public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> integerFuture = executorService.submit(new Factorial2(5));
        try {
            System.out.println("Trying to ger result");
            factorialResult = integerFuture.get();
            System.out.println("Got result");
            System.out.println(integerFuture.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class Factorial2 implements Callable<Integer> {
    int f;

    public Factorial2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f < 0) {
            throw new Exception("You entered the wrong number");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
            Thread.sleep(1000);
        }

        return result;
    }
}