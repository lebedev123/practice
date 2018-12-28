package ConcurentTests;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Runnable позволяет выполнить операцию асснихронно в другом потоке без возврата результата
 * Callable позволяет возвращать результат вычислений
 * Объект Future представляет собой "будущие" результат вычислений ( тот который еще не выполнился), данный объект имеет методы для ожидания результата и возврата результата вычислений( на это время поток блокируется и ждет)
 * Объект FutureTask позволяет инкапсулировать в него Callable или Runnable , передать его потоку на выполнение и далее с использование FutureTask.get ожидать пока задача выполняется
 *
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> integerCallable = () -> {
            Thread.sleep(1000);
            return 1;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(integerCallable);
        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());
    }
}
