package ConcurentTests;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService позволяет создать пул потоков ( так как создание нового потока довольно дорого)
 * Метод submit позволяет передать задачу на выполнение , пул запускает задачу сразу либо по появлению свободного потока
 * После завершения работы с пулом следует вызвать shutdown()
 *
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
//        executor.shutdown();
    }
}
