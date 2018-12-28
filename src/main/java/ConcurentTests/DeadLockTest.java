package ConcurentTests;

/**
 * Deadlock возникает в случае если первый поток взял блокировку первого объекта и пытается получить блокировку другого объекта
 * При этом другой поток взял блокировку второго объекта и не может взять блокировку первого объекта потому что она взята первым потоком
 */
public class DeadLockTest {
    static Object objectLock2 = new Object();
    static Object objectLock1 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (objectLock1) {
                try {
                    System.out.println("Lock 1");
                    Thread.sleep(100);
                    synchronized (objectLock2) {
                        System.out.println("Never executes command");
                    }
                } catch (Throwable throwable) {
                    System.out.println(throwable);
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (objectLock2) {
                try {
                    System.out.println("Lock 2");
                    Thread.sleep(100);
                    synchronized (objectLock1) {
                        System.out.println("Never executes command");
                    }
                } catch (Throwable throwable) {
                    System.out.println(throwable);
                }
            }
        }).start();
    }
}
