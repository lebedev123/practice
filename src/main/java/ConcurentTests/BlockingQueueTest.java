package ConcurentTests;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Блокирующая очередь позволяет заполнить очередь до лимита потоком который заполняет очередь
 * После достижения лимита поток заполняющий очередь блокируется пока не появистся место
 * В свою очередь другой поток который вычитывает из очереди будет вычитывать до тех пор пока в очереди есть элементы
 * Если в очереди нет элементов то поток блокируется до появления новых элементов
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(15);
        new Thread(() -> {
            for(int i =0 ; i<100;i++) {
                try {
                    queue.put(i);
                    System.out.println("Putted " + i);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            for(int i =0 ; i<100;i++) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }).start();

    }
}
