package Threads.DeadLock;

import javax.naming.InsufficientResourcesException;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

/**
 * volatile не спасает если операции не атомарные
 * В данном примере используется synchronized для возникновения DeadLock
 *Сначала захватывается объект ac1,данный потом оставнавливается на 1000 сек
 * Что порождает запуск другого потока который пытается получить доступ к ac1 и захватывает ac2
 */
class Operations {
    public static void main(String[] args) throws InsufficientResourcesException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);
        new Thread(() -> {
            try {
                transfer(a,b,500);
            } catch (InsufficientResourcesException e) {
                e.printStackTrace();
            }
        }).start();
        transfer(b,a,300);
    }

    static void transfer(Account ac1, Account ac2, int amount) throws InsufficientResourcesException {
        if (ac1.getBalance() < amount) {
            throw new InsufficientResourcesException();
        }
        synchronized (ac1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ac2){
                ac1.withdraw(amount);
                ac2.deposit(amount);
            }
        }
    }
}
