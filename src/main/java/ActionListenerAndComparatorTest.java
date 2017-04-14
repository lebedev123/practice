import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by dos on 05.01.2017.
 */
public class ActionListenerAndComparatorTest implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        LengthComparator comparator = new LengthComparator();
        String[] array = new String[]{"1","2","3","123","23","1"};
        Arrays.sort(array,comparator);
        Timer timer1 = new Timer(1000, e -> System.out.println("Timer is working"));
        Timer timer3 = new Timer(1000, System.out::println);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Timer is working");
            }
        });
        ActionListenerAndComparatorTest test = new ActionListenerAndComparatorTest();
        ActionListenerAndComparatorTest test1 = test.clone();
        for(String a : array) System.out.println(a);
    }

    @Override
    protected ActionListenerAndComparatorTest clone() throws CloneNotSupportedException {
        return (ActionListenerAndComparatorTest)super.clone();
    }
}
class LengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

