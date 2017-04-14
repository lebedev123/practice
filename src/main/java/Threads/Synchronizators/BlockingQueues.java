package Threads.Synchronizators;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *вынуждает поток блокироваться при попытке ввести элемент в переполненую очередь или удалить из пустой
 */
public class BlockingQueues {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                queue.add("string");
            }
        }.start();
    }
}
