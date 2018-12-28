package ConcurentTests;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch позволяет поток ожидать countDownLatch.await() пока счетчик countDownLatch.countDown() не достигнет "0"
 *
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            countDownLatch.countDown();
            System.out.println("countDownLatch 1");
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("countDownLatch 2");
        }).start();
        System.out.println("Waiting CountDown");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все потоки заверешны");
    }
}
