package Actions;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dos on 30.01.2017.
 */

public class AboutDialog extends JDialog{
    public AboutDialog(Frame owner) {
        super(owner,"About Dialog",true);
        add(new JLabel("<html><h1><i> Core Java </i></h1><hr> Cay Hortsman </h1></html>"),BorderLayout.CENTER);
        JPanel panel  = new JPanel();
        JButton button = new JButton("Ok");
        button.addActionListener(event->setVisible(false));
        panel.add(button);
        add(panel,BorderLayout.SOUTH);
        pack();
    }
}
