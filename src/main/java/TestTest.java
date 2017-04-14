import java.lang.reflect.Method;

/**
 * Created by dos on 24.11.2016.
 */
public class TestTest {
    public void LUL(){

    }
    public void LOL(){

    }

    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 3;
                int b = 0;
                int c = a/b;
            }
        });
        t1.start();

    }
}
