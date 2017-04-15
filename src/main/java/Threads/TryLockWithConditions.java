package Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

/**
 * Инкрементит 3 переменные ,когда значение i == 4 ,
 * включается метод прокси который увеличивает i на 1,
 * и отдает лок обратно первому потоку
 * Condition используется для await и signalAll
 */
public class TryLockWithConditions implements Runnable {
    private int i = 0;
    private int s = 0;
    private int l = 0;
    private Lock lock = new ReentrantLock();
    private Condition conditions = lock.newCondition();

    @Override
    public void run() {
        try {
            increment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void increment() throws InterruptedException {
        while (i < 10) {
            lock.lock();
            try {
                while (i == 4) {
                    System.out.println("Сигнал в 1 потоке");
                    conditions.signalAll();
                    System.out.println("1 поток спит");
                    conditions.await();
                }
                i = i + 1;
                s = s + 1;
                l = l + 1;
                System.out.println("i = " + i + " S = " + s + " l = " + l + " " + currentThread().toString());
            } finally {
                lock.unlock();
            }
        }
    }

    private void Proxy() {
        lock.lock();
        try {
            while (i != 4) {
                conditions.await();
            }
            i++;
            System.out.println("i увеличена");
            System.out.println("Сигнал в 2 потоке");
            conditions.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TryLockWithConditions a1 = new TryLockWithConditions();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(() -> {
            a1.Proxy();
        });
        t1.start();
        t2.start();
    }
}
