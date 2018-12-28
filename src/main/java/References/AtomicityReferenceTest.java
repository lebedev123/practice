package References;

public class AtomicityReferenceTest {
    Integer integer = 54;

    public static void main(String[] args) {
        AtomicityReferenceTest atomicityReferenceTest = new AtomicityReferenceTest();
        new Thread(new MyThread1(atomicityReferenceTest)).start();
        new Thread(new MyThread2(atomicityReferenceTest)).start();
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

}

class MyThread1 implements Runnable {
    AtomicityReferenceTest ref;

    public MyThread1(AtomicityReferenceTest ref) {
        this.ref = ref;
    }

    @Override
    public void run() {
        ref.setInteger(15);
    }

}


class MyThread2 implements Runnable {
    AtomicityReferenceTest ref;

    public MyThread2(AtomicityReferenceTest ref) {
        this.ref = ref;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ref.getInteger());
    }
}
