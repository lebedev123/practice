import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Long> callable = () -> {
            Thread.sleep(5000);
            return System.currentTimeMillis();
        };
        FutureTask<Long> task = new FutureTask<>(callable);
        Thread thread = new Thread(task);
        thread.start();
        Long result = task.get();
        System.out.println(result);
        
    }

}
