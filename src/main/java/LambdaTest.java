import java.util.Arrays;
import java.util.Date;
import javax.swing.*;

/**
 * Created by dos on 30.11.2016.
 */
public class LambdaTest {
    public static void main(String[] args){
        String[] planets = {"Mars","Earth","Venus","Mercury","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length");
        Arrays.sort(planets,(first,second)->first.length()-second.length());
        System.out.println(Arrays.toString(planets));
        Timer  t = new Timer(1000,event -> System.out.println("This time is" + new Date()));
        t.start();
        JOptionPane.showMessageDialog(null,"Quit program");
        System.exit(0);
    }
}
