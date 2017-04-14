/**
 * Created by dos on 13.10.2016.
 */
public class BankAccount {
    private int balance = 100;
    public int getBalance(){
        return balance;
    }
    public void withdraw(int amount){
        balance = balance - amount;
    }
}
class  RyanAndMonicaJob implements Runnable{
    private BankAccount account = new BankAccount();
    public static void main(String[] args){
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread Ryan = new Thread(theJob);
        Thread Monica = new Thread(theJob);
        Ryan.setName("Ryan");
        Monica.setName("Monica");
        Ryan.start();
        Monica.start();
    }

    @Override
    public void run() {
        for(int x= 0; x<3;x++){//kol-vo popitok
            makeWithdraw(50);
            if(account.getBalance()<0){
                System.out.println("Превышение лимита");
            }
        }
    }
    private synchronized void makeWithdraw(int amount){
        if(account.getBalance() >= amount){
            System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
            try{
                System.out.println(Thread.currentThread().getName()+" going sleep");
                Thread.sleep(500);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " waking up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " ending transaktion");
        }
        else{
            System.out.println("Sorry, for clien " + Thread.currentThread().getName() + " not enough money");
        }
    }
}
