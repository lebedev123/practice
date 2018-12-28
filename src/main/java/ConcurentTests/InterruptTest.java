package ConcurentTests;


/**
 * Тетирование метода interrupt
 * По результатам тестирования - когда поток выполняет вычисления прерывание не выполняется
 * Прерывание выполняется только в методах которые явно выбрасывают исключение InterruptedException
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            sout();
        });
        thread.start();
        thread.interrupt();

    }

    private synchronized static void sout() {
        while (Thread.interrupted()) {
            System.out.println("java");
        }
        System.out.println("thread stopped");
    }
}
