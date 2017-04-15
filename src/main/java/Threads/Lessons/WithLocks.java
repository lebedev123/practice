package Threads.Lessons;


import javax.naming.InsufficientResourcesException;
import java.util.concurrent.TimeUnit;

public class WithLocks {
    public static void main(String[] args) throws InsufficientResourcesException, InterruptedException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);
        new Thread(() -> {
            try {
                transfer(a, b, 500);
            } catch (InsufficientResourcesException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        transfer(b, a, 300);
    }

    static void transfer(Account ac1, Account ac2, int amount) throws InsufficientResourcesException, InterruptedException {

        if (ac1.getLock().tryLock(3, TimeUnit.SECONDS)) { //trylock возвращает true если получилось взять блокировку
            try {
                if (ac1.getBalance() < amount) {
                    throw new InsufficientResourcesException();
                }
                if (ac2.getLock().tryLock(3, TimeUnit.SECONDS)) {
                    try {
                        ac1.withdraw(amount);
                        ac2.deposit(amount);
                    } finally {
                        ac2.getLock().unlock();
                    }
                }
            } finally {
                ac1.getLock().unlock();
            }
        } else {
            System.out.println("ERROR");
        }
    }
}

