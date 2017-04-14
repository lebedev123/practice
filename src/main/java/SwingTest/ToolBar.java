package SwingTest;

import Actions.*;

import javax.swing.*;
import javax.swing.Action;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by dos on 25.01.2017.
 */
public class ToolBar extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;

    public ToolBar() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        Action blueAction = new ColorAction("Blue", Color.BLUE);
        Action redAction = new ColorAction("Red", Color.RED);
        Action greenAction = new ColorAction("green", Color.GREEN);
        Action exitAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "exit");
        JToolBar bar = new JToolBar();
        bar.add(blueAction);
        bar.add(redAction);
        bar.add(greenAction);
        bar.addSeparator();
        bar.add(exitAction);
        add(bar, BorderLayout.NORTH);
        JMenu menu = new JMenu("Color");
        menu.add(blueAction);
        menu.add(redAction);
        menu.add(greenAction);
        menu.addSeparator();
        menu.add(exitAction);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    class ColorAction extends AbstractAction {
        ColorAction(String name, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, name + "background");
            putValue("Color", color);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color");
            panel.setBackground(c);
        }
    }

    public static void main(String[] args) {
        ToolBar bar = new ToolBar();
        bar.setVisible(true);
        bar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
