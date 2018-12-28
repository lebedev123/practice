import java.awt.event.ActionListener;

public class LambdaTest {
    public static void main(String[] args) {

    }
    public static void testLambda(String text){
        ActionListener actionListener = e ->{
            System.out.println(text);
        };
    }



}


interface  A1 {
    String getString () throws Exception;
}

class B1 implements  A1{

    @Override
    public String getString() throws Exception {
        return null;
    }
}