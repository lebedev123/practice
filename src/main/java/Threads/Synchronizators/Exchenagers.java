package Threads.Synchronizators;

import java.util.concurrent.Exchanger;

/**
 * Обмен информацией между потоками exchange(string) передает информацию, exchange(null) вынимает из exchange
 */
public class Exchenagers {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Mike(exchanger);
        new Anket(exchanger);
    }
}
class Mike extends Thread{
    Exchanger<String> exchanger;

    public Mike(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        start();
    }
    //Обмен информацией в run
    @Override
    public void run() {
        try {
            exchanger.exchange("Hi, Im Mike");
            sleep(1000);
            exchanger.exchange("Im 27 yo");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
class Anket extends Thread{
    Exchanger<String> exchanger;

    public Anket(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        start();
    }

    @Override
    public void run() {
        try {
            String info = exchanger.exchange(null);
            String info1 = exchanger.exchange(null);
            System.out.println(info);
            System.out.println(info1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
