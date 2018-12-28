public class Test0 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        TestClass testClass = new TestClass();
        testClass = null;
        System.runFinalization();
        Thread.sleep(10000);
    }
}

class TestClass {
    static{
        System.out.println("java");
    }

    public void sout(){
        System.out.println("1");
    }

    public void sout(Object object){
        System.out.println("object");
    }

    public void sout(Integer integer){
        System.out.println("integer");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Deleted");
        super.finalize();
    }
}