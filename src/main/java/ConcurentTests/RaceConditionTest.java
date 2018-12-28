package ConcurentTests;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * В случае Race Condition нет гарантии что другой поток не изменит значение X после проверки в первом потоке
 * В данном случе нет гарантии что после проверки xandY.getX() == 5 в первом потоке второй поток не изменит значение X
 * Чтобы предотвратить Race Condition нужно обеспечить синхронизацию ( раскоментить код)
 */
public class RaceConditionTest {
    public static void main(String[] args) {
        XandY xandY = new XandY();
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            while (true) {
//                lock.lock();
                if (xandY.getX() == 5) {
                    xandY.setY(xandY.getX() * 2);
                    System.out.println(xandY.toString());
                }
//                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            while (true) {
//                lock.lock();
                for (int i = 0; i < 6; i++) {
                    xandY.setX(i);
                }
//                lock.unlock();
            }
        }).start();

    }


    static class XandY {
        int x = 5;
        int y = 2;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "XandY{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
