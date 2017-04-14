/**
 * Created by dos on 17.11.2016.
 */
public class finalizeTest {
    @Override
    protected void finalize()  {
        System.out.println("lul");
    }
    public  static void main(String[] args){
        finalizeTest finalizeTest = new finalizeTest();
        new finalizeTest();

    }
}
