

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/**
 * Created by dos on 03.12.2016.
 */
public class TalkingTime {
    private int interval;
    private boolean beep;
    public static void main(String[] args){
        TalkingTime time = new TalkingTime(1000,true);
        time.start();
        JOptionPane.showMessageDialog(null,"Quit?");
        System.exit(0);
    }
    public  TalkingTime(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }
    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }
    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("Time is " + now);
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
