import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 * Created by dos on 03.10.2016.
 */
public class InnerButton implements ActionListener {
    JFrame frame;
    JButton button;

    public static void main(String[] args) {
        InnerButton inner = new InnerButton();
        inner.go();
    }

    public void go() {
        frame = new JFrame();
        button = new JButton("A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(200, 100);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.getText().equals("A")) {
            button.setText("B");
        } else
            button.setText("A");

    }
}

