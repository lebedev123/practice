import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by dos on 07.01.2017.
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();
        TalkingClock clock2 = new TalkingClock(10000,true);
        JOptionPane.showMessageDialog(null,"Quit?");
        System.exit(0);
    }
}
class TalkingClock{
    private int interval;
    private boolean beep;
    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }
    public void start(){
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval,listener);
        timer.start();
    }
    class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone time is" + new Date());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
    public void start(int interval,boolean beep){
        class TimePrinter implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone time is" + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }}
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval,listener);
        timer.start();

    }
}
