public class ThreadTest {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Started ");
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        } ).start();
    }
}
