package Threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomacity позволяет не синхронизируя выполнить одну о операция в одно действие
 */
public class AtomacityTest {
private int i=0;

    public static void main(String[] args) {
        AtomicInteger Counter = new AtomicInteger();
        AtomacityTest test = new AtomacityTest();
        for (int n = 0; n < 100000; n++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Counter = " +  Counter.incrementAndGet());
                    System.out.println("i = " + (test.i = test.i +1));
                }
            }).start();
        }
    }

}
