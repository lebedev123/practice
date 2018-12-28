public class TestDeadLock {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Cool group");
        Thread errorThread = new Thread(group,() -> {
            throw new IllegalArgumentException("ex");
        });
        errorThread.setUncaughtExceptionHandler(new ClassCatchExceptions());
        errorThread.start();

    }

}


class ClassCatchExceptions implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception in thread " + t + " with Exception " + e);
    }
}
