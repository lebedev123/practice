package Threads.Synchronizators;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ожидает выполнения и затем выполняет код
 */
public class CycleBariers {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run()); // выполняет run после того как 3 объекта выполнились
        new SportMan(cyclicBarrier);
        new SportMan(cyclicBarrier);
        new SportMan(cyclicBarrier);
    }
}

class Run extends Thread {
    CyclicBarrier cyclicBarrier;
    @Override
    public void run() {
        System.out.println("Run is began");
    }
}

class SportMan extends Thread {
    CyclicBarrier cyclicBarrier;

    public SportMan(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        start();
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
