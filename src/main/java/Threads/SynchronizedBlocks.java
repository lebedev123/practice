package Threads;

import static java.lang.Thread.currentThread;


public class SynchronizedBlocks implements Runnable {
    private int i = 0;
    private int s = 0;
    private int l = 0;

    @Override
    public void run() {
        try {
            increment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void increment() throws InterruptedException {
        synchronized (this) {
            while (i < 10) {
                if (i == 4) notifyAll();
                while (i == 4) wait();
                i = i + 1;
                s = s + 1;
                l = l + 1;
                System.out.println("i = " + i + " S = " + s + " l = " + l + " " + currentThread().toString());
            }
        }
    }

    private void Proxy() throws InterruptedException {
        synchronized (this) {
            while (i != 4) wait();
            i++;
            System.out.println(" i увеличена");
            notifyAll();
        }
    }

    public static void main(String[] args) {
        SynchronizedBlocks a1 = new SynchronizedBlocks();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(() -> {
            try {
                a1.Proxy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
