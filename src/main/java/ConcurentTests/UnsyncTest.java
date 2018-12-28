package ConcurentTests;

import java.util.Arrays;

/**
 * Пример асинхронного вычисления, который работает неверно
 */
public class UnsyncTest {
    public static final int ACCOUNT_COUNT = 10;
    public static final double INIT_BALANCE = 100.0;

    public static void main(String[] args) {
        UnsyncBank bank = new UnsyncBank(ACCOUNT_COUNT, INIT_BALANCE);
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

    static class UnsyncBank {
        private final double[] accounts;

        public UnsyncBank(int accountCount, double initBalance) {
            this.accounts = new double[accountCount];
            Arrays.fill(accounts, initBalance);
        }

        public void transferMoney(int from, int to, double money) {
            if (accounts[from] < money) return;
            System.out.println(Thread.currentThread());
            accounts[from] -= money;
            System.out.printf(" %10.2f from %d to %d", money, from, to);
            accounts[to] += money;
            System.out.println("Total balance = " + getTotalBalance());
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
