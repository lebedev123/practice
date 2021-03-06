package Threads;


public class NotAtomacity extends Thread {
    volatile static int i;
    boolean b;

    public void run() {
        synchronized (NotAtomacity.class) {
            while (true) {
                if (b = !b)
                    i++; // b == !b == !false ==  true,because b is false and b now is true, "if" working,then b == !b == !true == false, "else" working
                else i--;
            }
        }
    }

    public static void main(String[] args) {
        new NotAtomacity().start();
        new NotAtomacity().start();

        while (true)
            System.out.println(i);
    }
}
