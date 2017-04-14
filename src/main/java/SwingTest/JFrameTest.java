package SwingTest;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dos on 16.01.2017.
 */
public class JFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                    newFrame frame = new newFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle("Lul");
                    frame.add(new JButton("Ok"));
                    frame.setVisible(true);
                }
        );
    }
}

class newFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public newFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
