/**
 * Created by dos on 14.10.2016.
 */
public class TestSync implements Runnable {
    private int balance = 0;
    public  void run(){
        for(int i =0;i<50;i++ ){
            increment();
            System.out.println("Balance = " +balance);
        }
    }
    public synchronized void increment(){
        int i=balance;
        balance = i+1;
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args){
        TestSync n = new TestSync();
        Thread a = new Thread(n);
        a.setName("First");
        Thread b = new Thread(n);
        b.setName("Second");
        a.start();
        b.start();
    }
}
