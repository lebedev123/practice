import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        CustomObject customObject = new CustomObject("java");
        Runnable runnable1 = () -> {
            try {
                customObject.setName("NonJava");
                System.out.println("Setting is dead");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnable2 = () -> {
            try {
                System.out.println(customObject.getName());
                System.out.println("Getting is dead");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}


class CustomObject {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock read = rwl.readLock();
    private final Lock write = rwl.writeLock();
    private String name;

    public CustomObject(String name) {
        this.name = name;
    }

    public String getName() throws InterruptedException {
        read.lock();
        Thread.sleep(10000);
        try {
            System.out.println("Returning");
            return name;
        } finally {
            read.unlock();
        }
    }

    public  void setName(String name) throws InterruptedException {
        write.lock();
        Thread.sleep(1000);
        try {
            System.out.println("Setting");
            this.name = name;
        } finally {
            write.unlock();
        }
    }

    public void blockingMethod() throws InterruptedException {
        int i = 0;
        write.lock();
        System.out.println(Thread.currentThread());
        System.out.println("Counter : " + i++);
        Thread.sleep(10000);
        write.unlock();
    }
}