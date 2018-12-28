package Threads;


/*
    Runnable позволяет наследовать (extends) еще один класс в отличии от Thread
    Runnable позволяет отделить отделить задачу от потока для последующего использования
    При использовании одного и того же обьекта Runnable в Thread'ах в Thread сохраняются все поля
 */
public class ThreadVsRunnable {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        new MyThreadTest().start();
        new MyThreadTest().start();
        new MyThreadTest().start();
    }
}

class MyRunnable implements Runnable {
    int count = 0;
    @Override
    public void run() {
        System.out.println(count++);
    }
}
class MyThreadTest extends Thread{
    int count = 0;
    @Override
    public void run() {
        System.out.println(count++);
    }
}