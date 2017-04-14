package Threads.Synchronizators;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * разделяет задачи между потоками
 */
public class ForkJoinFraemwork {
    static long numOfOperations = 10_000_000_000L;
    static int num_of_threads = Runtime.getRuntime().availableProcessors(); //количество ядер на процессоре

    public static void main(String[] args) {
        System.out.println(num_of_threads);
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new myFork(0,numOfOperations)));
        System.out.println(new Date());
    }
}

class myFork extends RecursiveTask<Long> {
    static long numOperations = 10_000_000_000L;
    static int num_of_threads = Runtime.getRuntime().availableProcessors(); //количество ядер на процессоре
    long from;
    long to;

    public myFork(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        //если процессор может обработать информацию в одном потоке то выполняем,если нет то разбивает на части
        if (to - from < numOperations / num_of_threads) {
            long j = 0;
            for (long i = from; i < to; i++) {
                j += i;
            }
            return j;
        } else {
            long middle = (to + from) / 2;
            myFork first = new myFork(from, middle);
            first.fork(); // для разбиения
            myFork second = new myFork(middle + 1, to);
            long secondvalue = second.compute();
            return first.join() + secondvalue;
        }
    }
}