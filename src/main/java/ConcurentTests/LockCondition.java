package ConcurentTests;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Пример блокировки с помщью Condition который позволяет вызывать await и signal/signalAll для ожидания и возобновления потока на условии
 */
public class LockCondition{
    public static final int ACCOUNT_COUNT = 10;
    public static final double INIT_BALANCE = 100.0;

    public static void main(String[] args) {
        ConditionLockBank  bank = new ConditionLockBank (ACCOUNT_COUNT, INIT_BALANCE);
        for (int i = 0; i < ACCOUNT_COUNT; i++) {
            int fromAccount = i;
            new Thread(() -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = INIT_BALANCE * Math.random();
                        bank.transferMoney(fromAccount, toAccount, amount);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }).start();
        }

    }

    static class ConditionLockBank {
        private final double[] accounts;
        Lock lock = new ReentrantLock();
        Condition condition ;

        public ConditionLockBank (int accountCount, double initBalance) {
            this.accounts = new double[accountCount];
            Arrays.fill(accounts, initBalance);
            condition = lock.newCondition();
        }

        public void transferMoney(int from, int to, double money) {
            lock.lock();
            try {
                if (accounts[from] < money) condition.await();
                System.out.println(Thread.currentThread());
                accounts[from] -= money;
                System.out.printf(" %10.2f from %d to %d ", money, from, to);
                accounts[to] += money;
                System.out.println("Total balance = " + getTotalBalance());
                condition.signalAll();
            }catch (Throwable throwable){
                System.out.println(throwable);
            }finally {
                lock.unlock();
            }

        }

        public double getTotalBalance() {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        }

        public int size() {
            return accounts.length;
        }
    }
}

