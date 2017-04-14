/**
 * Created by dos on 14.10.2016.
 */
public class TestThreads {

    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        Thread one = new Thread(t1);
        Thread two = new Thread(t2);
        one.start();
        two.start();

        for (int x = 0; x < 99; x++) {

        }

    }
}

class Accum {
    private static Accum a = new Accum();
    private int counter = 0;

    private Accum() {
    }

    public static Accum getAccum() {
        return a;
    }

    public void updateCounter(int add) {
        counter += add;
    }

    public int getCounter() {
        return counter;
    }
}

class ThreadOne implements Runnable {
    Accum a = Accum.getAccum();

    @Override
    public void run() {
        for (int x = 0; x < 98; x++) {
            a.updateCounter(1000);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("One " + a.getCounter());
    }
}

class ThreadTwo implements Runnable {
    Accum a = Accum.getAccum();

    @Override
    public void run() {
        for (int x = 0; x < 99; x++) {
            a.updateCounter(1);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("two " + a.getCounter());
    }
}