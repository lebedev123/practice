package Threads.Lessons;


import javax.naming.InsufficientResourcesException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Если в дочернем потоке запущенном из main возникает exception
 * main поток никогда об этом не узнает, потому что runnable ничего не возвращает
 * Появился Callable и Future
 * Класс использует класс Account уровнем выше
 */
public class CallableTest {
    public static void main(String[] args) {

    }
}

class Transfer implements Callable<Boolean> {
    Account ac1;
    Account ac2;
    int amount;
    Lock lock = new ReentrantLock();

    public Transfer(Account acc1, Account acc2, int amount) {
        this.ac1 = acc1;
        this.ac2 = acc2;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        if (ac1.getLock().tryLock(3, TimeUnit.SECONDS)) { //trylock возвращает true если получилось взять блокировку
            try {
                if (ac1.getBalance() < amount) {
                    throw new InsufficientResourcesException();
                }
                if (ac2.getLock().tryLock(3, TimeUnit.SECONDS)) {
                    try {
                        ac1.withdraw(amount);
                        ac2.deposit(amount);
                        Thread.sleep(10000);
                    } finally {
                        ac2.getLock().unlock();
                    }
                }
            } finally {
                ac1.getLock().unlock();
                return true;
            }
        } else {
            System.out.println("ERROR");
            ac1.incFailCount();
            return false;
        }
    }
}

