/**
 * Created by dos on 13.10.2016.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println("Vershina");
    }
}
    class ThreadTestDrive{
        public static void main(String [] args){
            Runnable threadJob = new MyRunnable();
            Thread myThread = new Thread(threadJob);
            myThread.start();
            System.out.println("Back to main");
        }
    }

