package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * Created by dos on 16.01.2017.
 */
public class NotHelloWorld {
    public static void main(String[] args) {
        JFrame frame = new NotHelloWorldFrame();
        frame.setTitle("Mashka - Kakashka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {
    public static int MESSAGE_X = 75;
    public static int MESSAGE_Y = 100;
    public static int DEFAULT_WIDTH = 500;
    public static int DEFAULT_HEIGHT = 500;

    @Override
    protected void paintComponent(Graphics g) {
        Rectangle2D rectangle2D = new Rectangle2D.Double(150,200,100,50);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(rectangle2D);
        g2.setColor(Color.RED);
        g2.fill(rectangle2D);
        g.drawString("Not a hello,program",MESSAGE_X,MESSAGE_Y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}