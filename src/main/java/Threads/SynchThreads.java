package Threads;

import java.util.Arrays;

/**
 * синхронизация, это хорошо, но не совершенно.
 * Она имеет некоторые функциональные ограничения -
 * невозможно прервать поток, который ожидает блокировки,
 * так же как невозможно опрашивать или пытаться получить блокировку,
 * не будучи готовым к долгому ожиданию.
 * Синхронизация также требует, чтобы блокировка была снята в том же стековом фрейме,
 * в котором была начата,
 * это правило верно почти все время (и хорошо взаимодействует с обработкой исключительных ситуаций),
 * за исключением небольшого количества случаев,
 * когда блокировка с неблочной структурой может быть большим преимуществом.
 */
public class SynchThreads {
    public static final int NACCOUNTS = 100;
    public static final double INITAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;
    public static void main(String[] args) {
        anotherBank bank = new anotherBank(NACCOUNTS, INITAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
class anotherBank{
    private final double[] accounts;

    public anotherBank(int n,double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }
    public synchronized void transfer(int from,int to,double amount) throws InterruptedException {
        while (accounts[from] < amount)
            wait();
        System.out.println(Thread.currentThread());
        accounts[from] -=amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to] +=amount;
        System.out.printf(" Total Balance: %10.2f%n ", getTotalBalance());
        notifyAll();
    }
    public synchronized double getTotalBalance(){
        double sum = 0;
        for(double a : accounts)
            sum+=a;
        return sum;
    }
    public int size(){
        return accounts.length;
    }
}
