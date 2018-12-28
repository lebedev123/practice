public class FinalizeTest {
    public static void main(String[] args) throws InterruptedException {
        TestFin fin = new TestFin();
//        while(true){
//            fin = null;
//            fin = new TestFin();
//        }
        fin = null;
        Thread.sleep(100000);
    }


    static class TestFin {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }
}
