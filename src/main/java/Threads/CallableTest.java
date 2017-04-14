package Threads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableTest implements Callable<String> {
    String name;
    public CallableTest(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return new String("Новый поток r" + name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CallableTest pool1 = new CallableTest("pool1");
        CallableTest pool2 = new CallableTest("pool2");
        CallableTest pool3 = new CallableTest("pool3");
        Future<String> future1 = executor.submit(pool1);
        Future<String> future2 = executor.submit(pool2);
        Future<String> future3 = executor.submit(pool3);
        ArrayList<Future<String>> futures = new ArrayList<>();
        futures.add(future1);
        futures.add(future2);
        futures.add(future3);
        for(Future<String> future : futures){
            System.out.println(future.get());
        }
        executor.shutdown();

    }
}
