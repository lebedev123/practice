import java.lang.reflect.Array;
import java.util.Arrays;

public class DeadLock {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_VALUE = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable runnable = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (NACCOUNTS * Math.random());
                        double amount = MAX_VALUE * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            };
            Thread t = new Thread(runnable);
            t.start();
        }

    }

}


class Bank {
    private final double[] account;

    public Bank(int n, double initBalance) {
        account = new double[n];
        Arrays.fill(account, initBalance);
    }

    public synchronized void transfer(int from, int to, double amount) {
        while (account[from] < amount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread());
        account[from] -= amount;
        System.out.printf("%10.2f from %d to %d ", amount, from, to);
        account[to] += amount;
        System.out.printf(" Total Balance : %10.2f%n", getTotalBalance());
        notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : account) {
            sum += a;
        }
        return sum;
    }

}
