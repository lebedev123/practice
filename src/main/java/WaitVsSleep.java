public class WaitVsSleep {
    public static void main(String[] args) throws InterruptedException {
        Gachi gachi = new Gachi();
        Runnable runnable1 = () -> {
            try {
                gachi.setBucks(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnable2 = () -> {
            System.out.println(gachi.getBucks());
        };
        new Thread(runnable1).start();
        Thread.sleep(100);
        new Thread(runnable2).start();
    }
}

class Gachi {
    private int bucks;

    public synchronized void setBucks(int bucks) throws InterruptedException {
        this.bucks = bucks;
        System.out.println("Setting " + bucks + "bucks");
        Thread.sleep(10000);
//        wait();
    }

    public synchronized int getBucks() {
//        notifyAll();
        return bucks;
    }
}
