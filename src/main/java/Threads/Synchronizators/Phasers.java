package Threads.Synchronizators;

import java.util.concurrent.Phaser;

/**
 *
 */
public class Phasers {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);//регистрирует два потока
        new Washer(phaser);
        new Washer(phaser);
    }
}

class Washer extends Thread {
    Phaser phaser;

    public Washer(Phaser phaser) {
        this.phaser = phaser;
        start();
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println(getName() + " washing the car");
            phaser.arriveAndAwaitAdvance(); // ожидает пока все потоки не завершат этап и далее выполняет код
        }
    }
}
