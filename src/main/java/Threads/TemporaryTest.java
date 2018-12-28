package Threads;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TemporaryTest {
    public static void main(String[] args) {
        SimpleObject object = new SimpleObject();
        SimpleObject object1 = new SimpleObject();
        Runnable r1 = () -> {
            System.out.println(object.toString());
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
        };
        Runnable r2 = () -> {
            System.out.println(object1.toString());
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
        };
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}

class SimpleObject {
    String name;
    int id;

    public SimpleObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public SimpleObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public synchronized String toString() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SimpleObject{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
