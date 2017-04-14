package Threads;

/**
 * Created by dos on 09.02.2017.
 */
public class JoinThread implements Runnable{
    Thread th;
    public JoinThread(String name) {
        th = new Thread(this,name);
        th.start();
    }

    @Override
    public void run() {
        System.out.println(th.getName() + " - starting ...");
        try{
            for(int i=0; i <10; i++){
                Thread.sleep(300);
                System.out.println("In " + th.getName() +  " count is "+ +i);
            }
        }catch (InterruptedException ex){
           System.out.println("Interrupted");
        }
        System.out.println("Ending");
    }
}
class JoinThreads{
    public static void main(String[] args) {
        JoinThread thread1 = new JoinThread("Thread #1");
        JoinThread thread2 = new JoinThread("Thread #2");
        JoinThread thread3 = new JoinThread("Thread #3");

        try{
            thread1.th.join();
            System.out.println("Thread #1 is joined");
            thread2.th.join();
            System.out.println("Thread #2 is joined");
            thread3.th.join();
            System.out.println("Thread #3 is joined");
        }catch (InterruptedException ex){
            System.out.println("The main thread is interrupted");
        }
        System.out.println("Ending of main thread");
    }
}

