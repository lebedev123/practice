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
 */
class Operations {
    public static void main(String[] args) throws InsufficientResourcesException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a,b,500);
                } catch (InsufficientResourcesException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        transfer(b,a,300);
    }

    static void transfer(Account ac1, Account ac2, int amount) throws InsufficientResourcesException {
        if (ac1.getBalance() < amount) {
            throw new InsufficientResourcesException();
        }
        ac1.withdraw(amount);
        ac2.deposit(amount);
    }

}
