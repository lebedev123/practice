package Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dos on 17.01.2017.
 */
public class Action {
    public static void main(String[] args) {
        JFrame frame = new startFrame();
        JButton button = new JButton("Click me");
        frame.add(button);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame hellofrane = new Hello();
                hellofrane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                hellofrane.setVisible(true);
            }
        };
        button.addActionListener(listener);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
class Hello extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public Hello() throws HeadlessException {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        add(new HelloButton());
    }
}
class startFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public startFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
class HelloButton extends JComponent{
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("You clicked",100,100);
    }
}
