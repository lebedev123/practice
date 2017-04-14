package Actions;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;


/**
 * Created by dos on 30.11.2016.
 */
public class TestActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {

    }
}
