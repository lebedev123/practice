import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by dos on 03.12.2016.
 */
public class CallBackTest1 {
    public static void main(String[] args){
        ActionListener actionListener = new TimePrinter();
        Timer t = new Timer(10000,actionListener);
        t.start();
        JOptionPane.showMessageDialog(null,"Quit ?");
        System.exit(0);
    }
}
class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is "+ new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
