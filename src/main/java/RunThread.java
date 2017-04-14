/**
 * Created by dos on 13.10.2016.
 */
public class RunThread implements  Runnable {
    public static void main(String [] args) {
        RunThread runThread = new RunThread();
        Thread alpha = new Thread(runThread);
        Thread beta = new Thread(runThread);
        alpha.setName("alpha");
        beta.setName("beta");
        alpha.start();
        beta.start();
    }
    @Override
    public void run() {
        for(int i=0;i<25;i++){
            String threadName = Thread.currentThread().getName();
            System.out.println("Сейчас - " + threadName);
        }
    }
}
