package Threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * создает 2 поток ,помещает их в Pool и получает их результаты
 */
public class ThreadPool {

    public static void main(String[] args) {
        Integer a = 2;
        String a1 = "Два";
        ExecutorService pool = Executors.newCachedThreadPool();
        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return a1;
            }
        };
        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return a;
            }
        };
        Future<Integer> future1 = pool.submit(callable2);
        Future<String> future2 = pool.submit(callable1);
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
        }catch (Exception ex){
            System.out.println("Прерван");
        }finally {
            pool.shutdown();
        }


    }


}
