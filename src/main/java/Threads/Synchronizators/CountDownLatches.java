package Threads.Synchronizators;

import java.util.concurrent.CountDownLatch;

/**
 * Создает счетчик с аргументом 3, countDown понижает
 * счетчик на 1, await ждет счетчика 0 и после
 * продолжает выполнение
 */
public class CountDownLatches {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);
        countDownLatch.await();
        System.out.println("All done");

    }
}
class Work extends Thread{
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            this.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done work ");
        countDownLatch.countDown();
    }
}
