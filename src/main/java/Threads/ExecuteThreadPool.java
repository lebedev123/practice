package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecuteThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer a1 = 3;
        Integer a2 = 4;
        Callable<Integer> t1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return a1;
            }
        };
        Callable<Integer> t2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return a2 * a1;
            }
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();
        results.add(pool.submit(t1));
        results.add(pool.submit(t2));
        for(Future f : results){
            System.out.println(f.get());
        }
    }
}
