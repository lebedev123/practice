package SwingTest;

import Actions.*;

import javax.swing.*;
import javax.swing.Action;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

/**
 * Created by dos on 17.01.2017.
 */
public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public static void main(String[] args) {
        ButtonFrame buttonFrame = new ButtonFrame();
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setVisible(true);
    }
    public ButtonFrame() {
        //inputmap - > put in map keystroke(combinatio,key);amap -> ColorAction ->JButton;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Action yellowAction = new ColorAction(Color.YELLOW,"YELLOW");
        Action blueAction = new ColorAction(Color.BLUE,"BLUE");
        Action redAction = new ColorAction(Color.RED,"RED");
        Action greenAction = new ColorAction(Color.GREEN,"GREEN");
        JButton yellow = new JButton(yellowAction);
        JButton blue = new JButton(blueAction);
        JButton red = new JButton(redAction);
        JButton green = new JButton(greenAction);
        buttonPanel = new JPanel();
        buttonPanel.add(yellow);
        buttonPanel.add(blue);
        buttonPanel.add(red);
        buttonPanel.add(green);
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");
        imap.put(KeyStroke.getKeyStroke("ctrl G"),"panel.green");
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.green",greenAction);
        amap.put("panel.yellow",yellowAction);
        amap.put("panel.blue",blueAction);
        amap.put("panel.red",redAction);
        add(buttonPanel);
    }

    private class ColorAction extends AbstractAction {
        public ColorAction(Color c,String name) {
            putValue(Action.NAME,name);
            putValue("color",c);
            putValue(Action.SHORT_DESCRIPTION,"Set panel color to " + name.toLowerCase());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
