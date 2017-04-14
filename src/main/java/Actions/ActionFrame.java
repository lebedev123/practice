package Actions;

import javax.swing.*;
import javax.swing.Action;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by dos on 24.01.2017.
 */
public class ActionFrame extends JFrame {
    private JPanel panel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public ActionFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        panel = new JPanel();
        Action yellowAction = new ColorAction("Yellow", Color.YELLOW);
        Action blueAction = new ColorAction("Blue",Color.BLUE);
        Action redAction = new ColorAction("Red",Color.RED);
        Action greenAction = new ColorAction("Green",Color.GREEN);
        panel.add(new JButton(yellowAction));
        panel.add(new JButton(redAction));
        panel.add(new JButton(blueAction));
        panel.add(new JButton(greenAction));
        add(panel);
        InputMap imap = panel.getInputMap();
        imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");
        imap.put(KeyStroke.getKeyStroke("ctrl G"),"panel.green");
        imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
        ActionMap amap = panel.getActionMap();
        amap.put("panel.yellow",yellowAction);
        amap.put("panel.red",redAction);
        amap.put("panel.blue",blueAction);
        amap.put("panel.green",greenAction);



    }
    public class ColorAction extends AbstractAction{
        public ColorAction(String name,Color c){
            putValue(Action.NAME,name);
            putValue(Action.SHORT_DESCRIPTION,"Set panel color to " + name.toLowerCase());
            putValue("color",c);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            panel.setBackground(c);
        }
    }

    public static void main(String[] args) {
        ActionFrame frame = new ActionFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
