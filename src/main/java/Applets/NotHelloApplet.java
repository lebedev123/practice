package Applets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dos on 03.02.2017.
 */
public class NotHelloApplet extends JApplet {
    public void init (){
        EventQueue.invokeLater(()->{
            JLabel label = new JLabel("Hello ? forsenE",SwingConstants.CENTER);
            add(label);
        });
    }
}
