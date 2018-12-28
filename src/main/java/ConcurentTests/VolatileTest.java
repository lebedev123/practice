package ConcurentTests;

/**
 * Пример volatile переменных
 */
public class VolatileTest {
    private final static int THREAD_COUNT = 50;
//    private   boolean b = true;
    private long l = 34;
    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        for(int i =0; i<THREAD_COUNT; i++){
            new Thread(() -> {
                int t = 0 ;
                while (t <50) {
                    System.out.println(volatileTest.getL()+ " Time: " +  System.currentTimeMillis());
                    t++;
                }

            }).start();
        }
        new Thread(() -> {
            System.out.println("Изменяю Time: " +  System.currentTimeMillis());
            volatileTest.setL(38);
            System.out.println("Изменил на false Time: " +  System.currentTimeMillis());
        }).start();
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }
    //    public boolean isB() {
//        return b;
//    }
//
//    public void setB(boolean b) {
//        this.b = b;
//    }
}
