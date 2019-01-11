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

