package Threads;

/**
 * Created by dos on 09.02.2017.
 */
public class Priority implements Runnable {
    int count;
    Thread thr;
    static boolean stop = false;
    static String currentName;

    public Priority(String name) {
        thr = new Thread(this,name);
        count = 0;
        currentName = name;
    }

    @Override
    public void run() {
        System.out.println("Thread :" + thr.getName() + " is starting");
        do{
            count++;
            if(currentName.compareTo(thr.getName())!=0){
                currentName = thr.getName();
                System.out.println("Now in thread : " + currentName);
            }
        }while(stop == false && count<100000);
        stop = true;
        System.out.println("Ending of :" + thr.getName());
    }
}
class PriorityDemo{
    public static void main(String[] args) {
        Priority firstThread = new Priority("Thread #1");
        Priority secondThread = new Priority("Thread #2");

        firstThread.thr.setPriority(Thread.NORM_PRIORITY+2);
        secondThread.thr.setPriority(Thread.NORM_PRIORITY-2);

        firstThread.thr.start();
        secondThread.thr.start();

        try{
            firstThread.thr.join();
            secondThread.thr.join();
        }catch (InterruptedException ex){
            System.out.println("Crash ...");
        }
        System.out.println("Count of high priority thread = " + firstThread.count);
        System.out.println("Count of low priority thread = " + secondThread.count);

    }
}
