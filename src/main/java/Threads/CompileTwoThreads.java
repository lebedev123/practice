package Threads;

import java.util.*;
import java.util.concurrent.*;


/**
 * Ввод числа с последующим разложением его на множители в двух потоках
 * первый поток KeyFounder вычисляет первую часть
 * второй поток founder2
 *
 *
 */
public class CompileTwoThreads implements Callable <HashSet<Integer>>{
    HashSet<Integer> arrayList;
    Integer number;

    CompileTwoThreads(Integer number) {
        this.number = number;
    }

    @Override
    public HashSet<Integer> call() throws Exception {
        arrayList = new HashSet<Integer>();
        int s = number/2;
        for (int i = 1; i <= s; i++) {
            if (number % i == 0) {
                arrayList.add(s);
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Enter the value");
        Scanner in = new Scanner(System.in);
        Integer i1 = in.nextInt();
        CompileTwoThreads founder = new CompileTwoThreads(i1);
        ArrayList<FutureTask<HashSet<Integer>>> result1 = new ArrayList<>();
        Callable founder2 = () -> {
            HashSet<Integer> hashSet = new HashSet<>();
            int l =0;
            for (int i = i1 / 2; i <= i1; i++) {
                l++;
                int s = i1 / l; // второе число
                if (i1 % l == 0) {
                    hashSet.add(s);
                    hashSet.add(l);
                }
            }
            return hashSet;
        };
        FutureTask<HashSet<Integer>> task1 = new FutureTask<>(founder);
        FutureTask<HashSet<Integer>> task2 = new FutureTask<>(founder2);
        result1.add(task1);
        result1.add(task2);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        for(Future<HashSet<Integer>> a : result1)
            System.out.println(a.get());
    }
}
