package Threads;

/**
 * Created by dos on 09.02.2017.
 */
public class TickTockTest {
    String state;
    synchronized void tick(boolean running){
        if(!running){
            state = "ticked";
            notify();
            return;
        }
        System.out.println("Tick");
        state = "ticked";
        notify();
        try{
            while(!state.equals("tocked")){
                wait();
            }
        }catch (InterruptedException ex){
            System.out.println("Прерывание потока");
        }
    }
    synchronized void tock(boolean running){
        if(!running){
            state = "tocked";
            notify();
            return;
        }
        System.out.println("Tock");
        state = "tocked";
        notify();
        try{
            while (!state.equals("ticked")){
                wait();
            }
        }catch (InterruptedException ex){
            System.out.println("Прерывание потока");
        }
    }
}
class MyThread implements Runnable {
    Thread th;
    TickTockTest ttob;

    public MyThread(TickTockTest tt, String name) {
        th = new Thread(this, name);
        ttob = tt;
        th.start();
    }

    @Override
    public void run() {
        if (th.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) ttob.tick(true);
            ttob.tick(false);
        }
    }
}
class ThreadCom {
    public static void main(String[] args) {
        TickTockTest tt = new TickTockTest();
        MyThread mt1 = new MyThread(tt,"Tick");
        MyThread mt2 = new MyThread(tt,"Tock");
        try{
            mt1.th.join();
            mt1.th.join();
        }catch (InterruptedException ex){
            System.out.println("Прерывание основного потока");
        }
    }
}
