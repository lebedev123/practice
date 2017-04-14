package Threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by dos on 04.02.2017.
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame extends JFrame {
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    public BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", e -> addBall());
        addButton(buttonPanel, "Close", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = () -> {
            try {
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }}

    class Ball {
        private static final int XSIZE = 15;
        private static final int YSIZE = 15;
        private double x = 0;
        private double y = 0;
        private double dx = 1;
        private double dy = 1;

        public void move(Rectangle2D bounds) {
            x += dx;
            y += dy;
            if (x < bounds.getMinX()) {
                x = bounds.getMinX();
                dx = -dx;
            }
            if (x + XSIZE >= bounds.getMaxX()) {
                x = bounds.getMaxX() - XSIZE;
                dx = -dx;
            }
            if (y < bounds.getMinY()) {
                y = bounds.getMinY();
                dy = -dy;
            }
            if (y + YSIZE >= bounds.getMaxY()) {
                y = bounds.getMaxY() - YSIZE;
                dy = -dy;
            }
        }

        public Ellipse2D getShape() {
            return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
        }
    }

    class BallComponent extends JPanel {
        private static final int DEFAULT_WIDTH = 450;
        private static final int DEFAULT_HEIGHT = 350;
        private java.util.List<Ball> balls = new ArrayList<>();

        public void add(Ball b) {
            balls.add(b);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (Ball b : balls) {
                g2.fill(b.getShape());
            }
        }

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }

