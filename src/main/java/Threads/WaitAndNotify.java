package Threads;

public class WaitAndNotify {
    Integer count = 0;
    public static void main(String[] args) {
        WaitAndNotify test = new WaitAndNotify();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized (test) {
                    System.out.println("Current thread " + Thread.currentThread() + " : " + test.count);
                    test.count++;
                    System.out.println("Incremented in " + Thread.currentThread());
                    System.out.println("Before wait");
                    try {
                        test.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("After wait");
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (test) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Current thread " + Thread.currentThread());
                    System.out.println("count  --");
                    test.count--;
                    System.out.println("Before notify");
                    test.notifyAll();
                    System.out.println("After thread " + Thread.currentThread());
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
