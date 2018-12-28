package ConcurentTests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Тестирование методов invokeAny и invokeAll для ExecutorService , описание ниже
 *
 */
public class ExecutorInvoke {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(10000);
                return 1;
            }
        });
        tasks.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
//                Thread.sleep(1000);
                return 1;
            }
        });
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Integer result = executor.invokeAny(tasks); // invokeAny позволяет запустить все таски из коллекции Callable и возвращает тот результат который быстрее будет получен
        List<Future<Integer>> results = executor.invokeAll(tasks); // invokeAll позволяет запустить все таски из коллекции Callable и получить результаты из всех потоков
        System.out.println(result);
        executor.shutdown();
    }
}
