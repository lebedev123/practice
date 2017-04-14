/**
 * Created by dos on 21.11.2016.
 */
public class TestConstr {
    int i;
    TestConstr(){
        System.out.print(i);
        i=4;
    }
    public static void main(String[] args){
        TestConstr n = new TestConstr();
    }
}
