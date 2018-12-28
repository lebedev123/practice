package ConcurentTests;


/**
 * Wait освобождает блокировку объекта чтобы другие потоки могли ее захватить и вызвать в определенный момент notify
 */
public class NotifyWaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object test = new Object();
        NotifyWaitTest notifyWaitTest = new NotifyWaitTest();
        System.out.println("Start");
        new Thread(() -> {
            try {
                notifyWaitTest.waitForFirstStage(test);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(10000);
        new Thread(() -> {
            notifyWaitTest.firstStage(test);
        }).start();


    }


    public void waitForFirstStage(Object test) throws InterruptedException {
        synchronized (test) {
            System.out.println("waiting");
            test.wait();
            System.out.println("after wait");
        }
    }

    public void firstStage(Object test) {
        System.out.println("enter first stage");
        synchronized (test) {
            System.out.println("notify first stage");
            test.notifyAll();
            System.out.println("after notify");
        }
    }
}
